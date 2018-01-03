
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jw91482
 */
import java.util.ArrayList;

public class Tester2 {
    public static void main(String[] args) {
        ArrayList<TestResult> tests;
        
        System.out.println("\n------------------------------");
        System.out.println("Testing Interface Methods with MyArrayList Object");
        tests = new ArrayList<>();
        //runCommonTests2(tests, new MyArrayList());        
        TestResult2.reportTestResults2(tests);
    }
//        public static void runCommonTests2(ArrayList<TestResult> tests, MyList<String> list){
//        
//        // Run the tests on MyArrayList
//        runInitializeTests(tests, list);
//        runAddTests(tests, list);        
//        runClearTests(tests, list);        
//        runContainsTests(tests, list);
//        runFirstIndexOfTests(tests, list);
//        runGetTests(tests, list);   
//        runIsEmptyTests(tests, list);
//        runLastIndexOfTests(tests, list);
//        runRemoveTests(tests, list);
//        runSetTests(tests, list);
//        runExceptionTests(tests, list);
//    
//    }
        

public static void runConstructorTests2(ArrayList<TestResult> tests){
        MyList<String> list;
        MyArrayList aList;
        String[] strArr0 = {};
        String[] strArr1 = {"a"};
        String[] strArr2 = {"a", "b"};
        String[] strArr3 = {"a", "b", "c"};

        // Constructing MyArrayList
        list = new MyArrayList<>();
        tests.add(new TestResult("Constructor part 1", "[]", list.toString()));
        tests.add(new TestResult("Constructor part 2", "0", "" + (list.size())));
        aList = (MyArrayList)list;
        tests.add(new TestResult("Constructor part 3", "true", "" + (aList.capacity() == MyArrayList.INITIAL_CAPACITY)));
        
        list = new MyArrayList<>(strArr0);
        tests.add(new TestResult("Constructor part 4", "[]", list.toString()));
        tests.add(new TestResult("Constructor part 5", "0", "" + (list.size())));
        aList = (MyArrayList)list;
        tests.add(new TestResult("Constructor part 6", "true", "" + (aList.capacity() == MyArrayList.INITIAL_CAPACITY)));
        
        list = new MyArrayList<>(strArr1);
        tests.add(new TestResult("Constructor part 7", "[a]", list.toString()));
        tests.add(new TestResult("Constructor part 8", "1", "" + (list.size())));
        aList = (MyArrayList)list;
        tests.add(new TestResult("Constructor part 9", "true", "" + (aList.capacity() == aList.size())));

        list = new MyArrayList<>(strArr2);
        tests.add(new TestResult("Constructor part 10", "[a, b]", list.toString()));
        tests.add(new TestResult("Constructor part 11", "2", "" + (list.size())));
        aList = (MyArrayList)list;
        tests.add(new TestResult("Constructor part 12", "true", "" + (aList.capacity() == aList.size())));

        list = new MyArrayList<>(strArr3);
        tests.add(new TestResult("Constructor part 13", "[a, b, c]", list.toString()));
        tests.add(new TestResult("Constructor part 14", "3", "" + (list.size())));
        aList = (MyArrayList)list;
        tests.add(new TestResult("Constructor part 15", "true", "" + (aList.capacity() == aList.size())));
}

/* Holds results of a single result */
class TestResult2 {

    private String message;
    private String expected;
    private String received;

    public TestResult2(String message, String expected, String received) {
        this.message = message;
        this.expected = expected;
        this.received = received;
    }
    
    private boolean passed() {
        return expected.equals(received);
    }
        
    public static void reportTestResults2(ArrayList<TestResult> testResults) {
        System.out.println("Results of " + testResults.size() + " tests:");
        boolean errorsFound = false;
        for (TestResult2 result : testResults) {
            if (!result.passed()) {
                System.out.println("Error: " + result.message);
                System.out.println("\tExpected: \"" + result.expected + "\"");
                System.out.println("\tReceived: \"" + result.received + "\"");
                errorsFound = true;
            }
        }
        
        if(!errorsFound){
            System.out.println("No Errors Found.");
        }
    }    

}