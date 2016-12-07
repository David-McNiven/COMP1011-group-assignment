package Warehouse;

import HR.*;
import Procurement.*;
import java.util.ArrayList;

/**
 * Student ID# 200330143
 * @author David McNiven
 * 
 * A simple employee management program with limited functionality.
 * Currently allows creation of employees, searching employees, 
 * searching products and viewing said products manufacturer information.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList();
        ArrayList<Product> products = new ArrayList();
        ArrayList<Manufacturer> manufacturers = new ArrayList();
        int menuNav = 0;
        Boolean exiting = false;

        // MENU DRIVEN INTERFACE //
        System.out.println(ServiceClass.introMessage());
        do {//top level menu
            menuNav = ServiceClass.readInt(ServiceClass.topLevelMessage(), 0, 3);
            if (menuNav == 1) {
                do {// adding new employees
                    menuNav = ServiceClass.readInt(ServiceClass.chooseEmployeeTypeMessage(), 0, 4);
                    if (menuNav == 1) {
                        // create salary based employee
                        employees.add(new SalaryEmployee(ServiceClass.readString(ServiceClass.firstNamePrompt()),
                                ServiceClass.readString(ServiceClass.lastNamePrompt()), 
                                ServiceClass.readString(ServiceClass.addressPrompt()),
                                ServiceClass.readString(ServiceClass.emailPrompt()), 
                                ServiceClass.readString(ServiceClass.phonePrompt()),
                                ServiceClass.readString(ServiceClass.genderPrompt()), 
                                ServiceClass.readInt(ServiceClass.birthYearPrompt(),ServiceClass.getCurrentYear() - 150,ServiceClass.getCurrentYear()),
                                ServiceClass.readInt(ServiceClass.birthMonthPrompt(), 1, 12), 
                                ServiceClass.readInt(ServiceClass.birthDayPrompt(), 1, 31),
                                ServiceClass.readInt(ServiceClass.sinPrompt()), 
                                ServiceClass.readDouble(ServiceClass.salaryPrompt())));
                    } else if (menuNav == 2) {
                        // create paid by the hour employee
                        employees.add(new HourlyEmployee(ServiceClass.readString(ServiceClass.firstNamePrompt()),
                                ServiceClass.readString(ServiceClass.lastNamePrompt()), 
                                ServiceClass.readString(ServiceClass.addressPrompt()),
                                ServiceClass.readString(ServiceClass.emailPrompt()), 
                                ServiceClass.readString(ServiceClass.phonePrompt()),
                                ServiceClass.readString(ServiceClass.genderPrompt()), 
                                ServiceClass.readInt(ServiceClass.birthYearPrompt(),ServiceClass.getCurrentYear() - 150,ServiceClass.getCurrentYear()),
                                ServiceClass.readInt(ServiceClass.birthMonthPrompt(), 1, 12), 
                                ServiceClass.readInt(ServiceClass.birthDayPrompt(), 1, 31),
                                ServiceClass.readInt(ServiceClass.sinPrompt()), 
                                ServiceClass.readDouble(ServiceClass.hourlyRatePrompt()), 
                                ServiceClass.readDouble(ServiceClass.hoursWorkedPrompt())));
                    } else if (menuNav == 3) {
                        // create commission based employee
                        employees.add(new CommissionSalesEmployee(ServiceClass.readString(ServiceClass.firstNamePrompt()),
                                ServiceClass.readString(ServiceClass.lastNamePrompt()), 
                                ServiceClass.readString(ServiceClass.addressPrompt()),
                                ServiceClass.readString(ServiceClass.emailPrompt()), 
                                ServiceClass.readString(ServiceClass.phonePrompt()),
                                ServiceClass.readString(ServiceClass.genderPrompt()), 
                                ServiceClass.readInt(ServiceClass.birthYearPrompt(),ServiceClass.getCurrentYear() - 150,ServiceClass.getCurrentYear()),
                                ServiceClass.readInt(ServiceClass.birthMonthPrompt(), 1, 12), 
                                ServiceClass.readInt(ServiceClass.birthDayPrompt(), 1, 31),
                                ServiceClass.readInt(ServiceClass.sinPrompt()),
                                ServiceClass.readDouble(ServiceClass.commissionRatePrompt()), 
                                ServiceClass.readDouble(ServiceClass.grossSalesPrompt())));
                    } else if (menuNav == 4) {
                        // create base plus commission employee
                        employees.add(new BasePlusCommissionSalesEmployee(ServiceClass.readString(ServiceClass.firstNamePrompt()),
                                ServiceClass.readString(ServiceClass.lastNamePrompt()), 
                                ServiceClass.readString(ServiceClass.addressPrompt()),
                                ServiceClass.readString(ServiceClass.emailPrompt()), 
                                ServiceClass.readString(ServiceClass.phonePrompt()),
                                ServiceClass.readString(ServiceClass.genderPrompt()), 
                                ServiceClass.readInt(ServiceClass.birthYearPrompt(),ServiceClass.getCurrentYear() - 150,ServiceClass.getCurrentYear()),
                                ServiceClass.readInt(ServiceClass.birthMonthPrompt(), 1, 12), 
                                ServiceClass.readInt(ServiceClass.birthDayPrompt(), 1, 31),
                                ServiceClass.readInt(ServiceClass.sinPrompt()),
                                ServiceClass.readDouble(ServiceClass.commissionRatePrompt()), 
                                ServiceClass.readDouble(ServiceClass.grossSalesPrompt()),
                                ServiceClass.readDouble(ServiceClass.basePayPrompt())));
                    } else {
                        exiting = true;
                    }
                    // prompt for adding another employee
                    if (!exiting) {
                        menuNav = ServiceClass.readInt(ServiceClass.addEmployeeAgainMessage(), 0, 1);
                        if (menuNav == 0) {
                            exiting = true;
                        }
                    }
                } while (!exiting);
                exiting = false;// end of adding employees menu
            } else if (menuNav == 2) {
                do {// employee search menu
                    int foundAt = 0;
                    menuNav = ServiceClass.readInt(ServiceClass.searchEmployeeMessage(), 0, 4);
                    if (menuNav == 1) {
                        String firstName = ServiceClass.readString(ServiceClass.firstNamePrompt());
                        do { // search by employees first name
                            if (foundAt >= employees.size()) {
                                exiting = true;
                            } else if (employees.get(foundAt).getFirstName().equals(firstName)) {
                                // check if correct result is found
                                menuNav = ServiceClass.readInt(employees.get(foundAt).toString()
                                        + ServiceClass.correctEmployeeMessage(), 0, 1);
                                if (menuNav == 1) {
                                    exiting = true;
                                } else {
                                    foundAt++;
                                }
                            } else {
                                foundAt++;
                            }
                        } while (!exiting);
                    } else if (menuNav == 2) {
                        String lastName = ServiceClass.readString(ServiceClass.lastNamePrompt());
                        do { // search by employees last name
                            if (foundAt >= employees.size()) {
                                exiting = true;
                            } else if (employees.get(foundAt).getLastName().equals(lastName)) {
                                // check if correct result is found
                                menuNav = ServiceClass.readInt(employees.get(foundAt).toString()
                                        + ServiceClass.correctEmployeeMessage(), 0, 1);
                                if (menuNav == 1) {
                                    exiting = true;
                                } else {
                                    foundAt++;
                                }
                            } else {
                                foundAt++;
                            }
                        } while (!exiting);
                    } else if (menuNav == 3) {
                        String fullName = ServiceClass.readString(ServiceClass.fullNamePrompt());
                        do { // search by employees full name
                            if (foundAt >= employees.size()) {
                                exiting = true;
                            } else if (employees.get(foundAt).getFullName().equals(fullName)) {
                                // check if correct result is found
                                menuNav = ServiceClass.readInt(employees.get(foundAt).toString()
                                        + ServiceClass.correctEmployeeMessage(), 0, 1);
                                if (menuNav == 1) {
                                    exiting = true;
                                } else {
                                    foundAt++;
                                }
                            } else {
                                foundAt++;
                            }
                        } while (!exiting);
                    } else if (menuNav == 4) {
                        int sin = ServiceClass.readInt(ServiceClass.sinPrompt());
                        do { // search by social insurance number
                            if (foundAt >= employees.size()) {
                                exiting = true;
                            } else if (employees.get(foundAt).getSIN() == sin) {
                                // check if correct result is found
                                menuNav = ServiceClass.readInt(employees.get(foundAt).toString()
                                        + ServiceClass.correctEmployeeMessage(), 0, 1);
                                if (menuNav == 1) {
                                    exiting = true;
                                } else {
                                    foundAt++;
                                }
                            } else {
                                foundAt++;
                            }
                        } while (!exiting);
                    }
                    if (exiting) {
                        if (foundAt >= employees.size()) {
                            System.out.println(ServiceClass.noEmployeeResultsMessage());
                        } else {
                            // further options would go here ie. edit info, calc pay
                            System.out.println(employees.get(foundAt).toString());
                        }
                        // prompt for new search
                        menuNav = ServiceClass.readInt(ServiceClass.searchAgainMessage(), 0, 1);
                        if (menuNav == 1) {
                            exiting = false;
                        }
                    } else {
                        exiting = true;
                    }
                } while (!exiting); // end of employee search menu
                exiting = false;
            } else if (menuNav == 3) {
                do {// product search menu
                    int foundAt = 0;
                    menuNav = ServiceClass.readInt(ServiceClass.searchProductMessage(), 0, 2);
                    if (menuNav == 1) {
                        String name = ServiceClass.readString(ServiceClass.productNamePrompt());
                        do { // search by product name
                            if (foundAt >= products.size()) {
                                exiting = true;
                            } else if (products.get(foundAt).getName().equals(name)) {
                                // check if correct search result is found
                                menuNav = ServiceClass.readInt(products.get(foundAt).toString() 
                                            + ServiceClass.correctProductMessage(), 0, 1);
                                if (menuNav == 1) {
                                    exiting = true;
                                } else {
                                    foundAt++;
                                }
                            } else {
                                foundAt++;
                            }
                        } while (!exiting);
                    } else if (menuNav == 2) {
                        String description = ServiceClass.readString(ServiceClass.productDescriptionPrompt());
                        do { // search by product description
                            if (foundAt >= products.size()) {
                                exiting = true;
                            } else if (products.get(foundAt).getDescription().equals(description)) {
                                // check if correct search result is found
                                menuNav = ServiceClass.readInt(products.get(foundAt).toString()
                                            + ServiceClass.correctProductMessage(), 0, 1);
                                if (menuNav == 1) {
                                    exiting = true;
                                } else {
                                    foundAt++;
                                }
                            } else {
                                foundAt++;
                            }
                        } while (!exiting);
                    }
                    if (exiting) {
                        if (foundAt >= products.size()) {
                            System.out.println(ServiceClass.noProductResultsMessage());
                        } else {
                            // prompt to display manufacturer information
                            // further product specific options would go here
                            System.out.println(products.get(foundAt).toString());
                            menuNav = ServiceClass.readInt(ServiceClass.viewManufacturerMessage());
                            if (menuNav == 1) {
                                System.out.println(products.get(foundAt).getManufacturer().toString());
                            }
                        }
                        // prompt for new search
                        menuNav = ServiceClass.readInt(ServiceClass.searchAgainMessage(), 0, 1);
                        if (menuNav == 1) {
                            exiting = false;
                        }
                    } else {
                        exiting = true;
                    }
                } while (!exiting);// end of product search menu
                exiting = false;
            } else {
                exiting = true;
            }
        } while (!exiting); // end of top level menu
        System.out.println(ServiceClass.outroMessage());
        // end runtime with a thankyou message
    }
}
