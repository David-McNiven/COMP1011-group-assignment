package Procurement;

import Warehouse.ServiceClass;
import java.util.GregorianCalendar;

/**
 * Student ID# 200330143
 * @author David McNiven
 */
public class Product {
    private int idNumber, stockLevel;
    private String name, description, category, packaging, hazards, regulator;
    private double procurementPricePerUnit, weight, height, width, length;
    private GregorianCalendar adoptionDate, expiryDate;
    private Boolean fragile;
    private Manufacturer manufacturer;
    
    // CONSTRUCTORS //
    public Product(String name, String description, String category, Manufacturer manufacturer,
            String packaging, String hazards, String regulator, double procurementPricePerUnit,
            double weight, double height, double width, double length, int adoptionYear, int adoptionMonth, int adoptionDay,
            int expiryYear, int expiryMonth, int expiryDay, Boolean fragile, int stockLevel){
        this(name, description, category);
        this.packaging = packaging;
        this.hazards = hazards;
        this.regulator = regulator;
        this.procurementPricePerUnit = procurementPricePerUnit;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.adoptionDate = new GregorianCalendar(adoptionYear,adoptionMonth-1,adoptionDay);
        this.expiryDate = new GregorianCalendar(expiryYear, expiryMonth-1, expiryDay);
        this.fragile = fragile;
        this.stockLevel = stockLevel;
        this.manufacturer = manufacturer;
    }
    public Product(String name, String description, String category){
        this.idNumber = ServiceClass.getNewProductID();
        this.name = name;
        this.description = description;
        this.category = category;
        packaging = "";
        hazards = "";
        regulator = "";
        procurementPricePerUnit = 0.0;
        weight = 0.0;
        height = 0.0;
        width = 0.0;
        length = 0.0;
        adoptionDate = new GregorianCalendar();
        expiryDate = new GregorianCalendar();
        fragile = false;
        stockLevel = 0;
    }
    
    // GETS //
    public int getIDNumber(){
        return this.idNumber;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public String getCategory(){
        return this.category;
    }
    public String getPackaging(){
        return this.packaging;
    }
    public String getHazards(){
        return this.hazards;
    }
    public String getRegulator(){
        return this.regulator;
    }
    public double getProcurementPricePerUnit(){
        return this.procurementPricePerUnit;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }
    public double getLength(){
        return this.length;
    }
    public GregorianCalendar getAdoptionDate(){
        return this.adoptionDate;
    }
    public GregorianCalendar getExpiryDate(){
        return this.expiryDate;
    }
    public Boolean isFragile(){
        return this.fragile;
    }
    public int getStockLevel(){
        return this.stockLevel;
    }
    public Manufacturer getManufacturer(){
        return this.manufacturer;
    }
    @Override
    public String toString(){
        return "\nName:\t\t\t" + this.getName()
                + "\nCategory:\t\t" + this.getCategory()
                + "\nDescription:\t\t" + this.getDescription()
                + "\nProduct Number:\t\t" + this.getIDNumber();
    }
    
    // SETS //
    public Boolean setName(String name){
        this.name = name;
        return true;
    }
    public Boolean setDescription(String description){
        this.description = description;
        return true;
    }
    public Boolean setCategory(String category){
        this.category = category;
        return true;
    }
    public Boolean setPackaging(String packaging){
        this.packaging = packaging;
        return true;
    }
    public Boolean setHazards(String hazards){
        this.hazards = hazards;
        return true;
    }
    public Boolean setRegulator(String regulator){
        this.regulator = regulator;
        return true;
    }
    public Boolean setProcurementPricePerUnit(double procurementPricePerUnit){
        this.procurementPricePerUnit = procurementPricePerUnit;
        return true;
    }
    public Boolean setWeight(double weight){
        this.weight = weight;
        return true;
    }
    public Boolean setHeight(double height){
        this.height = height;
        return true;
    }
    public Boolean setWidth(double width){
        this.width = width;
        return true;
    }
    public Boolean setLength(double length){
        this.length = length;
        return true;
    }
    public Boolean setAdoptionDate(int year, int month, int day){
        this.adoptionDate = new GregorianCalendar(year, month-1, day);
        return true;
    }
    public Boolean setExpiryDate(int year, int month, int day){
        this.expiryDate = new GregorianCalendar(year, month-1, day);
        return true;
    }
    public Boolean setFragility(Boolean fragile){
        this.fragile = fragile;
        return true;
    }
    public Boolean setStockLevel(int stockLevel){
        this.stockLevel = stockLevel;
        return true;
    }
    public Boolean setManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
        return true;
    }
}
