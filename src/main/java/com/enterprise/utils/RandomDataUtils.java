package com.enterprise.utils;

import java.util.Random;
import com.enterprise.models.*;


public class RandomDataUtils {
	
	private static final Random RANDOM=new Random();
	
	private RandomDataUtils()
	{
		
	}
	
	public static String getRandomNumber() {
		return String.valueOf(1000+RANDOM.nextInt(9000));
	}
	
	public static String getRandomFirstName() {

        return "test" + getRandomNumber();

    }

    public static String getRandomMiddleName() {

        return "user";

    }

    public static String getRandomLastName() {

        return "Sample" + getRandomNumber();

    }
    
    public static String getRandomEmployeeID() {
    	return getRandomNumber();
    }
    
    public static Employee getRandomEmployee() {

        return new Employee(
                getRandomFirstName(),
                getRandomMiddleName(),
                getRandomLastName(),
        		getRandomEmployeeID());

    }

}
