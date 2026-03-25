import org.testng.annotations.*;

public class Class3 {

    @BeforeGroups("smoke")
    public void setup() {
        System.out.println("Clasa1 - setup");
    }

    @AfterGroups("regression")
    public void tearDown() {
        System.out.println("Clasa1 - teardown");
    }

    @Test(groups = {"smoke"})
    public void clasa3Test1() {

    }

    @Test(groups = {"regression"})
    public void clasa3Test2() {

    }

    @Test(groups = {"regression", "slow"})
    public void clasa3Test3() {

    }
}
