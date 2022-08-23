package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.VartotojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReceptasMVController {

    @Autowired
    ReceptasRepository receptasRepository;
    @Autowired
    KategorijosRepository kategorijosRepository;

    @Autowired
    VartotojoRepository vartotojoRepository;

    @GetMapping("/test/sveikinimas")
    String testineFuncija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "testinis_puslapis.html";
    }


    @GetMapping("/rasti/recepta")
    String ieskomasReceptas(Model model, @RequestParam String pavadinimas) {
        Receptai receptas = receptasRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", receptas.getPavadinimas());
        model.addAttribute("nurodymai", receptas.getNurodymai());
        model.addAttribute("kalorijosPer100g", receptas.getKalorijosPer100g());
        model.addAttribute("kaina", receptas.getKaina());
        model.addAttribute("receptoIngredientai", receptas.getReceptoIngredientai());
        model.addAttribute("receptoKurejas", receptas.getReceptoKurejas());
        model.addAttribute("receptoKategorija", receptas.getReceptoKategorija());
        return "parodyti_recepta.html";
    }

    @GetMapping("/recep/paieska")
    String testPaieska(Model model) {
        return "rasti_recepta.html";
    }

    @GetMapping("/recepto/recepto_idejimas")
    String receptoIdejimas(Model model) {
        Receptai receptas = new Receptai();
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijosRepository.findAll());
        model.addAttribute("vartotojei", vartotojoRepository.findAll());
        return "ideti_recepta.html";
    }

    @PostMapping("/recepto/idejo_recepta")
    String pridetiRecepta(@ModelAttribute Receptai ivedamasReceptas) {
        receptasRepository.save(ivedamasReceptas);
        return "idetas_receptas.html";
    }

    @GetMapping("/recep/redaguoti_recepta")
    String redaguotiRecepta(Model model) {
        Receptai receptas = receptasRepository.findById(1);
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijosRepository.findAll());
        return "recepto_redagavimas.html";
    }
}
