import javafx.stage.Stage;

import java.time.LocalDate;

public abstract class Info extends Stage {
    String name ;
    String surname;
    String country;
    String city ;
    LocalDate dateofbirth ;
    String address;
    double earnings;

    public abstract String getInfos();
}




