import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Quicksort<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
    private long movimentacoes;
    private LocalDateTime inicio;
    private LocalDateTime termino;

    public Quicksort() {
        comparacoes = 0;
        movimentacoes = 0;
    }

    @Override
    public T[] ordenar(T[] dados) {
        return ordenar(dados, T::compareTo);
    }

    @Override
    public T[] ordenar(T[] dados, Comparator<T> comparador) {

        inicio = LocalDateTime.now();

        quicksort(dados, 0, dados.length - 1, comparador);

        termino = LocalDateTime.now();

        return dados;
    }

    private void quicksort(T[] array, int esq, int dir, Comparator<T> comp) {

        if (esq < dir) {
            int part = particao(array, esq, dir, comp);
            quicksort(array, esq, part - 1, comp);
            quicksort(array, part + 1, dir, comp);
        }
    }

    private int particao(T[] array, int inicio, int fim, Comparator<T> comp) {

        T pivot = array[fim];
        int part = inicio - 1;

        for (int i = inicio; i < fim; i++) {
            comparacoes++;
            if (comp.compare(array[i], pivot) < 0) {
                part++;
                troca(array, part, i);
            }
        }

        part++;
        troca(array, part, fim);

        return part;
    }

    private void troca(T[] array, int i, int j) {
        movimentacoes++;
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public double getTempoOrdenacao() {
        return Duration.between(inicio, termino).toMillis();
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }
}