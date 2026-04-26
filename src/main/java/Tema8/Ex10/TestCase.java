package Tema8.Ex10;

public class TestCase {

    protected String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void runTest() {
        System.out.println("Running test named: " + name);
    }
}
