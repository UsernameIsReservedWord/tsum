package tsum.tests;

import net.bytebuddy.utility.RandomString;

import java.util.Random;

public class Base {

    public static String getRandomString(int length) {
        return RandomString.make(length);
    }
}
