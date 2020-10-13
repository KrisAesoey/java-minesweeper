package Board;

public interface IList<T> {
    /**
     *
     * @param e Adds element e to the list.
     */
    void add(T e);
    /**
     *
     * @param i removes the element at index i in the list.
     * @return the object at index i.
     */
    T remove(int i);
    /**
     *
     * @param i the index you wish to access in the list
     * @return the element at index i.
     */
    T get(int i);
    /**
     *
     * @return true if the list is empty, else false.
     */
    boolean isEmpty();
    /**
     *
     * @return the length of the list.
     */
    int size();
    /**
     *
     * @param i the index you wish to set the element for
     * @param e the element you wish to place at index i.
     */
    void set(int i, T e);
    /**
     * Clears the list.
     */
    void clear();
}
