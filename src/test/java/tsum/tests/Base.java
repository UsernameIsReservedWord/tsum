package tsum.tests;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.SystemUtils;
import org.yecht.Data;

import java.util.Random;

public class Base {

    public void setDriver() {
        String driver;
        if (SystemUtils.IS_OS_WINDOWS) {
            driver = "geckodriver.exe";
        } else if (SystemUtils.IS_OS_LINUX) {
            driver = "geckodriver";
        } else {
            driver = "";
        }
        System.setProperty("webdriver.gecko.driver", String.format("%s%s%s",
                System.getProperty("user.dir"),
                "/src/main/resources/drivers/",
                driver));
    }
}
