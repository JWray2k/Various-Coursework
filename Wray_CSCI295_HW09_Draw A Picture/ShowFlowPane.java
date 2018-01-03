import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(11, 12, 13, 14)); // Border 
        pane.setHgap(5);
        pane.setVgap(5);

        // Place three nodes in the pane at once
        pane.getChildren().addAll(
                new Label("First Name:"),
                new TextField(), 
                new Label("MI:"));
        
        TextField tfMi = new TextField();
        
        tfMi.setPrefColumnCount(1); // Remove this and it becomes too wide
        
        pane.getChildren().addAll(
                tfMi, 
                new Label("Last Name:"),
                new TextField());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 700, 75);
        
        primaryStage.setTitle("Flow Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}