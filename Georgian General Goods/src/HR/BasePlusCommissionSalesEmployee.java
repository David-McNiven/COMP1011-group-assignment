package HR;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public class BasePlusCommissionSalesEmployee extends CommissionSalesEmployee {

    private double baseSalary;

    // CONSTRUCTORS //
    public BasePlusCommissionSalesEmployee(String firstName, String lastName,
            String address, String email, String phone, String gender,
            int birthYear, int birthMonth, int birthDay,  int sin,
            double commissionRate, double grossSales, double baseSalary) {
        super(firstName, lastName, address, email, phone, gender, 
                birthYear, birthMonth, birthDay, sin, 
                commissionRate, grossSales);
        this.baseSalary = baseSalary;
    }

    public BasePlusCommissionSalesEmployee(String firstName, String lastName, String address, 
            String email, String phone, String gender, int birthYear, 
            int birthMonth, int birthDay, int sin, String department, 
            String position, String status, int hireYear, int hireMonth, 
            int hireDay, double payRate, double commissionRate, 
            double grossSales, double baseSalary) {
        super(firstName, lastName, address, email, phone, gender, 
                birthYear, birthMonth, birthDay, sin, department, position, 
                status, hireYear, hireMonth, hireDay, payRate, 
                commissionRate, grossSales);
        this.baseSalary = baseSalary;
    }

    // GETS //
    public double getBaseSalary() {
        return this.baseSalary;
    }
    
    @Override
    public double getEarnings(){
        return super.getEarnings() + baseSalary * super.getYearsHired();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nBase Salary:\t\t" + this.getBaseSalary();
    }

    // SETS //
    public Boolean setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return true;
    }
}
