import java.time.LocalDate;

public class Hamster extends Animal {
    private String tipoJaula;

    public Hamster(String nombre, int edad, double peso, String propietario, LocalDate fechaIngreso, String tipoJaula) {
        super(nombre, edad, peso, propietario, fechaIngreso);
        this.tipoJaula = tipoJaula;
    }

    @Override
    public String getEspecie() {
        return "Hámster";
    }

    @Override
    public String getInformacionExtra() {
        return "Tipo de jaula: " + tipoJaula;
    }
}
