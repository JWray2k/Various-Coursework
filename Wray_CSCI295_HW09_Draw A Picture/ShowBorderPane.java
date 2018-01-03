
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowBorderPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Make a border pane 
        BorderPane pane = new BorderPane();

        // Put a custom pane in each are of the border pane.
        // So we now have a pane inside a pane.
        pane.setTop(new CustomPane("Top"));
        pane.setRight(new CustomPane("Right"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPane("Left"));
        pane.setCenter(new CustomPane("Center"));


        // Do the rest of the standard stuff
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Border Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Make custom pane. Notice that there are now two classes in this file.
class CustomPane extends StackPane {

    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: red");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}