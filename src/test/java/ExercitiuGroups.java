import org.testng.annotations.Test;

public class ExercitiuGroups {

    @Test(groups = {"smoke", "regression"})
    public void addToCart() {

    }

    @Test(groups = {"regression"})
    public void removeFromCart() {

    }

    @Test(groups = {"slow", "regression"})
    public void checkout() {

    }
}
