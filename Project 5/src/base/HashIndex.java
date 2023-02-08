package base;

import java.util.ArrayList;
import java.util.Objects;

public class HashIndex<K> implements HashIndexInterface<String> {

    private K obj;
    private ArrayList<Integer> hashIndex;

    public HashIndex(K obj) {
        this.obj = obj;
        hashIndex = new ArrayList<>();
    }

    /**
     * Return value of K occupying the hash index
     * @return K obj
     */
    public K data(){
        return obj;
    }

    public void getIndecies(){
        for (Integer i : hashIndex){
            System.out.println(i);
        }
    }

    public void add(Integer index){
        hashIndex.add(index);
    }

    public boolean contains(K code){
        for(int i = 0; i < hashIndex.size(); ++i){
            if (Objects.equals(hashIndex.get(i), code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashIndex(String word) {
        int result = Math.abs(word.hashCode());
        if (!hashIndex.contains(result)) { hashIndex.add(result); }
        return result;
    }

}
