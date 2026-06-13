public class Medicamento {
    private String nombre;
    private String dosis;
    private String duracion;

    public Medicamento(String nombre, String dosis, String duracion) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "- " + nombre + " | Dosis: " + dosis + " | Duración: " + duracion;
    }
}
