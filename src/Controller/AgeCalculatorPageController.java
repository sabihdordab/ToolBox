package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AgeCalculatorPageController implements Initializable {

    @FXML
    private TextField dayFLD;

    @FXML
    private TextField monthFLD;

    @FXML
    private TextField yearFLD;

    @FXML
    private Label errorLBL;

    @FXML
    private Button calculateBTN;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        calculateBTN.setOnAction(e -> {
            if (Pattern.matches("^\\d{4}$",yearFLD.getText()) && Pattern.matches("^(0[1-9]|1[0-2])$",monthFLD.getText()) && Pattern.matches("(0[1-9]|[12]\\d|3[01])",dayFLD.getText()))
            {

                String strDate = yearFLD.getText() + "-" + monthFLD.getText() + "-" + dayFLD.getText();
                LocalDate brithDate = LocalDate.parse(strDate);
                LocalDate curDate = LocalDate.now();
                Period period = Period.between(brithDate, curDate);
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Your Age is " + period.getYears() + " Y " + period.getMonths() + " M " + period.getDays() + " D ");
                errorLBL.setStyle("-fx-border-color: green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input , correct example : 01/01/0001");
                errorLBL.setStyle("-fx-border-color: red");
            }
        });

    }
}

