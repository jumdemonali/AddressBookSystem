package com.bl.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    String firstName, lastName, address, city, state, email;
    int zip;
    long phoneNo;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        addContact();
    }

    public static void addContact() {
        System.out.println("Enter the contact details:");
        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        System.out.println("Enter city");
        String city = sc.nextLine();
        System.out.println("Enter state");
        String state = sc.nextLine();
        System.out.println("Enter Zip");
        String zip = sc.nextLine();
        System.out.println("Enter Phone");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
    }
}
