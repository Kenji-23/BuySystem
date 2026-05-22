import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner ler = new Scanner(System.in);

        // LISTAS
        ArrayList<Produto> produtos = new ArrayList<>();

        ArrayList<Pedido> historicoPedidos = new ArrayList<>();

        ArrayList<Cliente> clientes = new ArrayList<>();

        int opcao;

        do {

            //Espera para iniciar
            System.out.println("\n Carregando...");

            Thread.sleep(1000); // espera 1000 milissegundos


            System.out.println("\n=-=-=- :-: BUYSYSTEM :-: -=-=-=\n");
            System.out.println("     1 - Adicionar Produto");
            System.out.println("     2 - Adicionar Cliente");
            System.out.println("     3 - Fazer Pedido");
            System.out.println("     4 - Listar Produtos");
            System.out.println("     5 - Listar Clientes");
            System.out.println("     6 - Historico de Pedidos");
            System.out.println("     7 - Atualizar Stock");
            System.out.println("     0 - Sair");
            System.out.println("\n=-=-=- :-: <<<>|<>>> :-: -=-=-=\n");

            System.out.print("Escolha: ");

            opcao = ler.nextInt();

            ler.nextLine();

            switch (opcao) {


                // CRIAR PRODUTO
                case 1:
                    System.out.println("Quantidade de Produtos que pretende inserir: ");
                    int numProduto = ler.nextInt();

                    for (int i = 0; i != numProduto; i++) {
                        ler.nextLine();// limpar memoria do buffer

                        System.out.print("Nome do produto: ");
                        String nomeProduto = ler.nextLine();

                        System.out.print("Preço: ");
                        double preco = ler.nextDouble();

                        System.out.print("Stock: ");
                        int stock = ler.nextInt();

                        Produto produto = new Produto(nomeProduto, preco, stock);

                        produtos.add(produto);

                        System.out.println("Produto criado!\n");

                    }

                    break;


                // CRIAR CLIENTE
                case 2:

                    System.out.println("Quantidade de Clientes que pretende inserir: ");

                    int quantidadeCliente = ler.nextInt();

                    for (int i = 0; i != quantidadeCliente; i++){
                        ler.nextLine();// limpar o enter

                        System.out.print("Nome do cliente: ");
                        String nomeCliente = ler.nextLine();

                        System.out.print("Id do cliente: ");
                        int idCliente = ler.nextInt();

                        Cliente cliente = new Cliente(nomeCliente, idCliente);

                        clientes.add(cliente);

                        System.out.println("Cliente criado!");
                    }

                    break;


                // FAZER PEDIDO
                case 3:

                    // Procurar cliente
                    System.out.print("Nome do cliente: ");

                    String nomePedido = ler.nextLine();

                    Cliente clienteEncontrado = null;

                    for (Cliente c : clientes) {

                        if (c.getNome().equalsIgnoreCase(nomePedido)) {

                            clienteEncontrado = c;

                            break;
                        }
                    }

                    // Verificar cliente
                    if (clienteEncontrado == null) {

                        System.out.println("Cliente não encontrado!");

                        break;
                    }

                    // Criar pedido
                    Pedido pedido = new Pedido(clienteEncontrado);

                    // Procurar produto
                    System.out.print("Nome do produto: ");

                    String nomeProdutoPedido = ler.nextLine();

                    Produto produtoEncontrado = null;

                    for (Produto p : produtos) {

                        if (p.getNome().equalsIgnoreCase(nomeProdutoPedido)) {

                            produtoEncontrado = p;

                            break;
                        }
                    }

                    // Verificar produto
                    if (produtoEncontrado == null) {

                        System.out.println("Produto não encontrado!");

                        break;
                    }

                    // Quantidade
                    System.out.print("Quantidade: ");

                    int quantidade = ler.nextInt();

                    // Verificar stock
                    if (quantidade > produtoEncontrado.getStock()) {

                        System.out.println("Stock insuficiente!\n");
                        break;
                    }

                    // Adicionar pedido
                    pedido.adicionarProduto(produtoEncontrado, quantidade);

                    // Mostrar resumo
                    pedido.mostrarResumo();
                    historicoPedidos.add(pedido);

                    break;


                // LISTAR PRODUTOS
                case 4:

                    System.out.println("\n|||||||||| PRODUTOS ||||||||||");

                    for (Produto p : produtos) {

                        System.out.println("Nome: " + p.getNome() + "\nPreco: " + p.getPreco() + " CVE \nStock: " + p.getStock());
                    }

                    break;


                // LISTAR CLIENTES
                case 5:

                    System.out.println("\n|||||||||| CLIENTES ||||||||||");

                    for (Cliente c : clientes) {

                        System.out.println("Nome: " + c.getNome() + "\nId: " + c.getId() );
                    }

                    break;

                case 6:

                    System.out.println("\n|||||||||| HISTÓRICO DE PEDIDOS ||||||||||");

                    if (historicoPedidos.isEmpty()) {
                        System.out.println("Nenhum pedido foi realizado ainda.");
                    } else {

                        for (Pedido p : historicoPedidos) {

                            System.out.println("\n===== PEDIDO =====");
                            System.out.println("Cliente: " + p.getCliente().getNome());

                            for (ProdutoPedido item : p.getItens()) {
                                System.out.println(item);
                            }

                            System.out.println("TOTAL: " + p.calcularTotal());
                            System.out.println("----------------------");
                        }
                    }

                    break;

                case 7:

                    System.out.print("Nome do produto: ");

                    String nomeStock = ler.nextLine();

                    Produto produtoStock = null;

                    // Procurar produto
                    for (Produto p : produtos) {

                        if (p.getNome().equalsIgnoreCase(nomeStock)) {

                            produtoStock = p;

                            break;
                        }
                    }

                    // Verifica se encontrou
                    if (produtoStock != null) {

                        System.out.print("Quantidade para adicionar: ");

                        int quantidadeStock = ler.nextInt();

                        produtoStock.addStock(quantidadeStock);

                        System.out.println("Stock atualizado!\n");

                        System.out.println("Produto: " + produtoStock.getNome() + " | Novo stock: " + produtoStock.getStock());

                    } else {

                        System.out.println("Produto não encontrado!");
                    }

                    break;

                // SAIR
                case 0:
                    //Espera para Sair
                    System.out.println("\nSaindo ...");

                    Thread.sleep(3000); // espera 3000 milissegundos = 3 segundos

                    System.out.println("Programa Terminado!");


                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        ler.close();
    }
}