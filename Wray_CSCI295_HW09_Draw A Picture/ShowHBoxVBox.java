
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowHBoxVBox extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a border pane 
       BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(getHBox()); // getHBox() creates and returns an HBox object
        pane.setLeft(getVBox()); // getVBox() creates and returns an VBox object

        // Boilerplate
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowHBoxVBox"); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox getHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");

        hBox.getChildren().add(new Button("Computer Science"));
        hBox.getChildren().add(new Button("Chemistry"));
        hBox.getChildren().add(new ImageView(new Image("us.gif")));

        return hBox;
    }

    private VBox getVBox() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5)); // top, right, bottom, left
        
        vBox.getChildren().add(new Label("Courses"));

        Label[] courses = {new Label("CSCI 195"), new Label("CSCI 295"),
            new Label("CSCI 310"), new Label("CSCI 400")};

        for (Label course : courses) {
            // Set margin to be used when node is placed inside VBox
            VBox.setMargin(course, new Insets(0, 0, 0, 15));
            
            // Place the node inside the VBox
            vBox.getChildren().add(course);
        }

        return vBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}