package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "bestcompany.com";

    // Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method for the department - return the department
        this.department = setDepartment();

        //Call a methode that returns a random password
        this.password = randomPassword(8);
        System.out.println("Your password is:" + this.password);

        //Combine a element to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }
    //Ask for the department
    private String setDepartment(){
        System.out.println("New worker:" + firstName+ ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\nEnter department codes: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if(deptChoice == 1){
            return "sales";
        }else if(deptChoice == 2){
            return "dev";
        }else if(deptChoice == 3){
            return "Accounting";
        }else{
            return "";
        }
    }
    //Generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ123456789!@#$%&";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) Math.random() * passwordSet.length();
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

}
