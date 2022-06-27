package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class StopWatchPageController implements Initializable {

    static int milliSecond = 0 ;
    static int second = 0 ;
    static int minutes = 0 ;
    static int  hour = 0 ;
    static boolean state = true ;

    @FXML
    private Label hourLBL;

    @FXML
    private Button ResetBTN;

    @FXML
    private Label secondLBL;

    @FXML
    private Label milliSecondLBL;

    @FXML
    private Button StartBTN;

    @FXML
    private Button StopBTN;

    @FXML
    private Label minutesLBL;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StartBTN.setOnAction(e -> {

            state = true ;
            Thread thread = new Thread( () -> {
                for (;;) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            milliSecondLBL.setText(String.valueOf(milliSecond));

                            milliSecond++;

                            secondLBL.setText(second + " : ");
                            minutesLBL.setText(minutes + " : ");
                            hourLBL.setText(hour + " : ");
                        }

                    });
                    if (state) {
                        try {

                            sleep(1);
                            if (milliSecond > 1000) {
                                milliSecond = 0;
                                second++;
                            }
                            if (second > 60) {
                                milliSecond = 0;
                                second = 0;
                                minutes++;
                            }
                            if (minutes > 60) {
                                milliSecond = 0;
                                second = 0;
                                minutes = 0;
                                hour++;
                            }

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }

                    } else {

                        break;
                    }

                }

            });thread.start();

        });


        StopBTN.setOnAction(e -> {
            state = false ;
        });

        ResetBTN.setOnAction(e -> {
            state = false;
            hour = 0 ;
            minutes = 0 ;
            second = 0 ;
            milliSecond = 0 ;

            milliSecondLBL.setText(" 00 ");
            secondLBL.setText( "00" + " : ");
            minutesLBL.setText( "00" + " : ");
            hourLBL.setText( "00" + " : ");
        });

    }
}
