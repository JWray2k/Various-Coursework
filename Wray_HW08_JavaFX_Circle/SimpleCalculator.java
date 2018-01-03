import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Calculator");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 400, 200);

        rootNode.add(new Label("Enter water temp in degrees F: "), 0, 0);
        TextField firstValue = new TextField();
        rootNode.add(firstValue, 1, 0);
        //rootNode.add(new Label("Second Value:"), 0, 1);
        //TextField secondValue = new TextField();
        //rootNode.add(secondValue, 1, 1);
        rootNode.add(new Label("The water is:"), 0, 3);
        Button aButton = new Button("Calculate");
        rootNode.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);
        rootNode.add(result, 1, 3);

        aButton.setOnAction(e -> {
            Integer degrees = Integer.valueOf(firstValue.getText());
            //Integer value2 = Integer.valueOf(secondValue.getText());
            String waterType = "unspecified";
            if (degrees <= 32){
            waterType = "frozen";
            //System.out.println("The waster is " + waterType + ".");
            }
        
            else if (degrees > 32 && degrees < 212){
                waterType = "liquid";
            //System.out.println("The waster is " + waterType);
            }
        
            else if (degrees >= 212){
                waterType = "boiling";
            //System.out.println("The waster is " + waterType);
            }

            //return waterType;
            result.setText(waterType);
        });

        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}