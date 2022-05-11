package practice.Pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage extends BaseFunc{
    Page page;
    String Mainmenu_Options="xpath=//*[@id='mainMenu']/ul/li/a";
    Locator locator;
    String module="HomePage";

    Locator PIMtab;
    Locator Employeename;
    Locator Search;

    public HomePage(Page page){
        super("HomePage");
        this.page=page;
        this.PIMtab=getelement(module,"PIMtab",page);
    }

    public Locator getPIMtab() {
        return PIMtab;
    }

    public Locator getEmployeename() throws InterruptedException {

        this.Employeename=getelement(module,"Employeename",page);
        return Employeename;
    }

    public Locator getSearch() {
        this.Search=getelement(module,"Search",page);
        return Search;
    }

}
