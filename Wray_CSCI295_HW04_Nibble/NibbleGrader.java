/*
 * Jonathan Wray
 * CSCI-295: HW04
 * Sept 11, 2016
 */

/*
This is Dr. Lillis' tester fo the Nibble class.
 */

import java.util.ArrayList;

public class NibbleGrader {

    static ArrayList<TestResult> tests = new ArrayList<>();

    static String expected, result;
    
    static Nibble n0000 = new Nibble(0);
    static Nibble n0001 = new Nibble(1);
    static Nibble n0010 = new Nibble(2);
    static Nibble n0011 = new Nibble(3);
    static Nibble n0100 = new Nibble(4);
    static Nibble n0101 = new Nibble(5);
    static Nibble n0110 = new Nibble(6);
    static Nibble n0111 = new Nibble(7);
    static Nibble n1000 = new Nibble(8);
    static Nibble n1001 = new Nibble(9);
    static Nibble n1010 = new Nibble(10);
    static Nibble n1011 = new Nibble(11);
    static Nibble n1100 = new Nibble(12);
    static Nibble n1101 = new Nibble(13);
    static Nibble n1110 = new Nibble(14);
    static Nibble n1111 = new Nibble(15);

    public static void main(String[] args) {
        runAllTests();
    }

    public static void runAllTests() {
        constructorTests();
        andTests();
        orTests();
        notTests();
        xorTests();
        shiftLeftTests();
        shiftRightTests();
        rotateLeftTests();
        rotateRightTests();
        toIntTests();
        toStringTests();

        TestResult.reportTestResults(tests);
    }

    public static void constructorTests(){
        tests.add(new TestResult("Constructor 0", "0000", n0000.toString()));
        tests.add(new TestResult("Constructor 1", "0001", n0001.toString()));
        tests.add(new TestResult("Constructor 2", "0010", n0010.toString()));
        tests.add(new TestResult("Constructor 3", "0011", n0011.toString()));
        tests.add(new TestResult("Constructor 4", "0100", n0100.toString()));
        tests.add(new TestResult("Constructor 5", "0101", n0101.toString()));
        tests.add(new TestResult("Constructor 6", "0110", n0110.toString()));
        tests.add(new TestResult("Constructor 7", "0111", n0111.toString()));
        tests.add(new TestResult("Constructor 8", "1000", n1000.toString()));
        tests.add(new TestResult("Constructor 9", "1001", n1001.toString()));
        tests.add(new TestResult("Constructor 10", "1010", n1010.toString()));
        tests.add(new TestResult("Constructor 11", "1011", n1011.toString()));
        tests.add(new TestResult("Constructor 12", "1100", n1100.toString()));
        tests.add(new TestResult("Constructor 13", "1101", n1101.toString()));
        tests.add(new TestResult("Constructor 14", "1110", n1110.toString()));
        tests.add(new TestResult("Constructor 15", "1111", n1111.toString()));
        
        tests.add(new TestResult("Constructor 16", "0000", (new Nibble()).toString()));        
        tests.add(new TestResult("Constructor 17", "0001", (new Nibble(12321)).toString()));        
    }
    
    public static void andTests() {
        result = n1010.and(n0101).toString();
        expected = "0000";
        tests.add(new TestResult("And 0", expected, result));
        
        result = n1111.and(n0000).toString();
        expected = "0000";
        tests.add(new TestResult("And 1", expected, result));
        
        result = n1111.and(n0001).toString();
        expected = "0001";
        tests.add(new TestResult("And 2", expected, result));
        
        result = n1111.and(n0010).toString();
        expected = "0010";
        tests.add(new TestResult("And 3", expected, result));
        
        result = n1111.and(n0100).toString();
        expected = "0100";
        tests.add(new TestResult("And 4", expected, result));
        
        result = n1111.and(n1000).toString();
        expected = "1000";
        tests.add(new TestResult("And 5", expected, result));
        
        result = n0000.and(n0000).toString();
        expected = "0000";
        tests.add(new TestResult("And 6", expected, result));
        
        result = n0001.and(n0000).toString();
        expected = "0000";
        tests.add(new TestResult("And 7", expected, result));
        
        result = n0010.and(n0000).toString();
        expected = "0000";
        tests.add(new TestResult("And 8", expected, result));
    }

    public static void orTests() {
        result = n0101.or(n1010).toString();
        expected = "1111";
        tests.add(new TestResult("Or 0", expected, result));
        
        result = n0000.or(n0000).toString();
        expected = "0000";
        tests.add(new TestResult("Or 1", expected, result));
        
        result = n0000.or(n0001).toString();
        expected = "0001";
        tests.add(new TestResult("Or 2", expected, result));
        
        result = n0000.or(n0010).toString();
        expected = "0010";
        tests.add(new TestResult("Or 3", expected, result));
        
        result = n0000.or(n0100).toString();
        expected = "0100";
        tests.add(new TestResult("Or 4", expected, result));
        
        result = n0000.or(n1000).toString();
        expected = "1000";
        tests.add(new TestResult("Or 5", expected, result));
        
        result = n0001.or(n0000).toString();
        expected = "0001";
        tests.add(new TestResult("Or 6", expected, result));
        
        result = n0010.or(n0000).toString();
        expected = "0010";
        tests.add(new TestResult("Or 7", expected, result));
        
        result = n0100.or(n0000).toString();
        expected = "0100";
        tests.add(new TestResult("Or 8", expected, result));
        
        result = n1000.or(n0000).toString();
        expected = "1000";
        tests.add(new TestResult("Or 9", expected, result));

        result = n1111.or(n0001).toString();
        expected = "1111";
        tests.add(new TestResult("Or 10", expected, result));
        
        result = n1111.or(n0010).toString();
        expected = "1111";
        tests.add(new TestResult("Or 11", expected, result));
        
        result = n1111.or(n0100).toString();
        expected = "1111";
        tests.add(new TestResult("Or 12", expected, result));
        
        result = n1111.or(n1000).toString();
        expected = "1111";
        tests.add(new TestResult("Or 13", expected, result));
        
        result = n1111.or(n0101).toString();
        expected = "1111";
        tests.add(new TestResult("Or 14", expected, result));
        
        result = n1111.or(n1111).toString();
        expected = "1111";
        tests.add(new TestResult("Or 15", expected, result));
    }

    public static void notTests() {
        result = n0000.not().toString();
        expected = "1111";
        tests.add(new TestResult("Not 0", expected, result));
        
        result = n0001.not().toString();
        expected = "1110";
        tests.add(new TestResult("Not 1", expected, result));
        
        result = n0010.not().toString();
        expected = "1101";
        tests.add(new TestResult("Not 2", expected, result));
        
        result = n0011.not().toString();
        expected = "1100";
        tests.add(new TestResult("Not 3", expected, result));
        
        result = n0100.not().toString();
        expected = "1011";
        tests.add(new TestResult("Not 4", expected, result));
        
        result = n0101.not().toString();
        expected = "1010";
        tests.add(new TestResult("Not 5", expected, result));
        
        result = n0110.not().toString();
        expected = "1001";
        tests.add(new TestResult("Not 6", expected, result));
        
        result = n0111.not().toString();
        expected = "1000";
        tests.add(new TestResult("Not 7", expected, result));
        
        result = n1000.not().toString();
        expected = "0111";
        tests.add(new TestResult("Not 8", expected, result));
        
        result = n1001.not().toString();
        expected = "0110";
        tests.add(new TestResult("Not 9", expected, result));
        
        result = n1010.not().toString();
        expected = "0101";
        tests.add(new TestResult("Not 10", expected, result));
        
        result = n1011.not().toString();
        expected = "0100";
        tests.add(new TestResult("Not 11", expected, result));
        
        result = n1100.not().toString();
        expected = "0011";
        tests.add(new TestResult("Not 12", expected, result));
        
        result = n1101.not().toString();
        expected = "0010";
        tests.add(new TestResult("Not 13", expected, result));
        
        result = n1110.not().toString();
        expected = "0001";
        tests.add(new TestResult("Not 14", expected, result));
        
        result = n1111.not().toString();
        expected = "0000";
        tests.add(new TestResult("Not 15", expected, result));
    }

    public static void xorTests() {
        result = n1010.xor(n0101).toString();
        expected = "1111";
        tests.add(new TestResult("Xor 0", expected, result));
        
        result = n1010.xor(n1010).toString();
        expected = "0000";
        tests.add(new TestResult("Xor 1", expected, result));
        
        result = n0000.xor(n0001).toString();
        expected = "0001";
        tests.add(new TestResult("Xor 2", expected, result));
        
        result = n0000.xor(n0010).toString();
        expected = "0010";
        tests.add(new TestResult("Xor 3", expected, result));
        
        result = n0000.xor(n0100).toString();
        expected = "0100";
        tests.add(new TestResult("Xor 4", expected, result));
        
        result = n0000.xor(n1000).toString();
        expected = "1000";
        tests.add(new TestResult("Xor 5", expected, result));
        
        result = n0001.xor(n0000).toString();
        expected = "0001";
        tests.add(new TestResult("Xor 6", expected, result));
        
        result = n0010.xor(n0000).toString();
        expected = "0010";
        tests.add(new TestResult("Xor 7", expected, result));
        
        result = n0100.xor(n0000).toString();
        expected = "0100";
        tests.add(new TestResult("Xor 8", expected, result));
        
        result = n1000.xor(n0000).toString();
        expected = "1000";
        tests.add(new TestResult("Xor 9", expected, result));

        result = n1111.xor(n0001).toString();
        expected = "1110";
        tests.add(new TestResult("Xor 10", expected, result));
        
        result = n1111.xor(n0010).toString();
        expected = "1101";
        tests.add(new TestResult("Xor 11", expected, result));
        
        result = n1111.xor(n0100).toString();
        expected = "1011";
        tests.add(new TestResult("Xor 12", expected, result));
        
        result = n1111.xor(n1000).toString();
        expected = "0111";
        tests.add(new TestResult("Xor 13", expected, result));
        
        result = n1111.xor(n0101).toString();
        expected = "1010";
        tests.add(new TestResult("Xor 14", expected, result));
        
        result = n1111.xor(n1111).toString();
        expected = "0000";
        tests.add(new TestResult("Xor 15", expected, result));

        result = n0000.xor(n0000).toString();
        expected = "0000";
        tests.add(new TestResult("Xor 16", expected, result));
    
    
    }

    public static void shiftLeftTests() {
        result = n0000.shiftLeft().toString();
        expected = "0000";
        tests.add(new TestResult("shiftL 0", expected, result));
        
        result = n0001.shiftLeft().toString();
        expected = "0010";
        tests.add(new TestResult("shiftL 1", expected, result));
        
        result = n0010.shiftLeft().toString();
        expected = "0100";
        tests.add(new TestResult("shiftL 2", expected, result));
        
        result = n0011.shiftLeft().toString();
        expected = "0110";
        tests.add(new TestResult("shiftL 3", expected, result));
        
        result = n0100.shiftLeft().toString();
        expected = "1000";
        tests.add(new TestResult("shiftL 4", expected, result));
        
        result = n0101.shiftLeft().toString();
        expected = "1010";
        tests.add(new TestResult("shiftL 5", expected, result));
        
        result = n0110.shiftLeft().toString();
        expected = "1100";
        tests.add(new TestResult("shiftL 6", expected, result));
        
        result = n0111.shiftLeft().toString();
        expected = "1110";
        tests.add(new TestResult("shiftL 7", expected, result));
        
        result = n1000.shiftLeft().toString();
        expected = "0000";
        tests.add(new TestResult("shiftL 8", expected, result));
        
        result = n1001.shiftLeft().toString();
        expected = "0010";
        tests.add(new TestResult("shiftL 9", expected, result));
        
        result = n1010.shiftLeft().toString();
        expected = "0100";
        tests.add(new TestResult("shiftL 10", expected, result));
        
        result = n1011.shiftLeft().toString();
        expected = "0110";
        tests.add(new TestResult("shiftL 11", expected, result));
        
        result = n1100.shiftLeft().toString();
        expected = "1000";
        tests.add(new TestResult("shiftL 12", expected, result));
        
        result = n1101.shiftLeft().toString();
        expected = "1010";
        tests.add(new TestResult("shiftL 13", expected, result));
        
        result = n1110.shiftLeft().toString();
        expected = "1100";
        tests.add(new TestResult("shiftL 14", expected, result));
        
        result = n1111.shiftLeft().toString();
        expected = "1110";
        tests.add(new TestResult("shiftL 15", expected, result));
        
        result = n1111.shiftLeft(0).toString();
        expected = "1111";
        tests.add(new TestResult("shiftL 16", expected, result));
        
        result = n1111.shiftLeft(1).toString();
        expected = "1110";
        tests.add(new TestResult("shiftL 17", expected, result));
        
        result = n1111.shiftLeft(2).toString();
        expected = "1100";
        tests.add(new TestResult("shiftL 18", expected, result));
        
        result = n1111.shiftLeft(3).toString();
        expected = "1000";
        tests.add(new TestResult("shiftL 19", expected, result));
        
        result = n1111.shiftLeft(4).toString();
        expected = "0000";
        tests.add(new TestResult("shiftL 20", expected, result));
    }

    public static void shiftRightTests() {
        result = n0000.shiftRight().toString();
        expected = "0000";
        tests.add(new TestResult("shiftR 0", expected, result));
        
        result = n0001.shiftRight().toString();
        expected = "0000";
        tests.add(new TestResult("shiftR 1", expected, result));
        
        result = n0010.shiftRight().toString();
        expected = "0001";
        tests.add(new TestResult("shiftR 2", expected, result));
        
        result = n0011.shiftRight().toString();
        expected = "0001";
        tests.add(new TestResult("shiftR 3", expected, result));
        
        result = n0100.shiftRight().toString();
        expected = "0010";
        tests.add(new TestResult("shiftR 4", expected, result));
        
        result = n0101.shiftRight().toString();
        expected = "0010";
        tests.add(new TestResult("shiftR 5", expected, result));
        
        result = n0110.shiftRight().toString();
        expected = "0011";
        tests.add(new TestResult("shiftR 6", expected, result));
        
        result = n0111.shiftRight().toString();
        expected = "0011";
        tests.add(new TestResult("shiftR 7", expected, result));
        
        result = n1000.shiftRight().toString();
        expected = "0100";
        tests.add(new TestResult("shiftR 8", expected, result));
        
        result = n1001.shiftRight().toString();
        expected = "0100";
        tests.add(new TestResult("shiftR 9", expected, result));
        
        result = n1010.shiftRight().toString();
        expected = "0101";
        tests.add(new TestResult("shiftR 10", expected, result));
        
        result = n1011.shiftRight().toString();
        expected = "0101";
        tests.add(new TestResult("shiftR 11", expected, result));
        
        result = n1100.shiftRight().toString();
        expected = "0110";
        tests.add(new TestResult("shiftR 12", expected, result));
        
        result = n1101.shiftRight().toString();
        expected = "0110";
        tests.add(new TestResult("shiftR 13", expected, result));
        
        result = n1110.shiftRight().toString();
        expected = "0111";
        tests.add(new TestResult("shiftR 14", expected, result));
        
        result = n1111.shiftRight().toString();
        expected = "0111";
        tests.add(new TestResult("shiftR 15", expected, result));
        
        result = n1111.shiftRight(0).toString();
        expected = "1111";
        tests.add(new TestResult("shiftR 16", expected, result));
        
        result = n1111.shiftRight(1).toString();
        expected = "0111";
        tests.add(new TestResult("shiftR 17", expected, result));
        
        result = n1111.shiftRight(2).toString();
        expected = "0011";
        tests.add(new TestResult("shiftR 18", expected, result));
        
        result = n1111.shiftRight(3).toString();
        expected = "0001";
        tests.add(new TestResult("shiftR 19", expected, result));
        
        result = n1111.shiftRight(4).toString();
        expected = "0000";
        tests.add(new TestResult("shiftR 20", expected, result));
    }

    public static void rotateLeftTests() {
        result = n0000.rotateLeft().toString();
        expected = "0000";
        tests.add(new TestResult("rotateL 0", expected, result));
        
        result = n0001.rotateLeft().toString();
        expected = "0010";
        tests.add(new TestResult("rotateL 1", expected, result));
        
        result = n0010.rotateLeft().toString();
        expected = "0100";
        tests.add(new TestResult("rotateL 2", expected, result));
        
        result = n0011.rotateLeft().toString();
        expected = "0110";
        tests.add(new TestResult("rotateL 3", expected, result));
        
        result = n0100.rotateLeft().toString();
        expected = "1000";
        tests.add(new TestResult("rotateL 4", expected, result));
        
        result = n0101.rotateLeft().toString();
        expected = "1010";
        tests.add(new TestResult("rotateL 5", expected, result));
        
        result = n0110.rotateLeft().toString();
        expected = "1100";
        tests.add(new TestResult("rotateL 6", expected, result));
        
        result = n0111.rotateLeft().toString();
        expected = "1110";
        tests.add(new TestResult("rotateL 7", expected, result));
        
        result = n1000.rotateLeft().toString();
        expected = "0001";
        tests.add(new TestResult("rotateL 8", expected, result));
        
        result = n1001.rotateLeft().toString();
        expected = "0011";
        tests.add(new TestResult("rotateL 9", expected, result));
        
        result = n1010.rotateLeft().toString();
        expected = "0101";
        tests.add(new TestResult("rotateL 10", expected, result));
        
        result = n1011.rotateLeft().toString();
        expected = "0111";
        tests.add(new TestResult("rotateL 11", expected, result));
        
        result = n1100.rotateLeft().toString();
        expected = "1001";
        tests.add(new TestResult("rotateL 12", expected, result));
        
        result = n1101.rotateLeft().toString();
        expected = "1011";
        tests.add(new TestResult("rotateL 13", expected, result));
        
        result = n1110.rotateLeft().toString();
        expected = "1101";
        tests.add(new TestResult("rotateL 14", expected, result));
        
        result = n1111.rotateLeft().toString();
        expected = "1111";
        tests.add(new TestResult("rotateL 15", expected, result));
        
        result = n1001.rotateLeft(7).toString();
        expected = "1100";
        tests.add(new TestResult("rotateL 16", expected, result));
        
    }

    public static void rotateRightTests() {
        result = n0000.rotateRight().toString();
        expected = "0000";
        tests.add(new TestResult("rotateR 0", expected, result));
        
        result = n0001.rotateRight().toString();
        expected = "1000";
        tests.add(new TestResult("rotateR 1", expected, result));
        
        result = n0010.rotateRight().toString();
        expected = "0001";
        tests.add(new TestResult("rotateR 2", expected, result));
        
        result = n0011.rotateRight().toString();
        expected = "1001";
        tests.add(new TestResult("rotateR 3", expected, result));
        
        result = n0100.rotateRight().toString();
        expected = "0010";
        tests.add(new TestResult("rotateR 4", expected, result));
        
        result = n0101.rotateRight().toString();
        expected = "1010";
        tests.add(new TestResult("rotateR 5", expected, result));
        
        result = n0110.rotateRight().toString();
        expected = "0011";
        tests.add(new TestResult("rotateR 6", expected, result));
        
        result = n0111.rotateRight().toString();
        expected = "1011";
        tests.add(new TestResult("rotateR 7", expected, result));
        
        result = n1000.rotateRight().toString();
        expected = "0100";
        tests.add(new TestResult("rotateR 8", expected, result));
        
        result = n1001.rotateRight().toString();
        expected = "1100";
        tests.add(new TestResult("rotateR 9", expected, result));
        
        result = n1010.rotateRight().toString();
        expected = "0101";
        tests.add(new TestResult("rotateR 10", expected, result));
        
        result = n1011.rotateRight().toString();
        expected = "1101";
        tests.add(new TestResult("rotateR 11", expected, result));
        
        result = n1100.rotateRight().toString();
        expected = "0110";
        tests.add(new TestResult("rotateR 12", expected, result));
        
        result = n1101.rotateRight().toString();
        expected = "1110";
        tests.add(new TestResult("rotateR 13", expected, result));
        
        result = n1110.rotateRight().toString();
        expected = "0111";
        tests.add(new TestResult("rotateR 14", expected, result));
        
        result = n1111.rotateRight().toString();
        expected = "1111";
        tests.add(new TestResult("rotateR 15", expected, result));
        
        result = n1001.rotateRight(7).toString();
        expected = "0011";
        tests.add(new TestResult("rotateR 16", expected, result));    
    }

    public static void toIntTests() {

        result = n0000.intValue() + "";
        expected = "0";
        tests.add(new TestResult("toInt 0", expected, result));
        
        result = n0001.intValue() + "";
        expected = "1";
        tests.add(new TestResult("toInt 1", expected, result));
        
        result = n0010.intValue() + "";
        expected = "2";
        tests.add(new TestResult("toInt 2", expected, result));
        
        result = n0011.intValue() + "";
        expected = "3";
        tests.add(new TestResult("toInt 3", expected, result));
        
        result = n0100.intValue() + "";
        expected = "4";
        tests.add(new TestResult("toInt 4", expected, result));
        
        result = n0101.intValue() + "";
        expected = "5";
        tests.add(new TestResult("toInt 5", expected, result));
        
        result = n0110.intValue() + "";
        expected = "6";
        tests.add(new TestResult("toInt 6", expected, result));
        
        result = n0111.intValue() + "";
        expected = "7";
        tests.add(new TestResult("toInt 7", expected, result));
        
        result = n1000.intValue() + "";
        expected = "8";
        tests.add(new TestResult("toInt 8", expected, result));
        
        result = n1001.intValue() + "";
        expected = "9";
        tests.add(new TestResult("toInt 9", expected, result));
        
        result = n1010.intValue() + "";
        expected = "10";
        tests.add(new TestResult("toInt 10", expected, result));
        
        result = n1011.intValue() + "";
        expected = "11";
        tests.add(new TestResult("toInt 11", expected, result));
        
        result = n1100.intValue() + "";
        expected = "12";
        tests.add(new TestResult("toInt 12", expected, result));
        
        result = n1101.intValue() + "";
        expected = "13";
        tests.add(new TestResult("toInt 13", expected, result));
        
        result = n1110.intValue() + "";
        expected = "14";
        tests.add(new TestResult("toInt 14", expected, result));
        
        result = n1111.intValue() + "";
        expected = "15";
        tests.add(new TestResult("toInt 15", expected, result));
        
    }

    public static void toStringTests() {
        tests.add(new TestResult("toString 0", "0000", n0000.toString()));
        tests.add(new TestResult("toString 1", "0001", n0001.toString()));
        tests.add(new TestResult("toString 2", "0010", n0010.toString()));
        tests.add(new TestResult("toString 3", "0011", n0011.toString()));
        tests.add(new TestResult("toString 4", "0100", n0100.toString()));
        tests.add(new TestResult("toString 5", "0101", n0101.toString()));
        tests.add(new TestResult("toString 6", "0110", n0110.toString()));
        tests.add(new TestResult("toString 7", "0111", n0111.toString()));
        tests.add(new TestResult("toString 8", "1000", n1000.toString()));
        tests.add(new TestResult("toString 9", "1001", n1001.toString()));
        tests.add(new TestResult("toString 10", "1010", n1010.toString()));
        tests.add(new TestResult("toString 11", "1011", n1011.toString()));
        tests.add(new TestResult("toString 12", "1100", n1100.toString()));
        tests.add(new TestResult("toString 13", "1101", n1101.toString()));
        tests.add(new TestResult("toString 14", "1110", n1110.toString()));
        tests.add(new TestResult("toString 15", "1111", n1111.toString()));    }

}

/* Holds results of a single result */
class TestResult {

    private final String message;
    private final String expected;
    private final String received;

    public TestResult(String message, String expected, String received) {
        this.message = message;
        this.expected = expected;
        this.received = received;
    }

    private boolean passed() {
        return expected.equals(received);
    }

    public static void reportTestResults(ArrayList<TestResult> testResults) {
        System.out.println("Results of " + testResults.size() + " tests:");
        boolean errorsFound = false;
        for (TestResult result : testResults) {
            if (!result.passed()) {
                System.out.println("Error: " + result.message);
                System.out.println("\tExpected: \"" + result.expected + "\"");
                System.out.println("\tReceived: \"" + result.received + "\"");
                errorsFound = true;
            }
        }

        if (!errorsFound) {
            System.out.println("No Errors Found.");
        }
    }
} // End of class TestResult
