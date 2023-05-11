import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TopOfHome extends VBox {

        private String currentQuestion;
        private String earned;

        public TopOfHome(String currentQuestion, String earned) {

            this.setPadding(new Insets(10));
            this.setAlignment(Pos.CENTER);
            this.setSpacing(10);

            // Add the labels to the VBox
            Label titleLabel = new Label("Kim Milyoner Olmak İster");
            titleLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
            Label currentQuestionLabel = new Label("Current question: " + currentQuestion);
            currentQuestionLabel.setStyle("-fx-font-size: 18pt;");
            Label earnedLabel = new Label("Earned: " + earned);
            earnedLabel.setStyle("-fx-font-size: 18pt;");

            this.getChildren().addAll(titleLabel, currentQuestionLabel, earnedLabel);

        }

    public void setCurrentQuestion(String currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void setEarned(String earned) {
        this.earned = earned;
    }

}

