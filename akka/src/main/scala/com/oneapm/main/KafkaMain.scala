package com.oneapm.main

import com.alibaba.fastjson.JSON
import com.oneapm.kafka.KafkaPacketProducer

//class KafkaMain {
//  //db配置信息
//  val connReader = ResourceBundle.getBundle("connection")
//  val hostname = connReader.getString("hostname")
//  val port = connReader.getString("port")
//  val username = connReader.getString("username")
//  val password = connReader.getString("password")
//
//}

object KafkaMain {
  private val producer =  new KafkaPacketProducer("as_jl_ai_event", "kafka.oneapm.me:9092", synchronously = true, requestRequiredAcks = 1)

  def main(args: Array[String]): Unit = {
    var aiRawEvent =
//      """{"key":"c7d3156a-6d9d-42ba-9fb7-97b28079ad44","eventCategory":"RawMetricEvent","metrics":{"TerminalIPUnmatch":"0","TotalTimes":"1","AvailableTimes":"1","ResponseTime":"303004.0"},"tags":null,"ttl":86400,"timestamp":1542771928272}"""
//      """{"eventCategory":"RawMetricEvent","key":"b22dd8c2-c43c-44e7-975c-561e71315b3a","metrics":{"ResponseTime":"300220.0"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//      """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1536562263393_node_1_1_0_1_2","metrics":{"VMUsage":"2328808"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
          """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559032752333_webTransaction_2_2_111_4_0","metrics":{"AvgRespTime_AVG":"64"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    var event = JSON.parseObject(aiRawEvent)
    try {
      //        event.put("timestamp", System.currentTimeMillis - (10 - i) * 60 * 1000)

//      for (i <- 0 to 1000) {
        event.put("timestamp", System.currentTimeMillis - 135 * 60 * 1000)

        producer.send(event.toJSONString, "akka")
        producer.flush
//      }

//      Thread.sleep(10000L)


//      for (i <- 0 to 1000) {
        aiRawEvent =
          """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559032752333_webTransaction_2_2_111_4_0","metrics":{"AvgRespTime_AVG":"32"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

        event = JSON.parseObject(aiRawEvent)

        event.put("timestamp", System.currentTimeMillis)

        producer.send(event.toJSONString, "akka")
        producer.flush
//      }

      //      for (i <- 0 to 1) {
//        println("发送数据第 " + (i + 1) + " 条: ")
////        event.put("timestamp", System.currentTimeMillis - (10 - i) * 60 * 1000)
//        event.put("timestamp", System.currentTimeMillis - 30 * 60 * 1000)
//
//        producer.send(event.toJSONString, "akka")
//        producer.flush
//        Thread.sleep(10000L)
//      }
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

}
