package com.oneapm;

import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;

public class Test {

    public static void main(String[] args) {
        String s = String.valueOf(new Bean());
        System.out.println(s);
    }

//    @OnMethod(clazz = "com.package.name.Demo", // 类的全限定名
//            method = "getDemoView", // 方法名
//            location = @Location(Kind.RETURN)) // 表示跟踪某个类的某个方法，位置为方法返回处
//    public static void onMethodReturn(@Self Object self, long id, @Return AnyType result) { // @Return注解将上面被跟踪方法的返回值绑定到此探查方法的参数上
//        println(BTraceUtils.Time.timestamp("yyyy-MM-dd HH:mm:ss")); // 打印时间
//        println("method self: " + str(self));
//        println("method params: " + id); // 打印入参
//        println("method return: " + String.valueOf(result)); // 打印结果对象，因String.valueOf(obj)为外部方法，故需使用unsafe模式
//        println("=========================="); // 强烈建议加上，否则会因为输出缓冲看不到最新打印结果
//    }
}
