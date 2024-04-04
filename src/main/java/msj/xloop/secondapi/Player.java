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
    private Double avg;

    // @Setter(AccessLevel.NONE)
    private Integer wickets;
    private Integer mom;

}
