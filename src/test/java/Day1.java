import org.testng.annotations.Test;

public class Day1 {

    @Test
    public void testMethod1() {

    }

    @Test
    public void test002() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println(i);
        }
    }

    @Test
    public void test003() {
        int i = 10;
        int j = 3;

        System.out.println("i is " + i);
        System.out.println("j is " + j);

        int k = i % j;
        System.out.println("i%j is " + k);
    }

    @Test
    public void test004() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println(i);
        }
    }

    @Test
    public void testInterfaceCat() {
        Cat myCAt1 = new Cat();

        myCAt1.eat();
        myCAt1.jump();
    }
}
