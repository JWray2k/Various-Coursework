
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class DrawLines extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Make new LinePane and put it inside a new scene.
        Scene scene = new Scene(new LinePane(), 300, 200);
        
        primaryStage.setTitle("Draw Lines");
        
        // Put the scene inside the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }    
}

class LinePane extends Pane {

    public LinePane() {
        // Red Line
        Line redLine = new Line();
        
        redLine.setStartX(10); // These two don't change.
        redLine.setStartY(10); // The line always starts at (10, 10)

        redLine.endXProperty().bind(widthProperty().subtract(10));
        redLine.endYProperty().bind(heightProperty().subtract(10));
        
        redLine.setStrokeWidth(5);
        redLine.setStroke(Color.RED);
        
        this.getChildren().add(redLine);

        
        // Green Line
        Line greenLine = new Line();
        
        greenLine.startXProperty().bind(widthProperty().subtract(10));
        greenLine.setStartY(10);
        
        greenLine.setEndX(10);
        greenLine.endYProperty().bind(heightProperty().subtract(10));
        
        greenLine.setStrokeWidth(5);
        greenLine.setStroke(Color.GREEN);
        
        this.getChildren().add(greenLine);

    }
}