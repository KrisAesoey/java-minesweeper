package Board;

import Objects.Cell;
import Objects.ICellObject;

import java.util.Random;

public class Board implements IGrid<ICellObject> {

    private boolean isClicked = false;
    private int difficulty = 0;
    private int height, width;
    private IList<ICellObject> board;

    public Board(int width, int height, int difficulty) {
        this.width = width;
        this.height = height;
        board = new List(width * height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board.add(new Cell(i, j, this));
            }
        }
        this.difficulty = difficulty;
    }

    public void initialize(int x, int y, int difficulty) {
        int mines = 0;
        switch (difficulty) {
            case 0:
                mines = 10;
                break;
            case 1:
                mines = 40;
                break;
            case 2:
                mines = 99;
        }
        for (int i = 0; i < mines; i++) {
            placeMine(x, y);
        }
        get(x, y).search(x, y);
    }

    public void placeMine(int a, int b) {
        Random random = new Random();
        int x = random.nextInt(this.width);
        int y = random.nextInt(this.height);
        if (!get(x, y).isMine() && (!get(x, y).isClicked()) && !get(x, y).isNeighbour(a, b)) {
            get(x, y).setMine();
        }
        else {
            placeMine(a, b);
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public ICellObject get(int x, int y) {
        int i = y + (height * x);
        return board.get(i);
    }

    @Override
    public void set(int x, int y, ICellObject e) {
        int i = y + (height * x);
        board.set(i, e);
    }

    @Override
    public boolean inGrid(int x, int y) {
        return (0 <= x && x < getWidth() && 0 <= y && y < getHeight());
    }

    public boolean firstClicked() {
        return isClicked;
    }

    public void firstIsClicked(int x, int y) {
        isClicked = true;
        initialize(x, y, difficulty);
    }
}
