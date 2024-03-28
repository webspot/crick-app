package msj.xloop.secondapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mycontroller")
public class mycontroller {
    
    public mycontroller(){

    }

    @GetMapping("/hi")
    public String greating(){
        return "Welcom to Java";
    }

    @PostMapping("/sum")
    public int sum(int a){
        return (a + a);
    }


}
