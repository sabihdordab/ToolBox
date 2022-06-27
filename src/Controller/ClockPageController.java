package Controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class ClockPageController implements Initializable {

    static Date date ;
    static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss") ;

    @FXML
    private Label timeLBL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Thread thread = new Thread( () -> {
            for (;;) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        date = new Date() ;
                        timeLBL.setText(format.format(date));
                    }

                });

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });thread.start();

    }
}

