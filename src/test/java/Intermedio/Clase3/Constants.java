package Intermedio.Clase3;

import com.github.javafaker.Faker;

public class Constants {
    public static final String PASSWORD = "helloworld";
    public static final String BIRTH_DAY="8";
    public static final String BIRTH_MONTH = "11";
    public static final String BIRTH_YEAR ="1992";
    public static final String CITY = "NEW YORK";

    private static Faker FAKER = new Faker();
    public static String FAKE_FIRST_NAME = FAKER.name().firstName();
    public static String FAKE_LAST_NAME = FAKER.name().lastName();
    public static String EMAIL_ADDRESS = "seleniumintermedio" + Math.random() + "test@gmail.com" ;


}
