package com.scmspain.kafka.clients.consumer;

import com.scmspain.kafka.clients.annotation.Consumer;
import com.scmspain.kafka.clients.annotation.Topic;
import kafka.message.MessageAndMetadata;
import rx.Observable;

@Consumer
public class KafkaConsumer implements ConsumerInterface<MessageAndMetadata<byte[], byte[]>> {


  public KafkaConsumer() {

  }

  @Override
  @Topic(value = "test", groupId = "forlayo", streams = 2)
  public Observable<MessageAndMetadata<byte[], byte[]>> consume(Observable<MessageAndMetadata<byte[], byte[]>> message) {
    return message.doOnNext(data -> System.out.println(new String(data.message())+"***** from KafkaConsumer1"));
  }
}