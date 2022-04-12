package restful.booker.helper;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class DataGenerator {


    private static final Random random = new Random();

    private DataGenerator() {
    }

    public static String randomString(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return (RandomStringUtils.random(length, useLetters, useNumbers));
    }


    public static Integer randomInteger(Integer lowerLimit, Integer upperLimit) {
        return lowerLimit + (random.nextInt() * (upperLimit - lowerLimit));
    }


}
