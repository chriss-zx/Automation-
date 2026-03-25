import org.testng.annotations.Test;

public class Priorities {

    // prioritatea default este 0.

    @Test
    public void openHomePage() {

    }

    @Test (priority = 1)
    public void verifyTitle() {

    }

    @Test (priority = 2)
    public void verifyLoginButton() {

    }

    @Test (priority = 3)
    public void verifyFooter() {

    }
}