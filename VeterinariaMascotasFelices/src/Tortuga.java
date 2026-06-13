import java.time.LocalDate;

public class Tortuga extends Animal {
    private String tipoCaparazon;

    public Tortuga(String nombre, int edad, double peso, String propietario, LocalDate fechaIngreso, String tipoCaparazon) {
        super(nombre, edad, peso, propietario, fechaIngreso);
        this.tipoCaparazon = tipoCaparazon;
    }

    @Override
    public String getEspecie() {
        return "Tortuga";
    }

    @Override
    public String getInformacionExtra() {
        return "Tipo de caparazón: " + tipoCaparazon;
    }
}
