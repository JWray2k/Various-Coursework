/*
 * Jonathan Wray
 * CSCI295 - HW06 - Queue of Integers - Extends
 * 9/23/2016
 */

import java.util.ArrayList;

public class QueueTester {

    static TestResults tests = new TestResults();

    static String expected, result;
    static Integer element;
    static MyQueueOfIntegers queue;
    
    
    public static void main(String[] args) {
        allTests();
        
        // Print Results of the tests
        System.out.println(tests);
    }
    
    public static void allTests(){
        // Test 1: Make a new queue and inspect it
        queue = new QueueOfIntegers();
        expected = "Front [] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 1a", expected, result));
        
        expected = "0";
        result = "" + queue.size();
        tests.add(new TestResult("Test 1b", expected, result));
        
        expected = "true";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 1c", expected, result));
        
        expected = "null";
        result = "" + queue.dequeue();
        tests.add(new TestResult("Test 1d", expected, result));
        
        expected = "null";
        result = "" + queue.front();
        tests.add(new TestResult("Test 1e", expected, result));
        

        // Test 2: Add first element to the queue
        queue.enqueue(10);
        expected = "Front [10] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 2a", expected, result));
        
        expected = "1";
        result = "" + queue.size();
        tests.add(new TestResult("Test 2b", expected, result));
        
        expected = "false";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 2c", expected, result));
        
        expected = "10";
        result = "" + queue.front();
        tests.add(new TestResult("Test 2d", expected, result));
        
        
        // Test 3: Add another element
        queue.enqueue(20);
        expected = "Front [10, 20] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 3a", expected, result));
        
        expected = "2";
        result = "" + queue.size();
        tests.add(new TestResult("Test 3b", expected, result));
        
        expected = "false";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 3c", expected, result));
        
        expected = "10";
        result = "" + queue.front();
        tests.add(new TestResult("Test 3d", expected, result));
        
        // Test 4: Add one more element
        queue.enqueue(30);
        expected = "Front [10, 20, 30] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 4a", expected, result));
        
        expected = "3";
        result = "" + queue.size();
        tests.add(new TestResult("Test 4b", expected, result));
        
        expected = "false";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 4c", expected, result));
        
        expected = "10";
        result = "" + queue.front();
        tests.add(new TestResult("Test 4d", expected, result));
        
        
        // Test 5: Remove element
        element = queue.dequeue();
        expected = "10";
        result = "" + element;
        tests.add(new TestResult("Test 5a", expected, result));
        
        expected = "Front [20, 30] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 5b", expected, result));
        
        expected = "2";
        result = "" + queue.size();
        tests.add(new TestResult("Test 5c", expected, result));
        
        expected = "false";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 5d", expected, result));
        
        expected = "20";
        result = "" + queue.front();
        tests.add(new TestResult("Test 5e", expected, result));
        

        // Test 6: Remove element
        element = queue.dequeue();
        expected = "20";
        result = "" + element;
        tests.add(new TestResult("Test 6a", expected, result));
        
        expected = "Front [30] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 6b", expected, result));
        
        expected = "1";
        result = "" + queue.size();
        tests.add(new TestResult("Test 6c", expected, result));
        
        expected = "false";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 6d", expected, result));
        
        expected = "30";
        result = "" + queue.front();
        tests.add(new TestResult("Test 6e", expected, result));
        

        // Test 7: Remove element
        element = queue.dequeue();
        expected = "30";
        result = "" + element;
        tests.add(new TestResult("Test 7a", expected, result));
        
        expected = "Front [] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 7b", expected, result));
        
        expected = "0";
        result = "" + queue.size();
        tests.add(new TestResult("Test 7c", expected, result));
        
        expected = "true";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 7d", expected, result));
        
        expected = "null";
        result = "" + queue.front();
        tests.add(new TestResult("Test 7e", expected, result));
        
        // Test 8: Remove from empty queue
        element = queue.dequeue();
        expected = "null";
        result = "" + element;
        tests.add(new TestResult("Test 8a", expected, result));
        
        expected = "Front [] Rear";
        result = queue.toString();
        tests.add(new TestResult("Test 8b", expected, result));
        
        expected = "0";
        result = "" + queue.size();
        tests.add(new TestResult("Test 8c", expected, result));
        
        expected = "true";
        result = "" + queue.isEmpty();
        tests.add(new TestResult("Test 8d", expected, result));
        
        expected = "null";
        result = "" + queue.front();
        tests.add(new TestResult("Test 8e", expected, result));    
    }
}

/* A collection of test results */
class TestResults {

    ArrayList<TestResult> results = new ArrayList<>();
    int errorCount = 0; // the number of tests that failed.

    public void add(TestResult result) {
        results.add(result);
        if (!result.passed()) {
            errorCount++;
        }
    }

    public String toString() {
        String s = "";
        s = s + "Results of " + results.size() + " tests:\n";
        
        if(errorCount > 0){
            s = s + errorCount + " error(s) found\n\n";
            for(TestResult result : results){
                if(!result.passed()){
                    s = s + "Error: " + result.getMessage() + "\n";
                    s = s + "\tExpected: " + result.getExpected() + "\n";
                    s = s + "\tReceived: " + result.getReceived() + "\n";
                }
            }
        } else {
            s += "No Errors Found";
        }
        
        return s;
    }

} // End of class TestResults


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

    public String getMessage() {
        return message;
    }

    public String getExpected() {
        return expected;
    }

    public String getReceived() {
        return received;
    }

    public boolean passed() {
        return expected.equals(received);
    }
} // End of class TestResult
