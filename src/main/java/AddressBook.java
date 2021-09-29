
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome To Address Book Program");
        Scanner Scan=new Scanner(System.in);

        try {
            InputStream inputStream = new FileInputStream("C:/Users/Admin/Desktop/AddressBookSystemWithIO/src/main/resources/Welcome.txt");
            int byteData = inputStream.read();
            if(byteData!=-1){
                System.out.println(byteData);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }


        File file = new File("C:\\Users\\Admin\\Desktop\\AddressBookSystemWithIO\\src\\main\\resources\\AddressBookDetails.txt");
        try {
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated) {
                System.out.println("File Created succesfully!!1");
            } else {
                System.out.println("Something went wrong or file already exist");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        AddressBookController addressBookController = new AddressBookController();

        while(true) {

            System.out.println("Choose what to do");
            System.out.println("1) Add a person");
            System.out.println("2) Edit person");
            System.out.println("3) Delete a person");
            System.out.println("4) Sort Address Book");
            System.out.println("5) View person by city or state name");
            System.out.println("6) Search for person in city or state");
            System.out.println("7) View All Contacts");
            System.out.println("8) Exit");
            int choice = Scan.nextInt();

            switch (choice) {
                case 1: addressBookController.addPerson();
                    break;
                case 2: addressBookController.editPerson();
                    break;
                case 3: addressBookController.deletePerson();
                    break;
                case 4: addressBookController.sorting();
                    break;
                case 5: addressBookController.viewByCityOrCity();
                    break;
                case 6: addressBookController.searchByCityOrCity();
                    break;
                case 7: addressBookController.print();
                    break;
                case 8: return;
            }
        }



    }
}