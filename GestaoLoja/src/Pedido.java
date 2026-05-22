import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;
    private ArrayList<ProdutoPedido> itens;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ProdutoPedido> getItens() {
        return itens;
    }

    // Adicionar produto ao pedido
    public void adicionarProduto(Produto produto, int quantidade) {

        ProdutoPedido item = new ProdutoPedido(produto, quantidade);
        itens.add(item);

        produto.removerStock(quantidade);

        System.out.println("Produto adicionado ao pedido!");
    }

    // Calcular total
    public double calcularTotal() {

        double total = 0;

        for (ProdutoPedido item : itens) {
            total += item.calcularTotal();
        }

        return total;
    }

    // Mostrar fatura
    public void mostrarResumo() {

        System.out.println("\n|||||||||| FATURA ||||||||||");
        System.out.println("Cliente: " + cliente.getId());

        for (ProdutoPedido item : itens) {
            System.out.println(item);
        }

        System.out.println("TOTAL A PAGAR: " + calcularTotal() + " CVE");
        System.out.println("||||||||||||||||||||||||||||\n");
    }
}