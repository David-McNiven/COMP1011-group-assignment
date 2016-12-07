package Warehouse;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public abstract class ServiceClass {
    private static int employeeCount = 1000;
    private static int productCount = 100000;
    private static int manufacturerCount = 1000;
    
    // methods for generating unique numeric identifiers
    public static int getNewEmployeeID(){
        return ++employeeCount;
    }
    public static int getNewProductID(){
        return ++productCount;
    }
    public static int getNewManufacturerID(){
        return ++manufacturerCount;
    }
    
    // returns the current year for use in date input validation
    public static int getCurrentYear(){
        return new GregorianCalendar().get(GregorianCalendar.YEAR);
    }
    
    // menu prompts and messages
    public static String introMessage(){
        return "\nWelcome to Georgian General Goods!";
    }
    public static String outroMessage(){
        return "\nThanks for stopping by!";
    }
    public static String topLevelMessage() {
        return "\nWhat would you like to do?" 
                + "\n1. Add new employee" 
                + "\n2. Search employees" 
                + "\n3. Search products" 
                + "\n0. Exit";
    }
    public static String chooseEmployeeTypeMessage(){
        return "\nWhat type of payment structure would you like?"
                + "\n1. Salary"
                + "\n2. Hourly"
                + "\n3. Commission"
                + "\n4. Base plus commission"
                + "\n0. Exit";
    }
    public static String addEmployeeAgainMessage(){
        return "\nWould you like to add another employee?"
                + "\n1. Yes"
                + "\n0. No";
    }
    public static String searchEmployeeMessage(){
        return "\nWhat would you like to search by?"
                + "\n1. Given name"
                + "\n2. Family name"
                + "\n3. Full name"
                + "\n4. SIN"
                + "\n0. Exit";
    }
    public static String correctEmployeeMessage(){
        return "\nIs this the employee you were looking for?"
                + "\n1. Yes"
                + "\n0. No";
    }
    public static String noEmployeeResultsMessage(){
        return "\nCould not find desired employee, try refining your search";
    }
    public static String searchProductMessage(){
        return "\nWhat would you like to search by?"
                + "\n1. Name"
                + "\n2. Description"
                + "\n0. Exit";
    }
    public static String correctProductMessage(){
        return "\nIs this the product you were looking for?"
                + "\n1. Yes"
                + "\n0. No";
    }
    public static String noProductResultsMessage(){
        return "\nCould not find desired product, try refining your search";
    }
    public static String viewManufacturerMessage(){
        return "\nWould you like to view the manufacturers information?"
                + "\n1 Yes"
                + "\n0. No";
    }
    public static String searchAgainMessage(){
        return "\nWould you like to perform another search?"
                + "\n1. Yes"
                + "\n0. No";
    }
    public static String firstNamePrompt(){
        return "\nPlease enter the employee's given name";
    }
    public static String lastNamePrompt(){
        return "\nPlease enter the employee's family name";
    }
    public static String fullNamePrompt(){
        return "\nPlease enter the employee's full name";
    }
    public static String addressPrompt(){
        return "\nPlease enter the employee's address";
    }
    public static String emailPrompt(){
        return "\nPlease enter the employee's email";
    }
    public static String phonePrompt(){
        return "\nPlease enter the employee's phone number";
    }
    public static String genderPrompt(){
        return "\nPlease enter the employee's gender";
    }
    public static String birthYearPrompt(){
        return "\nPlease enter the employee's year of birth";
    }
    public static String birthMonthPrompt(){
        return "\nPlease enter the employee's month of birth";
    }
    public static String birthDayPrompt(){
        return "\nPlease enter the employee's day of birth";
    }
    public static String sinPrompt(){
        return "\nPlease enter the employee's social insurance number";
    }
    public static String salaryPrompt(){
        return "\nPlease enter the employee's salary";
    }
    public static String hourlyRatePrompt(){
        return "\nPlease enter the employee's hourly pay";
    }
    public static String hoursWorkedPrompt(){
        return "\nPlease enter the employee's hours worked";
    }
    public static String commissionRatePrompt(){
        return "\nPlease enter the employee's commission rate";
    }
    public static String grossSalesPrompt(){
        return "\nPlease enter the employee's gross sales";
    }
    public static String basePayPrompt(){
        return "\nPlease enter the employee's base pay rate";
    }
    public static String productNamePrompt(){
        return "\nPlease enter the product's name";
    }
    public static String productDescriptionPrompt(){
        return "\nPlease enter the product's description";
    }
    
    // handles user input validation for strings
    public static String readString(String prompt){
        Scanner keyboard = new Scanner(System.in);
        String userInput = "";
        Boolean invalid = true;
        do {
            System.out.println(prompt);
            userInput = keyboard.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("Must be a non-empty value");
            } else {
                invalid = false;
            }
        }while(invalid);
        return userInput;
    }
    
    // user input validation for integers
    // overloads for cases with minimum and maximum values
    public static int readInt(String prompt, int min, int max){
        int userInt = 0;
        Boolean invalid = true;
        do {
            userInt = readInt(prompt, min);
            if (userInt <= max) {
                    invalid = false;
                } else {
                    System.out.println("Must be less than or equal to " + max);
                }
        }while(invalid);
        return userInt;
    }
    public static int readInt(String prompt, int min){
        int userInt = 0;
        Boolean invalid = true;
        do {
            userInt = readInt(prompt);
            if (userInt >= min) {
                invalid = false;
            } else {
                System.out.println("Must be " + min + " or greater");
            }
        }while(invalid);
        return userInt;
    }
    public static int readInt(String prompt){
        Scanner keyboard = new Scanner(System.in);
        String userInput = "";
        // allows only numeric values, no brackets, no decimals, no negatives
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(userInput);
        int parsedInt = 0;
        Boolean invalid = true;
        do {
            System.out.println(prompt);
            userInput = keyboard.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("Must be a non-empty value");
            } else if (userInput.length() >= 11){
                System.out.println("Cannot be more than 10 digits long");
            } else if (!matcher.reset(userInput).matches()){
                System.out.println("Must be a positive number");
            } else if (userInput.length() == 10 && "2147483647".compareTo(userInput) < 0) {
                // checks against the max int if it is the max length
                System.out.println("Must be less than 2147483647");
            } else {
                parsedInt = parseInt(userInput);
                invalid = false;
            }
        } while(invalid);
        return parsedInt;
    }
    
    // user input validation for doubles
    // also overloads for minimum and maximum values
    public static double readDouble(String prompt, double min, double max){
        double userDouble = 0.0;
        Boolean invalid = true;
        do {
            userDouble = readDouble(prompt, min);
            if (userDouble <= max) {
                invalid = false;
            } else {
                System.out.println("Must be less than or equal to " + max);
            }
        } while (invalid);
        return userDouble;
    }
    public static double readDouble(String prompt, double min){
        double userDouble = 0.0;
        Boolean invalid = true;
        do {
            userDouble = readDouble(prompt);
            if (userDouble >= min) {
                invalid = false;
            } else {
                System.out.println("Must be " + min + " or greater");
            }
        } while (invalid);
        return userDouble;
    }
    public static double readDouble(String prompt){
        Scanner keyboard = new Scanner(System.in);
        String userInput = "";
        // allows any number of decimal values and java's e^n notation
        Pattern pattern = Pattern.compile("^([0-9]+(\\.[0-9]+)?|\\.[0-9]+)([eE]\\-?[0-9]+)?$");
        Matcher matcher = pattern.matcher(userInput);
        double parsedDouble = 0.0;
        Boolean invalid = true;
        do {
            System.out.println(prompt);
            userInput = keyboard.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("Must be a non-empty value");
            } else if (userInput.length() >= 16) {
                System.out.println("Must be less than 16 digits long");
            } else if (!matcher.reset(userInput).matches()){
                System.out.println("Must be a positive number");
            } else {
                parsedDouble = parseDouble(userInput);
                invalid = false;
            }
        } while(invalid);
        return parsedDouble;
    }
}
