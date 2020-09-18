package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGeneratorUtility {

    public static String random_GeneratingRandomString() {
        String randomString = RandomStringUtils.randomAlphabetic(6);
        return randomString;
    }
}
