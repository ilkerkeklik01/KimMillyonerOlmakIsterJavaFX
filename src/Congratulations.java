import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Congratulations extends Stage implements AsNode{

    public Congratulations(Window existingWindow,int price){
        this.initOwner(existingWindow);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle("Congratulations");



        Scene scene = new Scene(createCongratulationsPane(price),1200,800);
        this.setScene(scene);


    }
    public StackPane createCongratulationsPane(int price) {

        playCongSound();

        StackPane pane = new StackPane();

        Image image = new Image("images/dollars.jpg");
        pane.setBackground(new Background(new BackgroundImage(image,null,null,null,null)));

        Rectangle rectangle = new Rectangle(1100, 600, Color.rgb(235, 246, 255,0.7));
        rectangle.setArcWidth(100);
        rectangle.setArcHeight(100);

        pane.getChildren().add(rectangle);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);

        Text message = new Text("Congratulations!");
        message.setStyle("-fx-font-weight: bold;");
        message.setFont(Font.font("Helvetica", 64));
        message.setFill(Color.BLACK);
        vBox.getChildren().add(message);

        Text earnedPrice = new Text("You have earned $" + price + " dollars");
        earnedPrice.setStyle("-fx-font-weight: bold;");
        earnedPrice.setFont(Font.font("Helvetica", 50));
        earnedPrice.setFill(Color.BLACK);
        vBox.getChildren().add(earnedPrice);

        Text instructions = new Text("Thank you for participating in our competition.");
        instructions.setFont(Font.font("Helvetica", 28));
        instructions.setStyle("-fx-font-weight: bold;");
        instructions.setFill(Color.BLACK);
        vBox.getChildren().add(instructions);

        pane.getChildren().add(vBox);
        vBox.setLayoutX(150);
        vBox.setLayoutY(100);

        return pane;
    }

    private void playCongSound(){
        String path = "src/sounds/bitis.wav";

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

    @Override
    public String whichNode() {
        return "Congratulations Stage";
    }
}
