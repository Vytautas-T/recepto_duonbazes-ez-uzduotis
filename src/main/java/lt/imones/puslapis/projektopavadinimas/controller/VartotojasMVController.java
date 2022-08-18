package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.VartotojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VartotojasMVController {
    @Autowired
    ReceptasRepository receptasRepository;

    @Autowired
    VartotojoRepository vartotojasRepository;

    @PostMapping("/vartotojas/pamegti_recepta")
    String pamegtiRecepta(){

        return "pamegtas_receptas";
    }
}
