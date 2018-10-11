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
  private val producer = new KafkaPacketProducer("as_jl_ai_event", "10.128.106.94:9092", synchronously = true, requestRequiredAcks = 1)

  def main(args: Array[String]): Unit = {
    val aiRawEvent =
      """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1536284645342_node_1_1_0_1_1","metrics":{"VM":"2328808"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//      """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1536284645342_node_1_1_0_1_1","metrics":{"VMUsage":"2328808"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
    //      """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1535699921714_node_1_1","metrics":{"VMUsage":"0.02328808"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    val event = JSON.parseObject(aiRawEvent)
    try {
      for (i <- 0 to 10) {
        println("发送数据第 " + (i + 1) + " 条: ")
//        event.put("timestamp", System.currentTimeMillis - (10 - i) * 60 * 1000)
        event.put("timestamp", System.currentTimeMillis)

        producer.send(event.toJSONString, "akka")
        producer.flush
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

}
