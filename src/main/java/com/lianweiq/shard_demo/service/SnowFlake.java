package com.lianweiq.shard_demo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: state_machine
 * @description: 雪花算法
 * @author: lianweiq
 * @create: 2020-01-13 15:47
 */
@Component
public class SnowFlake {
        private final long twepoch = 1288834974657L; //指定开始时间戳
        private final long workerIdBits = 5L; //机器id 5位
        private final long dataCenterIdBits = 5L; //数据标识 5位
        private final long maxWorkerId = ~(-1L << workerIdBits); //最大机器id
        private final long maxDatacenterId = ~(-1L << dataCenterIdBits); //最大数据标识id
        private final long sequenceBits = 12L; //序列号位数
        private final long workerIdShift = sequenceBits; //机器id向左移位数
        private final long datacenterIdShift = sequenceBits + workerIdBits; //数据标识左移位数
        private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits; //时间戳左移位数
        private final long sequenceMask = ~(-1L << sequenceBits); //序列掩码

        private final long workerId=0;
        private final long datacenterId = 0;
        private AtomicLong sequence = new AtomicLong(0);
        private AtomicLong lastTimestamp = new AtomicLong(-1);



        public synchronized long nextId() {
            long timestamp = timeGen();
            if (timestamp < lastTimestamp.get()) {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp.get() - timestamp));
            }
            if (lastTimestamp.get() == timestamp) {
                sequence.set(sequence.incrementAndGet()&sequenceMask);
                if (sequence.get() == 0) {
                    timestamp = tilNextMillis(lastTimestamp);
                }
            } else {
                sequence.incrementAndGet();
            }

            lastTimestamp.set(timestamp);

            return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence.get();
        }

        private long tilNextMillis(AtomicLong lastTimestamp) {
            long timestamp = timeGen();
            while (timestamp <= lastTimestamp.get()) {
                timestamp = timeGen();
            }
            return timestamp;
        }

    private long timeGen() {
            return System.currentTimeMillis();
        }

        public static void main(String[] args) {
            SnowFlake idWorker = new SnowFlake();
            for (int i = 0; i < 1000; i++) {
                long id = idWorker.nextId();
                System.out.println(id);
            }
        }

}
