package base;

/**
 * @author Thibault and Corie
 */

public class Person{

    private String firstName, lastName;

    public Person(String first, String last){

        firstName = first.toLowerCase();
        lastName = last.toLowerCase();
    }

    public String toString(){
        return firstName + " " + lastName;
    }
}