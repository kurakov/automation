public class AutomationTester extends Employee {
    String name = "Alex Barabash";

    void automating() {
        System.out.println("automating");
    }


    public void work() {
        System.out.println("automating and working in this case");
    }

    public void work(String param) {
        System.out.println("automating and working" + param);
    }
}
