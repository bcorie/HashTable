package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ContactList contacts = new ContactList();
        populateContactList(contacts, "contacts.txt");
        Person contact = new Person("Charles", "Beard");
        List<String> numbers = contacts.lookup(contact);
        // Print telephone numbers
        System.out.println(numbers);
        String telephone = "7142453703";
        List<Person> cnts = contacts.reverseLookup(telephone);
        // Print contacts
        System.out.println(cnts);
    }


    private static void populateContactList(ContactList contacts, String s) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(s));
        String num, first, last;
        do {
            num = scanner.next();
            last = scanner.next();
            first = scanner.next();
            contacts.add(new Person(first, last), num);
        } while (scanner.hasNext());
    }
}
