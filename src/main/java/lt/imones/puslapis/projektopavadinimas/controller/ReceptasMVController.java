package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.dto.IngredientaiDto;
import lt.imones.puslapis.projektopavadinimas.model.entity.Ingredientai;
import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.IngredientaiRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.VartotojoRepository;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReceptasMVController {

    @Autowired
    ReceptasRepository receptasRepository;
    @Autowired
    KategorijosRepository kategorijosRepository;

    @Autowired
    VartotojoRepository vartotojoRepository;

    @Autowired
    IngredientaiRepository ingredienturepository;

    @GetMapping("/test/sveikinimas")
    String testineFuncija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "testinis_puslapis.html";
    }


    @GetMapping("/rasti/recepta")
    String ieskomasReceptas(Model model, @RequestParam String pavadinimas) {
        Receptai receptas = receptasRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("id", receptas.getId());
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

    @PostMapping("/receptas/idejo_recepta")
    String pridetiRecepta(@ModelAttribute Receptai ivedamasReceptas) {
        receptasRepository.save(ivedamasReceptas);
        return "idetas_receptas.html";
    }

    @GetMapping("/recep/redaguoti_recepta/{id}")
    String redaguotiRecepta(Model model, @PathVariable long id) {
        Receptai receptas = receptasRepository.findById(id);
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijosRepository.findAll());
        return "recepto_redagavimas.html";
    }

    @PostMapping("/recep/istrinti_recepta/{id}")
    String istrintiRecepta(Model model, @PathVariable long id) {
        receptasRepository.delete(receptasRepository.findById(id));
        return "istrintas_receptas.html";
    }

    @GetMapping("/recep/funcija1/{id}")
    String idetiIngredientus(Model model, @PathVariable long id) {
        IngredientaiDto ivedamasObjiektas = new IngredientaiDto();
        model.addAttribute("ingredientai", ivedamasObjiektas);
        return "ingredientu_idejimas.html";
    }

    @PostMapping("/recep/funcija2")
    String ingreIdetas(Model model, @ModelAttribute IngredientaiDto ingredientai) {
        ingredientai.setIsskaldytiPavadinimai(ingredientai.getPavadinimai().split(","));
        for (String s : ingredientai.getIsskaldytiPavadinimai()) {
            System.out.println(ingredienturepository.findByPavadinimas(s));
            
        }
        System.out.println(ingredientai);
        return "puslapis2.html";
    }
}
