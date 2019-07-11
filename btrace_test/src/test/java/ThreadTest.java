public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(5000L);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("test");
                }
            }).start();
        }
    }
}
