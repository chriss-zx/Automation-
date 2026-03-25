import org.testng.annotations.*;

public class Class1 {

    @BeforeGroups("smoke")
    public void setup() {
        System.out.println("Clasa1 - setup");
    }

    @AfterGroups("regression")
    public void tearDown() {
        System.out.println("Clasa1 - teardown");
    }


    @Test(groups = {"regression"})
    public void clasa1Test1() {

    }

    @Test(groups = {"smoke"})
    public void clasa1Test2() {

    }

    @Test(groups = {"regression", "slow"})
    public void clasa1Test3() {

    }

}
