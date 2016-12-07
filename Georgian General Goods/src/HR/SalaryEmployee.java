package HR;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public class SalaryEmployee extends Employee{
    private double salary;
    
    // CONSTRUCTORS //
    public SalaryEmployee(String firstName, String lastName, String address, 
            String email, String phone, String gender, int birthYear, 
            int birthMonth, int birthDay, int sin, String department, 
            String position, String status, int hireYear, int hireMonth, 
            int hireDay, double payRate, double salary){
        super(firstName, lastName, address, email, phone, gender, 
                birthYear, birthMonth, birthDay, sin, department, position, 
                status, hireYear, hireMonth, hireDay, payRate);
        this.salary = salary;
    }
    public SalaryEmployee(String firstName, String lastName, 
            String address, String email, String phone, String gender, 
            int birthYear, int birthMonth, int birthDay, int sin, 
            double salary){
        super(firstName,lastName,address,email,phone,gender,
                birthYear,birthMonth,birthDay,sin);
        this.salary = salary;
    }
    
    // GETS // 
    @Override
    public String toString(){
        return super.toString() + "\nSalary:\t\t\t" + this.getSalary();
    }
    public double getSalary(){
        return this.salary;
    }
    @Override
    public double getEarnings(){
        return Math.round(this.salary * super.getYearsHired() * 100) / 100;
    }
    
    // SETS // 
    public Boolean setSalary(double salary){
        this.salary = salary;
        return true;
    }
}
