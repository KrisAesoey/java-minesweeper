import Board.Board;
import Objects.Cell;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private double MIN_HEIGHT = 512;
    private double MIN_WIDTH = 512;

    private int difficulty = 0;
    Board board = new Board(8, 8, 1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minesweeper");
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setMinWidth(MIN_WIDTH);
        setDifficulty(primaryStage);
        primaryStage.show();
    }

    public void setDifficulty(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(64, 64, 64, 64));
        grid.setMinSize(MIN_WIDTH, MIN_HEIGHT);

        Button easy = new Button("Easy");
        Button medium = new Button ("Medium");
        Button expert = new Button ("Expert");
        Button play = new Button ("Play");

        easy.setOnMouseClicked(event -> {
            difficulty = 0;
        });
        medium.setOnMouseClicked(event -> {
            difficulty = 1;
        });
        expert.setOnMouseClicked(event -> {
            difficulty = 2;
        });
        play.setOnMouseClicked(event -> {
            setBoard(primaryStage);
        });

        grid.add(easy, 4, 4);
        grid.add(medium, 4, 5);
        grid.add(expert, 4 , 6);
        grid.add(play, 4, 7);

        Scene scene = new Scene(grid, MIN_WIDTH, MIN_HEIGHT);
        primaryStage.setScene(scene);
    }

    public void setBoard(Stage primaryStage) {
        int w = 0;
        int h = 0;
        switch(difficulty) {
            case 0:
                MIN_WIDTH = 512;
                w = 8;
                h = 8;
                board = new Board(8, 8, 0);
                break;
            case 1:
                MIN_WIDTH = 512;
                w = 15;
                h = 13;
                board = new Board(15, 13, 1);
                break;
            case 2:
                MIN_WIDTH = 960;
                w = 30;
                h = 16;
                board = new Board(30, 16, 2);
                break;
        }

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(32, 32, 32, 32));
        grid.setMinSize(MIN_WIDTH, MIN_HEIGHT);

        for (int i=0; i < w; i++) {
            for (int j=0; j < h; j++) {
                grid.add( (Cell) board.get(i, j), i, j);
            }
        }

        Scene scene = new Scene(grid, MIN_WIDTH, MIN_HEIGHT);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
