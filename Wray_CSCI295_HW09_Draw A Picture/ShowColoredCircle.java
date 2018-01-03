
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowColoredCircle extends Application {
    
    @Override
    public void start(Stage primaryStage){
        // Make a new circle
        Circle circ = new Circle();
        
        // Set circle's (x, y) center and radius
        circ.setCenterX(100);
        circ.setCenterY(100);
        circ.setRadius(50);
        
        // Set circle color
        circ.setStroke(new Color(1, 0, 0, 1));

        Color fillColor = Color.rgb(0, 0, 255, .3);
        circ.setFill(fillColor);
        
        // Make new pane
        Pane pane = new Pane();
        
        // Add circle to the new pane
        pane.getChildren().add(circ);
        
        // Make new scene, specify pane, width, height, and title
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("ShowCircle");
        
        // Add scene to stage
        primaryStage.setScene(scene);
        
        // Make stage visible
        primaryStage.show();

    }
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}