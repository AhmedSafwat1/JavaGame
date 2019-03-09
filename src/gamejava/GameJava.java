/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author safwat
 */
public class GameJava extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         FXMLLoader x = new FXMLLoader();
<<<<<<< HEAD
        // x.setLocation(getClass().getResource("player.fxml"));
         x.setLocation(getClass().getResource("login.fxml"));
         Parent root = x.load();
        // playerController c = x.getController();
        // c.prepareConnection();
=======
         x.setLocation(getClass().getResource("Home.fxml"));
         Parent root = x.load();
//        FXMLDocumentController c = x.getController();
>>>>>>> ca8197e3316b18634fb19a00b89a96e782596add
       
//        Parent root = new FXMLDocumentBase();
        Scene scene = new Scene(root);
         
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
