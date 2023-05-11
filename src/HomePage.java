import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HomePage extends BorderPane{


    public HomePage(Stage primaryStage){


        Image image = new Image("images/background.jpeg");
        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(),this.getHeight(),
                        false,false,true,true))));

        Question question = new Question("$10000","how to do you came from Adana to Istanbul I do not know \n" +
                "what i am talking about",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek");

        this.setCenter(question);

        //use getter and setter
        TopOfHome topOfHome = new TopOfHome("1st question","$0");
        this.setTop(topOfHome);

    }





}
