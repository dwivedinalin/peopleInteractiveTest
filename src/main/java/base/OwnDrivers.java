package base;

//public class OwnDrivers implements DriverSource {
//
//    @Managed
//    WebDriver driver;
//
//    @Override
//    public WebDriver newDriver() {
//        try {
//            System.setProperty("webdriver.chrome.driver","src/test/resources/webdriver/mac/chromedriver");
//            ChromeOptions chromeOptions=new ChromeOptions();
//            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//            // Add
//            capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
//            driver=new ChromeDriver(chromeOptions);
//            //takesScreenshots();
//            return driver;
//        }
//        catch (Exception e) {
//            throw new Error(e);
//        }
//    }
//
//    @Override
//    public boolean takesScreenshots() {
//        return true;
//    }
//}
