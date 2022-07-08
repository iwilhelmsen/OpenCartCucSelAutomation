package pages;

import models.Customer;
import models.CustomerGroup;
import org.openqa.selenium.By;

public class adminPage extends basePage{
    protected final String pageURL = "admin";
    //log in button to access Admin area
    protected final By adminLoginButton = By.xpath("//button[normalize-space()='Login']");

    //Side bar menu navigation options
    protected final By customerMenuButton = By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']");
    protected final By customerMenuOption = By.xpath("//ul[@class='collapse in']//a[contains(text(),'Customers')]");
    protected final By customerGroupMenuOption = By.xpath("//a[normalize-space()='Customer Groups']");

    //Customer page locators
    protected final By addCustomerButton = By.xpath("//div[@class='pull-right']//a[@class='btn btn-primary']");
    protected final By deleteCustomerButton = By.xpath("//button[@class='btn btn-danger']");

    //Customer Group Page locators
    protected final By addCustomerGroupButton = By.xpath("//div[@class='pull-right']//a[@class='btn btn-primary']");
    protected final By deleteCustomerGroupButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");

    //Add Customer Page locators
    protected final By addCustomerGroupSelect = By.xpath("//select[@name='customer_group_id']");
    protected final By addCustomerFirstNameInput = By.xpath("//input[@placeholder='First Name']");
    protected final By addCustomerLastnameInput = By.xpath("//input[@placeholder='Last Name']");
    protected final By addCustomerEmailInput = By.xpath("//input[@placeholder='E-Mail']");
    protected final By addCustomerTelephoneInput = By.xpath("//input[@placeholder='Telephone']");
    protected final By addCustomerPasswordInput = By.xpath("//input[@placeholder='Password']");
    protected final By addCustomerConfirmPasswordInput = By.xpath("//input[@placeholder='Confirm']");
    protected final By addCustomerNewsletterSelect = By.xpath("//select[@name='newsletter']");
    protected final By addCustomerStatusSelect = By.xpath("//select[@name='status']");
    protected final By addCustomerSafeSelect = By.xpath("//select[@name='safe']");
    protected final By addCustomerSubmitButton = By.xpath("//i[@class='fa fa-save']");
    protected final By addCustomerCancelButton = By.xpath("//i[@class='fa fa-reply']");

    //Add Customer Group locators
    protected final By addGroupNameInput = By.xpath("//input[@placeholder='Customer Group Name']");
    protected final By addGroupSubmitButton = By.xpath("//button[@type='submit']");
    protected final By addGroupCancelButton = By.xpath("//i[@class='fa fa-reply']");

    public adminPage(String browser){
        super(browser);
        this.navigateTo(this.pageURL);
        this.click(this.adminLoginButton);
    }

    public void goToCustomerSection(){
        this.click(this.customerMenuButton);
        this.click(this.customerMenuOption);
    }

    public void goToCustomerGroupSection(){
        this.click(this.customerMenuButton);
        this.click(this.customerGroupMenuOption);
    }

    public void goToAddCustomerGroupSection(){
        this.goToCustomerGroupSection();
        this.click(this.addCustomerGroupButton);
    }

    public void goToAddCustomerSection(){
        this.goToCustomerSection();
        this.click(this.addCustomerButton);
    }

    public void goToDeleteCustomerSection(){
        this.goToCustomerSection();
        this.click(this.deleteCustomerButton);
    }

    public void addCustomerFromCustomerObject(Customer customer){
        this.goToAddCustomerSection();
        this.clickAndSelectOpt(customer.getGroupName(), this.addCustomerGroupSelect);
        this.type(customer.getFirstName(), this.addCustomerFirstNameInput);
        this.type(customer.getLastName(), this.addCustomerLastnameInput);
        this.type(customer.getEmail(), this.addCustomerEmailInput);
        this.type(customer.getTelephoneNumber(), this.addCustomerTelephoneInput);
        this.type(customer.getPassword(), this.addCustomerPasswordInput);
        this.type(customer.getConfirmPassword(), this.addCustomerConfirmPasswordInput);

        this.click(this.addCustomerSubmitButton);
    }

    public void addCustomerFromListOfCustomer(CustomerGroup customerGroup){
        this.addCustomerGroupFromGroupObject(customerGroup);
        customerGroup.customers.forEach(this::addCustomerFromCustomerObject);
    }

    public void addCustomerGroupFromGroupObject(CustomerGroup customerGroup){
        this.goToCustomerGroupSection();
        this.type(customerGroup.groupName, this.addGroupNameInput);
        this.click(this.addGroupSubmitButton);
    }

    public void changeCustomerGroupByGroupObject(CustomerGroup customerGroup){

    }

    public void getCustomerByCustomerObject(Customer customer){

    }

    public void filterCustomersByGroup(){

    }
}
