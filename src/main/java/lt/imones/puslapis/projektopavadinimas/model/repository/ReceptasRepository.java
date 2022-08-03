package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptasRepository  extends JpaRepository<Receptai, Integer> {

    Receptai FindByPavadinimas(String pavadinimas);

    List<Receptai> FindByKainaBetween(double pradineKaina, double galutineKaina);
}
