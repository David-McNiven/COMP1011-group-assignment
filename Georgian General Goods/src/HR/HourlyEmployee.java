package HR;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public class HourlyEmployee extends Employee{
    private double hourlyRate;
    private double hoursWorked;
    
    // CONSTRUCTORS //
    public HourlyEmployee(String firstName, String lastName, String address, 
            String email, String phone, String gender, int birthYear, 
            int birthMonth, int birthDay, int sin, String department, 
            String position, String status, int hireYear, int hireMonth, 
            int hireDay, double payRate, double hourlyRate, double hoursWorked){
        super(firstName, lastName, address, email, phone, gender, 
                birthYear, birthMonth, birthDay, sin, department, position, 
                status, hireYear, hireMonth, hireDay, payRate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public HourlyEmployee(String firstName, String lastName, 
            String address, String email, String phone, String gender,
            int birthYear, int birthMonth, int birthDay,  int sin,
            double hourlyRate, double hoursWorked){
        super(firstName,lastName,address,email,phone,gender,
                birthYear,birthMonth,birthDay,sin);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    // GETS // 
    @Override
    public String toString(){
        return super.toString() + "\nHourly Rate:\t\t" + this.getHourlyRate()
                + "\nHours Worked:\t\t" + this.getHoursWorked()
                + "\nTotal Earnings:\t\t" + this.getEarnings();
    }
    public double getHourlyRate(){
        return this.hourlyRate;
    }
    public double getHoursWorked(){
        return this.hoursWorked;
    }
    @Override
    public double getEarnings(){
        return Math.round(this.hourlyRate * this.hoursWorked * 100) / 100;
    }
    
    // SETS // 
    public Boolean setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
        return true;
    }
    public Boolean setHoursWorked(double hoursWorked){
        this.hoursWorked = hoursWorked;
        return true;
    }
}
