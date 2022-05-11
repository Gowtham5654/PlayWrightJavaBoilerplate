package practice.tests;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import demo.Reporter;
import practice.Datahandler.LoginPage_handler;
import practice.Pages.HomePage;
import practice.Pages.LoginPage;

import java.nio.file.Paths;

public class LoginFunc extends BasicConfig {

    //ThreadLocal<LoginPage> loginpage=new ThreadLocal<>();
    LoginPage_handler loginpagehandler=new LoginPage_handler();


    @Test(enabled = false)
    public void loginfunctionalitycheck1(){
        report.logscenario("Checking the functionality of the login page");
//        loginpage.set(new LoginPage(page));
        LoginPage l1=new LoginPage(page);
        l1.username().fill(loginpagehandler.getusername());
        l1.password().fill(loginpagehandler.getpassword());
        l1.signin().click();
        report.logpass("Login Successful",page);
    }

    @Test
    public void loginfunctionalitycheck2(){
        LoginPage l1=new LoginPage(page);
        report.logscenario("Checking the functionality of the login page");
        entertext(l1.username(),"username",loginpagehandler.getusername());
        entertext(l1.password(),"password",loginpagehandler.getpassword());
        clickelement(l1.signin(),"Sign in");
        report.logpass("Login Successful",page);
    }

    @Test
    public void pimTabCheck() throws InterruptedException {
        HomePage h1=new HomePage(page);
        report.logscenario("Checking the PIM tab");
        h1.getPIMtab().click();
        h1.getEmployeename().fill("Mohan");
        h1.getSearch().click();
        report.logpass("PIM tab check successful",page);
    }

}
