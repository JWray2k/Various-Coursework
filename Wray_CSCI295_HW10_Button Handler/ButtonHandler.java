/*
* Jonathan Wray
* CSCI-295 HW10 - Button Handler
* 10/26/2016
*/


/*
 * HW 10 - Button Handler
 *
 * Write a JavaFX program that contains a single button. When the program starts 
 * a message is displayed on the standard output device that reads Value = 1. 
 * Every time the button is clicked, the value should be doubled and displayed again. 
 * For example, if the button is clicked 5 times, the output would look like this:
 * Value = 1
 * Value = 2
 * Value = 4
 * Value = 8
 * Value = 16
 * Value = 32
 */


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class ButtonHandler extends Application{
    @Override
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setAlignment(Pos.CENTER);
        
        Button Double = new Button("DOUBLE TIME!");
        
        DoubleHandlerClass doubleHandler = new DoubleHandlerClass();
        Double.setOnAction(doubleHandler);
   
        
        pane.getChildren().add(Double);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Handle Events"); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class DoubleHandlerClass implements EventHandler<ActionEvent> {
    int i = 1;
    @Override
    public void handle(ActionEvent e) {
        System.out.println("Value = " + i);
        i = i*2;
        //sets value of i = i*2, thus on every click, i continues to double.
    }
}




