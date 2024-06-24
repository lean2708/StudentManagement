package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static final int MIN_ID = 1;
    public static final int MAX_NAME_SIZE = 100;
    public static final int MIN_YEAR = 1990;
    public static final int MAX_YEAR = LocalDate.now().getYear();
    public static final int MAX_ADDRESS = 300;
    public static final double MIN_HEIGHT = 50.0f;
    public static final double MAX_HEIGHT = 300.0f;
    public static final double MIN_WEIGHT = 5.0f;
    public static final double MAX_WEIGHT = 1000.0f;
    public static final int MAX_STUDENTCODE_SIZE = 10;
    public static final int MAX_UNIVERSITY_SIZE = 200;
    public static final int START_YEAR = 1900;
    public static final double MIN_GPA = 0.0d;
    public static final double MAX_GPA = 10.0d;
    public static boolean CheckBirthday(LocalDate birthDate){
        int year = birthDate.getYear();
        int month = birthDate.getMonthValue();
        int day = birthDate.getDayOfMonth();
        if(year < MIN_YEAR || year > MAX_YEAR){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        if(day < 1 || day > birthDate.lengthOfMonth()){
            return false;
        }
        return true;
    }
}
