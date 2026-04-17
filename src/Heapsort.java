import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Heapsort<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
    private long movimentacoes;
    private LocalDateTime inicio;
    private LocalDateTime termino;

    public Heapsort() {
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

        // vetor auxiliar (índice começa em 1)
        T[] tmp = Arrays.copyOf(dados, dados.length + 1);

        for (int i = 0; i < dados.length; i++) {
            tmp[i + 1] = dados[i];
        }

        // construção do heap
        for (int i = (tmp.length - 1) / 2; i >= 1; i--) {
            restaura(tmp, i, tmp.length - 1, comparador);
        }

        // ordenação
        int tamHeap = tmp.length - 1;
        troca(tmp, 1, tamHeap--);

        while (tamHeap > 1) {
            restaura(tmp, 1, tamHeap, comparador);
            troca(tmp, 1, tamHeap--);
        }

        // voltar pro array original
        for (int i = 0; i < dados.length; i++) {
            dados[i] = tmp[i + 1];
        }

        termino = LocalDateTime.now();

        return dados;
    }

    private void restaura(T[] array, int i, int tamHeap, Comparator<T> comp) {

        int maior = i;
        int filho = getMaiorFilho(array, i, tamHeap, comp);

        if (comp.compare(array[i], array[filho]) < 0)
            maior = filho;

        if (maior != i) {
            troca(array, i, maior);

            if (maior <= tamHeap / 2)
                restaura(array, maior, tamHeap, comp);
        }
    }

    private int getMaiorFilho(T[] array, int i, int tamHeap, Comparator<T> comp) {

        if (2 * i == tamHeap || comp.compare(array[2 * i], array[2 * i + 1]) > 0) {
            return 2 * i;
        } else {
            return 2 * i + 1;
        }
    }

    private void troca(T[] array, int i, int j) {
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