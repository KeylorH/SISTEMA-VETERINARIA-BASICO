import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SistemaVeterinaria {
    private ArrayList<Animal> animales;
    private Scanner scanner;

    public SistemaVeterinaria() {
        animales = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarAnimal();
                    break;
                case 2:
                    consultarExpediente();
                    break;
                case 3:
                    registrarVacuna();
                    break;
                case 4:
                    registrarMedicamento();
                    break;
                case 5:
                    mostrarTodos();
                    break;
                case 6:
                    buscarAnimal();
                    break;
                case 7:
                    ordenarAnimales();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }

    private void mostrarMenu() {
        System.out.println("\n===== CLÍNICA VETERINARIA MASCOTAS FELICES =====");
        System.out.println("1. Registrar animal");
        System.out.println("2. Consultar expediente");
        System.out.println("3. Registrar vacuna");
        System.out.println("4. Registrar medicamento");
        System.out.println("5. Mostrar todos los animales");
        System.out.println("6. Buscar animal");
        System.out.println("7. Ordenar animales");
        System.out.println("8. Salir");
    }

    private void registrarAnimal() {
        System.out.println("\nTipos de animales:");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("3. Loro");
        System.out.println("4. Hámster");
        System.out.println("5. Tortuga");

        int tipo = leerEntero("Seleccione el tipo de animal: ");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        double peso = leerDouble("Peso en kg: ");
        String propietario = leerTexto("Propietario: ");
        LocalDate fechaIngreso = leerFecha("Fecha de ingreso (AAAA-MM-DD): ");

        Animal animal = null;

        switch (tipo) {
            case 1:
                String raza = leerTexto("Raza: ");
                animal = new Perro(nombre, edad, peso, propietario, fechaIngreso, raza);
                break;
            case 2:
                boolean esterilizado = leerSiNo("¿Está esterilizado? (s/n): ");
                animal = new Gato(nombre, edad, peso, propietario, fechaIngreso, esterilizado);
                break;
            case 3:
                String colorPlumas = leerTexto("Color de plumas: ");
                animal = new Loro(nombre, edad, peso, propietario, fechaIngreso, colorPlumas);
                break;
            case 4:
                String tipoJaula = leerTexto("Tipo de jaula: ");
                animal = new Hamster(nombre, edad, peso, propietario, fechaIngreso, tipoJaula);
                break;
            case 5:
                String tipoCaparazon = leerTexto("Tipo de caparazón: ");
                animal = new Tortuga(nombre, edad, peso, propietario, fechaIngreso, tipoCaparazon);
                break;
            default:
                System.out.println("Tipo inválido. No se registró el animal.");
                return;
        }

        String observacion = leerTexto("Observación médica inicial: ");
        String consulta = leerTexto("Consulta realizada: ");
        animal.agregarObservacion(observacion);
        animal.agregarConsulta(consulta);

        animales.add(animal);
        System.out.println("Animal registrado correctamente.");
    }

    private void consultarExpediente() {
        Animal animal = seleccionarAnimalPorNombre();
        if (animal != null) {
            animal.mostrarExpedienteCompleto();
        }
    }

    private void registrarVacuna() {
        Animal animal = seleccionarAnimalPorNombre();
        if (animal != null) {
            String nombre = leerTexto("Nombre de la vacuna: ");
            LocalDate fecha = leerFecha("Fecha de aplicación (AAAA-MM-DD): ");
            String dosis = leerTexto("Dosis: ");
            animal.agregarVacuna(new Vacuna(nombre, fecha, dosis));
            System.out.println("Vacuna registrada correctamente.");
        }
    }

    private void registrarMedicamento() {
        Animal animal = seleccionarAnimalPorNombre();
        if (animal != null) {
            String nombre = leerTexto("Nombre del medicamento: ");
            String dosis = leerTexto("Dosis: ");
            String duracion = leerTexto("Duración del tratamiento: ");
            animal.agregarMedicamento(new Medicamento(nombre, dosis, duracion));
            System.out.println("Medicamento registrado correctamente.");
        }
    }

    private void mostrarTodos() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE ANIMALES =====");
        for (Animal animal : animales) {
            animal.mostrarResumen();
        }
    }

    private void buscarAnimal() {
        String criterio = leerTexto("Ingrese nombre, especie o propietario a buscar: ").toLowerCase();
        boolean encontrado = false;

        for (Animal animal : animales) {
            if (animal.getNombre().toLowerCase().contains(criterio)
                    || animal.getEspecie().toLowerCase().contains(criterio)
                    || animal.getPropietario().toLowerCase().contains(criterio)) {
                animal.mostrarResumen();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron animales con ese criterio.");
        }
    }

    private void ordenarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales para ordenar.");
            return;
        }

        System.out.println("\nOpciones de ordenamiento:");
        System.out.println("1. Ordenar por nombre usando Comparable");
        System.out.println("2. Ordenar por edad usando Comparator");
        System.out.println("3. Ordenar por peso usando Comparator");

        int opcion = leerEntero("Seleccione una opción: ");

        switch (opcion) {
            case 1:
                Collections.sort(animales);
                System.out.println("Animales ordenados por nombre.");
                break;
            case 2:
                animales.sort(new ComparadorPorEdad());
                System.out.println("Animales ordenados por edad.");
                break;
            case 3:
                animales.sort(new ComparadorPorPeso());
                System.out.println("Animales ordenados por peso.");
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        mostrarTodos();
    }

    private Animal seleccionarAnimalPorNombre() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return null;
        }

        String nombre = leerTexto("Ingrese el nombre del animal: ");

        for (Animal animal : animales) {
            if (animal.getNombre().equalsIgnoreCase(nombre)) {
                return animal;
            }
        }

        System.out.println("No se encontró un animal con ese nombre.");
        return null;
    }

    private String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero < 0) {
                    System.out.println("Debe ingresar un número positivo.");
                } else {
                    return numero;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double numero = Double.parseDouble(scanner.nextLine());
                if (numero <= 0) {
                    System.out.println("Debe ingresar un número mayor a 0.");
                } else {
                    return numero;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    private LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Formato incorrecto. Use AAAA-MM-DD. Ejemplo: 2026-06-12");
            }
        }
    }

    private boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) {
                return true;
            } else if (respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Ingrese solamente s o n.");
            }
        }
    }
}
