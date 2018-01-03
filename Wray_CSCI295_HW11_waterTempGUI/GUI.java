/*
 * Jonathan Wray
 * CSCI-295 - Object Oriented II
 * HW11 - WaterType GUI
 * 11/6/2016
 */


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Calculator");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(pane, 400, 200);

        pane.add(new Label("Enter water temp in degrees F: "), 0, 0);
        TextField firstValue = new TextField();
        pane.add(firstValue, 1, 0);
        pane.add(new Label("The water is:"), 0, 3);
        Button aButton = new Button("Calculate Water Type");
        pane.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);
        pane.add(result, 1, 3);

        aButton.setOnAction(e -> {
            Integer degrees = Integer.valueOf(firstValue.getText());
            String waterType = "unspecified";
            if (degrees <= 32){
                waterType = "frozen";
            }
            else if (degrees > 32 && degrees < 212){
                waterType = "liquid";
            }
            else if (degrees >= 212){
                waterType = "boiling";
            }
            result.setText(waterType);
        });

        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}