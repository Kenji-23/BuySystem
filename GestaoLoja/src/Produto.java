public class Produto {

    private String nome;
    private double preco;
    private int stock;

    // Construtor
    public Produto(String nome, double preco, int stock) {

        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getStock() {
        return stock;
    }

    // Remover stock
    public void removerStock(int quantidade) {
        stock -= quantidade;
    }

    // Adicionar no Stock
    public void addStock(int quantidade){
        stock += quantidade;
    }
}