
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;

public class ShowEllipse2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Pane pane = new MyEllipse();
        
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Cool Ellipse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class MyEllipse extends Pane {
//    private int widthCount = 0;
//    private int heightCount = 0;

    private void kmlPaint() {
        getChildren().clear();

        double centerX, centerY, radiusX, radiusY;
        int numEllipsis = 16;        
        for (int i = 0; i < numEllipsis; i++) {
            // Create an ellipse and add it to pane
            centerX = getWidth()/2;
            centerY = getHeight()/2;
            radiusX = centerX - 50;
            radiusY = centerY - 50;
            Ellipse e1 = new Ellipse(centerX, centerY, radiusX, radiusY);
            e1.setStroke(Color.color(Math.random(), Math.random(),
                    Math.random()));
            e1.setFill(Color.WHITE);
            e1.setRotate(i * 180 / numEllipsis);
            getChildren().add(e1);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        kmlPaint();
//        widthCount++;
//        System.out.println("Width: " + widthCount);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        kmlPaint();
//        heightCount++;
//        System.out.println("          Height: " + heightCount);
    }
}