/*
This is an in-class demo showing a circle's radius which sticks to the center-bottom of the stage.
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircleCentered extends Application {
    
    @Override
    public void start(Stage primaryStage){
       // Make new pane
        Pane pane = new Pane();
        
        // Make a new circle
        Circle circ = new Circle();
        circ.setStroke(Color.DARKBLUE);
        circ.setFill(Color.YELLOW);
        
        // Set (x, y) of center using properties
        // Center of circle equals the bottom right corner of the pane
        // circ.centerXProperty().bind(pane.widthProperty());
        // circ.centerYProperty().bind(pane.heightProperty());
        
        // Center circle in the center of the pane
        circ.centerXProperty().bind(pane.widthProperty().divide(2));
        //circ.centerYProperty().bind(pane.heightProperty().divide(2));

        circ.centerYProperty().bind(pane.heightProperty().subtract(10));
        
        // Hard set radius to 50
        circ.setRadius(50);
        
        // Bind circle's radius the the height of the pane
        //circ.radiusProperty().bind(pane.heightProperty().divide(3));
        
        // Add circle to the new pane
        pane.getChildren().add(circ);
        
        // Make new scene, specify pane, width, height, and title
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("ShowCircleCentered");
        
        // Add scene to stage
        primaryStage.setScene(scene);
        
        // Make stage visible
        primaryStage.show();
        
    }
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}