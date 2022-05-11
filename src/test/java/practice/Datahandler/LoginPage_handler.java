package practice.Datahandler;

import demo.jsonread;

public class LoginPage_handler extends jsonread {

    String module="LoginPage";

    public String getusername(){ return getValue(module,"username");}
    public String getpassword(){ return getValue(module,"password");}

}
