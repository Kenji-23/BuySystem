public class Cliente {

    private String nome;
    private int id;

    // Construtor
    public Cliente(String nome, int id) {

        this.nome = nome;
        this.id = id;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}