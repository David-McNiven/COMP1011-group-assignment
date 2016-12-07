package HR;

import java.util.GregorianCalendar;
import Warehouse.ServiceClass;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public abstract class Employee {
    private String firstName, lastName, department, position, address, 
            email, phone, status, gender;
    private int idNumber, sin;
    private double payRate;
    private GregorianCalendar dateOfBirth, dateOfHire;
    private static int employeeCount;
    
    // CONSTRUCTORS //
    public Employee(String firstName, String lastName, String address, 
            String email, String phone, String gender, int birthYear, 
            int birthMonth, int birthDay, int sin, String department, 
            String position, String status, int hireYear, int hireMonth, 
            int hireDay, double payRate){
        this(firstName, lastName, address, email, phone, gender,
                birthYear, birthMonth, birthDay, sin);
        this.status = status;
        this.dateOfHire = new GregorianCalendar(hireYear,hireMonth-1,hireDay);
        this.payRate = payRate;
        this.department = department;
        this.position = position;
    }
    public Employee(String firstName, String lastName, String address, 
            String email, String phone, String gender, int birthYear, 
            int birthMonth, int birthDay, int sin) {
        this.firstName = firstName;
        this.lastName = lastName;
        idNumber = ServiceClass.getNewEmployeeID();
        department = "";
        position = "";
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = new GregorianCalendar(birthYear,birthMonth-1,birthDay);
        status = "";
        dateOfHire = new GregorianCalendar();
        payRate = 0.0;
        this.gender = gender;
        this.sin = sin;
        employeeCount++;
    }
    
    // GETS //
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getIDNumber(){
        return this.idNumber;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getPosition(){
        return this.position;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public GregorianCalendar getDateOfBirth(){
        return this.dateOfBirth;
    }
    public String getStatus(){
        return this.status;
    }
    public GregorianCalendar getDateOfHire(){
        return this.dateOfHire;
    }
    public double getPayRate(){
        return this.payRate;
    }
    public String getGender(){
        return this.gender;
    }
    public int getSIN(){
        return this.sin;
    }
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    public int getAge(){
        return  new GregorianCalendar().get(GregorianCalendar.YEAR) - this.dateOfBirth.get(GregorianCalendar.YEAR);
    }
    public int getYearsHired(){
        return  new GregorianCalendar().get(GregorianCalendar.YEAR) - this.dateOfHire.get(GregorianCalendar.YEAR);
    }
    public int getEmployeeCount(){
        return Employee.employeeCount;
    }
    public abstract double getEarnings();
    
    @Override
    public String toString(){
        return "\nName:\t\t\t" + this.getFullName() 
                + "\nAge:\t\t\t" + this.getAge()
                + "\nPosition:\t\t" + this.getPosition()
                + "\nDate of Hire:\t\t" + this.getDateOfHire().getTime().toString()
                + "\nEmployee Number:\t" + this.getIDNumber();
    }
    
    // SETS //
    public Boolean setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        return true;
    }
    public Boolean setDepartment(String department){
        this.department = department;
        return true;
    }
    public Boolean setPosition(String position){
        this.position = position;
        return true;
    }
    public Boolean setAddress(String address){
        this.address = address;
        return true;
    }
    public Boolean setEmail(String email){
        this.email = email;
        return true;
    }
    public Boolean setPhone(String phone){
        this.phone = phone;
        return true;
    }
    public Boolean setDateOfBirth(int year, int month, int day){
        this.dateOfBirth = new GregorianCalendar(year, month-1, day);
        return true;
    }
    public Boolean setStatus(String status){
        this.status = status;
        return true;
    }
    public Boolean setDateOfHire(int year, int month, int day){
        this.dateOfHire = new GregorianCalendar(year, month-1, day);
        return true;
    }
    public Boolean setPayRate(double payRate){
        this.payRate = payRate;
        return true;
    }
    public Boolean setGender(String gender){
        this.gender = gender;
        return true;
    }
    public Boolean setSIN(int sin){
        this.sin = sin;
        return true;
    }
}
