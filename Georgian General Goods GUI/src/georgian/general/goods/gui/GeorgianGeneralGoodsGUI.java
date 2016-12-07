package georgian.general.goods.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Student ID# 200330143
 * @author David McNiven
 * 
 * Preliminary GUI for Georgian General Goods, does not include functionality
 */
public class GeorgianGeneralGoodsGUI extends JFrame {
    // panels and tabpanes
    private JPanel greetingPanel, buttonPanel, HRPanel, inventoryPanel,
            createInventoryPanel, productOptionsPanel, createEmployeePanel, 
            employeePanel, employeeSearchPanel, employeeTypePanel, 
            employeeOptionsPanel, employeeSearchOptionsPanel, createProductPanel, 
            productPanel, productSearchPanel, manufacturerOptionsPanel,
            manufacturerPanel, productSearchOptionsPanel, createManufacturerPanel;
    private JTabbedPane createInventoryTabPane,inventoryTabPane, HRTabPane, mainTabPane;
    
    // options menu components
    private JLabel employeeOptionsTypeLabel, productOptionsManufacturerLabel;
    private JComboBox<String> employeeOptions, productOptions, 
            employeeSearchOptions, productSearchOptions;
    private static final String[] employeeSearchTypes = {"Employee ID","Type","Name","SIN"},
            employeeTypes = {"Salary","Hourly","Commission","Base plus Commission"},
            productSearchTypes = {"Product ID","Manufacturer ID","Type","Name"},
            manufacturers = {"H&K", "Norseman LTD","Create New"};
    private JButton exitButton, employeeCreateButton, employeeClearButton,
            productCreateButton, productClearButton, manufacturerCreateButton,
            manufacturerClearButton;
    
    // employee creation tab components
    private JLabel greetingLabel, firstNameLabel, lastNameLabel, addressLabel, 
            emailLabel, phoneLabel, genderLabel, birthYearLabel, birthMonthLabel, 
            birthDayLabel, sinLabel, departmentLabel, positionLabel, 
            statusLabel, hireYearLabel, hireMonthLabel, hireDayLabel;
    private JTextField firstNameTextField, lastNameTextField, addressTextField, 
            emailTextField, phoneTextField, genderTextField, birthYearTextField, birthMonthTextField, 
            birthDayTextField, sinTextField, departmentTextField, positionTextField, 
            statusTextField, hireYearTextField, hireMonthTextField, hireDayTextField;
    
    // employee type specialy components
    private JLabel hourlyEmployeeHourlyRateLabel, hourlyEmployeeHoursWorkedLabel,
            commissionEmployeeCommissionRateLabel, commissionEmployeeGrossSalesLabel,
            basePlusCommissionEmployeeBaseSalaryLabel, salaryEmployeeSalaryLabel;
    private JTextField hourlyEmployeeHourlyRateTextField, hourlyEmployeeHoursWorkedTextField,
            commissionEmployeeCommissionRateTextField, commissionEmployeeGrossSalesTextField,
            basePlusCommissionEmployeeBaseSalarytextField, salaryEmployeeSalaryTextField;
    
    // product creation tab components
    private JLabel productNameLabel, productDescriptionLabel, productCategoryLabel,
        productPackagingLabel, productHazardsLabel, productRegulatorLabel,
        productProcurementPricePerUnitLabel, productWeightLabel, productHeightLabel,
        productWidthLabel, productlengthLabel, productAdoptionYearLabel,
        productAdoptionMonthLabel, productAdoptionDayLabel, productExpiryYearLabel,
        productExpiryMonthLabel, productExpiryDayLabel, productFragileLabel,
        productStockLevelLabel;
    private JTextField productNameTextField, productDescriptionTextField,
        productCategoryTextField, productPackagingTextField,
        productHazardsTextField, productRegulatorTextField,
        productProcurementPricePerUnitTextField, productWeightTextField,
        productHeightTextField, productWidthTextField, productlengthTextField,
        productAdoptionYearTextField, productAdoptionMonthTextField,
        productAdoptionDayTextField, productExpiryYearTextField,
        productExpiryMonthTextField, productExpiryDayTextField,
        productFragileTextField, productStockLevelTextField;
    
    // manufacturer creation tab components
    private JLabel manufacturerNameLabel, manufacturerAddressLabel, 
            manufacturerPhoneLabel, manufacturerEmailLabel, 
            manufacturerHandlerFirstNameLabel, manufacturerHandlerLastNameLabel;
    private JTextField manufacturerNameTextField, manufacturerAddressTextField, 
            manufacturerPhoneTextField, manufacturerEmailTextField, 
            manufacturerHandlerFirstNameTextField, manufacturerHandlerLastNameTextField;
    
    // search tab components
    private JTextArea employeeSearchResultsTextArea, productSearchResultsTextArea;
    private JLabel employeeSearchByLabel, productSearchByLabel;
    private JTextField employeeSearchTextField, productSearchTextField;
    
    // FRAME //
    // constructor
    public GeorgianGeneralGoodsGUI() {
        // frame setup
        super("Georgian General Goods");
        setLayout(new BorderLayout());
        
        // components
        buildGreetingPanel();
        buildButtonPanel();
        buildHRPanel();
        buildInventoryPanel();
        mainTabPane = new JTabbedPane();
        mainTabPane.addTab("HR",null,HRPanel,"HR Tab");
        mainTabPane.addTab("Inventory",null,null,"Inventory Tab");
        mainTabPane.addChangeListener(new TabResizeHandler(new JPanel[] {HRPanel,inventoryPanel}));
        
        // construction
        this.add(greetingPanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(mainTabPane,BorderLayout.CENTER);
    }

    // HEADER PANEL //
    // panel for welcome message above tabs
    private void buildGreetingPanel() {
        // components
        greetingLabel = new JLabel("Welcome to Georgian General Goods!");
        
        // construction
        greetingPanel = new JPanel();
        greetingPanel.add(greetingLabel);
    }

    // HR PANELS //
    // panel for HR tabs
    private void buildHRPanel() {
        // components
        buildCreateEmployeePanel();
        buildEmployeeSearchPanel();
        HRTabPane = new JTabbedPane();
        HRTabPane.addTab("Create", null, createEmployeePanel, "New Employee Tab");
        HRTabPane.addTab("Search", null, null, "Search Employees Tab");
        HRTabPane.addChangeListener(new TabResizeHandler(new JPanel[] 
            {createEmployeePanel,employeeSearchPanel}));
        
        // construction
        HRPanel = new JPanel();
        HRPanel.add(HRTabPane);
    }
    
    // EMPLOYEE PANELS //
    // lays out options above and employee subtypes below basic employee form
    private void buildCreateEmployeePanel(){
        // components
        buildEmployeePanel();
        buildEmployeeOptionsPanel();
        buildSalaryEmployeePanel();
        
        // construction
        createEmployeePanel = new JPanel();
        createEmployeePanel.setLayout(new BorderLayout());
        createEmployeePanel.add(employeeOptionsPanel, BorderLayout.NORTH);
        createEmployeePanel.add(employeePanel, BorderLayout.CENTER);
        createEmployeePanel.add(employeeTypePanel, BorderLayout.SOUTH);
    }
    
    // includes options for employee type selection, saving and clearing
    private void buildEmployeeOptionsPanel(){
        // components
        employeeOptionsTypeLabel = new JLabel("Employee Type:");
        employeeOptions = new JComboBox<>(employeeTypes);
        employeeOptions.setMaximumRowCount(employeeTypes.length);
        employeeCreateButton = new JButton("Submit");
        employeeClearButton = new JButton("Clear");
        
        // construction
        employeeOptionsPanel = new JPanel();
        employeeOptionsPanel.setLayout((new FlowLayout()));
        employeeOptionsPanel.add(employeeOptionsTypeLabel);
        employeeOptionsPanel.add(employeeOptions);
        employeeOptionsPanel.add(employeeCreateButton);
        employeeOptionsPanel.add(employeeClearButton);
        employeeOptions.addActionListener(new EmployeeTypeHandler());
    }
    
    // creates form for all basic employee fields
    private void buildEmployeePanel(){
        // components
        firstNameLabel= new JLabel("First Name:");
        lastNameLabel= new JLabel("Last Name:");
        addressLabel= new JLabel("Billing Address:");
        emailLabel= new JLabel("Email Address:");
        phoneLabel= new JLabel("Phone Number:");
        genderLabel= new JLabel("Gender:");
        birthYearLabel= new JLabel("Year of Birth:");
        birthMonthLabel= new JLabel("Month of Birth:"); 
        birthDayLabel= new JLabel("Day of Birth:");
        sinLabel= new JLabel("SIN:");
        departmentLabel= new JLabel("Department:");
        positionLabel= new JLabel("Position:"); 
        statusLabel= new JLabel("Employment Status:");
        hireYearLabel= new JLabel("Year of Hire:");
        hireMonthLabel= new JLabel("Month of Hire:");
        hireDayLabel = new JLabel("Day of Hire:");
        firstNameTextField = new JTextField();
        lastNameTextField = new JTextField();
        addressTextField = new JTextField(); 
        emailTextField = new JTextField();
        phoneTextField = new JTextField();
        genderTextField = new JTextField();
        birthYearTextField = new JTextField();
        birthMonthTextField = new JTextField(); 
        birthDayTextField = new JTextField();
        sinTextField = new JTextField();
        departmentTextField = new JTextField();
        positionTextField = new JTextField(); 
        statusTextField = new JTextField();
        hireYearTextField = new JTextField();
        hireMonthTextField = new JTextField();
        hireDayTextField = new JTextField();
        
        // panel construction
        employeePanel = new JPanel();
        employeePanel.setLayout(new GridLayout(8,4));
        employeePanel.add(firstNameLabel);
        employeePanel.add(firstNameTextField);
        employeePanel.add(lastNameLabel);
        employeePanel.add(lastNameTextField);
        employeePanel.add(addressLabel);
        employeePanel.add(addressTextField);
        employeePanel.add(emailLabel);
        employeePanel.add(emailTextField);
        employeePanel.add(phoneLabel);
        employeePanel.add(phoneTextField);
        employeePanel.add(genderLabel);
        employeePanel.add(genderTextField);
        employeePanel.add(birthYearLabel);
        employeePanel.add(birthYearTextField);
        employeePanel.add(birthMonthLabel);
        employeePanel.add(birthMonthTextField);
        employeePanel.add(birthDayLabel);
        employeePanel.add(birthDayTextField);
        employeePanel.add(sinLabel);
        employeePanel.add(sinTextField);
        employeePanel.add(departmentLabel);
        employeePanel.add(departmentTextField);
        employeePanel.add(positionLabel);
        employeePanel.add(positionTextField);
        employeePanel.add(statusLabel);
        employeePanel.add(statusTextField);
        employeePanel.add(hireYearLabel);
        employeePanel.add(hireYearTextField);
        employeePanel.add(hireMonthLabel);
        employeePanel.add(hireMonthTextField);
        employeePanel.add(hireDayLabel);
        employeePanel.add(hireDayTextField);
    }
    
    // EMPLOYEE SUBCLASS PANELS //
    // resets employee type panel for salary based pay
    private void buildSalaryEmployeePanel() {
        // components
        salaryEmployeeSalaryLabel = new JLabel("Salary:");
        salaryEmployeeSalaryTextField = new JTextField();
        
        // construction
        employeeTypePanel = new JPanel();
        employeeTypePanel.setLayout(new GridLayout(1,4));
        employeeTypePanel.add(salaryEmployeeSalaryLabel);
        employeeTypePanel.add(salaryEmployeeSalaryTextField);
        employeeTypePanel.add(new JLabel()); // dummy labels 
        employeeTypePanel.add(new JLabel()); // to make gridlayout behave
    }
    
    // resets employee type panel for hourly pay
    private void buildHourlyEmployeePanel() {
        // components
        hourlyEmployeeHourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyEmployeeHourlyRateTextField = new JTextField();
        hourlyEmployeeHoursWorkedLabel = new JLabel("Hours Worked:");
        hourlyEmployeeHoursWorkedTextField = new JTextField();
        
        // construction
        employeeTypePanel = new JPanel();
        employeeTypePanel.setLayout(new GridLayout(1,4));
        employeeTypePanel.add(hourlyEmployeeHourlyRateLabel);
        employeeTypePanel.add(hourlyEmployeeHourlyRateTextField);
        employeeTypePanel.add(hourlyEmployeeHoursWorkedLabel);
        employeeTypePanel.add(hourlyEmployeeHoursWorkedTextField);
    }
    
    // resets employee type panel for commissions based pay
    private void buildCommissionSalesEmployeePanel() {
        // components
        commissionEmployeeCommissionRateLabel = new JLabel("Commission Rate:");
        commissionEmployeeCommissionRateTextField = new JTextField();
        commissionEmployeeGrossSalesLabel = new JLabel("Gross Sales:");
        commissionEmployeeGrossSalesTextField = new JTextField();
        
        // construction
        employeeTypePanel = new JPanel();
        employeeTypePanel.setLayout(new GridLayout(1,4));
        employeeTypePanel.add(commissionEmployeeCommissionRateLabel);
        employeeTypePanel.add(commissionEmployeeCommissionRateTextField);
        employeeTypePanel.add(commissionEmployeeGrossSalesLabel);
        employeeTypePanel.add(commissionEmployeeGrossSalesTextField);
    }
    
    // resets  employee type panel for salary and commission based pay
    private void buildBasePlusCommissionEmployeePanel() {
        // components
        buildCommissionSalesEmployeePanel();
        basePlusCommissionEmployeeBaseSalaryLabel = new JLabel("Base Salary:");
        basePlusCommissionEmployeeBaseSalarytextField = new JTextField();
        
        // construction
        employeeTypePanel.setLayout(new GridLayout(2,4));
        employeeTypePanel.add(basePlusCommissionEmployeeBaseSalaryLabel);
        employeeTypePanel.add(basePlusCommissionEmployeeBaseSalarytextField);
        employeeTypePanel.add(new JLabel()); // dummy for grid layout
    }
    
    // HR SEARCH PANELS //
    // creates results section below search bar
    private void buildEmployeeSearchPanel() {
        // components
        buildEmployeeSearchOptionsPanel();
        employeeSearchResultsTextArea = new JTextArea(10,40);
        
        // construction
        employeeSearchPanel = new JPanel();
        employeeSearchPanel.setLayout(new BorderLayout());
        employeeSearchPanel.add(employeeSearchOptionsPanel, BorderLayout.NORTH);
        employeeSearchPanel.add(employeeSearchResultsTextArea, BorderLayout.CENTER);
    }
    
    // creates search bar
    private void buildEmployeeSearchOptionsPanel(){
        // components
        employeeSearchTextField = new JTextField(15);
        employeeSearchByLabel = new JLabel("Search By:");
        employeeSearchOptions = new JComboBox(employeeSearchTypes);
        employeeSearchOptions.setMaximumRowCount(employeeSearchTypes.length);
        
        // construction
        employeeSearchOptionsPanel = new JPanel();
        employeeSearchOptionsPanel.setLayout((new FlowLayout()));
        employeeSearchOptionsPanel.add(employeeSearchTextField);
        employeeSearchOptionsPanel.add(employeeSearchByLabel);
        employeeSearchOptionsPanel.add(employeeSearchOptions);
    }
    
    // INVENTORY PANELS //
    // builds inventory tabs
    private void buildInventoryPanel() {
        // components
        buildCreateInventoryPanel();
        buildProductSearchPanel();
        inventoryTabPane = new JTabbedPane();
        inventoryTabPane.addTab("Create", null, createInventoryPanel, "New product Tab");
        inventoryTabPane.addTab("Search", null, null, "Search Products Tab");
        inventoryTabPane.addChangeListener(new TabResizeHandler(new JPanel[] 
            {createInventoryPanel,productSearchPanel}));
        
        // construction
        inventoryPanel = new JPanel();
        inventoryPanel.add(inventoryTabPane);
    }
    
    // build create new product/manufacturer tabs
    private void buildCreateInventoryPanel() {
        // components
        buildCreateProductPanel();
        buildCreateManufacturerPanel();
        createInventoryTabPane = new JTabbedPane();
        createInventoryTabPane.addTab("Product", null, createProductPanel, "New Product Tab");
        createInventoryTabPane.addTab("Manufacturer", null, null, "new Manufacturer Tab");
        createInventoryTabPane.addChangeListener(new TabResizeHandler(new JPanel[] 
            {createProductPanel,createManufacturerPanel}));
        
        // construction
        createInventoryPanel = new JPanel();
        createInventoryPanel.add(createInventoryTabPane);
    }
    
    // PRODUCT PANLES //
    // lays out options and form for creating new product
    private void buildCreateProductPanel(){
        // components
        buildProductOptionsPanel();
        buildProductPanel();
        
        // construction
        createProductPanel = new JPanel();
        createProductPanel.setLayout(new BorderLayout());
        createProductPanel.add(productOptionsPanel, BorderLayout.NORTH);
        createProductPanel.add(productPanel, BorderLayout.CENTER);
    }
    
    // creates options for selecting manufacturer, save, and clear
    private void buildProductOptionsPanel(){
        // components
        // insert handler for manufacturer list population here
        productOptionsManufacturerLabel = new JLabel("Select Manufacturer:");
        productOptions = new JComboBox<>(manufacturers);
        productOptions.setMaximumRowCount(manufacturers.length);
        productOptions.addActionListener(new ProductNewManufacturerHandler());
        productCreateButton = new JButton("Submit");
        productClearButton = new JButton("Clear");
        
        // construction
        productOptionsPanel = new JPanel();
        productOptionsPanel.setLayout((new FlowLayout()));
        productOptionsPanel.add(productOptionsManufacturerLabel);
        productOptionsPanel.add(productOptions);
        productOptionsPanel.add(productCreateButton);
        productOptionsPanel.add(productClearButton);
    }
    
    // creates the form for all basic product
    private void buildProductPanel(){
        // components
        productNameLabel = new JLabel("Name:");
        productDescriptionLabel = new JLabel("Description:");
        productCategoryLabel = new JLabel("Category:");
        productPackagingLabel = new JLabel("Packaging:");
        productHazardsLabel = new JLabel("Hazards:");
        productRegulatorLabel = new JLabel("Regulations:");
        productProcurementPricePerUnitLabel = new JLabel("Procurement Price:");
        productWeightLabel = new JLabel("Weight:");
        productHeightLabel = new JLabel("Height:");
        productWidthLabel = new JLabel("Width:");
        productlengthLabel = new JLabel("Length:");
        productAdoptionYearLabel = new JLabel("Year of Adoption:");
        productAdoptionMonthLabel = new JLabel("Month of Adoption:");
        productAdoptionDayLabel = new JLabel("Day of Adoption:");
        productExpiryYearLabel = new JLabel("Year of Expiry:");
        productExpiryMonthLabel = new JLabel("Month of Expiry:");
        productExpiryDayLabel = new JLabel("Day of Expiry:");
        productFragileLabel = new JLabel("Fragility:");
        productStockLevelLabel = new JLabel("Stock Level:");
        productNameTextField = new JTextField();
        productDescriptionTextField = new JTextField();
        productCategoryTextField = new JTextField();
        productPackagingTextField = new JTextField();
        productHazardsTextField = new JTextField();
        productRegulatorTextField = new JTextField();
        productProcurementPricePerUnitTextField = new JTextField();
        productWeightTextField = new JTextField();
        productHeightTextField = new JTextField();
        productWidthTextField = new JTextField();
        productlengthTextField = new JTextField();
        productAdoptionYearTextField = new JTextField();
        productAdoptionMonthTextField = new JTextField();
        productAdoptionDayTextField = new JTextField();
        productExpiryYearTextField = new JTextField();
        productExpiryMonthTextField = new JTextField();
        productExpiryDayTextField = new JTextField();
        productFragileTextField = new JTextField();
        productStockLevelTextField = new JTextField();
        
        // construction
        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(10,4));
        productPanel.add(productNameLabel);
        productPanel.add(productNameTextField);
        productPanel.add(productDescriptionLabel);
        productPanel.add(productDescriptionTextField);
        productPanel.add(productCategoryLabel);
        productPanel.add(productCategoryTextField);
        productPanel.add(productPackagingLabel);        
        productPanel.add(productPackagingTextField);
        productPanel.add(productHazardsLabel);        
        productPanel.add(productHazardsTextField);
        productPanel.add(productRegulatorLabel);        
        productPanel.add(productRegulatorTextField);
        productPanel.add(productProcurementPricePerUnitLabel);        
        productPanel.add(productProcurementPricePerUnitTextField);
        productPanel.add(productWeightLabel);        
        productPanel.add(productWeightTextField);
        productPanel.add(productHeightLabel);        
        productPanel.add(productHeightTextField);
        productPanel.add(productWidthLabel);        
        productPanel.add(productWidthTextField);
        productPanel.add(productlengthLabel);        
        productPanel.add(productlengthTextField);
        productPanel.add(productAdoptionYearLabel);        
        productPanel.add(productAdoptionYearTextField);
        productPanel.add(productAdoptionMonthLabel);        
        productPanel.add(productAdoptionMonthTextField);
        productPanel.add(productAdoptionDayLabel);        
        productPanel.add(productAdoptionDayTextField);
        productPanel.add(productExpiryYearLabel);        
        productPanel.add(productExpiryYearTextField);
        productPanel.add(productExpiryMonthLabel);        
        productPanel.add(productExpiryMonthTextField);
        productPanel.add(productExpiryDayLabel);        
        productPanel.add(productExpiryDayTextField);
        productPanel.add(productFragileLabel);        
        productPanel.add(productFragileTextField);
        productPanel.add(productStockLevelLabel);        
        productPanel.add(productStockLevelTextField);     
    }
    
    // MANUFACTURER PANELS //
    // lays out options and form for creating a manufacturer
    private void buildCreateManufacturerPanel(){
        // components
        buildManufacturerOptionsPanel();
        buildManufacturerPanel();
        
        // construction
        createManufacturerPanel = new JPanel();
        createManufacturerPanel.setLayout(new BorderLayout());
        createManufacturerPanel.add(manufacturerOptionsPanel, BorderLayout.NORTH);
        createManufacturerPanel.add(manufacturerPanel, BorderLayout.CENTER);
        createManufacturerPanel.setPreferredSize(createManufacturerPanel.getPreferredSize());
    }
    
    // creates options for saving or clearing entries
    private void buildManufacturerOptionsPanel(){
        // components
        manufacturerCreateButton = new JButton("Submit");
        manufacturerClearButton = new JButton("Clear");
        
        // construction
        manufacturerOptionsPanel = new JPanel();
        manufacturerOptionsPanel.setLayout((new FlowLayout()));
        manufacturerOptionsPanel.add(manufacturerCreateButton);
        manufacturerOptionsPanel.add(manufacturerClearButton);
    }
    
    // creates basic form for manufacturer information
    private void buildManufacturerPanel(){
        // components
        manufacturerNameLabel = new JLabel("Name:");
        manufacturerAddressLabel = new JLabel("Shipping Address:");
        manufacturerPhoneLabel = new JLabel("Phone Number:");
        manufacturerEmailLabel = new JLabel("Email Address:");
        manufacturerHandlerFirstNameLabel = new JLabel("handler First Name:");
        manufacturerHandlerLastNameLabel = new JLabel("Handler Last Name:");
        manufacturerNameTextField = new JTextField();
        manufacturerAddressTextField = new JTextField();
        manufacturerPhoneTextField = new JTextField();
        manufacturerEmailTextField = new JTextField();
        manufacturerHandlerFirstNameTextField = new JTextField();
        manufacturerHandlerLastNameTextField = new JTextField();
        
        // panel constuction
        manufacturerPanel = new JPanel();
        manufacturerPanel.setLayout(new GridLayout(3,4));
        manufacturerPanel.add(manufacturerNameLabel);
        manufacturerPanel.add(manufacturerNameTextField);
        manufacturerPanel.add(manufacturerAddressLabel);
        manufacturerPanel.add(manufacturerAddressTextField);
        manufacturerPanel.add(manufacturerPhoneLabel);
        manufacturerPanel.add(manufacturerPhoneTextField);
        manufacturerPanel.add(manufacturerEmailLabel);
        manufacturerPanel.add(manufacturerEmailTextField);
        manufacturerPanel.add(manufacturerHandlerFirstNameLabel);
        manufacturerPanel.add(manufacturerHandlerFirstNameTextField);
        manufacturerPanel.add(manufacturerHandlerLastNameLabel);
        manufacturerPanel.add(manufacturerHandlerLastNameTextField);
    }
    
    // INVENTORY SEARCH PANELS //
    // creates result section below search bar
    private void buildProductSearchPanel() {
        // components
        buildProductSearchOptionsPanel();
        productSearchResultsTextArea = new JTextArea(10,40);
        
        // construction
        productSearchPanel = new JPanel();
        productSearchPanel.setLayout(new BorderLayout());
        productSearchPanel.add(productSearchOptionsPanel, BorderLayout.NORTH);
        productSearchPanel.add(productSearchResultsTextArea, BorderLayout.CENTER);
    }
    
    // creates search bar
    private void buildProductSearchOptionsPanel() {
        // components
        productSearchByLabel = new JLabel("Search By:");
        productSearchOptions = new JComboBox(productSearchTypes);
        productSearchOptions.setMaximumRowCount(productSearchTypes.length);
        productSearchTextField = new JTextField(15);
        
        // construction
        productSearchOptionsPanel = new JPanel();
        productSearchOptionsPanel.setLayout((new FlowLayout()));
        productSearchOptionsPanel.add(productSearchTextField);
        productSearchOptionsPanel.add(productSearchByLabel);
        productSearchOptionsPanel.add(productSearchOptions);
    }
    
    // FOOTER PANEL //
    // creates an exit button
    private void buildButtonPanel() {
        // components
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonListener());
        
        // construction
        buttonPanel = new JPanel();
        buttonPanel.add(exitButton);
    }
    
    // EVENT HANDLERS //
    // event handler for the exit button
    private class ExitButtonListener implements ActionListener {
        // opens up a confirmation dialog for exiting the application
        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?",
                   "Exit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        
    }
    
    // event handler for changing displayed panel based on elected employee type
    private class EmployeeTypeHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // pulls value of selected option
            String type = employeeOptions.getSelectedItem().toString();
            
            // discards the current employee type panel
            createEmployeePanel.remove(employeeTypePanel);
            
            // calls the relevant constructor depending on which is selected
            if (type.equals("Salary")){
                buildSalaryEmployeePanel();
            } else if(type.equals("Hourly")){
                buildHourlyEmployeePanel();
            } else if(type.equals("Commission")){
                buildCommissionSalesEmployeePanel();
            } else if(type.equals("Base plus Commission")){
                buildBasePlusCommissionEmployeePanel();
            }
            
            // adds the newly created panel, refreshes the frame and repacks
            createEmployeePanel.add(employeeTypePanel, BorderLayout.SOUTH);
            repaint();
            pack();
        }
    }
    
    // event handler for selecting to create a new manufacturer
    private class ProductNewManufacturerHandler implements ActionListener {
        // checks if the selected manufacturer changed to create new
        // and sets the active tab to create manufacturer
        @Override
        public void actionPerformed(ActionEvent e) {
            if (productOptions.getSelectedItem().toString().equals("Create New")){
                createInventoryTabPane.setSelectedIndex(1);
            }
        }
    }
    
    // event handler for all tabs that hides inactive panels 
    // and repacks the form to fit the current panels preferred size
    private class TabResizeHandler implements ChangeListener{
        // array of panels on the TabPane in question
        JPanel[] panels;
        
        // constructor to initialize panels array
        public TabResizeHandler(JPanel[] panels){
            this.panels = panels;
        }
        
        @Override
        public void stateChanged(ChangeEvent e) {
            // assumes source is a tabPane and iterates through all tabs
            // ensure only the surrent tab is shown
            JTabbedPane source = (JTabbedPane) e.getSource();
            
            for (int i = 0; i < source.getTabCount();i++){
                if (i == source.getSelectedIndex()) {
                    source.setComponentAt(i, panels[i]);
                } else {
                    source.setComponentAt(i, null);
                }
            }
            repaint();
            pack();
        }
        
    }
}