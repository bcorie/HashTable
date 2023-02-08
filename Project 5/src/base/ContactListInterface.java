package base;
import java.util.List;

/**
 * Project 5 - Contact List
 * The implementation of this interface is a class where A can have many corresponding
 * values of type B and B can have many corresponding values of type A.
 * @author Gerald Cohen, Ph.D.
 */
public interface ContactListInterface<A, B> {

    /**
     * Add an object A with corresponding object B to the contact list.
     * If a duplicate already exists, it is replaced by the new one.
     * @param o1
     * @param o2 
     */
    void add(A o1, B o2);
    
    /**
     * Return a list of all values corresponding to the key A
     * @param object
     * @return list or null if none
     */
    List<B> lookup(A object);

    /**
     * Return a list of all keys corresponding to the value B
     * @param object
     * @return list or null if none
     */
    List<A> reverseLookup(B object);

    /**
     * Return true if key A is in the lookup table
     * @param object
     * @return 
     */
    boolean contains(A object);

    /**
     * Return the size of the lookup table
     * @return 
     */
    int sizeLookup();

    /**
     * Return the size of the reverse lookup table
     * @return 
     */
    int sizeReverseLookup();
}
