/*
 * Jonathan Wray
 * CSCI-295 - Object Oriented II
 * HW08 - JavaFX Circle
 * 10/15/2016
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;

public class JavaFX_Circles extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Make new pane
        Pane pane1 = new Pane();
        
        // Make a new circle - BOTTOM RIGHT
        Circle circ1 = new Circle();
        circ1.setStroke(Color.TEAL);
        circ1.setFill(Color.GOLDENROD);

        // subtract from width and height properties
        circ1.centerXProperty().bind(pane1.widthProperty().subtract(43));
        circ1.centerYProperty().bind(pane1.heightProperty().subtract(43));
        
        // Hard set radius to 40
        circ1.setRadius(40);

        // Add circle to the new pane
        pane1.getChildren().add(circ1);
        
        // Make new scene, specify pane, width, height, and title
        Scene scene1 = new Scene(pane1, 300, 400);
        primaryStage.setTitle("Bottom Right");
        
        // Add scene to stage
        primaryStage.setScene(scene1);
        
        // Make stage visible
        primaryStage.show();
        
        
        //BOTTOM CENTER
        Pane pane2 = new Pane();
        
        // Make a new circle
        Circle circ2 = new Circle();
        circ2.setStroke(Color.FUCHSIA);
        circ2.setFill(Color.LIGHTPINK);
        
        // Set Circle to Bottom-center
        circ2.centerXProperty().bind(pane2.widthProperty().divide(2));
        circ2.centerYProperty().bind(pane2.heightProperty().subtract(40));
        
        // Hard set radius to 35
        circ2.setRadius(35);
        
        // Add circle to the new pane
        pane2.getChildren().add(circ2);
        
        // Make new scene, specify pane, width, height, and title
        Stage bottomCenterStage = new Stage();
        Scene scene2 = new Scene(pane2, 300, 300);
        bottomCenterStage.setTitle("Bottom Center");
        
        // Add scene to stage
        bottomCenterStage.setScene(scene2);
        
        // Make stage visible
        bottomCenterStage.show();
        
        
        //RADIUS == WIDTH
        Pane pane3 = new Pane();
        
        // Make a new circle
        Circle circ3 = new Circle();
        circ3.setStroke(Color.LIGHTSLATEGRAY);
        circ3.setFill(Color.VIOLET);
        
        // Center circle in the center of the pane
        circ3.centerXProperty().bind(pane3.widthProperty().divide(2));
        circ3.centerYProperty().bind(pane3.heightProperty().divide(2));
        
        // Hard set radius to 50
        circ3.setRadius(50);
        
        // The circle is set to the width of the pane
        circ3.radiusProperty().bind(pane3.widthProperty().divide(2));
        
        
        // Add circle to the new pane
        pane3.getChildren().add(circ3);
        
        // Make new scene, specify pane, width, height, and title
        Stage radiusEqualsWidth = new Stage();
        Scene scene3 = new Scene(pane3, 400, 300);
        radiusEqualsWidth.setTitle("Radius == Width");
        
        // Add scene to stage
        radiusEqualsWidth.setScene(scene3);
        
        // Make stage visible
        radiusEqualsWidth.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }

}