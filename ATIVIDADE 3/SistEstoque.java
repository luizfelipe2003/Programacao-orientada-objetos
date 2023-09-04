import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItemEstoque {
    private String nome;
    private int quantidade;

    public ItemEstoque(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Quantidade: " + quantidade;
    }
}

class GerenciadorEstoque {
    private List<ItemEstoque> estoque = new ArrayList<>();

    public void adicionarItem(String nome, int quantidade) {
        ItemEstoque item = new ItemEstoque(nome, quantidade);
        estoque.add(item);
    }

    public void removerItem(String nome) {
        estoque.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    public void listarItens() {
        for (ItemEstoque item : estoque) {
            System.out.println(item);
        }
    }

    public void atualizarQuantidade(String nome, int quantidade) {
        for (ItemEstoque item : estoque) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                item.setQuantidade(quantidade);
                return;
            }
        }
        System.out.println("Item não encontrado no estoque.");
    }
}

public class SistEstoque {
    public static void main(String[] args) {
        GerenciadorEstoque gerenciador = new GerenciadorEstoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Estoque");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Listar Itens");
            System.out.println("4. Atualizar Quantidade");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    gerenciador.adicionarItem(nome, quantidade);
                    break;
                case 2:
                    System.out.print("Digite o nome do item a ser removido: ");
                    nome = scanner.nextLine();
                    gerenciador.removerItem(nome);
                    break;
                case 3:
                    System.out.println("\nItens no Estoque:");
                    gerenciador.listarItens();
                    break;
                case 4:
                    System.out.print("Digite o nome do item a ser atualizado: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    quantidade = scanner.nextInt();
                    gerenciador.atualizarQuantidade(nome, quantidade);
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}