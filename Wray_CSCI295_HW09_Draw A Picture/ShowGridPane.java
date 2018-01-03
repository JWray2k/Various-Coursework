
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ShowGridPane extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a pane and set its properties
        GridPane numberPane = new GridPane();
        numberPane.setAlignment(Pos.CENTER);
        numberPane.setPadding(new Insets(5, 15, 5, 15));
        numberPane.setHgap(5.5);
        numberPane.setVgap(5.5);

        // Place number buttons in the pane (c, r)
        numberPane.add(new Button("1"), 0, 0);
        numberPane.add(new Button("2"), 1, 0);
        numberPane.add(new Button("3"), 2, 0);
        numberPane.add(new Button("4"), 0, 1);
        numberPane.add(new Button("5"), 1, 1);
        numberPane.add(new Button("6"), 2, 1);
        numberPane.add(new Button("7"), 0, 2);
        numberPane.add(new Button("8"), 1, 2);
        numberPane.add(new Button("9"), 2, 2);
        numberPane.add(new Button("*"), 0, 3);
        numberPane.add(new Button("0"), 1, 3);
        numberPane.add(new Button("#"), 2, 3);

        GridPane buttonPane = new GridPane();
        Button btnCall = new Button("Call");
        btnCall.setTextFill(Color.GREEN);
        buttonPane.add(btnCall, 0, 0);

        Button btnEnd = new Button("End");
        btnEnd.setTextFill(Color.RED);
        buttonPane.add(btnEnd, 1, 0);

        buttonPane.setPadding(new Insets(5, 5, 5, 5));
        buttonPane.setHgap(10);
        buttonPane.setAlignment(Pos.CENTER);

        GridPane phonePane = new GridPane();
        phonePane.add(numberPane, 0, 0);
        phonePane.add(buttonPane, 0, 1);
        phonePane.setAlignment(Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(phonePane);

        primaryStage.setTitle("Phone");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}