package demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class jsonread {

    public final static String defaultconfigfolderpath = "Configuration/";
    final static String Locatorspath="TestData/Locators/";
    final static String TestdataPath = "TestData/";
    static JSONObject jsonConfig;

    //loading configuration files
    public static void loadConfigFile() {

        String path = defaultconfigfolderpath + "Config.json";
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(new FileReader(path));
            jsonConfig = (JSONObject) obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getbrowser(){
        return (String) jsonConfig.get("browser");
    }
    public static String getappurl(){
        return (String) jsonConfig.get("appurl");
    }
    public static String getvideorecording(){
        return (String) jsonConfig.get("videorecording");
    }
    public static String getheadless(){
        return (String) jsonConfig.get("headless");
    }


    //JSON Read functions

    private static JSONObject getModule(String jsonName) {

        JSONObject jsonObj = null;
        String path;
        JSONParser parser = new JSONParser();
        Object obj;
        path = TestdataPath + jsonName + "/" + jsonName + ".json";
        try {
            if (new File(path).exists()) {
                obj = parser.parse(new FileReader(path));
                jsonObj = (JSONObject) obj;
            } else {
                jsonObj = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public static synchronized String getValue(String module, String propname) {

        if (getModule(module) != null && (String) getModule(module).get(propname) != null)
            return (String) getModule(module).get(propname);
        else
            System.out.println("No matching JSON Values");
            return null;
    }

//    public static JSONObject getjsonobject() {
//        JSONObject jsonObj = null;
//        String path;
//        JSONParser parser = new JSONParser();
//        Object obj;
//        path="TestData/properties.json";
//        try {
//            if (new File(path).exists()) {
//                obj = parser.parse(new FileReader(path));
//                jsonObj = (JSONObject) obj;
//            } else {
//                jsonObj = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonObj;
//    }
//
//    public String getproperty(String propname) {
//        String jsonValue = null;
//        JSONObject jsonobj=getjsonobject();
//        if (jsonobj != null)
//            jsonValue = (String) jsonobj.get(propname);
//        if (jsonValue != null)
//            return jsonValue;
//        else {
//            //Reporter.logFailForConf(jsonobj + " : " + propname, "property");
//            System.out.println("No matching json value");
//            return null;
//        }
//    }

    //Finding Locators using identifiers from JSON files

    public static JSONObject getjsonobject(String jsonName) {
        JSONObject jsonObj = null;
        String path;
        JSONParser parser = new JSONParser();
        Object obj;
        path= Locatorspath + jsonName + ".json";
        try {
            if (new File(path).exists()) {
                obj = parser.parse(new FileReader(path));
                jsonObj = (JSONObject) obj;
            } else {
                jsonObj = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public static List<String> getElementLocators(String module, String propname) {
        List<String> jsonValue= null;
        String s1;
        JSONObject jsonobj=getjsonobject(module);
        if (jsonobj != null)
            jsonValue =(List<String>) jsonobj.get(propname);
        if (jsonValue != null)
            return jsonValue;
        else {
            System.out.println("No matching json value");
            return null;
        }
    }

}


