package Controller;

//Algorithm from:
//https://virgool.io/@mohsen.coder/%D8%A7%D9%84%DA%AF%D9%88%D8%B1%DB%8C%D8%AA%D9%85-%D8%AA%D8%A8%D8%AF%DB%8C%D9%84-%D8%AA%D8%A7%D8%B1%DB%8C%D8%AE-%D9%85%DB%8C%D9%84%D8%A7%D8%AF%DB%8C-%D8%A8%D9%87-%D8%B4%D9%85%D8%B3%DB%8C-pvshllcywm2q


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class DateConverterController implements Initializable {

    static int convertedYear ;
    static int convertedMonth = 0 ;
    static int convertedDay = 0 ;

    @FXML
    private Button convertBTN;

    @FXML
    private TextField dayFLD;

    @FXML
    private TextField monthFLD;

    @FXML
    private TextField yearFLD;

    @FXML
    private Label errorLBL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        convertBTN.setOnAction(e ->{

           if (Pattern.matches("\\d{4}",yearFLD.getText()) && Pattern.matches("(0[1-9]|1[0-2])",monthFLD.getText()) && Pattern.matches("(0[1-9]|[12]\\d|3[01])",dayFLD.getText()))
               {
                   convertedYear = convertedYear();
                   convertMonthAndDAy();
                   errorLBL.setTextFill(Color.GREEN);
                   errorLBL.setText("Converted Date : year : " + convertedYear + " Month : " + convertedMonth + " Day : " + convertedDay );
                   errorLBL.setStyle("-fx-border-color: green");
               }
               else{
                   errorLBL.setTextFill(Color.RED);
                   errorLBL.setText("invalid input , correct example : 01/01/0001");
                   errorLBL.setStyle("-fx-border-color: red");
               }

        });
    }

    public int convertedYear()
    {
        if (Integer.parseInt(monthFLD.getText()) <= 2 || ( Integer.parseInt(monthFLD.getText()) == 3 && Integer.parseInt(dayFLD.getText()) <= 21 ) )
        {

            return Integer.parseInt(yearFLD.getText()) - 622 ;
        }
        else {
            return Integer.parseInt(yearFLD.getText()) - 621 ;
        }
    }

    public void convertMonthAndDAy()
    {
        int[] daysOfMonths = {31,28,31,30,31,30,31,31,30,31,30} ; //The year is not a leap year here

        int days = 0 ;

        for (int i = 0; i < Integer.parseInt(monthFLD.getText()) - 1 ; i++)
        {
            days += daysOfMonths[i] ;
        }

        days += Integer.parseInt(dayFLD.getText()) ;

        if (isLeapYear() && Integer.parseInt(monthFLD.getText()) > 2 )
        {
            days += 1 ;
        }

        if (days <= 79)
        {
            days += 10 ;

            if (isLeapYear())
            {
                days+= 1 ;
            }

            if (days % 30 == 0)
            {
               convertedDay =  30 ;
               convertedMonth = days / 30 + 9 ;
            }
            else if (days % 30 > 0 )
            {
                convertedDay = days % 30 ;
                convertedMonth = days / 30 + 10 ;
            }

        }else
        {
            days -= 79 ;

            if (days <= 186)
            {

                if (days % 31 == 0)
                {
                    convertedDay = 31 ;
                    convertedMonth = days / 31 ;
                }
                else if (days % 31 > 0)
                {
                    convertedMonth = days / 31 + 1 ;
                    convertedDay = days % 31 ;
                }
            }
            else {

                days -= 186 ;
                if (days % 30 == 0)
                {
                    convertedDay =  30 ;
                    convertedMonth = days / 30 + 6 ;
                }
                else if (days % 30 > 0 )
                {
                    convertedDay = days % 30 ;
                    convertedMonth = days / 30 + 7 ;
                }

            }
        }

    }

    public boolean isLeapYear()
    {
        if (Integer.parseInt(yearFLD.getText())  % 4 == 0  && Integer.parseInt(yearFLD.getText()) % 100 > 0)
        {
            return true;
        }
        else if (Integer.parseInt(yearFLD.getText())  % 400 == 0 )
        {
            return true;
        }
        return false ;
    }

}

