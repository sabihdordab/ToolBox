package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BaseConveratorPageController implements Initializable {

    @FXML
    private Button convertBTN;

    @FXML
    private TextField convertToBaseFLD;

    @FXML
    private TextField NumberFLD;

    @FXML
    private TextField baseFLD;

    @FXML
    private Label ErrorLBL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        convertBTN.setOnAction(e -> {
            if ( ( NumberFLD.getText() != null ) && ( baseFLD.getText() != null ) && ( convertToBaseFLD.getText() != null ) )
            {
                if (Pattern.matches("^[0-9]+$",NumberFLD.getText()) && Pattern.matches("^([2-9]|10|11|12|13|14|15|16)$",baseFLD.getText()) && Pattern.matches("^([2-9]|10|11|12|13|14|15|16)$",convertToBaseFLD.getText()))
                {
                    String answer = Integer.toString(
                            Integer.parseInt(NumberFLD.getText(), Integer.parseInt(baseFLD.getText())), Integer.parseInt(convertToBaseFLD.getText()));
                    ErrorLBL.setTextFill(Color.GREEN);
                    ErrorLBL.setText("Answer : " + answer);
                    ErrorLBL.setStyle("-fx-border-color : green");


                }
                else {
                    ErrorLBL.setTextFill(Color.RED);
                    ErrorLBL.setText("Wrong input");

                }
            }
            else {
                ErrorLBL.setTextFill(Color.RED);
                ErrorLBL.setText("empty field");
            }
        });
    }
}
