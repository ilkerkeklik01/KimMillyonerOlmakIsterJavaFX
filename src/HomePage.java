import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.crypto.spec.PSource;

public class HomePage extends BorderPane{

    ObservableList<Question> questionObservableList;
    TopOfHome topOfHome ;
    int nextClicked = 0;
    public HomePage(Stage primaryStage){

        Image image = new Image("images/background.jpeg");
        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(),this.getHeight(),
                        false,false,true,true))));
        topOfHome = new TopOfHome();
        questionObservableList = getQuestions();
        setPage();
        StackPane pane = new StackPane();
        Image image1 = new Image("images/Marmara_University_logo.png");
        ImageView imageView = new ImageView(image1);
        pane.getChildren().add(imageView);
        pane.setMinHeight(350);
        this.setBottom(pane);

    }

    private void setPage(){
        //Burada bütün soruları dogru bilirse olacagı yapacam
        if(nextClicked==10){

        }

        if(nextClicked<=9)
        this.setCenter(questionObservableList.get(nextClicked));

        int earned = 0;

        for (int i = 0;i<nextClicked;i++){
            earned+= questionObservableList.get(i).price;
        }
        topOfHome.setCurrentQuestion((nextClicked+1)+"");
        topOfHome.setEarned("$"+earned);
        this.setTop(topOfHome);
    }


    public void nextButtonClicked(){
        nextClicked++;
        System.out.println("Next Button Clicked");
        setPage();
    }

    private ObservableList<Question> getQuestions(){
        ObservableList<Question> list= FXCollections.observableArrayList();
        list.add(new Question("$10000","1. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$20000","2. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$30000","3. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$40000","4. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$50000","5. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$60000","6. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$70000","7. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$80000","8. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$90000","9. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));
        list.add(new Question("$100000","10. soru \n",new String[]{"birinci seçenek","ikinci seçenek","üçüncü seçenek","dördüncü seçenek"}
                ,"üçüncü seçenek",this));

        return list;
    }


}
