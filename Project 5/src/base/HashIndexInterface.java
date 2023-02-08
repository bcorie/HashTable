package base;

/**
 * Hash Index Interface
 *
 * @author Gerald Cohen, Ph.D.
 */
public interface HashIndexInterface<T> {
    /**
     * Hashing index based upon table size
     * @param word Text to hash
     * @return hash index
     */
    int hashIndex(T word);
}
