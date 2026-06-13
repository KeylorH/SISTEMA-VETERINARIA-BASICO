import java.util.Comparator;

public class ComparadorPorPeso implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return Double.compare(a1.getPeso(), a2.getPeso());
    }
}
