import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal implements Comparable<Animal> {
    private String nombre;
    private int edad;
    private double peso;
    private String propietario;
    private LocalDate fechaIngreso;
    private ArrayList<Vacuna> vacunas;
    private ArrayList<Medicamento> medicamentos;
    private ArrayList<String> observaciones;
    private ArrayList<String> consultas;

    public Animal(String nombre, int edad, double peso, String propietario, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.propietario = propietario;
        this.fechaIngreso = fechaIngreso;
        this.vacunas = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
        this.observaciones = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getPropietario() {
        return propietario;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void agregarVacuna(Vacuna vacuna) {
        vacunas.add(vacuna);
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void agregarObservacion(String observacion) {
        observaciones.add(observacion);
    }

    public void agregarConsulta(String consulta) {
        consultas.add(consulta);
    }

    public abstract String getEspecie();

    public abstract String getInformacionExtra();

    @Override
    public int compareTo(Animal otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    public void mostrarResumen() {
        System.out.println("Especie: " + getEspecie());
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Propietario: " + propietario);
        System.out.println("Fecha de ingreso: " + fechaIngreso);
        System.out.println("------------------------------");
    }

    public void mostrarExpedienteCompleto() {
        System.out.println("\n===== EXPEDIENTE COMPLETO =====");
        System.out.println("Especie: " + getEspecie());
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Propietario: " + propietario);
        System.out.println("Fecha de ingreso: " + fechaIngreso);
        System.out.println(getInformacionExtra());

        System.out.println("\nVacunas:");
        if (vacunas.isEmpty()) {
            System.out.println("No tiene vacunas registradas.");
        } else {
            for (Vacuna vacuna : vacunas) {
                System.out.println(vacuna);
            }
        }

        System.out.println("\nMedicamentos:");
        if (medicamentos.isEmpty()) {
            System.out.println("No tiene medicamentos registrados.");
        } else {
            for (Medicamento medicamento : medicamentos) {
                System.out.println(medicamento);
            }
        }

        System.out.println("\nObservaciones:");
        if (observaciones.isEmpty()) {
            System.out.println("No tiene observaciones registradas.");
        } else {
            for (String observacion : observaciones) {
                System.out.println("- " + observacion);
            }
        }

        System.out.println("\nConsultas:");
        if (consultas.isEmpty()) {
            System.out.println("No tiene consultas registradas.");
        } else {
            for (String consulta : consultas) {
                System.out.println("- " + consulta);
            }
        }
        System.out.println("===============================\n");
    }
}
