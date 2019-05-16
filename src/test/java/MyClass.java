public class MyClass {


    public MyClass(String param) {
        System.out.println("Constructor with params:" + param);
    }

    public MyClass() {
        System.out.println("Constructors Called");
    }

    public void print() {
        System.out.println("printed");
    }

    public String print(String parametrValue) {
        String result;

        result = parametrValue + "printed";

        return result;
    }
}


