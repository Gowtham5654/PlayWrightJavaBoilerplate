package practice.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BaseFunc {
    Page page;
    Locator locator;
    Locator username;
    String module="LoginPage";
    private String fieldname;

//    public void setUserName(String Username){
//        this.fieldname=Username;
//    }
//
//    public String getUserName(){
//        return fieldname;
//    }

    public LoginPage(Page page){
        super("LoginPage");
        this.page=page;

    }

    public Locator username(){
        this.locator=getelement(module,"username",page);
        return locator;
    }
    public Locator password(){
        this.locator=getelement(module,"password",page);
        return locator;
    }
    public Locator signin(){
        this.locator=getelement(module,"signin",page);
        return locator;
    }
//
//    public Locator getLocator(String fieldname){
//        this.locator=getelement(module,fieldname,page);
//        return locator;
//    }

    public Locator getlocator(String fieldname){
        this.locator=getelement(module,fieldname,page);
        return locator;
    }

}
