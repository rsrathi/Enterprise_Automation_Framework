package com.enterprise.utils;

import java.util.Random;

public class RandomDataUtils {
	
	private static final Random RANDOM=new Random();
	
	private RandomDataUtils()
	{
		
	}
	
	public static String getRandomNumber() {
		return String.valueOf(1000+RANDOM.nextInt(9000));
	}
	
	public static String getRandomFirstName() {

        return "John" + getRandomNumber();

    }

    public static String getRandomMiddleName() {

        return "A";

    }

    public static String getRandomLastName() {

        return "Smith" + getRandomNumber();

    }

}
