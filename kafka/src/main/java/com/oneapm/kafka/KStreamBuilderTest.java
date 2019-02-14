package com.oneapm.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;

public class KStreamBuilderTest {
    public static void main(String[] args) {
        KStreamBuilder builder = new KStreamBuilder();

        KStream source1 = builder.stream("topic1", "topic2");
        KTable source2 = builder.table("topic3", "stateStoreName");

//        source1.mapValues(record -> record.get("category"));
//
//        source1.to
    }
}
