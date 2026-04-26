package Tema8;

import Tema8.Ex1.Book;
import Tema8.Ex10.LoginTest;
import Tema8.Ex10.SearchTest;
import Tema8.Ex10.TestCase;
import Tema8.Ex2.Product;
import Tema8.Ex3.Device;
import Tema8.Ex3.Phone;
import Tema8.Ex4.Account;
import Tema8.Ex4.AdminAccount;
import Tema8.Ex5.Course;
import Tema8.Ex5.OnlineCourse;
import Tema8.Ex6.EmailNotification;
import Tema8.Ex6.Notification;
import Tema8.Ex7.OnlineOrder;
import Tema8.Ex7.Order;
import Tema8.Ex8.BasePage;
import Tema8.Ex8.LoginPage;
import Tema8.Ex9.LoginService;
import Tema8.Ex9.User;

public class Main {

    public static void main(String []args) {

    Book book = new Book();
        // exercitiul 1
    book.setTitle("Ion");
    book.setAuthor("Liviu Rebreanu");

        System.out.println("Titlu: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());

        System.out.println();

        // exercitiul 2
        Product product = new Product();
        product.setName("Telefon");
//        product.setPrice(999.99);
        product.setPrice(-273);

        System.out.println("Produsul este: " + product.getName());
        System.out.println("Pretul produsului este: " + product.getPrice() + " lei.");

        System.out.println();

        // exercitiul 3
        Device device = new Device();
        Phone phone = new Phone();

        device.powerOn();
        phone.call();

        System.out.println();

        // exercitiul 4
        Account account = new Account();
        AdminAccount adminAccount = new AdminAccount();

        account.setUsername("cristi");
        System.out.println(account.getUsername());

        account.login();
        adminAccount.deleteUser("cristi");


        // exercitiul 5
        Course course = new Course("Testare manuala", 3);
        OnlineCourse onlineCourse = new OnlineCourse("Testare automata", 4, "Google");

        course.courseDetails();
        onlineCourse.onlineCourseDetails();

        System.out.println();

        // exercitiul 6
        Notification notification = new Notification();
        notification.send();

        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setEmailAdress("cristi@test.com");
        System.out.println(emailNotification.getEmailAdress());
        emailNotification.send();

        System.out.println();

        // exercitiul 7
        Order order = new Order();
        order.printOrder(237);

        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.trackOrder(2384);

        System.out.println();

        // exercitiul 8
        BasePage basePage = new BasePage("Google");
        basePage.openUrl();

        LoginPage loginPage = new LoginPage("Gmail");
        loginPage.login("cristi@test.com", "test1234");

        System.out.println();

        // exercitiul 9

        User user = new User("cristi", "test123");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        LoginService loginService = new LoginService();
        loginService.login("test", "pass98775");

        System.out.println();

        // exercitiul 10
        TestCase testCase = new TestCase("appTest");
        LoginTest loginTest = new LoginTest("loginTest");
        SearchTest searchTest = new SearchTest("searchTest");

        testCase.runTest();
        loginTest.runTest();
        searchTest.runTest();
    }
}
