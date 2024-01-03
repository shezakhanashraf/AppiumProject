package baseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.configReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver driver;

    public static configReader confgReader;

    String currentUsersHomeDir = System.getProperty("user.dir");

    public void initializer() throws MalformedURLException {

        DesiredCapabilities cap= new DesiredCapabilities();
        confgReader = new configReader();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, confgReader.getAutomationName());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, confgReader.getPlatformName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, confgReader.getPlatformVersion());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, confgReader.getDeviceName());
        cap.setCapability(MobileCapabilityType.APP, currentUsersHomeDir + confgReader.getApkPath());

        URL url= new URL(confgReader.getAppiumServerURL());

        driver= new AppiumDriver(url,cap);

        AppDriver.setDriver(driver);

    }

    public void quitDriver(){
        if (null != driver){
            driver.quit();
        }
    }
}