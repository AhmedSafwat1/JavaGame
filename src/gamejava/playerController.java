/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
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
public class playerController implements Initializable {
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
    //connection
    Socket s;
    PrintStream pw;
    DataInputStream dis;
    int f1 ;
    listnerServer th = null;
    // array from button
    private final ArrayList<Button> btns = new ArrayList<>(9);
    private  ArrayList<Button> btnsCpy ;
    private Vector<String> Player1Step =  new Vector<>();
    private Vector<String> Player2Step =  new Vector<>();
    //Button[] btnArray = new Button[9];
    // attribute use
    private boolean turnFlag = true;
    private volatile boolean gameFlag = true;
    private volatile String playerName1 = "Name"; 
    private volatile String playerName2 = "PC"; 
    private int mode = 1;
    private boolean display =false;
    private String Winer = "No-One";
    public boolean recordState = false;
    private volatile String Type1 = "X";
    private volatile String Type2 = "O";
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
        disableBtn();
        
        Button temp =  (Button)event.getSource();
        //computer
        
        
        {
            //disableBtn();
            
            pw.println(f1+","+temp.getId());
            new Thread(){
                @Override
                public void run() {
                 int i = 1;
                 while(i<3)
                 {
                     
                 };
                }
                
            };
           
                    
                
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
    private void player1(Button temp ,String type)
    {
         temp.setDisable(true);
         btnsCpy.remove(temp);
         Player1Step.add(temp.getId().replace("b", type));
         temp.setTextFill(Color.GREEN);
         temp.setText(type);
         if(type.equals("X"))
           stautus.setText("Turn of "+playerName2 + " Play O");
         else
           stautus.setText("Turn of "+playerName2 + " Play X");
         stautus.setTextFill(Color.RED);
    }
    //test
    public synchronized void addOne()
    {
        turnFlag = !turnFlag;
    }
    public synchronized boolean get()
    {
        return turnFlag;
    }
    // player 2 play
    private void player2(Button temp,String type)
    {
         temp.setDisable(true);
          btnsCpy.remove(temp);
         temp.setTextFill(Color.RED);
         temp.setText(type);
         Player2Step.add(temp.getId().replace("b", type));
         if(type.equals("X"))
         {
           stautus.setText("Turn of "+playerName2 + " Play O");
           stautus.setTextFill(Color.RED);
         }
         else
         {
             stautus.setText("Turn of "+playerName2 + " Play X");
             stautus.setTextFill(Color.GREEN);
         }
         //stautus.setText("Turn of "+playerName1 + " Play X");
         
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
    public void prepareConnection()
    {
        
             Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    disableBtn();
                    stautus.setText("connection .... ");
                    labelName1.setText("......");
                    labelName2.setText("......");
                }
            });
            new Thread(){
                 @Override
                 public void run() {
                     try {
                         
                        s =  new Socket(InetAddress.getLocalHost(), 5000);


                        pw = new PrintStream(s.getOutputStream());


                        dis = new DataInputStream(s.getInputStream());
                         
                         pw.println("name,"+playerName1+"1");
                         String te;
                         
                             te = dis.readLine();
                             System.out.println(te);
                         
                         String[] Name = te.split(",");
                         Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(Name[2]);
                               f1 = Integer.parseInt(Name[2].substring(1));
                                System.out.println("falg"+f1);
                               if(f1 == 1)
                               {
                                   Type1="X";
                                   Type2="O";
                                   labelName1.setText(playerName1 + ": "+Type1);
                                   playerName2 = Name[1];
                                   System.out.println(playerName2);
                                   labelName2.setText(playerName2 +  ": "+Type2);
                                   
                                   enableBtn();
        
                               }
                               if(f1 == 2)
                               {
                                   Type1 = "O"; 
                                   Type2="X";
                                   labelName1.setText(playerName1 + " : O");
                                   playerName2 = Name[1];
                                   System.out.println(playerName1);
                                  labelName2.setText(playerName2 + " : X");
                                  addOne();
                                  
                                  
                               }
                               th = new listnerServer();
                               th.start();
                                stautus.setText("Game Start "+playerName1 + " will Play X");
                               
                            }
                        });
                         
                     } catch (IOException ex) {
                         Logger.getLogger(playerController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
            
            }.start();
             
             
            
             
             
             
        
    }
    class listnerServer extends Thread
    {

        @Override
        public void run() {
           while(gameFlag && !s.isClosed())
           {
               try {
                   String message = dis.readLine();
                   if(message == null || message.isEmpty())
                   {
                       System.out.println("empty");
                       break;
                   }
                   int flag = Integer.parseInt(message.split(",")[0]);
                   Button temp = btns.get(Integer.parseInt(message.split(",")[1].substring(1))-1);
                   if(flag == 1 )
                   {
                       enableBtn();
                       addOne();
                       System.out.println(message);
//                       Platform.runLater(new Runnable() {
//                           @Override
//                           public void run() {
//                               player1(temp, Type1);
//                               addOne();
//
//                             if(CheckWinner(Type1))
//                             {
//
//                                 gameFlag = !gameFlag;
//                                 Winer = playerName1;
//                                 stautus.setText("The Player "+playerName1 + " Winner");
//                                 if (Type1.equals("X")) {
//                                     stautus.setTextFill(Color.GREEN);
//                                 }
//                                 else
//                                 {
//                                     stautus.setTextFill(Color.RED);
//                                 }
//                                 disableBtn();
//                                 //again.setVisible(true);
//
//
//                             }
//                             if(checkEndGame() && gameFlag)
//                             {
//                                 gameFlag = !gameFlag;
//                                 stautus.setText("The Game End");
//                                 stautus.setTextFill(Color.AQUA);
//                                 again.setVisible(true);
//                                 disableBtn();
//
//                             }
//                              // disableBtn();
//                           }
//                          
//                       });
                   }
                   else if(f1==2  )
                   {
                       
                       {
                         
                         enableBtn();
                         System.out.println(message);
                         addOne();
//                       Platform.runLater(new Runnable() {
//                           @Override
//                           public void run() {
//                               player2(temp, Type2);
//                        
//                           if(CheckWinner(Type2))
//                           {
//                            gameFlag = !gameFlag;
//                            Winer = playerName2;
//                            stautus.setText("The Player "+playerName2 + " Winner");
//                            if (Type2.equals("X")) {
//                                     stautus.setTextFill(Color.GREEN);
//                                 }
//                                 else
//                                 {
//                                     stautus.setTextFill(Color.RED);
//                                 }
//                            disableBtn();
//                            //again.setVisible(true);
//                          }
//                          if(checkEndGame()&& gameFlag)
//                          {
//                            gameFlag = !gameFlag;
//                            stautus.setText("The Game End");
//                            stautus.setTextFill(Color.AQUA);
//                           // again.setVisible(true);
//                          }
//                          //disableBtn();
//                          
//                           }
//                       });   
                       }
                      
                   }
               } catch (IOException ex) {
                   Logger.getLogger(playerController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // handl the name 
        labelName1.setText(playerName1 + " : X");
        System.out.println(turnFlag);
        line.setVisible(false);
        labelName1.setTextFill(Color.GREEN);
        labelName2.setText(playerName2 + " : O");
        labelName2.setTextFill(Color.RED);
        btns.addAll(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9));
        btnsCpy = (ArrayList<Button>) btns.clone();
        stautus.setText("Game Start "+playerName1 + " will Play X");
        
    }    
    
}
