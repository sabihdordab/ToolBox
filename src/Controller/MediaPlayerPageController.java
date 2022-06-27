package Controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaPlayerPageController implements Initializable {


    @FXML
    private Slider volSlider;

    @FXML
    private Button PauseBTN;

    @FXML
    private Button PlayBTN;

    @FXML
    private Button FastBTN;

    @FXML
    private Button ChooseVideoBTN;

    @FXML
    private Button SlowBTN;

    @FXML
    private Button back10BTN;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button skip10BTN;

    @FXML
    private Slider timeSlider;

    @FXML
    private Button StopBTN;

    private static MediaPlayer mediaPlayer ;

    private static Media media = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ChooseVideoBTN.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("MP4 files (*.mp4)", "*.mp4"));

            File mediaFile = fileChooser.showOpenDialog(new Stage());

            try {
                media = new Media(mediaFile.toURI().toURL().toString());
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

            mediaPlayer = new MediaPlayer(media);

            mediaView.setMediaPlayer(mediaPlayer);

            try {
                volSlider.setValue(mediaPlayer.getVolume() * 100);
                volSlider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        mediaPlayer.setVolume(volSlider.getValue()/100);
                    }
                });


                timeSlider.setOnMousePressed( event ->{
                    mediaPlayer.seek(Duration.seconds(timeSlider.getValue()));
                });

                timeSlider.setOnMouseDragged( event -> {
                    mediaPlayer.seek(Duration.seconds(timeSlider.getValue()));

                });

                mediaPlayer.setOnReady(new Runnable() {
                    @Override
                    public void run() {
                        Duration total = media.getDuration();
                        timeSlider.setMax(total.toSeconds());
                    }
                });
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }


            mediaPlayer.play();

        });

        PlayBTN.setOnAction(e -> {
            mediaPlayer.play();
            mediaPlayer.setRate(1);
        });

        PauseBTN.setOnAction(e -> {
            mediaPlayer.pause();
        });

        StopBTN.setOnAction(e -> {
            mediaPlayer.stop();
        });

        SlowBTN.setOnAction(e -> {
            mediaPlayer.setRate(0.5);
        });

        FastBTN.setOnAction(e -> {
            mediaPlayer.setRate(2);
        });

        skip10BTN.setOnAction( e -> {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
        });

        back10BTN.setOnAction(e -> {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(-10)));
        });

    }
}
