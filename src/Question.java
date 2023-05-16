import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Question extends BorderPane implements AsNode{

    private Label priceLabel;
    private Label questionLabel;
    private Label[] optionLabels;
    private Button yesButton;
    private Button noButton;
    private Label confirmLabel;
    private RadioButton[] optionButtons;
    private String correctOption;

    int price = 0;

    public Question(String price, String question, String[] options, String correctOption,HomePage homePage) {

        this.price=Integer.parseInt(price.substring(1));
        setPadding(new Insets(10));
        this.setStyle("-fx-background-color: lightblue;");
        setMinHeight(350);

        priceLabel = new Label(price);
        priceLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        BorderPane.setAlignment(priceLabel, Pos.TOP_RIGHT);
        setMargin(priceLabel, new Insets(5));
        setRight(priceLabel);

        // Create the question label and add it to the screen
        questionLabel = new Label(question);
        questionLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
        VBox questionArea = new VBox(10, questionLabel);
        setCenter(questionArea);

        // Create the radio buttons  and connect them with togglegorup
        ToggleGroup toggleGroup = new ToggleGroup();
        optionButtons = new RadioButton[options.length];
        for (int i = 0; i < options.length; i++) {
            optionButtons[i] = new RadioButton(options[i]);
            optionButtons[i].setStyle("-fx-font-size: 16pt;");
            optionButtons[i].setToggleGroup(toggleGroup);
        }

        HBox bottomBox = new HBox();

        VBox optionArea = new VBox(10, optionButtons);
        bottomBox.getChildren().add(optionArea);
        this.correctOption = correctOption;

        // Create the confirmation label and buttons
        confirmLabel = new Label("Are you sure?");
        HBox confirmArea = new HBox(10, confirmLabel, new Button("Yes"), new Button("No"));
        confirmArea.setAlignment(Pos.CENTER_RIGHT);
        setMargin(confirmArea, new Insets(5));
        bottomBox.getChildren().add(confirmArea);


        // confirm area is not visible initially
        confirmArea.setVisible(false);


        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                confirmArea.setVisible(true);
            } else {
                confirmArea.setVisible(false);
            }
        });

        // What will be happened after using buttons
        Button yesButton = (Button) confirmArea.getChildren().get(1);
        Button noButton = (Button) confirmArea.getChildren().get(2);
        Text text = new Text();
        text.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        bottomBox.getChildren().add(text);


        Button nextButton = new Button("Next");
        nextButton.setMinWidth(100);
        nextButton.setOnAction(e-> homePage.nextButtonClicked());

        yesButton.setOnAction(event -> {
            String selectedOption = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
            //Correct answer
            if (selectedOption.equals(correctOption)) {
                text.setText("Correct Answer!");
                bottomBox.getChildren().add(new Separator(Orientation.HORIZONTAL));
                bottomBox.getChildren().add(nextButton);
                System.out.println("Correct!");
                for(RadioButton each: optionButtons){
                    each.setDisable(true);
                }
            }
            //Incorrect answer
            else {
                text.setText("Incorrect Answer!");
                System.out.println("Incorrect!");

                for(RadioButton each: optionButtons){
                    each.setDisable(true);
                }

                Window existingWindow = this.getScene().getWindow();
                
                Stage newWindow = new Congratulations(existingWindow,HomePage.earnedStatic);

                newWindow.show();

            }
            toggleGroup.selectToggle(null);
            confirmArea.setVisible(false);
        });
        noButton.setOnAction(event -> {
            toggleGroup.selectToggle(null);
            confirmArea.setVisible(false);
        });

        setBottom(bottomBox);

    }

    @Override
    public String whichNode() {
        return "Question BorderPane";
    }
}
