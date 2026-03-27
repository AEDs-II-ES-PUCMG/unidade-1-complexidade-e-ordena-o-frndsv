import java.util.Arrays;
import java.util.Random;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }


    public static void main(String[] args) {

        int tam;
        Integer[] vetor;
        BubbleSort<Integer> bolha;
        Integer[] vetorOrdenadoBolha;
        InsertionSort<Integer> insert;
        Integer[] vetorOrdenadoInsert;
        SelectionSort<Integer> selecao;
        Integer[] vetorOrdenadoSelecao;
        
        for (int i = 0; i < tamanhosTesteMedio.length - 1; i++) {
            tam = tamanhosTesteMedio[i];
            vetor = gerarVetorObjetos(tam);
            bolha = new BubbleSort<>();
            vetorOrdenadoBolha = bolha.ordenar(vetor);

            System.out.println("\nVetor ordenado método Bolha (TAMANHO MEDIO):");
            System.out.println("Comparacoes: " + bolha.getComparacoes());
            System.out.println("Movimentacoes: " + bolha.getMovimentacoes());
            System.out.println("Tempo de ordenao (ms): " + bolha.getTempoOrdenacao());
        }
        

        /* 
        for (int i = 0; i < tamanhosTesteMedio.length; i++) {
            tam = tamanhosTesteMedio[i];
            vetor = gerarVetorObjetos(tam);
            insert = new InsertionSort<>();
            vetorOrdenadoInsert = insert.ordenar(vetor);

            System.out.println("\nVetor ordenado método Insert (TAMANHO MEDIO):");
            System.out.println("Comparacoes: " + insert.getComparacoes());
            System.out.println("Movimentacoes: " + insert.getMovimentacoes());
            System.out.println("Tempo de ordenao (ms): " + insert.getTempoOrdenacao());
        }
        */

        /* 
        for (int i = 0; i < tamanhosTesteMedio.length; i++) {
            tam = tamanhosTesteMedio[i];
            vetor = gerarVetorObjetos(tam);
            selecao = new SelectionSort<>();
            vetorOrdenadoSelecao = selecao.ordenar(vetor);

            System.out.println("\nVetor ordenado método Select (TAMANHO MEDIO):");
            System.out.println("Comparacoes: " + selecao.getComparacoes());
            System.out.println("Movimentacoes: " + selecao.getMovimentacoes());
            System.out.println("Tempo de ordenao (ms): " + selecao.getTempoOrdenacao());
        }
        */
       
    }
}
