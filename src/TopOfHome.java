import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TopOfHome extends VBox implements AsNode{

        private String currentQuestion;
        private String earned;

        private Label earnedLabel= new Label();

        private Label currentQuestionLabel=new Label();
        public TopOfHome() {

            this.setPadding(new Insets(10));
            this.setAlignment(Pos.CENTER);
            this.setSpacing(10);

            // Add the labels to the VBox
            Label titleLabel = new Label("Kim Milyoner Olmak İster");
            titleLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
            //Label currentQuestionLabel = new Label("Current question: " + currentQuestion);
            currentQuestionLabel.setStyle("-fx-font-size: 18pt;");
            //Label earnedLabel = new Label("Earned: " + earned);
            earnedLabel.setStyle("-fx-font-size: 18pt;");

            this.getChildren().addAll(titleLabel, currentQuestionLabel, earnedLabel);

        }

    public void setCurrentQuestion(String currentQuestion) {

            this.currentQuestion = currentQuestion;
            setCurrentQuestionLabel();
        }

    public void setEarned(String earned) {
        this.earned = earned;
        setEarnedLabel();
    }

    private void setCurrentQuestionLabel(){
            currentQuestionLabel.setText("Current question: " + currentQuestion);
    }
    private void setEarnedLabel(){
        earnedLabel.setText("Earned: " + earned);
    }

    @Override
    public String whichNode() {
        return "TopOfHome VBox";
    }
}

