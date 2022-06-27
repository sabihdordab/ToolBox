package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ShutDownPageController implements Initializable {

    @FXML
    private TextField MinutesFLD;

    @FXML
    private Label errorLBL;

    @FXML
    private Button ShutDownBTN;

    @FXML
    private TextField hourFLD;

    @FXML
    private TextField secondFLD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ShutDownBTN.setOnAction(e -> {

            if (Pattern.matches("^[0-9]+$",secondFLD.getText()) && Pattern.matches("^[0-9]+$",MinutesFLD.getText()) && Pattern.matches("^[0-9]+$",hourFLD.getText()))
            {
                Runtime runtime = Runtime.getRuntime();
                int seconds = Integer.parseInt(secondFLD.getText()) + Integer.parseInt(MinutesFLD.getText()) * 60 + Integer.parseInt(hourFLD.getText())  * 60 * 60 ;
                try {
                    runtime.exec("shutdown -s -t " +seconds);
                    errorLBL.setTextFill(Color.GREEN);
                    errorLBL.setText("Bye");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
            }
        });
    }
}
