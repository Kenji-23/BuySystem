public class ProdutoPedido {

    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ProdutoPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    public double calcularTotal() {
        return precoUnitario * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Nome: ..... " + produto.getNome() + "\nQuantidade: ..... " + quantidade + "\nPreço: ..... " + precoUnitario + "\nTotal: ..... " + calcularTotal();
    }
}