import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        Scene scene = new Scene(new HomePage(primaryStage), 1200, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kim Milyoner Olmak İster");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
