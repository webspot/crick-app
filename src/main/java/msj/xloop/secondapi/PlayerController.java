package msj.xloop.secondapi;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    PlayerRepo repo;

    public PlayerController(){
        repo = new PlayerRepo();
    }

    @GetMapping("/all")
    public Collection<Player> getAllPlayers(){
        return repo.getAll();
    }

    @PostMapping("/add")
    public String createPlayer(@RequestBody Player p){
        repo.save(p);
        return "Played Saved..";
    }

    @GetMapping("/pid")
    @ResponseBody
    public Collection<Player> getPlayerData(@RequestParam int id) {
        
        return repo.getAll().stream().filter(a-> a.getId() == id).collect(Collectors.toList());
    }

    
}
