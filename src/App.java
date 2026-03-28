import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    static Scanner teclado;


    static void cabecalho(){
        System.out.println("ATIVIDADE DE ORDENAÇÕES AEDS II");
        System.out.println("===========================");
    }

    static void pausa(){
        System.out.println("Digite enter para continuar...");
        teclado.nextLine();
    }

    static int menu(){
        cabecalho();
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Inserction Sort");
        System.out.println("3 - Selection Sort");
        System.out.println("4 - Merge Sort ");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        return Integer.parseInt(teclado.nextLine());
    }

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

        teclado = new Scanner(System.in, Charset.forName("ISO-8859-2"));
        int opcao = -1;
        do{
            opcao = menu();
            switch (opcao) {
                case 1 -> ordenarBubble();
                case 2 -> ordenarInsert();
                case 3 -> ordenarSelection();
                case 4 -> ordenarMergeSort();
            }
            pausa();
        }while(opcao !=0);       


        teclado.close();        
    }

    private static void ordenarBubble() {
        int tam;
        Integer[] vetor;
        BubbleSort<Integer> bolha;
        Integer[] vetorOrdenadoBolha;

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
    }

    

    private static void ordenarInsert() {
        int tam;
        Integer[] vetor;
        InsertionSort<Integer> insert;
        Integer[] vetorOrdenadoInsert;

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
    }

    private static void ordenarSelection() {
        int tam;
        Integer[] vetor;
        SelectionSort<Integer> selecao;
        Integer[] vetorOrdenadoSelecao;
    }

    private static void ordenarMergeSort() {
        int tam;
        Integer[] vetor;
        SelectionSort<Integer> selecao;
        Integer[] vetorOrdenadoSelecao;

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
    }




}
