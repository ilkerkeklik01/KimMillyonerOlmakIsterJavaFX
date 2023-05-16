import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Main extends Application {
    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) {
        ApplicationPage applicationPage = new ApplicationPage(primaryStage);
        applicationPage.show();

        Scene scene = new Scene(new HomePage(primaryStage), 1200, 800);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Kim Milyoner Olmak İster");
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void playStartSound(){
        String path = "src/sounds/milyoner.wav";

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
