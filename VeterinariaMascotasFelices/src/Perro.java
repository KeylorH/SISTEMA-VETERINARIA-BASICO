import java.time.LocalDate;

public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, double peso, String propietario, LocalDate fechaIngreso, String raza) {
        super(nombre, edad, peso, propietario, fechaIngreso);
        this.raza = raza;
    }

    @Override
    public String getEspecie() {
        return "Perro";
    }

    @Override
    public String getInformacionExtra() {
        return "Raza: " + raza;
    }
}
