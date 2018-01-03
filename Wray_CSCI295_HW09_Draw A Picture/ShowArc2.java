
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

public class ShowArc2 extends Application {

    @Override 
    public void start(Stage primaryStage) {

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
        Text text1 = new Text(210, 40, "arc1: round");

        // Arc # 2 - open
        startAngle += 90;
        Arc arc2 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);
        Text text2 = new Text(20, 40, "arc2: open");

        // Arc # 3 - chord
        startAngle += 90;
        Arc arc3 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc3.setFill(Color.WHITE);
        arc3.setType(ArcType.CHORD);
        arc3.setStroke(Color.BLACK);
        Text text3 = new Text(20, 170, "arc3: chord");

        // Arc # 4 - chord
        startAngle += 90;
        Arc arc4 = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc4.setFill(Color.GREEN);
        arc4.setType(ArcType.CHORD);
        arc4.setStroke(Color.BLACK);
        Text text4 = new Text(210, 170, "arc4: chord");

        // Create a group and add nodes to the group
        Group group = new Group();
        group.getChildren().addAll(text1,arc1, text2, arc2, text3, arc3,
                text4, arc4);

        // Create a scene and place it in the stage
        Scene scene = new Scene(new Pane(group), 300, 200);
        primaryStage.setTitle("Four Arcs in a Group"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}