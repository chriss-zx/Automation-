import org.testng.annotations.Test;

public class  Groups{

    @Test(groups = {"smoke"})
    public void verifyPageTitle() {

    }

    @Test (groups = {"UI"})
    public void verifyFullNameField() {

    }

    @Test (groups = {"form"})
    public void verifyEmailField() {

    }

    @Test (groups = {"smoke"})
    public void verifySubmitButton() {

    }
}
