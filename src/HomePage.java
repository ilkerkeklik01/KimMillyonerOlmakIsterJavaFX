import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;


public class HomePage extends BorderPane implements AsNode{
    static int earnedStatic =0;
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
        int earned = 0;

        for (int i = 0;i<nextClicked;i++){
            earned+= questionObservableList.get(i).price;
        }
        earnedStatic=earned;
        //Burada bütün soruları dogru bilirse olacagı yapacam
        if(nextClicked==10){
            Window existingWindow = this.getScene().getWindow();
            ((Stage) existingWindow).close();
            Stage newWindow = new Congratulations(existingWindow,earned);

            newWindow.show();
            return;
        }


            this.setCenter(questionObservableList.get(nextClicked));

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
        list.add(new Question("$10000","1.\tTürkiye’de Erozyonla mücadele amacıyla kurulan \nvakfın kısa adı nedir?  " +
                "\n",new String[]{"TEMA","KIZILAY","TEV","LÖSEV"}
                ,"TEMA",this));
        list.add(new Question("$20000","2.\tİlk Türkçe sözlük hangisidir? \n",
                new String[]{"Kutadgu Bilig","Atabetü’l-Hakayık","Divân-ı Hikmet","Divân-ı Lügat’it-Türk"}
                ,"Divân-ı Lügat’it-Türk",this));
        list.add(new Question("$30000","3.\tDünyanın İlk Kadın Savaş Pilotu kimdir?\n",
                new String[]{"Raymonde de Laroche","Sabiha Gökçen","Bedriye Tahir","Berna Şen Şenol"}
                ,"Sabiha Gökçen",this));
        list.add(new Question("$40000","4.\tAmerika kıtasını 2’ye ayıran önemli su \ngeçidinin adı nedir?  \n",
                new String[]{"Panama Kanalı","Korint Kanalı","Dover Boğazı","Süveyş Kanalı"}
                ,"Panama Kanalı",this));
        list.add(new Question("$50000","5.\tNotada durak işareti hangisidir?  \n",
                new String[]{"Akor","Ölçü","Es","Solfej"}
                ,"Es",this));
        list.add(new Question("$60000","6.\tMimar Sinan'ın ustalık dönemi eseri sayılan \nEdirne'deki eserinin adı nedir?\n",
                new String[]{"Süleymaniye Camii","Selimiye Cami","Şehzade Camii","Mihrimah Sultan Cami"}
                ,"Selimiye Cami",this));
        list.add(new Question("$70000","7.\tAltın Palmiye Ödülleri hangi şehrimizde verilmektedir?\n",
                new String[]{"Adana","İstanbul","İzmir","Antalya"}
                ,"Antalya",this));
        list.add(new Question("$80000","8.\tEverest Tepesine tırmanan ilk Türk dağcı kimdir?\n",
                new String[]{"Nasuh MAHRUKİ","Uğur ULUOCAK","Serhan POÇAN","Gülnur TUMBAT"}
                ,"Nasuh MAHRUKİ",this));
        list.add(new Question("$90000","9.\tFIFA’ya göre futbolun doğduğu ülke neresidir?  \n",
                new String[]{"İngiltere","Brezilya","Çin","Arjantin"}
                ,"Çin",this));
        list.add(new Question("$100000","10.\tDivan edebiyatında padişahları ve devletin ileri gelenleri \növmek için yazılan methiye türündeki şiirlere ne ad verilir? \n"
                ,new String[]{"Gazel","Kaside","Mesnevi","Müstezad"}
                ,"Kaside",this));

        return list;
    }


    @Override
    public String whichNode() {
        return "HomePage BorderPane";
    }
}
