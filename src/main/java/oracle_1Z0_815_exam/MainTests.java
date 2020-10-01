package oracle_1Z0_815_exam;

public class MainTests {
    // Executable main method
    public static strictfp synchronized void main(String...args) throws Exception { //order of static strictfp synchronized doesnt matter
        main("");
        main();
    }

    // Incorrect Signature, not an executable main
    public static void main(String arg) {
        System.out.println("main(String arg): Not an executable main method");
    }

    // Incorrect Signature, not an executable main
    public static void main() {
        System.out.println("main(): Not an executable main method");
    }

}

