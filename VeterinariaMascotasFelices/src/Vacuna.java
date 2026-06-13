import java.time.LocalDate;

public class Vacuna {
    private String nombre;
    private LocalDate fecha;
    private String dosis;

    public Vacuna(String nombre, LocalDate fecha, String dosis) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return "- " + nombre + " | Fecha: " + fecha + " | Dosis: " + dosis;
    }
}
