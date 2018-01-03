
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;

public class ShowEllipse extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        double centerX=150, centerY=100, radiusX=100, radiusY=50;
        int numEllipsis = 16;
        // Make the ellipsis
        for (int i = 0; i < numEllipsis; i++) {
            // Create an ellipse and add it to pane
            Ellipse e1 = new Ellipse(centerX, centerY, radiusX, radiusY);
            e1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            e1.setFill(Color.WHITE);
            e1.setRotate(i * 180 / numEllipsis);
            pane.getChildren().add(e1);
        }

        
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("16 Ellipsis");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}