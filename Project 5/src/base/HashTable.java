package base;
import java.util.*;

/**
 * Hash Tables
 *
 * @author Gerald Cohen, Ph.D.
 */
public class HashTable<K, V> {

    private LinkedList<V>[] hashTable;
    private HashIndexInterface hashcode;
    private ArrayList<Integer> person = new ArrayList<>();
    private ArrayList<Integer> indexes = new ArrayList<>();
    private final int defaultSize = 101;

    /**
     * Specify the size and method for computing a hash code index
     *
     * @param size
     * @param hashcode
     */
    public HashTable(int size, HashIndexInterface hashcode) {
        hashTable = new LinkedList[size];
        this.hashcode = hashcode;
    }

    public HashTable(HashIndexInterface hashcode) {
        hashTable = new LinkedList[defaultSize];
        this.hashcode = hashcode;
    }

    /**
     * Add an element to the table. Return false if not successful
     *
     * @param element
     * @return true if element was added to the table
     */
    public boolean add(K key, V element) {
        int index = hashIndex(key);
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        return hashTable[index].add(element);
    }

    /**
     * Remove an element from the table
     *
     * @param key
     * @return element removed or null if not found
     */
    public V remove(K key) {
        return find(key, true);
    }

    /**
     * Return the element in the table with the desired key
     *
     * @param key
     * @return element or null if not found
     */
    public V find(K key) {
        return find(key, false);
    }

    private V find(K key, boolean remove) {
        int index = hashIndex(key);

        if (hashTable[index] == null) {
            return null;
        }

        List<V> list = hashTable[index];
        for (int i = 0; i < list.size(); i++) {
            V obj = list.get(i);
            if (obj instanceof ArrayList || obj instanceof LinkedList) {
                List<V> subList = (List<V>) obj;
                for (int j = 0; j < subList.size(); j++) {
                    if (subList.get(j).equals(key)) {
                        if (remove) {
                            V element = subList.remove(j);
                            return element;
                        } else {
                            return list.get(j);
                        }
                    }
                    return null;
                }
            }

            if (remove) {
                V element = list.remove(i);
                if (list.size() == 0) {
                    hashTable[index] = null;
                }
                return element;
            } else {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Scan the hash table to compute the number of entries
     *
     * @return number of entries
     */
    public int size() {
        int count = 0;
        for (int i = 0; i < hashTable.length; ++i) {
            if (hashTable[i] != null) // if the hashTable is occupied by a phonenumber then count it
            {
                count++;
            }
        }
        return count;
    }

    public int hashIndex(K key) {
        if (!person.contains(key.toString().hashCode())) {

            int hash = key.toString().hashCode();
            int result = Math.abs(hash) % hashTable.length;
            person.add(hash);

            while (hashTable[result] != null) {
                result++;
            }
            indexes.add(result);
            return result;

        } else {
            int result = 0;
            for(int i = 0; i < person.size(); ++i){
                if (person.get(i) == key.toString().hashCode()){
                    return indexes.get(i);
                }
            }
            return result;
        }
    }

    public void dumpTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                System.out.println("Index: " + i + " Empty");
            } else {
                LinkedList<V> list = hashTable[i];
                System.out.print("Index: " + i + " (" + list.size() + ") ");
                System.out.println(list);
            }
        }
    }
}