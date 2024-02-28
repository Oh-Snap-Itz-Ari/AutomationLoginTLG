package Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtility extends BaseTest{

    public static FileInputStream getScreenshotPathAsFileStream() throws IOException{
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        return new FileInputStream(srcFile);
    }

}
