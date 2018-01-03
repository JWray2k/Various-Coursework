
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowImage extends Application {
    @Override
    public void start(Stage primaryStage){
        
        // Stack pane doesn't work so well. Everything is in the center
        // stacked one on top of the other
        //Pane pane = new StackPane(); 

        // Hbox is better
        int width = 10; // box will expand to hold what we add.
        Pane pane = new HBox(width);
        pane.setPadding(new Insets(5, 5, 5, 5)); // T R B L
        
        //String imageName = "http://cis4.sau.edu/lillis/me.jpg";        
        String imageName = "shield.jpeg";
        Image image = new Image(imageName);
        
        // Add the image for the first time, using the images size
        ImageView imageView1 = new ImageView(image);
        pane.getChildren().add(imageView1);
        
        // Add the image again only make height and width 1/3 the original
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(image.getHeight() / 3);
        imageView2.setFitWidth(image.getWidth() / 3);
        pane.getChildren().add(imageView2);
        
        
        // Add the image a third time with the original size, only rotated 90 deg
        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ImageView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        Application.launch(args);
    }    

}