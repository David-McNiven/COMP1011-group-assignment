package Procurement;

import Warehouse.ServiceClass;


/**
 * Student ID# 200330143
 * @author David McNiven
 */
public class Manufacturer {
    private int idNumber;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String handlerFirstName;
    private String handlerLastName;
    
    // CONSTRUCTORS //
    public Manufacturer(String name, String address, String phone, 
            String email, String handlerFirstName, String handlerLastName){
        this.idNumber = ServiceClass.getNewManufacturerID();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.handlerFirstName = handlerFirstName;
        this.handlerLastName = handlerLastName;
    }
    
    // GETS //
    public int getIDNumber(){
        return this.idNumber;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getEmail(){
        return this.email;
    }
    public String getHandlerFirstName(){
        return this.handlerFirstName;
    }
    public String getHandlerLastName(){
        return this.handlerLastName;
    }
    @Override
    public String toString(){
        return "\nName:\t\t\t" + this.getName() + 
                "\nAddress:\t\t" + this.getAddress() + 
                "\nPhone Number:\t\t" + this.getPhone() + 
                "\nEmail:\t\t\t" + this.getEmail() + 
                "\nHandler:\t\t" + this.getHandlerFirstName() + " " + this.getHandlerLastName() +
                "\nManufacturer ID:\t" + this.getIDNumber();
    }
    
    // SETS //
    public Boolean setName(String name){
        this.name = name;
        return true;
    }
    public Boolean setAddress(String address){
        this.address = address;
        return true;
    }
    public Boolean setPhone(String phone){
        this.phone = phone;
        return true;
    }
    public Boolean setEmail(String email){
        this.email = email;
        return true;
    }
    public Boolean setHandlerFirstName(String handlerFirstName){
        this.handlerFirstName = handlerFirstName;
        return true;
    }
    public Boolean setHandlerLastName(String handlerLastName){
        this.handlerLastName = handlerLastName;
        return true;
    }
}
