import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        if(o1.getTotalItens() == o2.getTotalItens()) {
            if(o1.getDataPedido() == o2.getDataPedido()) {
                return o1.hashCode();
            } else {
                return o1.getDataPedido().isBefore(o2.getDataPedido()) ;
            }
        }
        return o1.getTotalItens - o2.getTotalItens();
    }
}
