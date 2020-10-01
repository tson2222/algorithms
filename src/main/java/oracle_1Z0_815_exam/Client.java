package oracle_1Z0_815_exam;

import java.util.concurrent.ThreadLocalRandom;

class Client {
    static void doCalc(byte... a) {
        System.out.print("byte...");
    }

    static void doCalc(short a, long b) {
        System.out.print("long, long");
    }

    static void doCalc(Byte s1, Byte s2) {
        System.out.print("Byte, Byte");
    }

    public static void main(String[] args) {
        for (int x = 0; x < 1000000; x++) {
            int y = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            if(y < 10000) System.out.println(y);
        }
        byte b = 5;
        doCalc(b, b);
    }

}
