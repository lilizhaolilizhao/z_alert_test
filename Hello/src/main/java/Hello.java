public class Hello {
    public static void main(String[] args) throws InterruptedException {
//        for (int i=0;i<10000;i++) {
//            System.out.println("this is a test: " + i);
//            Thread.sleep(1000L);
//        }

        String test = "aaaabbbbbccccccaaaa";
        String[] split = test.split("");
        System.out.println(split);
    }
}
