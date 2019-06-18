package com.oneapm.main

import com.alibaba.fastjson.JSON
import com.oneapm.kafka.KafkaPacketProducer

/**
  * 测试断流事件
  */
object KafkaMain {
  private val producer = new KafkaPacketProducer("as_jl_mi_event", "10.128.106.94:9092", synchronously = true, requestRequiredAcks = 1)

  def main(args: Array[String]): Unit = {
    //    testContinueEvent
    //    testCutoffEvent
    //    testFrequencyEvents
//    testCommonEvent
//    testContinueEvent2
    testFrequencyEvent
  }

  //测试频次
  def testFrequencyEvent: Unit = {
    try {
      for (i <- 1 to 10) {
        var aiRawEvent =
          """{"eventCategory":"RawMetricEvent","key":"46c29046-517b-453b-a6e6-4c16fb12ad81","metrics":{"errorRate_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
        var event = JSON.parseObject(aiRawEvent)
        event.put("timestamp", System.currentTimeMillis - 20 * 60 * 1000)

        producer.send(event.toJSONString, "akka")
        producer.flush

        aiRawEvent =
          """{"eventCategory":"RawMetricEvent","key":"46c29046-517b-453b-a6e6-4c16fb12ad81","metrics":{"avgRespTime_AVG":"10000","errorRate_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
        event = JSON.parseObject(aiRawEvent)
        event.put("timestamp", System.currentTimeMillis - 1 * 60 * 1000)
        producer.send(event.toJSONString, "akka")
        producer.flush

//        aiRawEvent =
//          """{"eventCategory":"RawMetricEvent","key":"46c29046-517b-453b-a6e6-4c16fb12ad81","metrics":{"avgRespTime_AVG":"10000","errorRate_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//        event = JSON.parseObject(aiRawEvent)
//        event.put("timestamp", System.currentTimeMillis - 1 * 60 * 1000)
//        producer.send(event.toJSONString, "akka")
//        producer.flush
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  def testContinueEvent2: Unit = {
    try {
      var aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"46c29046-517b-453b-a6e6-4c16fb12ad81","metrics":{"avgRespTime_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      var event = JSON.parseObject(aiRawEvent)
      event.put("timestamp", System.currentTimeMillis - 20 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush


      event = JSON.parseObject(aiRawEvent)
      event.put("timestamp", System.currentTimeMillis - 1 * 60 * 1000)
      producer.send(event.toJSONString, "akka")
      producer.flush
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  def testCommonEvent: Unit = {
    try {
      var aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"989b1a66-44a6-41b8-9148-3b41b5bf2a6e","metrics":{"avgRespTime_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      var event = JSON.parseObject(aiRawEvent)
//      event.put("timestamp", System.currentTimeMillis - 2 * 60 * 1000)
      event.put("timestamp", System.currentTimeMillis)

      producer.send(event.toJSONString, "akka")
      producer.flush
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  /**
    * 测试频次事件
    */
  def testFrequencyEvents = {
    try {
      ////////////////////////////////////////////100////////////////////////////////////////////////////
      var aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"100"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      var event = JSON.parseObject(aiRawEvent)
      event.put("timestamp", System.currentTimeMillis - 6 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush

      ////////////////////////////////////////////200////////////////////////////////////////////////////
      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"100"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis - 5 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush

      ////////////////////////////////////////////300////////////////////////////////////////////////////
      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"100"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis - 4 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush

      ////////////////////////////////////////////400////////////////////////////////////////////////////
      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"190"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis - 3 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush

      ////////////////////////////////////////////500////////////////////////////////////////////////////
      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"100"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis - 2 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush

      ////////////////////////////////////////////600////////////////////////////////////////////////////
      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"180"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis - 1 * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush

      ////////////////////////////////////////////700////////////////////////////////////////////////////
      aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559033845652_webTransaction_1_2_0_5_0","metrics":{"AvgRespTime_AVG":"100"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      event = JSON.parseObject(aiRawEvent)

      event.put("timestamp", System.currentTimeMillis)

      producer.send(event.toJSONString, "akka")
      producer.flush
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  /**
    * 测试
    */
  def testContinueEvent = {
    var aiRawEvent =
      """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559032752333_webTransaction_2_2_111_4_0","metrics":{"AvgRespTime_AVG":"64"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    var event = JSON.parseObject(aiRawEvent)
    try {
      for (i <- 1 to 100) {
        println(i)
        aiRawEvent =
          """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1559032752333_webTransaction_2_2_111_4_0","metrics":{"AvgRespTime_AVG":"32"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

        event = JSON.parseObject(aiRawEvent)

        event.put("timestamp", System.currentTimeMillis)

        producer.send(event.toJSONString, "akka")
        producer.flush

        Thread.sleep(60000L)
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
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
