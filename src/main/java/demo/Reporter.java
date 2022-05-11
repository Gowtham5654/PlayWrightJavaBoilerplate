package demo;

import com.microsoft.playwright.Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import demo.config.Utility.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Reporter {

    ExtentReports extent;
    static ExtentTest logger;
    protected static String REPORT_PATH = "Report/Extent Report/";
    public static String resultpath;
    public static String folderName = "";

    public void createreport() {
        resultpath = REPORT_PATH + util.getTimeStamp();
        extent = new ExtentReports(resultpath + "/ExtentReportResults.html");
        extent.addSystemInfo("User Name", System.getProperty("user.name"));
        extent.addSystemInfo("OS", System.getProperty("os.name"));
        extent.addSystemInfo("Environment", "Automation Testing");
        util.createFolder(resultpath + "/Screenshot/");
    }

    public static synchronized String addscreenshot(Page page) throws IOException {
        File directory = new File(resultpath + "/Screenshot/" + folderName);
        if (!directory.exists())
            directory.mkdir();
        int count = new File(resultpath + "/Screenshot/" + folderName).list().length + 1;
        String screenshotpath = resultpath + "/Screenshot/" + folderName + "/Image" + count + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotpath)).setFullPage(true));
        String screenshotlink = "./Screenshot/" + folderName + "/Image" + count + ".png";
        return screenshotlink;
    }

    public void starttest(String methodname){
        logger=extent.startTest(methodname);
    }

    public  void logscenario(String logmsg){
        logger.log(LogStatus.INFO, "<b>" + logmsg + "</b>", "");
    }


    public void logpass(String logmsg){ logpass(logmsg,null);}
    public void logpass(String logmsg,Page page){
        if(page!=null){
            try {
                logger.log(LogStatus.PASS, "", logmsg + logger.addScreenCapture(Reporter.addscreenshot(page)));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        else {
            logger.log(LogStatus.PASS, "", logmsg );
        }
    }

    public void logfail(String logmsg){
        logger.log(LogStatus.FAIL,"",logmsg);
    }



    public void endtest(){
        extent.endTest(logger);
    }

    public void endreport(){
        extent.flush();
        extent.close();
    }
    }

