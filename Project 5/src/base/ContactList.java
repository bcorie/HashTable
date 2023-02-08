package base;

import java.util.ArrayList;
import java.util.List;


/**
 * By Thibault and Corie
 */
public class ContactList implements ContactListInterface<Person, String> {

    private HashTable<Person, String> list;
    private HashTable<String, Person> reverseList;
    private HashIndexInterface hashcode;

    public ContactList(){
        list = new HashTable<>(hashcode);
        reverseList = new HashTable<>(hashcode);
    }

    public void add(Person o1, String o2){
        list.add(o1, o2);
        reverseList.add(o2, o1);
    }

    public List<String> lookup(Person object){ // returns phone #
        List<String> phoneNumbers = new ArrayList<>();
        while(list.find(object) != null){
            phoneNumbers.add(list.remove(object));
        }

        for(int i = 0; i < phoneNumbers.size(); ++i){
            list.add(object, phoneNumbers.get(i));
        }
        return phoneNumbers;
    }

    public List<Person> reverseLookup(String object){ // return people
        List<Person> contacts = new ArrayList<>();
        while(reverseList.find(object) != null){
            contacts.add(reverseList.remove(object));
        }

        for(int i = 0; i < contacts.size(); ++i){
            reverseList.add(object, contacts.get(i));
        }
        return contacts;
    }

    public boolean contains(Person object){
        if(list.find(object) != null)
            return true;
        return false;
    }

    public int sizeLookup(){
        return list.size();
    }

    public int sizeReverseLookup(){
        System.out.println(reverseList.size());
        return reverseList.size();
    }

    public String toString(){
        list.dumpTable();
        System.out.println("\n\n\n");
        reverseList.dumpTable();
        return "";
    }

}