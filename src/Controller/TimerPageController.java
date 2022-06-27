package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class TimerPageController implements Initializable {


    static int milliSecond = 0 ;
    static int second = 0 ;
    static int minutes = 0 ;
    static int  hour = 0 ;

    @FXML
    private TextField hourFLD;

    @FXML
    private Button startBTN;

    @FXML
    private TextField minutesFLD;

    @FXML
    private Label errorLBL;

    @FXML
    private TextField secondFLD;


    @FXML
    private Label milliSecondLBL;

    @FXML
    private TextField milliSecondFLD;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startBTN.setOnAction(e -> {

            if (Pattern.matches("^[0-9]+$",hourFLD.getText()) && Pattern.matches("^[0-9]+$",minutesFLD.getText()) && Pattern.matches("^[0-9]+$",secondFLD.getText()))
            {
                //milliSecond = Integer.parseInt(milliSecondFLD.getText());
                second = Integer.parseInt(secondFLD.getText());
                minutes = Integer.parseInt(minutesFLD.getText());
                hour = Integer.parseInt(hourFLD.getText());

                milliSecond = (hour * 60 * 60 + minutes  * 60 + second) * 1000 + Integer.parseInt(milliSecondFLD.getText());

                secondFLD.setVisible(false);
                minutesFLD.setVisible(false);
                hourFLD.setVisible(false);
                errorLBL.setVisible(false);
                startBTN.setVisible(false);
                milliSecondFLD.setVisible(false);


                Thread thread = new Thread( () -> {

                    for (int i = milliSecond ; i > 0 ; i--) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                milliSecond--;
//                                secondLBL.setText(second + " : ");
//                                minutesLBL.setText(minutes + " : ");
//                                hourLBL.setText(hour + " : ");
                                milliSecondLBL.setText(String.valueOf(milliSecond));

                            }

                        });
                        try {

                            sleep(1);

//                            if (milliSecond > 0) {
//                                milliSecond = 999 ;
//                                if (second > 0)
//                                    second--;
//                           }
//                            if (second > 0) {
//                                milliSecond = 999 ;
//                                second = 59;
//                                if (minutes > 0)
//                                    minutes--;
//                            }
//                            if (minutes > 0) {
//                                milliSecond = 999 ;
//                                second = 59;
//                                minutes = 59;
//                                if (hour > 0)
//                                    hour--;
//                            }

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }

                    }

                });thread.start();


            }
            else {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color: red");
                }
        });
    }

}

