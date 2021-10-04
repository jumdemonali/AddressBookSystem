package com.bl.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        ContactDetails c = new ContactDetails();
        System.out.println("Welcome to the Address Book  System ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add Contact  \n");
        System.out.print("Enter First Name: ");
        c.setFirstName(scanner.nextLine());
        System.out.print("Enter Last Name : ");
        c.setLastName(scanner.nextLine());
        System.out.print("Enter City : ");
        c.setCity(scanner.nextLine());
        System.out.print("Enter State : ");
        c.setState(scanner.nextLine());
        System.out.print("Enter zip : ");
        c.setZip(scanner.nextInt());
        System.out.print("Enter PhoneNumber: ");
        c.setPhoneNo(scanner.nextInt());
        System.out.print("Enter Email ID : ");
        c.setEmail(scanner.next());
    }

}