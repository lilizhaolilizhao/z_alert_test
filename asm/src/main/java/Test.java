import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        IntStream.range(1, 10).map(x -> x + 1).filter(x -> x > 3).forEach(System.out::println);
    }
}
