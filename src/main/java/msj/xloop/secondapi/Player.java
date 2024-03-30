package msj.xloop.secondapi;

//import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Integer id;
    private String name;
    private String country;
    private double avg;

    // @Setter(AccessLevel.NONE)
    private int wickets;
    private int mom;

}
