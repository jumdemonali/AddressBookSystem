package com.bl.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;
public class FileHandling {
    public void writeContactToCsv(Map<String, AddressBook> addressBookSystem) throws IOException {

        CSVWriter writer = new CSVWriter(new FileWriter("AddressBookFile.csv"));
        String line[] = { "AddressBook Name", "First Name", "Last Name", "Address", "City", "State", "Pone Number",
                "E-mail", "Zip" };
        List contactList = new ArrayList();
        contactList.add(line);
        for (String keyName : addressBookSystem.keySet()) {
            AddressBook addrBookObj = addressBookSystem.get(keyName);

            addrBookObj.getContacts().forEach((contact) -> {

                String line1[] = { keyName, contact.getFirstName().toString(), contact.getLastName().toString(),
                        contact.getAddress().toString(), contact.getCity().toString(), contact.getState().toString(),
                        String.valueOf(contact.getPhoneNo()), contact.getEmail().toString(),
                        String.valueOf(contact.getZip()) };
                contactList.add(line1);

            });
        }
        writer.writeAll(contactList);
        writer.flush();
        System.out.println("Details written into CSV");
    }
}
