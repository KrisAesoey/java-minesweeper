package Objects;

import Board.Board;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;

import java.util.concurrent.TimeUnit;

public class Cell extends Button implements ICellObject {
    private boolean clicked = false;
    private boolean flagged = false;
    private boolean mine = false;
    private int x, y;
    private Board grid;

    public Cell(int x, int y, Board grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.setMinSize(32, 32);
        this.setPrefSize(32, 32);
        this.setStyle("-fx-background-color: #888888; -fx-border-color: #000000;");

        this.setOnMouseClicked(event -> {
            if (grid.firstClicked()) {
                if (!clicked) {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        if (!flagged) {
                            clicked = true;
                            if (mine) {
                                this.setStyle("-fx-background-color: #aa0000; -fx-border-color: #000000;");
                            } else {
                                search(x, y);
                            }
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        if (flagged) {
                            this.setStyle("-fx-background-color: #888888; -fx-border-color: #000000;");
                            flagged = false;
                        } else {
                            this.setStyle("-fx-background-color: #00aaff; -fx-border-color: #000000;");
                            flagged = true;
                        }
                    }
                }
            }
            else {
                clicked = true;
                grid.firstIsClicked(x, y);

            }
        });
    }

    public void search(int a, int b) {
        int neighborMines = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (grid.inGrid(i, j) && grid.get(i, j).isMine()) {
                    neighborMines++;
                }
            }
        }
        clicked = true;
        if (neighborMines > 0 && !isMine()) {
            setText(String.valueOf(neighborMines));
        }
        else {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (grid.inGrid(i, j) && !grid.get(i, j).isClicked()) {
                        if (!grid.get(i, j).isMine()) {
                            grid.get(i, j).search(i, j);
                        }
                    }
                }
            }
        }
        this.setStyle("-fx-background-color: #dddddd; -fx-border-color: #000000;");
    }

    public boolean isClicked() {
        return clicked;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine() {
        mine = true;
    }

    public boolean isNeighbour(int a, int b) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == a && j == b) {
                    return true;
                }
            }
        }
        return false;
    }
}
