package lt.imones.puslapis.projektopavadinimas.model.dto;

public class IngredientaiDto {
    String pavadinimai;

    String[] isskaldytiPavadinimai;
    public IngredientaiDto() {
    }

    public IngredientaiDto(String pavadinimai) {
        this.pavadinimai = pavadinimai;
    }

    public String getPavadinimai() {
        return pavadinimai;
    }

    public void setPavadinimai(String pavadinimai) {
        this.pavadinimai = pavadinimai;
    }

    public String[] getIsskaldytiPavadinimai() {
        return isskaldytiPavadinimai;
    }

    public void setIsskaldytiPavadinimai(String[] isskaldytiPavadinimai) {
        this.isskaldytiPavadinimai = isskaldytiPavadinimai;
    }

    @Override
    public String toString() {
        return "IngredientaiDto{" +
                "pavadinimai='" + pavadinimai + '\'' +
                '}';
    }
}
