
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

public class ShowPolygon extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new MyPolygon(), 400, 400);
        primaryStage.setTitle("ShowPolygon"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        //System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
        launch(args);
    }
}

class MyPolygon extends Pane {

    private void paint() {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        
        ObservableList<Double> points = polygon.getPoints(); // this is empty

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        // Why the 0.4 in the previous line? We are settign the radius, so that
        // should be 1/2 the of min(width, height). We make it just a little 
        // smaller so there's a border around the edge.

        int numSides = 6;
        // Add points to the polygon list
        for (int i = 0; i < numSides; i++) {
            // Add x coordinate
            points.add(centerX + radius * Math.cos(2 * i * Math.PI / numSides));
            
            // Add y coordinate
            points.add(centerY - radius * Math.sin(2 * i * Math.PI / numSides));
        }

//        // print the points
//        for(int i = 0; i < points.size(); i+=2){
//            System.out.println(points.get(i) + ", " + points.get(i + 1));
//        }
//        System.out.println("====================================================");
        
        getChildren().clear();
        getChildren().add(polygon);
    }
    
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}