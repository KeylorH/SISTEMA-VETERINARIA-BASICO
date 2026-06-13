import java.time.LocalDate;

public class Loro extends Animal {
    private String colorPlumas;

    public Loro(String nombre, int edad, double peso, String propietario, LocalDate fechaIngreso, String colorPlumas) {
        super(nombre, edad, peso, propietario, fechaIngreso);
        this.colorPlumas = colorPlumas;
    }

    @Override
    public String getEspecie() {
        return "Loro";
    }

    @Override
    public String getInformacionExtra() {
        return "Color de plumas: " + colorPlumas;
    }
}
