package lt.imones.puslapis.projektopavadinimas.model.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredientai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String pavadinimas;
    private  int kalorijosPer100g;
    private double kaina;

    @ManyToMany
    @JoinTable(
            name = "receptai_ingredientai",
            joinColumns = @JoinColumn(name = "ingredientas_id"),
            inverseJoinColumns = @JoinColumn(name = "receptas_id")
    )
    private Set<Ingredientai> receptoIngredientai;

    public Ingredientai() {
    }

    public Ingredientai(int id, String pavadinimas, int kalorijosPer100g, double kaina, Set<Ingredientai> receptoIngredientai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kalorijosPer100g = kalorijosPer100g;
        this.kaina = kaina;
        this.receptoIngredientai = receptoIngredientai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getKalorijosPer100g() {
        return kalorijosPer100g;
    }

    public void setKalorijosPer100g(int kalorijosPer100g) {
        this.kalorijosPer100g = kalorijosPer100g;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public Set<Ingredientai> getReceptoIngredientai() {
        return receptoIngredientai;
    }

    public void setReceptoIngredientai(Set<Ingredientai> receptoIngredientai) {
        this.receptoIngredientai = receptoIngredientai;
    }

    @Override
    public String toString() {
        return "Ingredientai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kalorijosPer100g=" + kalorijosPer100g +
                ", kaina=" + kaina +
                ", receptoIngredientai=" + receptoIngredientai +
                '}';
    }
}
