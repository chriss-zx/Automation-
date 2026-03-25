import org.testng.annotations.*;

public class Class2 {

    @BeforeGroups("smoke")
    public void setup() {
        System.out.println("Clasa1 - setup");
    }

    @AfterGroups("regression")
    public void tearDown() {
        System.out.println("Clasa1 - teardown");
    }

    @Test(groups = {"regression"})
    public void clasa2Test1() {

    }

    @Test(groups = {"regression", "slow"})
    public void clasa2Test2() {

    }

    @Test(groups = {"smoke"})
    public void clasa2Test3() {

    }
}
