package Board;

public interface IGrid<T> {
    /**
     *
     * @return the height of the grid.
     */
    int getHeight();
    /**
     *
     * @return the width of the grid.
     */
    int getWidth();
    /**
     *
     * @param x the x coordinate of the grid
     * @param y the y coordinate of the grid
     * @return the element you wish to retrieve
     */
    T get (int x, int y);
    /**
     *
     * @param x the x coordinate of the grid
     * @param y the y coordinate of the grid
     * @param e the element you wish to set at (x, y)
     */
    void set (int x, int y, T e);

    boolean inGrid(int x, int y);
}
