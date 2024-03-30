package msj.xloop.secondapi;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    PlayerRepo repo;

    public PlayerController() {
        repo = new PlayerRepo();
    }

    @GetMapping("/all")
    public Collection<Player> getAllPlayers() {
        return repo.getAll();
    }

    /**
     * @param p
     * @return
     */
    @PostMapping("/add")
    public String createPlayer(@RequestBody Player p) {
        repo.save(p);
        return "Player Added..";
    }

    /**
     * @param: id
     * @return: player collection list
     * @desc:fetch player data by id
     * @ref: https://www.baeldung.com/spring-request-param
     */
    @GetMapping("/show/pid")
    public Collection<Player> getPlayerDataById(@RequestParam int id) {
        return repo.getAll().stream().filter(entry -> entry.getId() == id).collect(Collectors.toList());
    }

    /**
     * @param: id
     * @return: String
     * @desc: remove player data by id
     */
    @GetMapping("/remove/pid")
    public String RemovePlayerById(@RequestParam int id) {
        if (!repo.getAll().removeIf(entry -> entry.getId() == id)) {
            return "Player No. " + id + " does not exists";
        } else {
            return "Player No. " + id + " removed successfully";
        }
    }

    /**
     * @param p
     * @return
     */
    @GetMapping("/update")
    public String updatePlayer(@RequestBody Player p) {
        repo.save(p);
        return "Player No. " + p.getId() + " Updated..";
    }

}
