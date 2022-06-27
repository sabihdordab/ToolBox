package Controller;

import com.sun.javaws.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {


    @FXML
    private Button StopewatchBTN;

    @FXML
    private Button ClockBTN;

    @FXML
    private Button TimerBTN;

    @FXML
    private Button DateConverterBTN;

    @FXML
    private Button NotepadBTN;

    @FXML
    private Button ZipUnzipBTN;

    @FXML
    private Button PhonebookBTN;

    @FXML
    private Button CalculatorBTN;

    @FXML
    private Button MediaPlayerBTN;

    @FXML
    private Button SystemShutDowningBTN;

    @FXML
    private Button AgeCalculatorBTN;

    @FXML
    private Button ExitBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ExitBTN.setOnAction(e -> {
            Platform.exit();
        });

        PhonebookBTN.setOnAction(e ->{


            PhoneBookController phoneBookController = new PhoneBookController();
            Stage mainPageStage = new Stage() ;
            mainPageStage.setScene(new Scene(phoneBookController.getPhoneBookPage()));
            mainPageStage.setHeight(700);
            mainPageStage.setWidth(1000);
            mainPageStage.show();
        });

        SystemShutDowningBTN.setOnAction(e -> {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/ShutDownPage.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Scene scene = new Scene (loader.getRoot());
            scene.getStylesheets().add(getClass().getResource("/Style/MainPageStyle.css").toExternalForm());
            Stage shutDownPageStage = new Stage();
            shutDownPageStage.setScene(scene);
            shutDownPageStage.show();
            
        });

        CalculatorBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/calculatorPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage calculatorStage = new Stage();
            Scene scene = new Scene (loader.getRoot());
            scene.getStylesheets().add(getClass().getResource("/Style/MainPageStyle.css").toExternalForm());
            calculatorStage.setScene(scene);
            calculatorStage.show();
        });

        TimerBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/TimerPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage  timerStage= new Stage();
            timerStage.setScene(new Scene(loader.getRoot()));
            timerStage.show();
        });

        DateConverterBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/DateConverterPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage  dateConverterPage= new Stage();
            dateConverterPage.setScene(new Scene(loader.getRoot()));
            dateConverterPage.show();
        });

        NotepadBTN.setOnAction( e ->{

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/NotePadPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage  notePadPageStage= new Stage();
            Scene scene = new Scene (loader.getRoot());
            scene.getStylesheets().add(getClass().getResource("/Style/MainPageStyle.css").toExternalForm());
            notePadPageStage.setScene(scene);
            notePadPageStage.show();

        });

        ZipUnzipBTN.setOnAction(e -> {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/ZipUnzipPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage  zipUnzipStage= new Stage();
            Scene scene = new Scene (loader.getRoot());
            scene.getStylesheets().add(getClass().getResource("/Style/MainPageStyle.css").toExternalForm());
            zipUnzipStage.setScene(scene);
            zipUnzipStage.show();

        });

        MediaPlayerBTN.setOnAction(e -> {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/MediaPlayerPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage  mediaPlayerPageStage = new Stage();
            mediaPlayerPageStage.setScene(new Scene(loader.getRoot()));
            mediaPlayerPageStage.show();

        });

        StopewatchBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/StopWatchPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage  stopWatchPageStage = new Stage();
            stopWatchPageStage.setScene(new Scene(loader.getRoot()));
            stopWatchPageStage.show();

        });

        AgeCalculatorBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/AgeCalculatorPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage ageCalculatorPageStage = new Stage();
            ageCalculatorPageStage.setScene(new Scene(loader.getRoot()));
            ageCalculatorPageStage.show();
        });

        ClockBTN.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/ClockPage.fxml"));
            try {
                loader.load();
            }
            catch ( IOException ex)
            {
                ex.printStackTrace();
            }
            Stage clockPageStage = new Stage();
            clockPageStage.setScene(new Scene(loader.getRoot()));
            clockPageStage.show();
        });
    }
}
