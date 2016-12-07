package HR;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public class CommissionSalesEmployee extends Employee{
    private double commissionRate;
    private double grossSales;
    
    // CONSTRUCTORS //
    public CommissionSalesEmployee(String firstName, String lastName, String address, 
            String email, String phone, String gender, int birthYear, 
            int birthMonth, int birthDay, int sin, String department, 
            String position, String status, int hireYear, int hireMonth, 
            int hireDay, double payRate, double commissionRate, 
            double grossSales){
        super(firstName, lastName, address, email, phone, gender, birthYear,
                birthMonth, birthDay, sin, department, position,  status, 
                hireYear, hireMonth, hireDay, payRate);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }
    public CommissionSalesEmployee(String firstName, String lastName, 
            String address, String email, String phone, String gender,
            int birthYear, int birthMonth, int birthDay,  int sin,
            double commissionRate, double grossSales){
        super(firstName, lastName, address, email, phone, gender,
                birthYear, birthMonth, birthDay, sin);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }
    
    // GETS // 
    @Override
    public String toString(){
        return super.toString() + "\nGross Sales:\t\t" + this.getGrossSales()
                + "\nCommission Rate:\t" + this.getCommissionRate()
                + "\nTotal Earnings:\t\t" + this.getEarnings();
    }
    public double getCommissionRate(){
        return this.commissionRate;
    }
    public double getGrossSales(){
        return this.grossSales;
    }
    @Override
    public double getEarnings(){
        return Math.round(this.commissionRate * this.grossSales * 100) / 100;
    }
    
    // SETS // 
    public Boolean setCommissionRate(double commissionRate){
        this.commissionRate = commissionRate;
        return true;
    }
    public Boolean setGrossSales(double grossSales){
        this.grossSales = grossSales;
        return true;
    }
}
