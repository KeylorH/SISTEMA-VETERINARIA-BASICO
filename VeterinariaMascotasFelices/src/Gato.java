import java.time.LocalDate;

public class Gato extends Animal {
    private boolean esterilizado;

    public Gato(String nombre, int edad, double peso, String propietario, LocalDate fechaIngreso, boolean esterilizado) {
        super(nombre, edad, peso, propietario, fechaIngreso);
        this.esterilizado = esterilizado;
    }

    @Override
    public String getEspecie() {
        return "Gato";
    }

    @Override
    public String getInformacionExtra() {
        return "Esterilizado: " + (esterilizado ? "Sí" : "No");
    }
}
