package com.oneapm;

import javax.tools.*;
import java.io.IOException;
import java.util.Arrays;

public class TestCompilerApi {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 建立DiagnosticCollector对象
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        // 建立用于保存被编译文件名的对象
        // 每个文件被保存在一个从JavaFileObject继承的类中
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromStrings(Arrays.asList("/Users/oneapm/git/z_alert_test/btrace_test/src/main/java/com/oneapm/Test.java"));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                diagnostics, null, null, compilationUnits);
        // 编译源程式
        boolean success = task.call();
        fileManager.close();
        System.out.println((success) ? "编译成功" : "编译失败");
    }
}
