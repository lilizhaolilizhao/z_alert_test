import java.io.PrintStream;

public class Test {
    public Test() {
    }

    private static PrintStream ps = System.err;

    public static void main(String[] args) {
        {
            int a = 90;
        }

        int s = 23;
        System.out.println("test");

        System.gc();
    }
}
