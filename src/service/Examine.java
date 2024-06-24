package fact.service;
import service.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Examine {
    public static ArrayList<Integer> ListID = new ArrayList<Integer>();
    public static int ExamineID(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("ID: ");
            int id = scanner.nextInt();
            if(id < Constants.MIN_ID || ListID.contains(id)){
                System.out.println("Your ID is NOT Invalid");
            }
            else{
                System.out.println("Your ID is Valid");
                return id;
            }
        }
    }
    public static String ExamineName(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            boolean number = false;
            for(int i = 0; i < name.length(); i++){
                if(Character.isDigit(name.charAt(i))){
                    number = true;
                    break;
                }
            }
            if (name == null || name.length() > service.Constants.MAX_NAME_SIZE || number == true) {
                System.out.println("Your Name is NOT Invalid");
            }
            else {
                System.out.println("Your Name is Valid");
                return name;
            }
        }
    }
    public static LocalDate ExamineBirthday(){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true){
            try {
                System.out.print("Birthday (dd/mm/yyyy): ");
                String input = scanner.nextLine();
                LocalDate birthday = LocalDate.parse(input, formatter);
                if (Constants.CheckBirthday(birthday)) {
                    System.out.println("Your Birthday is Valid");
                    return birthday;
                } else {
                    System.out.println("Your Birthday is NOT Invalid");
                }
            }
            catch (DateTimeParseException e){
                System.out.println("Your Birthday is NOT Invalid");
            }
        }
    }
    public static String ExamineAddress(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Address: ");
            String address = scanner.nextLine();
            if(address == null || address.length() > service.Constants.MAX_ADDRESS){
            System.out.println("Your Address is NOT Invalid");
            }
            else{
            System.out.println("Your Address is Valid");
            return address;
            }
        }
    }
    public static double ExamineHeight(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Height (cm): ");
            if(scanner.hasNextDouble()) {
                double height = scanner.nextDouble();
                if (height < service.Constants.MIN_HEIGHT || height > service.Constants.MAX_HEIGHT) {
                    System.out.println("Your Height is NOT Invalid");
                } else {
                    System.out.println("Your Height is Valid");
                    return height;
                }
            }
            else{
                System.out.println("Your Height is NOT Invalid");
                scanner.next();
            }
        }
    }
    public static double ExamineWeight(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Weight (kg): ");
            if(scanner.hasNextDouble()) {
                double weight = scanner.nextDouble();
                if (weight < service.Constants.MIN_WEIGHT || weight > service.Constants.MAX_WEIGHT) {
                    System.out.println("Your Weight is NOT Invalid");
                } else {
                    System.out.println("Your Weight is Valid");
                    return weight;
                }
            }else{
                System.out.println("Your Weight is NOT Invalid");
                scanner.next();
            }
        }
    }
    public static String ExamineStudentCode(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Student Code (10 characters): ");
            String studentCode = scanner.nextLine();
            if((studentCode == null) || (studentCode.length() != service.Constants.MAX_STUDENTCODE_SIZE)){
                System.out.println("Your Student Code is NOT Invalid");
            }
            else{
                System.out.println("Your Student Code is Valid");
                return studentCode;
            }
        }

    }
    public static String ExamineUniversity(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("University: ");
            String university = scanner.nextLine();
            if(university == null || university.length() > service.Constants.MAX_UNIVERSITY_SIZE){
                System.out.println("Your University is NOT Invalid");
            }
            else{
                System.out.println("Your University is Valid");
                return university;
            }
        }
    }
    public static int ExamineStartYear(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Start Year: ");
            if(scanner.hasNextInt()) {
                int startYear = scanner.nextInt();
                if (startYear < service.Constants.MIN_YEAR || startYear >= Constants.MAX_YEAR) {
                    System.out.println("Your Start Year is NOT Invalid");
                } else {
                    System.out.println("Your Start Year is Valid");
                    return startYear;
                }
            }
            else{
                System.out.println("Your Start Year is NOT Invalid");
                scanner.next();
            }
        }
    }
    public static double ExamineGPA(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("GPA: ");
            if(scanner.hasNextDouble()) {
                double gpa = scanner.nextDouble();
                if (gpa < service.Constants.MIN_GPA || gpa > service.Constants.MAX_GPA) {
                    System.out.println("Your GPA is NOT Invalid");
                } else {
                    System.out.println("Your GPA is Valid");
                    return gpa;
                }
            }
            else{
                System.out.println("Your GPA is NOT Invalid");
                scanner.next();
            }
        }
    }
}
