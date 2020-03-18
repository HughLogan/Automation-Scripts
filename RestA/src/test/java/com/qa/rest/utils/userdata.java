package com.qa.rest.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class userdata {
    public static String fname(){
        String nam = RandomStringUtils.randomAlphabetic(2);
        return ("oliver"+nam);
    }
    public static String lname(){
        String nam = RandomStringUtils.randomAlphabetic(2);
        return ("Queen"+nam);
    }
    public static String uname(){
        String nam = RandomStringUtils.randomAlphabetic(2);
        return ("Olive"+nam);
    }
    public static String pass(){
        String nam = RandomStringUtils.randomAlphabetic(2);
        return ("Olive"+nam);
    }
    public static String email(){
        String nam = RandomStringUtils.randomAlphabetic(2);
        return ("OliveQue"+nam+"@gmail.com");
    }
}
