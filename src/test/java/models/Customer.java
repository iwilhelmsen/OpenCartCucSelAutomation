package models;

public class Customer {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String telephoneNumber;
    protected String password;
    protected String confirmPassword;
    protected String newsletter;
    protected String status;
    protected String groupName;

    public Customer(String firstName, String lastName, String email, String telephoneNumber, String password, String confirmPassword, String newsletter, String status, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.newsletter = newsletter;
        this.status = status;
        this.groupName = groupName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public String getStatus() {
        return status;
    }

    public String getGroupName() {
        return groupName;
    }
}
