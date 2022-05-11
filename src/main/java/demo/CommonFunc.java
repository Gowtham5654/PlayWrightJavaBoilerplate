package demo;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonFunc {


        public void entertext(Locator elelocator,String elelabel,String testdata){
            elelocator.fill(testdata);
        }

        public void clickelement(Locator elelocator,String elelabel){
            elelocator.click();
        }

}
