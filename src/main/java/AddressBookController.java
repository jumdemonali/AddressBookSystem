import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBookController {
    Scanner scan = new Scanner(System.in);
    LinkedList<Person> personList = new LinkedList<Person>();
    HashMap<String,String > cityMap = new HashMap<>();
    HashMap<String,String> stateMap = new HashMap<>();

    public Person getPersonDetails() {
        System.out.println("Enter First Name!!!");
        String firstName = scan.next();
        System.out.println("Enter Last Name!!!");
        String lastName = scan.next();

        for (Person person : this.personList) {
            if (firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
                return person;
            }
        }
        return null;
    }

    public boolean checkPerson(String phoneNumber) {
        for (Person person : this.personList) {
            if (phoneNumber.equalsIgnoreCase(person.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public void addressDetails(Person person){
        System.out.println("Enter Address");
        person.setAddress(scan.next());

        System.out.println("Enter City");
        person.setCity(scan.next());

        System.out.println("Enter State");
        person.setState(scan.next());

        System.out.println("Enter Zipcode");
        person.setZip(scan.next());

        System.out.println("Enter Phone Number");
        person.setPhoneNumber(scan.next());
    }

    public void addPerson() {
        Person person = new Person();
        System.out.println("Enter First Name");
        person.setFirstName(scan.next());
        System.out.println("Enter Last Name");
        person.setLastName(scan.next());
        addressDetails(person);
        boolean duplicate=this.checkPerson(person.getPhoneNumber());
        if ( duplicate == false)
        {
            personList.add(person);
            cityMap.put(person.getCity(),person.getFirstName());
            stateMap.put(person.getState(),person.getFirstName());
            System.out.println("Contact added successfully");
        }
        else{
            System.out.println("Details Already Exist!!!");
        }
    }

    public void editPerson() {
        Person personToedit = this.getPersonDetails();
        if (personToedit != null) {
            addressDetails(personToedit);
            personToedit.setPhoneNumber(scan.next());
            System.out.println("Contact Details Updated!!!");
        }
        else{
            System.out.println("No Details Found!!!");
        }
    }

    public void deletePerson(){
        Person personToDelete=this.getPersonDetails();
        if(personToDelete != null)
        {
            this.personList.remove(personToDelete);
            System.out.println("Contact Deleted Successfully");
        }
        else
            System.out.println("Invalid Details");
    }

    public void print() throws IOException {
        FileWriter writer = null;
        writer = new FileWriter("C:\\Users\\Admin\\Desktop\\AddressBookSystemWithIO\\src\\main\\resources\\AddressBookDetails.txt");

        try {
            for(Person items : personList){
                System.out.println(items);
                writer.write(items + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.close();

    }

    public void sorting() {
        System.out.println("Enter the type according to which you want to sort : 1)First Name 2)City 3)state 4)zipcode");
        int option = scan.nextInt();
        switch (option) {
            case 1: this.personList.sort(Comparator.comparing(Person:: getFirstName));
                break;
            case 2: this.personList.sort(Comparator.comparing(Person:: getCity));
                break;
            case 3: this.personList.sort(Comparator.comparing(Person:: getState));
                break;
            case 4: this.personList.sort(Comparator.comparing(Person:: getZip));
                break;
        }
    }

    public void viewByCityOrCity() {
        System.out.println("Enter City or State Name");
        String name = scan.next();
        if (cityMap.containsKey(name)) {
            System.out.println(cityMap.get(name));
        } else {
            System.out.println(stateMap.get(name));
        }
    }
    public void searchByCityOrCity() {
        System.out.println("Enter City or State Name");
        String name = scan.next();
        for (HashMap.Entry<String, String> pair : cityMap.entrySet()) {
            if (cityMap.containsKey(name)) {
                System.out.println(cityMap.get(name));
            }
        }
        for (HashMap.Entry<String, String> pair : stateMap.entrySet()) {
            if (stateMap.containsKey(name)) {
                System.out.println(stateMap.get(name));
            }
        }
    }
}
