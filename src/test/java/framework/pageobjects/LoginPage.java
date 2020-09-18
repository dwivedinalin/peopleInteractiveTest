package framework.pageobjects;

import base.BaseActions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import utility.ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class LoginPage {

    private static final String ROOT_PATH = "user.dir";
    public static List<HashMap<String, String>> datamap;
    private final String SHEET_NAME = "Domain";

    FileInputStream loginproperties;
    Properties properties;

    @Steps
    BaseActions baseActions;

    public LoginPage() {
        try {
            loginproperties = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/framework/objectrepo/login.properties");
            properties = new Properties();
            properties.load(loginproperties);
            String path = System.getProperty(ROOT_PATH) + "/people_interactive.xls";
            datamap = ExcelUtility.data(path, SHEET_NAME);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    @Step("Open the login panel")
    public void open_Login_link(){
        baseActions.getURL("https://www.marathishaadi.com/");
    }

    @Step("User enters the email")
    public void enter_email(){
        try {
            baseActions.click(properties.getProperty("lets_begin"));
            baseActions.entertext(properties.getProperty("email"),"kaxawak700@mail7d.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("User enters password")
    public void enter_password(){
        try {
            baseActions.entertext(properties.getProperty("password"),"Test@123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("User selects profile")
    public void select_profile(){
        try {
            baseActions.click(properties.getProperty("profile_dropdown"));
            baseActions.click(properties.getProperty("self_profile"));
            baseActions.click(properties.getProperty("male_gender"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("User clicks Next button")
    public void click_Next(){
        try {
            baseActions.click(properties.getProperty("next_button"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("User verifies community name")
    public void verify(String arg){
        int index = Integer.parseInt(arg) - 1;
        String community = datamap.get(index).get("Community");
        String community_text=baseActions.getText(properties.getProperty("marathi_community"));

        Assert.assertEquals(community,community_text);
    }




}
