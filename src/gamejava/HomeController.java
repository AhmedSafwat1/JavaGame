/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**background_image.jpg
 * FXML Controller class
 *
 * @author safwat
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button pc;
    @FXML
    Button friendPlay;
    @FXML
    Button online;
    @FXML
    Button record;
   
    // record
    private Vector<String> Player1StepRecod =  new Vector<>();
    private Vector<String> Player2StepRecod =  new Vector<>();
    private String recodPlayer1 = "";
    private String recodPlayer2 = "";
    private String WinnerName="";
    public String playerlogin = "User";
    public String playerfriend = "Unknown";
    @FXML
    private void goPc(ActionEvent event)
    {
       
        try {
             FXMLLoader x = new FXMLLoader();
             x.setLocation(getClass().getResource("FXMLDocument.fxml"));
             Parent root = x.load();
             FXMLDocumentController c = x.getController();
             Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Want To Recod The Game");
            alert.setHeaderText("Record the game to watch Later");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                c.recordState = true;
            } 
             Stage stage =(Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    private void gorecord(ActionEvent event)
    {
       
        try {
             if(Player1StepRecod.isEmpty() || Player2StepRecod.isEmpty())
             {
                 System.out.println("not record yet");
                  Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning ..");
                    alert.setHeaderText("Look, a Warning Not have Any Record ");
                    alert.setContentText("Record The next Game Thanks ..");

                    alert.showAndWait();
             }
             else
             {
                FXMLLoader x = new FXMLLoader();
                x.setLocation(getClass().getResource("FXMLDocument.fxml"));
                Parent root = x.load();
                FXMLDocumentController c = x.getController();
                c.makeRecod(recodPlayer1, recodPlayer2, Player1StepRecod, Player2StepRecod,WinnerName);
                Stage stage =(Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
             }
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
     private void goFriend(ActionEvent event)
    {
       
        try {
             FXMLLoader x = new FXMLLoader();
             x.setLocation(getClass().getResource("FXMLDocument.fxml"));
             Parent root = x.load();
             FXMLDocumentController c = x.getController();
             Alert alert = new Alert(AlertType.CONFIRMATION);
             alert.setTitle("Want To Recod The Game");
             alert.setHeaderText("Record the game to watch Later");
             alert.setContentText("Are you ok with this?");
 
             Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){
                // ... user chose OK
                c.recordState = true;
             } 
             //get friend name
             TextInputDialog dialog = new TextInputDialog("");
             dialog.setTitle("Friend Name");
             dialog.setHeaderText("Look, a Text Input ");
             dialog.setContentText("Please enter your Friend name:");

            // Traditional way to get the response value.
            Optional<String> namePlayer2 = dialog.showAndWait();
            if (namePlayer2.isPresent() && !namePlayer2.get().isEmpty()){
                playerfriend = namePlayer2.get();
            }
             c.makeGame(playerlogin, playerfriend, 0);
             Stage stage =(Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void PutRecod(Vector<String> play1 , Vector<String> play2,String name1,String name2, String W)
     {
         Player1StepRecod.clear();
         Player2StepRecod.clear();
         Player1StepRecod = (Vector)play1.clone();
         Player2StepRecod = (Vector)play2.clone();
         recodPlayer1 = name1;
         recodPlayer2 = name2;
         WinnerName  = W;
         //Player1StepRecod.forEach((x)->System.out.println(x));
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
