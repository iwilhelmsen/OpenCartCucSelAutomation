package models;

import java.util.ArrayList;

public class CustomerGroup {
    public String groupName;
    public ArrayList<Customer> customers;

    public CustomerGroup(String groupName) {
        this.groupName = groupName;
        this.customers = new ArrayList<>();
    }
}
