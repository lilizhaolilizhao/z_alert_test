package com.oneapm.main

import java.util.Date

import com.alibaba.fastjson.JSON
import com.oneapm.kafka.KafkaPacketProducer

/**
  * 测试断流事件
  */
object KafkaMain {
  private val producer = new KafkaPacketProducer("as_jl_bi_event", "10.128.106.94:9092", synchronously = true, requestRequiredAcks = 1)

  def main(args: Array[String]): Unit = {
    testContinueEventSong
    //    testContinueEvent
    //    testCutoffEvent
    //    testFrequencyEvents
    //    testCommonEvent
    //    testContinueEvent2
//    testFrequencyEvent
//    testFrequencyEvent22
//    testContinueEvent23
//    testContinueEventLlz
  }

  def testContinueEventSong = {
    var aiRawEvent =
      """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"-2600000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    var event = JSON.parseObject(aiRawEvent)
    try {
      event.put("timestamp", System.currentTimeMillis)

      producer.send(event.toJSONString, "akka")
      producer.flush

      println("发送数据: ")
    } catch {
      case e: Exception => e.printStackTrace
    }

//    for (i <- 1 to 22) {
//      if (i % 2 == 1) {
//        var aiRawEvent =
//          """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"-2600000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//        var event = JSON.parseObject(aiRawEvent)
//        try {
//          event.put("timestamp", System.currentTimeMillis)
//
//          producer.send(event.toJSONString, "akka")
//          producer.flush
//
//          println("发送数据: " + i)
//        } catch {
//          case e: Exception => e.printStackTrace
//        }
//      }
//
//      Thread.sleep(60 * 1000L)
//    }

//    var aiRawEvent =
//      """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//    var event = JSON.parseObject(aiRawEvent)
//    try {
//      event.put("timestamp", System.currentTimeMillis)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//    } catch {
//      case e: Exception => e.printStackTrace
//    }
  }

  def testContinueEventLlz = {
    while (true) {
      var aiRawEvent =
        """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

      var event = JSON.parseObject(aiRawEvent)
      try {
        event.put("timestamp", System.currentTimeMillis)

        producer.send(event.toJSONString, "akka")
        producer.flush

        println("发送数据: " + new Date())
      } catch {
        case e: Exception => e.printStackTrace
      }

      Thread.sleep(6 * 60 * 1000)
    }
  }

    //  def testContinueEvent234 = {
//    var aiRawEvent =
//      """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//    var event = JSON.parseObject(aiRawEvent)
//    try {
//      event.put("timestamp", System.currentTimeMillis - 2 * 60 * 1000)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//
//      aiRawEvent =
//        """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2500"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//      event = JSON.parseObject(aiRawEvent)
//
//      event.put("timestamp", System.currentTimeMillis - 1 * 60 * 1000)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//
//      aiRawEvent =
//        """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2400"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//      event = JSON.parseObject(aiRawEvent)
//
//      event.put("timestamp", System.currentTimeMillis)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//    } catch {
//      case e: Exception => e.printStackTrace
//    }
//  }

  def testContinueEvent23 = {
    for (i <- 1 to 22) {
      if (i % 2 == 0) {
        var aiRawEvent =
          """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

        if (i == 22) {
          println("================")
        }

        var event = JSON.parseObject(aiRawEvent)
        try {
          event.put("timestamp", System.currentTimeMillis - (i - i) * 60 * 1000)

          producer.send(event.toJSONString, "akka")
          producer.flush
        } catch {
          case e: Exception => e.printStackTrace
        }
      }
    }

    var aiRawEvent =
      """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    var event = JSON.parseObject(aiRawEvent)
    try {
      event.put("timestamp", System.currentTimeMillis - (22 - 13) * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush
    } catch {
      case e: Exception => e.printStackTrace
    }

    aiRawEvent =
      """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";

    event = JSON.parseObject(aiRawEvent)
    try {
      event.put("timestamp", System.currentTimeMillis - (22 - 22) * 60 * 1000)

      producer.send(event.toJSONString, "akka")
      producer.flush
    } catch {
      case e: Exception => e.printStackTrace
    }

//    var aiRawEvent =
//      """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2600"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//    var event = JSON.parseObject(aiRawEvent)
//    try {
//      event.put("timestamp", System.currentTimeMillis - 25 * 60 * 1000)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//
//      aiRawEvent =
//        """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2500"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//      event = JSON.parseObject(aiRawEvent)
//
//      event.put("timestamp", System.currentTimeMillis - 18 * 60 * 1000)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//
//      aiRawEvent =
//        """{"eventCategory":"RawMetricEvent","key":"61c254c1-73f0-4cff-bc73-f0c05756600b_-1_-1_-1_-1_-1","metrics":{"pageLoadTime_AVG":"2400"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
//
//      event = JSON.parseObject(aiRawEvent)
//
//      event.put("timestamp", System.currentTimeMillis)
//
//      producer.send(event.toJSONString, "akka")
//      producer.flush
//    } catch {
//      case e: Exception => e.printStackTrace
//    }
  }

  //测试频次 测试数据乱序
  def testFrequencyEvent22: Unit = {
    try {
      for (i <- 1 to 5) {
          var aiRawEvent =
            """{"eventCategory":"RawMetricEvent","key":"ONEAPM_ALERT_AI_9_1561370032989_webTransaction_2_2_111_4_0","metrics":{"Apdex":"0.00000000","AvgRespTime_AVG":"1.01555717","CallCount":"12.00000000"},"tags":{"tierId":"6","agentOrMetricId":"0","applicationId":"4"},"timestamp":1561365840000,"ttl":1800}""";
          var event = JSON.parseObject(aiRawEvent)
          event.put("timestamp", System.currentTimeMillis)

          producer.send(event.toJSONString, "akka")
          producer.flush
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  //测试频次 测试数据乱序
  def testFrequencyEvent: Unit = {
    try {
      for (i <- 1 to 200) {
        if (i % 2 == 0) {
          var aiRawEvent =
            """{"eventCategory":"RawMetricEvent","key":"cabd0c80-e15e-4490-9d6e-76b594a2dbaa","metrics":{"errorRate_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
          var event = JSON.parseObject(aiRawEvent)
          event.put("timestamp", System.currentTimeMillis - (19 - i) * 1000)

          producer.send(event.toJSONString, "akka")
          producer.flush

          aiRawEvent =
            """{"eventCategory":"RawMetricEvent","key":"cabd0c80-e15e-4490-9d6e-76b594a2dbaa","metrics":{"avgRespTime_AVG":"10000","errorRate_AVG":"10000"},"tags":{"tierId":"1","agentOrMetricId":"0","applicationId":"1"},"timestamp":1535620539000,"ttl":1800}""";
          event = JSON.parseObject(aiRawEvent)
          event.put("timestamp", System.currentTimeMillis - (20 - i) * 1000)
          producer.send(event.toJSONString, "akka")
          producer.flush
        }
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
