/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;

public class MultipleStageDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Button("Primary Stage Button"), 200, 250);
        primaryStage.setTitle("Primary Stage");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage2 = new Stage();
        stage2.setTitle("Other Stage");
        stage2.setScene(new Scene(new Button("Other Stage Button"), 400, 100));
        stage2.show();
        
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }

}