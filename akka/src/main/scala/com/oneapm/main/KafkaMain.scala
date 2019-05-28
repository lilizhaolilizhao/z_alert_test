package com.oneapm.main

import com.alibaba.fastjson.JSON
import com.oneapm.kafka.KafkaPacketProducer

/**
  * 测试断流事件
  */
object KafkaMain {
  private val producer =  new KafkaPacketProducer("as_jl_ai_event", "kafka.oneapm.me:9092", synchronously = true, requestRequiredAcks = 1)

  def main(args: Array[String]): Unit = {
//    testCutoffEvent
  }

  /**
    * 测试断流事件
    */
  def testCutoffEvent = {
    var aiRawEvent =
      """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559032752333_webTransaction_2_2_111_4_0","metrics":{"AvgRespTime_AVG":"64"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    var event = JSON.parseObject(aiRawEvent)
    try {
      event.put("timestamp", System.currentTimeMillis - 135 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush


      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559032752333_webTransaction_2_2_111_4_0","metrics":{"AvgRespTime_AVG":"32"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis)

      producer.send(event.toJSONString, "akka")
      producer.flush
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

}
