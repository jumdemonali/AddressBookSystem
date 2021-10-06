
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    AddressBookRepo addressBookRepo = new AddressBookRepo();

    public static void main(String[] args) throws SQLException {
        AddressBook addressBook=new AddressBook();
        addressBook.retrieveData();
        addressBook.updateSalary();
        addressBook.getContactsInDatePeriod();
    }

    private void getContactsInDatePeriod() throws SQLException {
        addressBookRepo.getContactsInDatePeriod();
    }

    private void retrieveData () throws SQLException {
            List<Person> employeeInfoList = addressBookRepo.retrieveData();
            System.out.println(employeeInfoList);
        }
    private void updateSalary() {
        addressBookRepo.updateSalary("Mona",5000);
    }

    }
