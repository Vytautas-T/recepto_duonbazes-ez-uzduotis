package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReceptasMVController {

    @Autowired
    ReceptasRepository receptasRepository;

    @GetMapping("/test/sveikinimas")
    String testineFuncija(Model model, @RequestParam String vardas){
        model.addAttribute("vardas", vardas);
        return "testinis_puslapis.html";
    }

    @GetMapping("/testinis/tikras")
    String testReceptas(Model model) {
        Receptai receptai = receptasRepository.findById(2);
        model.addAttribute("pavadinimas", receptai.getPavadinimas());
        model.addAttribute("nurodymai", receptai.getNurodymai());
        model.addAttribute("kaina", receptai.getKaina());
        model.addAttribute("kalorijosPer100g", receptai.getKalorijosPer100g());
        model.addAttribute("receptoIngredientai", receptai.getReceptoIngredientai());
        model.addAttribute("receptoKategorija", receptai.getReceptoKategorija());
        model.addAttribute("receptoKurejas", receptai.getReceptoKurejas());
        return "parodyti_recepta.html";
    }

    @GetMapping("/rasti/recepta")
    String ieskomasReceptas(Model model,@RequestParam String pavadinimas) {
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


}
