package demo.config;

import com.microsoft.playwright.*;
import demo.jsonread;

import java.nio.file.Paths;

public class BrowserConfig {

    Browser browser;
    BrowserContext context;
    jsonread jsonprop=new jsonread();

    public Browser browserinit(Playwright playwright) {
        boolean headless = false;
        String browsername = jsonread.getbrowser();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel(browsername);
        lp.setHeadless(headless);
        if (jsonread.getheadless().equals("true")) {
            headless = true;
        }
        //Browser browser = playwright.chromium().launch();
        switch (browsername) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "Firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "Webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "chrome":
                browser = playwright.chromium().launch(lp);
                break;
            case "edge ":
                browser = playwright.chromium().launch(lp);
                break;
        }
        return browser;
    }
    public BrowserContext contextinit(Browser browser) {
        if (jsonread.getvideorecording().equals("ON")) {
            context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
        } else {
            context = browser.newContext();
        }
    return context;
    }

}
