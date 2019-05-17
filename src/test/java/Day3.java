import org.testng.annotations.Test;

import java.util.Arrays;


public class Day3 {

    public void printValue(int valueToPrint) {
        System.out.println(valueToPrint);
    }

    @Test
    public void test001() {
        for (int i = 1; i <= 40; i++) {
            if (i % 2 == 1) printValue(i);

        }
    }

    @Test
    public void test010() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 1) printValue(i);

        }
    }

    private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
    }

    @Test
    public void swapTwoNumbersInArray() {
        int[] array = {1, 2, 3, 4};
        swap(array, 1, 2);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testCountLetters() {
        String input = "Hello world";
        int result = 0;
        for (char eachChar : input.toCharArray()) {
            if (eachChar == 'o') result++;
        }
        System.out.println(result);
    }

    @Test
    public void testClasses() {
        MyClass myClassObject = new MyClass();
        MyClass myClassObject1 = new MyClass("Value from test");


    }

    @Test
    public void testInherClass() {
        AutomationTester automationTester = new AutomationTester();
        Employee employee = new Employee();
        System.out.println(automationTester.name);
        System.out.println(employee.name);

        automationTester.work();
        automationTester.work("value from test");

    }

    @Test
    public void test009() {
        MyClass myClass = new MyClass();

        String valueReturnedmyClass = myClass.print("value from test");
        System.out.println(valueReturnedmyClass);
    }


    @Test
    public void testReverseString() {
        String inputString = "MyValueValueValue";

        String reverse = "";

        String str;
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reverse = reverse + inputString.charAt(i);
        }
        System.out.println(reverse);
    }
}

