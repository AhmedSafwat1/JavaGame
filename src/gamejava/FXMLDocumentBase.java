package gamejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author safwat
 */
public class FXMLDocumentBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button b7;
    protected final Button b1;
    protected final Button b3;
    protected final Button b8;
    protected final Button b2;
    protected final Button b6;
    protected final Button b5;
    protected final Button b9;
    protected final Button b4;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Label labelName1;
    protected final Label labelName2;
    protected final Label stautus;
    protected final Button button;
    protected final Label label;
    protected final Line line;
     // array from button
    private final ArrayList<Button> btns = new ArrayList<>(9);
    private Vector<String> Player1Step =  new Vector<>();
    private Vector<String> Player2Step =  new Vector<>();
    //Button[] btnArray = new Button[9];
    // attribute use
    private boolean turnFlag = true;
    private boolean gameFlag = true;
    private String playerName1 = "Name"; 
    private String playerName2 = "PC"; 
    
    public FXMLDocumentBase() {

        imageView = new ImageView();
        b7 = new Button();
        b1 = new Button();
        b3 = new Button();
        b8 = new Button();
        b2 = new Button();
        b6 = new Button();
        b5 = new Button();
        b9 = new Button();
        b4 = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        labelName1 = new Label();
        labelName2 = new Label();
        stautus = new Label();
        button = new Button();
        label = new Label();
        line = new Line();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(531.0);
        setPrefWidth(662.0);
        setStyle("-fx-background-color: #b0b9be;");
        getStylesheets().add("/gamejava/css/main.css");

        imageView.setFitHeight(392.0);
        imageView.setFitWidth(670.0);
        imageView.setLayoutY(139.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("images/tic-tac-toe-1954446_1280.jpg").toExternalForm()));

        b7.setLayoutX(118.0);
        b7.setLayoutY(386.0);
        b7.setMnemonicParsing(false);
        b7.setOnAction(this::handleButtonAction);
        b7.setPrefHeight(112.0);
        b7.setPrefWidth(136.0);
        b7.setStyle("-fx-background-color: transparent;");
        b7.getStyleClass().add("playButton");
        b7.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b7.setFont(new Font(60.0));
        b7.setCursor(Cursor.HAND);

        b1.setLayoutX(118.0);
        b1.setLayoutY(154.0);
        b1.setMnemonicParsing(false);
        b1.setOnAction(this::handleButtonAction);
        b1.setPrefHeight(112.0);
        b1.setPrefWidth(136.0);
        b1.setStyle("-fx-background-color: transparent;");
        b1.getStyleClass().add("playButton");
        b1.setText("");
        b1.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b1.setFont(new Font(60.0));
        b1.setCursor(Cursor.HAND);

        b3.setLayoutX(399.0);
        b3.setLayoutY(154.0);
        b3.setMnemonicParsing(false);
        b3.setOnAction(this::handleButtonAction);
        b3.setPrefHeight(112.0);
        b3.setPrefWidth(136.0);
        b3.setStyle("-fx-background-color: transparent;");
        b3.getStyleClass().add("playButton");
        b3.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b3.setFont(new Font(60.0));
        b3.setCursor(Cursor.HAND);

        b8.setLayoutX(254.0);
        b8.setLayoutY(378.0);
        b8.setMnemonicParsing(false);
        b8.setOnAction(this::handleButtonAction);
        b8.setPrefHeight(112.0);
        b8.setPrefWidth(136.0);
        b8.setStyle("-fx-background-color: transparent;");
        b8.getStyleClass().add("playButton");
        b8.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b8.setFont(new Font(60.0));
        b8.setCursor(Cursor.HAND);

        b2.setLayoutX(263.0);
        b2.setLayoutY(154.0);
        b2.setMnemonicParsing(false);
        b2.setOnAction(this::handleButtonAction);
        b2.setPrefHeight(112.0);
        b2.setPrefWidth(136.0);
        b2.setStyle("-fx-background-color: transparent;");
        b2.getStyleClass().add("playButton");
        b2.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b2.setFont(new Font(60.0));
        b2.setCursor(Cursor.HAND);

        b6.setLayoutX(399.0);
        b6.setLayoutY(266.0);
        b6.setMnemonicParsing(false);
        b6.setOnAction(this::handleButtonAction);
        b6.setPrefHeight(112.0);
        b6.setPrefWidth(136.0);
        b6.setStyle("-fx-background-color: transparent;");
        b6.getStyleClass().add("playButton");
        b6.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b6.setFont(new Font(60.0));
        b6.setCursor(Cursor.HAND);

        b5.setLayoutX(263.0);
        b5.setLayoutY(266.0);
        b5.setMnemonicParsing(false);
        b5.setOnAction(this::handleButtonAction);
        b5.setPrefHeight(112.0);
        b5.setPrefWidth(136.0);
        b5.setStyle("-fx-background-color: transparent;");
        b5.getStyleClass().add("playButton");
        b5.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b5.setFont(new Font(60.0));
        b5.setCursor(Cursor.HAND);

        b9.setLayoutX(399.0);
        b9.setLayoutY(378.0);
        b9.setMnemonicParsing(false);
        b9.setOnAction(this::handleButtonAction);
        b9.setPrefHeight(112.0);
        b9.setPrefWidth(136.0);
        b9.setStyle("-fx-background-color: transparent;");
        b9.getStyleClass().add("playButton");
        b9.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b9.setFont(new Font(60.0));
        b9.setCursor(Cursor.HAND);

        b4.setLayoutX(118.0);
        b4.setLayoutY(266.0);
        b4.setMnemonicParsing(false);
        b4.setOnAction(this::handleButtonAction);
        b4.setPrefHeight(112.0);
        b4.setPrefWidth(136.0);
        b4.setStyle("-fx-background-color: transparent;");
        b4.getStyleClass().add("playButton");
        b4.setTextFill(javafx.scene.paint.Color.valueOf("#3e7540"));
        b4.setFont(new Font(60.0));
        b4.setCursor(Cursor.HAND);

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(59.0);
        imageView0.setLayoutX(548.0);
        imageView0.setLayoutY(34.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.getStyleClass().add(".ciricle");
        imageView0.setImage(new Image(getClass().getResource("images/unnamed.png").toExternalForm()));

        imageView1.setFitHeight(67.0);
        imageView1.setFitWidth(106.0);
        imageView1.setLayoutX(38.0);
        imageView1.setLayoutY(30.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.getStyleClass().add(".ciricle");
        imageView1.setImage(new Image(getClass().getResource("images/user.png").toExternalForm()));

        labelName1.setAlignment(javafx.geometry.Pos.CENTER);
        labelName1.setLayoutX(22.0);
        labelName1.setLayoutY(99.0);
        labelName1.setPrefHeight(34.0);
        labelName1.setPrefWidth(99.0);
        labelName1.setText("Name");
        labelName1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelName1.setFont(new Font(15.0));

        labelName2.setAlignment(javafx.geometry.Pos.CENTER);
        labelName2.setLayoutX(528.0);
        labelName2.setLayoutY(99.0);
        labelName2.setPrefHeight(34.0);
        labelName2.setPrefWidth(99.0);
        labelName2.setText("PC");
        labelName2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelName2.setFont(new Font(15.0));

        stautus.setAlignment(javafx.geometry.Pos.CENTER);
        stautus.setLayoutX(149.0);
        stautus.setLayoutY(50.0);
        stautus.setPrefHeight(49.0);
        stautus.setPrefWidth(364.0);
        stautus.setText("Turn  Of Name Play X");
        stautus.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        stautus.setTextFill(javafx.scene.paint.Color.valueOf("#8a2e2e"));
        stautus.setFont(new Font(23.0));

        button.setLayoutX(254.0);
        button.setLayoutY(8.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(26.0);
        button.setPrefWidth(146.0);
        button.setStyle("-fx-background-color: #dc4145;");
        button.setText("Exit");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#eeeae8"));
        button.setFont(new Font(19.0));
        button.setCursor(Cursor.HAND);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(105.0);
        label.setLayoutY(6.0);
        label.setPrefHeight(49.0);
        label.setPrefWidth(99.0);
        label.setStyle("-fx-color: black;");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#a1331d"));
        label.setFont(new Font(17.0));

        line.setEndX(-36.0);
        line.setEndY(345.0);
        line.setLayoutX(222.0);
        line.setLayoutY(106.0);
        line.setStartX(-36.0);
        line.setStartY(104.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#fcf6f6"));
        line.setStrokeWidth(15.0);

        getChildren().add(imageView);
        getChildren().add(b7);
        getChildren().add(b1);
        getChildren().add(b3);
        getChildren().add(b8);
        getChildren().add(b2);
        getChildren().add(b6);
        getChildren().add(b5);
        getChildren().add(b9);
        getChildren().add(b4);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(labelName1);
        getChildren().add(labelName2);
        getChildren().add(stautus);
        getChildren().add(button);
        getChildren().add(label);
        getChildren().add(line);
        // handl the name 
        labelName1.setText(playerName1 + " : X");
        line.setVisible(false);
        labelName1.setTextFill(Color.GREEN);
        labelName2.setText(playerName2 + " : Y");
        labelName2.setTextFill(Color.RED);
        btns.addAll(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9));
        stautus.setText("Turn of "+playerName1 + " Play X");


    }

    private void handleButtonAction(ActionEvent event) {
        System.out.println(""+ b1.getLayoutX());
//        line.setStartX( b1.get);
//        line.setStartY( b1.getLayoutY());
//        line.setEndX( b3.getLayoutX());
//        line.setEndY(b3.getLayoutY());
      //  System.out.println("(Button)event.getSource()"+(Button)event.getSource());
        Button temp =  (Button)event.getSource();
        if(turnFlag && gameFlag)
        {
            player1(temp);
            if(CheckWinner("X"))
            {
               
                gameFlag = !gameFlag;
                stautus.setText("The Player "+playerName1 + " Winner");
                stautus.setTextFill(Color.GREEN);
                
                
            }
            if(checkEndGame())
            {
                gameFlag = !gameFlag;
                stautus.setText("The Game End");
                stautus.setTextFill(Color.AQUA);
                
            }
            turnFlag = !turnFlag;
        }
         if(gameFlag && !turnFlag)
            {
                PcPlayer("X");
                if(CheckWinner("O"))
                {
                    gameFlag = !gameFlag;
                    stautus.setText("The Player "+playerName2 + " Winner");
                    stautus.setTextFill(Color.RED);
                }
                if(checkEndGame())
                {
                    gameFlag = !gameFlag;
                    stautus.setText("The Game End");
                    stautus.setTextFill(Color.AQUA);
                }
                turnFlag = !turnFlag;
            }
//        else
//        {
//            if(gameFlag)
//            {
//                player2(temp);
//                if(CheckWinner("O"))
//                {
//                    gameFlag = !gameFlag;
//                    stautus.setText("The Player "+playerName2 + " Winner");
//                    stautus.setTextFill(Color.BLUE);
//                }
//                if(checkEndGame())
//                {
//                    stautus.setText("The Game End");
//                    stautus.setTextFill(Color.AQUA);
//                }
//                turnFlag = !turnFlag;
//            }
//        }
        
    }
    //private using method
    // player 1 play
    private void player1(Button temp)
    {
         temp.setDisable(true);
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
    









}
