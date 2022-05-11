package practice.Pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import demo.Reporter;
import demo.jsonread;

import java.util.List;

public class BaseFunc {
    Locator locator;
    Page page;


    String module;

    public BaseFunc(String module){
        this.module=module;
    }

    public ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();
    static jsonread jsonread=new jsonread();
    Reporter report=new Reporter();


    public static Locator getelementfrombrowser(String label, Page page) {
        Locator locator = null;
        try {
            ElementHandle e1=page.waitForSelector(label);
            //ElementHandle e1=page.querySelector(label);
            if (e1 == null) {
                e1=page.waitForSelector(label);
                //e1=page.querySelector(label);
            }
            if(e1!=null){
                locator = page.locator(label);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the element with the locator : " +label);
            e.printStackTrace();
        }
        return locator;
    }

    public static Locator getelement(String module,String fieldname, Page page) {
        Locator locator = null;
        List<String> element=null;
        element = jsonread.getElementLocators(module,fieldname);
        try {
            for (String ele:element){
                locator=getelementfrombrowser(ele,page);
                if (locator!=null){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return locator;
    }

}
