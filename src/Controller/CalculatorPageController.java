package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sun.applet.Main;
import java.lang.Math;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CalculatorPageController implements Initializable {

    @FXML
    private Button multiplicationBTN;

    @FXML
    private Button sqrtBTN;

    @FXML
    private TextField firstNumberFLD;

    @FXML
    private TextField secondNumberFLD;

    @FXML
    private Button subtractionBTN;

    @FXML
    private Button baseConveratorPageBTN;

    @FXML
    private Button powBTN;

    @FXML
    private Button AdditionBTN;

    @FXML
    private Button divisionBTN;

    @FXML
    private Button logBTN;

    @FXML
    private Button factorialBTN;

    @FXML
    private Button floorBTN;

    @FXML
    private Button absBTN;

    @FXML
    private Button ceilBTN;

    @FXML
    private Button radiansBTN;

    @FXML
    private Label errorLBL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        baseConveratorPageBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/BaseConveratorPage.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Stage baseConveratorStage  = new Stage();
            Scene scene = new Scene (loader.getRoot());
            scene.getStylesheets().add(getClass().getResource("/Style/MainPageStyle.css").toExternalForm());
            baseConveratorStage.setScene(scene);
            baseConveratorStage.show();
        });

        AdditionBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()) && Pattern.matches("[-+]?[0-9]*\\.?[0-9]",secondNumberFLD.getText()))
            {
                Float Answer = Float.parseFloat(firstNumberFLD.getText()) + Float.parseFloat(secondNumberFLD.getText());
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        subtractionBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()) && Pattern.matches("[-+]?[0-9]*\\.?[0-9]",secondNumberFLD.getText()))
            {
                Float Answer = Float.parseFloat(firstNumberFLD.getText()) - Float.parseFloat(secondNumberFLD.getText());
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        multiplicationBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()) && Pattern.matches("[-+]?[0-9]*\\.?[0-9]",secondNumberFLD.getText()))
            {
                Float Answer = Float.parseFloat(firstNumberFLD.getText()) * Float.parseFloat(secondNumberFLD.getText());
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        divisionBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()) && Pattern.matches("[-+]?[1-9]*\\.?[0-9]",secondNumberFLD.getText()))
            {
                Float Answer = Float.parseFloat(firstNumberFLD.getText()) / Float.parseFloat(secondNumberFLD.getText());
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        powBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()) && Pattern.matches("[-+]?[0-9]*\\.?[0-9]",secondNumberFLD.getText()))
            {
                double Answer = Math.pow(Float.parseFloat(firstNumberFLD.getText()),Float.parseFloat(secondNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        sqrtBTN.setOnAction(e ->{
            if (Pattern.matches("[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                double Answer = Math.sqrt(Float.parseFloat(firstNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        logBTN.setOnAction(e ->{
            if (Pattern.matches("[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                double Answer = Math.log(Float.parseFloat(firstNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        ceilBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                double Answer = Math.ceil(Float.parseFloat(firstNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        floorBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                double Answer = Math.floor(Float.parseFloat(firstNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        absBTN.setOnAction(e ->{
            if (Pattern.matches("[-+]?[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                double Answer = Math.abs(Float.parseFloat(firstNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        radiansBTN.setOnAction(e ->{
            if (Pattern.matches("[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                double Answer = Math.toRadians(Float.parseFloat(firstNumberFLD.getText()));
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText("Answer : " + Answer) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
                errorLBL.setStyle("-fx-border-color : red");
            }
        });

        factorialBTN.setOnAction(e ->{
            if (Pattern.matches("[0-9]*\\.?[0-9]",firstNumberFLD.getText()))
            {
                int number = Integer.parseInt(firstNumberFLD.getText());
                errorLBL.setTextFill(Color.GREEN);
                errorLBL.setText( "Answer : " + factorial(number) ) ;
                errorLBL.setStyle("-fx-border-color : green");
            }
            else
            {
                errorLBL.setTextFill(Color.RED);
                errorLBL.setText("invalid input");
            }
        });

    }

    public int factorial(int number)
    {
        int Factorial = 1 ;
        for(int i = 1 ; i <= number ;i++){

            Factorial = Factorial * i;
        }

        return Factorial ;
    }
}

