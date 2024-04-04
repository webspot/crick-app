package msj.xloop.secondapi;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/player")
public class PlayerController {

    PlayerRepo repo;

    public PlayerController() {
        repo = new PlayerRepo();
    }

    @GetMapping("/greeting")
    public String greeting() {
        // RestTemplate restTemplate = new RestTemplate();
        return "Welcome to CrickInfo";
    }

    /**
     * @param: void
     * @return: Collection p
     * @endpoint:http://localhost:8080/player/all
     */
    @GetMapping("/all")
    public Collection<Player> getAllPlayers() {
        return repo.getAll();
    }

    /**
     * @param: p
     * @return: String
     * @endpoint:http://localhost:8080/player/add
     */
    @PostMapping("/add")
    public String createPlayer(@RequestBody Player p) {
        repo.save(p);
        return "Player Added..";
    }

    /**
     * @param: id
     * @return: player collection list
     * @desc: fetch player data by id
     * @ref: https://www.baeldung.com/spring-request-param
     *       https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
     * @endpoint:http://localhost:8080/player/show/2
     */
    @GetMapping("/show/{pid}")
    public Collection<Player> getPlayerById(@PathVariable int pid) {
        return repo.getAll().stream().filter(entry -> entry.getId() == pid).collect(Collectors.toList());
    }

    /**
     * @param: id
     * @return: String
     * @desc: remove player data by id
     * @endpoint: http://localhost:8080/player/delete/2
     */
    @DeleteMapping("/delete/{pid}")
    public String deletePlayer(@PathVariable int pid) {
        if (!repo.getAll().removeIf(entry -> entry.getId() == pid)) {
            return "Player No. " + pid + " does not exists";
        } else {
            return "Player No. " + pid + " removed successfully";
        }
    }

    /**
     * @param p
     * @return
     */
    /*
     * @PostMapping("/update-p")
     * public String updatePlayer(@RequestBody Player p) {
     * repo.save(p);
     * return "Player No. " + p.getId() + " Updated..";
     * }
     */

    @PutMapping("/update/{pid}")
    public String updateTutorial(@PathVariable("pid") long pid, @RequestBody Player p) {

        List<Player> playerData = repo.getAll().stream().filter(entry -> entry.getId() == pid)
                .collect(Collectors.toList());

        if (playerData.isEmpty()) {
            return "Player No. " + pid + " does not exists";

        } else {
            Player _player = playerData.get(0);

            if (p.getName() != null) {
                _player.setName(p.getName());
            }

            if (p.getCountry() != null) {
                _player.setCountry(p.getCountry());
            }

            if (p.getWickets() != null) {
                _player.setWickets(p.getWickets());
            }

            if (p.getAvg() != null) {
                _player.setAvg(p.getAvg());
            }

            if (p.getMom() != null) {
                _player.setMom(p.getMom());
            }

            return "Player No. " + pid + " update successfully";
        }
    }
}
