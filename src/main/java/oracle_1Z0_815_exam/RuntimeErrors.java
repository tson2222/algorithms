package oracle_1Z0_815_exam;

import java.util.stream.Stream;

public class RuntimeErrors {

    public static void main(String[] args) {

        Stream<Integer> numStream = Stream.of(10, 20, 30);
        numStream.map(n -> n + 10).peek(s -> System.out.print(s));
        numStream.forEach(s -> System.out.println(s)); //stream has already been operated upon or closed!

    }

}

