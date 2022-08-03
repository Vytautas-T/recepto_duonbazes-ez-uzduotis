package lt.imones.puslapis.projektopavadinimas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceptasController {

    @GetMapping("/test/greeting")
    String testinisEndpoint() {
        return "šis puslapis veikia";
    }
}
