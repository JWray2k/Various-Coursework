
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontDemo extends Application{
    @Override
    public void start(Stage primaryStage){
        // Make new stack pane
        Pane pane = new StackPane();        
                
        // Make a new circle & Set its properties
        Circle circ = new Circle();
        circ.setRadius(50);
        circ.setStroke(Color.BROWN);
        circ.setStrokeWidth(3);
        circ.setFill(new Color(1, .9, 0, 1));
        
        // Make a label
        Label label = new Label("SAU");
        label.setFont(Font.font("Snell Roundhand", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
        
        
        // Switch the two & change opacity of circle fill color
        
        // Add circle to the new pane
        pane.getChildren().add(circ);
        
        // Add label to the pane
        pane.getChildren().add(label);
        
        
        
        // Make new scene, specify pane, width, height, and title
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("FontDemo");
        
        // Add scene to stage
        primaryStage.setScene(scene);
        
        // Make stage visible
        primaryStage.show();

    }

    
    public static void main(String[] args) {
        Application.launch(args);
    }    
}