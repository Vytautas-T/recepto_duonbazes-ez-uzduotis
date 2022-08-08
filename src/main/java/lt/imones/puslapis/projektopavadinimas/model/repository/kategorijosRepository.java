package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface kategorijosRepository extends JpaRepository<Kategorija, Integer> {
}
