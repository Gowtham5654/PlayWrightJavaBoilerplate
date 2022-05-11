package practice.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.*;
import demo.CommonFunc;
import demo.Reporter;
import demo.config.BrowserConfig;
import demo.jsonread;
import org.testng.annotations.*;


import java.lang.reflect.Method;

public class BasicConfig extends CommonFunc {
    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext context;

    jsonread jsonprop=new jsonread();
    Reporter report=new Reporter();
    BrowserConfig browserconfig=new BrowserConfig();


    @BeforeTest
    public void setup(){
        jsonread.loadConfigFile();
        playwright=Playwright.create();
        System.out.println("Before Test");
        browser=browserconfig.browserinit(playwright);
        context=browserconfig.contextinit(browser);
        page= context.newPage();
        page.navigate(jsonread.getappurl());
        System.out.println(page.url());
        System.out.println(page.title());
        report.createreport();
    }


    @BeforeMethod
    public void beforemethod(Method method){
        System.out.println("Before Method");
        report.starttest(method.getName());
    }


    @AfterMethod
    public void aftermethod(){
        System.out.println("After Method");
        report.endtest();
    }

    @AfterTest
    public void tearup(){
        System.out.println("After Test");
        report.endreport();
        context.close();
        browser.close();
        playwright.close();
    }
}
