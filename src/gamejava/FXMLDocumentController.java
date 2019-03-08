/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author safwat
 */
public class FXMLDocumentController implements Initializable {
    //button
    @FXML
    private Button exit;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button again;
    // label
    @FXML
    private  Label stautus;
    @FXML
    private Label labelName1;
    @FXML
    private Label labelName2;
    @FXML
    private Label labelRecord;
    @FXML
    private Line line;
    
    // array from button
    private final ArrayList<Button> btns = new ArrayList<>(9);
    private  ArrayList<Button> btnsCpy ;
    private Vector<String> Player1Step =  new Vector<>();
    private Vector<String> Player2Step =  new Vector<>();
    //Button[] btnArray = new Button[9];
    // attribute use
    private boolean turnFlag = true;
    private boolean gameFlag = true;
    private String playerName1 = "Name"; 
    private String playerName2 = "PC"; 
    private int mode = 1;
    private boolean display =false;
    private String Winer = "No-One";
    public boolean recordState = false;
    //test
    @FXML
    private void Exit(ActionEvent event)
    {
        try {
             FXMLLoader x = new FXMLLoader();
             x.setLocation(getClass().getResource("Home.fxml"));
             Parent root = x.load();
             HomeController c = x.getController();
             if(!gameFlag && recordState)
             {
                 c.PutRecod(Player1Step, Player2Step,playerName1,playerName2,Winer);
             }
             else
             {
                 if(recordState && !display)
                 {
                     Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning ..");
                    alert.setHeaderText("Look, a Warning Not commplete the game ");
                    alert.setContentText("Careful The record not save!");

                    alert.showAndWait();
                 }
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
    private void reset(ActionEvent event)
    {
        turnFlag = true;
        gameFlag = true;
        stautus.setText("Game Start "+playerName1 + " will Play X");
        btns.forEach((x)->{
            x.setText("");
            x.setDisable(false);
            
        });
        Player1Step.clear();
        Player2Step.clear();
        again.setVisible(false);
        
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(recordState)
            labelRecord.setText("Record ..");
        System.out.println(""+ b1.getLayoutX());
//        line.setStartX( b1.get);
//        line.setStartY( b1.getLayoutY());
//        line.setEndX( b3.getLayoutX());
//        line.setEndY(b3.getLayoutY());
      //  System.out.println("(Button)event.getSource()"+(Button)event.getSource());
        Button temp =  (Button)event.getSource();
        //computer
        
        if(mode == 1)
        {
            disableBtn();
            if(turnFlag && gameFlag)
            {
                player1(temp);
                if(CheckWinner("X"))
                {

                    gameFlag = !gameFlag;
                    Winer = playerName1;
                    stautus.setText("The Player "+playerName1 + " Winner");
                    stautus.setTextFill(Color.GREEN);
                    again.setVisible(true);


                }
                if(checkEndGame() && gameFlag)
                {
                    gameFlag = !gameFlag;
                    stautus.setText("The Game End");
                    stautus.setTextFill(Color.AQUA);
                    again.setVisible(true);

                }
                turnFlag = !turnFlag;
            }
             if(gameFlag && !turnFlag)
                {
                    
                   new Thread(){
                       @Override
                       public void run() {
                           
                            try {
                                sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                           
                           PcPlayer("X");
                        if(CheckWinner("O"))
                        {
                            gameFlag = !gameFlag;
                            Winer = playerName2;
                            stautus.setText("The Player "+playerName2 + " Winner");
                            stautus.setTextFill(Color.RED);
                            again.setVisible(true);
                        }
                        if(checkEndGame()&& gameFlag)
                        {
                            gameFlag = !gameFlag;
                            stautus.setText("The Game End");
                            stautus.setTextFill(Color.AQUA);
                            again.setVisible(true);
                        }
                        turnFlag = !turnFlag;
                        enableBtn();
                        }
                    });
                       }
                       
                   }.start();
                    
                }
        }
        else // friend
        {
            if(turnFlag && gameFlag)
            {
                player1(temp);
                if(CheckWinner("X"))
                {

                    gameFlag = !gameFlag;
                    Winer = playerName2;
                    stautus.setText("The Player "+playerName1 + " Winner");
                    stautus.setTextFill(Color.GREEN);
                    again.setVisible(true);


                }
                if(checkEndGame() && gameFlag)
                {
                    gameFlag = !gameFlag;
                    stautus.setText("The Game End");
                    stautus.setTextFill(Color.AQUA);
                    again.setVisible(true);

                }
                turnFlag = !turnFlag;
            }
             else
            {
                if(gameFlag)
                {
                    player2(temp);
                    if(CheckWinner("O"))
                    {
                        gameFlag = !gameFlag;
                        Winer = playerName2;
                        stautus.setText("Tahe Player "+playerName2 + " Winner");
                        stautus.setTextFill(Color.BLUE);
                        again.setVisible(true);
                    }
                    if(checkEndGame()&& gameFlag)
                    {
                        stautus.setText("The Game End");
                        stautus.setTextFill(Color.AQUA);
                        again.setVisible(true);
                    }
                    turnFlag = !turnFlag;
                }
            }
        }

        
    }
    //private using method
    //disable button untill
    private void disableBtn()
    {
        
        btnsCpy.forEach(x->x.setDisable(true));
    }
    private void enableBtn()
    {
        btnsCpy.forEach(x->x.setDisable(false));
    }
    // player 1 play
    private void player1(Button temp)
    {
         temp.setDisable(true);
         btnsCpy.remove(temp);
         Player1Step.add(temp.getId().replace("b", "x"));
         temp.setTextFill(Color.GREEN);
         temp.setText("X");
         stautus.setText("Turn of "+playerName2 + " Play O");
         stautus.setTextFill(Color.RED);
    }
    // player 2 play
    private void player2(Button temp)
    {
         temp.setDisable(true);
          btnsCpy.remove(temp);
         temp.setTextFill(Color.RED);
         temp.setText("O");
         Player2Step.add(temp.getId().replace("b", "o"));
         stautus.setText("Turn of "+playerName1 + " Play X");
         stautus.setTextFill(Color.GREEN);
    }
    // Check winer
    private boolean CheckWinner(String TypePlyer)
    {
        if(b1.getText().equals(TypePlyer) && b5.getText().equals(TypePlyer) && b9.getText().equals(TypePlyer) )
            return true;
        else if(b3.getText().equals(TypePlyer) && b5.getText().equals(TypePlyer) && b7.getText().equals(TypePlyer) )
            return true;
        else if(b1.getText().equals(TypePlyer) && b2.getText().equals(TypePlyer) && b3.getText().equals(TypePlyer) )
            return true;
        else if(b4.getText().equals(TypePlyer) && b5.getText().equals(TypePlyer) && b6.getText().equals(TypePlyer) )
            return true;
        else if(b7.getText().equals(TypePlyer) && b8.getText().equals(TypePlyer) && b9.getText().equals(TypePlyer) )
            return true;
        else if(b1.getText().equals(TypePlyer) && b4.getText().equals(TypePlyer) && b7.getText().equals(TypePlyer) )
            return true;
        else if(b2.getText().equals(TypePlyer) && b5.getText().equals(TypePlyer) && b8.getText().equals(TypePlyer) )
            return true;
        else if(b3.getText().equals(TypePlyer) && b6.getText().equals(TypePlyer) && b9.getText().equals(TypePlyer) )
            return true;
        else
            return false;
    }
    // check if game end
    private boolean checkEndGame()
    {
        return(Player1Step.size() + Player2Step.size() == 9);     
    }
    //computer player
    private void PcPlayer(String player)
    {
        Random rn = new Random();
        int step = rn.nextInt(9) ;
        String another = "X";
        if(player.equals("X"))
           another = "O";
       
        
        while(btns.get(step).getText().equals(player) || btns.get(step).getText().equals(another))
        {
            step = rn.nextInt(9);
        }
        System.out.println(step);
        if(player.equals("X"))
           player2(btns.get(step));
        else
            player1(btns.get(step));
    }
    public void  makeGame(String player1Name,String player2Name,int _mode)
    {
        playerName1 = player1Name;
        playerName2 = player2Name;
        labelName1.setText(player1Name + " : X");
        labelName2.setText(player2Name + " : O");
        mode = _mode;
    }
    public void makeRecod(String player1Name,String player2Name,Vector<String> play1 , Vector<String> play2,String Winner)
    {
        display = true;
        playerName1 = player1Name;
        playerName2 = player2Name;
        Winer = Winner;
        labelName1.setText(playerName1 + " : X");
        labelName2.setText(playerName2 + " : O");
        Player1Step.clear();
        Player2Step.clear();
        Player1Step = (Vector)play1.clone();
        Player2Step = (Vector)play2.clone();
        System.out.println("1 : "+Player1Step.size());
        System.out.println("2 : "+Player2Step.size());
         btns.forEach((x)->{
            x.setText("");
            x.setDisable(true);
            
        });
        class rec extends Thread
        {

            @Override
            public void run() {
                int count = 0;
                int size1  = Player1Step.size();
                int size2 = Player2Step.size();
                int mainSize = size1 > size2 ? size1 : size2;
                 while(count < mainSize)
                 {
                      
                  try {
                     
                        try{
                          
                            
                             int index = Integer.parseInt(Player1Step.get(count).substring(1))-1;
                             Platform.runLater(new Runnable() {
                                 @Override
                                 public void run() {
                                    btns.get(index).setTextFill(Color.GREEN);
                                    btns.get(index).setText("X");
                                    stautus.setText("Turn of "+playerName2 + " Play O");
                                    stautus.setTextFill(Color.RED);
                                 }
                             });
                             
//          
                        }
                        catch(IndexOutOfBoundsException ex){}

                        if(count == size1-1 && size1 > size2)
                            break;
                        sleep(2000);
                        try
                        {
                          int index = Integer.parseInt(Player2Step.get(count).substring(1))-1;
                            Platform.runLater(new Runnable() {
                                 @Override
                                 public void run() {
                                     
                                     btns.get(index).setTextFill(Color.RED);
                                     btns.get(index).setText("O");
                                     if(size2 == mainSize)
                                     {
                                        stautus.setText("Turn of "+playerName1 + " Play X");
                                        stautus.setTextFill(Color.GREEN);
                                     }
                                 }
                             });
                            sleep(2000);
                        }
                        catch(IndexOutOfBoundsException ex){}
                        
                        
                    } catch (InterruptedException ex  ) {}
                    
                     count++;
                 }
                 gameFlag = !gameFlag;
                 Platform.runLater(new Runnable() {
                                 @Override
                                 public void run() {
                                    stautus.setText("Finsih Winner is  "+Winner );
                                    stautus.setTextFill(Color.AQUA);
                                 }
                             });
                 
            }
            
        }
        new rec().start();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // handl the name 
        labelName1.setText(playerName1 + " : X");
        
        line.setVisible(false);
        labelName1.setTextFill(Color.GREEN);
        labelName2.setText(playerName2 + " : O");
        labelName2.setTextFill(Color.RED);
        btns.addAll(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9));
        btnsCpy = (ArrayList<Button>) btns.clone();
        stautus.setText("Game Start "+playerName1 + " will Play X");
        
    }    
    
}
