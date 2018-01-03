
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

public class ShowArc extends Application {

    @Override 
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        double centerX, centerY, radiusX, radiusY, startAngle, length;
        
        // Arc # 1 - round, red
        centerX=150; 
        centerY=100; 
        radiusX=80; 
        radiusY=80; 
        startAngle=30; 
        length=35;
        Arc arc1 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.ROUND);
        pane.getChildren().add(new Text(210, 40, "arc1: round"));
        pane.getChildren().add(arc1);

        // Arc # 2 - open
        startAngle += 90;
        Arc arc2 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);
        pane.getChildren().add(new Text(20, 40, "arc2: open"));
        pane.getChildren().add(arc2);

        // Arc # 3 - chord
        startAngle += 90;
        Arc arc3 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc3.setFill(Color.WHITE);
        arc3.setType(ArcType.CHORD);
        arc3.setStroke(Color.BLACK);
        pane.getChildren().add(new Text(20, 170, "arc3: chord"));
        pane.getChildren().add(arc3);
        
        // Arc # 4 - chord
        startAngle += 90;
        Arc arc4 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc4.setFill(Color.GREEN);
        arc4.setType(ArcType.CHORD);
        arc4.setStroke(Color.BLACK);
        pane.getChildren().add(new Text(210, 170, "arc4: chord"));
        pane.getChildren().add(arc4);


        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Four Arcs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}