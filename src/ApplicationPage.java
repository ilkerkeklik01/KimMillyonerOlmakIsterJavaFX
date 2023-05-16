import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationPage extends Info implements AsNode{

    public ApplicationPage(Stage primaryStage) {
        setTitle("Application Page");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label nameLabel = new Label("Name :");
        TextField nameTextField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);

        Label surnameLabel = new Label("Surname :");
        TextField surnameTextField = new TextField();
        gridPane.add(surnameLabel, 0, 1);
        gridPane.add(surnameTextField, 1, 1);

        // Country
        Label countryLabel = new Label("Country :");
        TextField countryTextField = new TextField();
        gridPane.add(countryLabel, 0, 2);
        gridPane.add(countryTextField, 1, 2);

        // City
        Label cityLabel = new Label("City :");
        TextField cityTextField = new TextField();
        gridPane.add(cityLabel, 0, 3);
        gridPane.add(cityTextField, 1, 3);

        // Date of Birth
        Label dobLabel = new Label("Date of Birth :");
        DatePicker dobPicker = new DatePicker();
        gridPane.add(dobLabel, 0, 4);
        gridPane.add(dobPicker, 1, 4);

        // Address
        Label addressLabel = new Label("Address :");
        TextField addressTextField = new TextField();
        gridPane.add(addressLabel, 0, 5);
        gridPane.add(addressTextField, 1, 5);

        // Aimed Earnings
        Label earningsLabel = new Label("How much do you aim to earn?");
        Slider earningsSlider = new Slider(0, 550000, 0);
        earningsSlider.setShowTickMarks(true);
        earningsSlider.setShowTickLabels(true);
        earningsSlider.setMajorTickUnit(100000);
        earningsSlider.setMinorTickCount(5);
        earningsSlider.setBlockIncrement(10000);
        gridPane.add(earningsLabel, 0, 6);
        gridPane.add(earningsSlider, 1, 6);

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            Main.playStartSound();
            this.name = nameTextField.getText();
            this.surname = surnameTextField.getText();
            this.country = countryTextField.getText();
            this.city = cityTextField.getText();
            this.dateofbirth = dobPicker.getValue();
            this.address = addressTextField.getText();
            this.earnings = earningsSlider.getValue();
            close();
            System.out.println(getInfos());
            primaryStage.show();
        });
        gridPane.add(submitButton, 1, 7);

        Scene scene = new Scene(gridPane, 600, 500);

        setScene(scene);

    }

    @Override
    public String whichNode() {
        return "Application Page Stage";
    }


    @Override
    public String getInfos() {
        String str = "Name: " + name+
        "\nSurname: " + surname+
        "\nCountry: " + country+
        "\nCity: " + city+
        "\nDate of Birth: " + dateofbirth+
        "\nAddress: " + address+
        "\nAimed Earnings: " + earnings;
        return str;
    }
}
