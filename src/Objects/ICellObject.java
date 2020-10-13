package Objects;

public interface ICellObject {

    boolean isClicked();

    boolean isMine();

    void setMine();

    void search(int x, int y);

    boolean isNeighbour(int x, int y);
}
