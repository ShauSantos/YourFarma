import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class Carrinho {
    // Lista de produtos selecionados
    static List<HashMap<String, Double>> produtosSelecionados = new ArrayList<>();

    public static void selecionarProdutos() {
        String elementoSelecionado;

                HashMap<String, Double> produtoSelecionado = Produtos.listaDeProdutos.get(indice);
                for (HashMap.Entry<String, Double> entry : produtoSelecionado.entrySet()) {
                    String nomeProduto = entry.getKey();
                    Double precoProduto = entry.getValue();
                    adicionarProduto(nomeProduto, precoProduto); // Aqui, estamos passando o nome e o preço do produto.
                    JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho: " + nomeProduto);
                }
            }
        } while (elementoSelecionado != null && !elementoSelecionado.equals("0"));
    }

    // Método privado para adicionar um produto ao carrinho
    public static void adicionarProduto(String nome, double preco) {
        HashMap<String, Double> produto = new HashMap<>();
        produto.put(nome, preco);
        produtosSelecionados.add(produto);
    }

    public static void removerProduto(int indiceProduto) {
        produtosSelecionados.remove(indiceProduto);
    }

    public static void removerProduto(String nome) {
        int indice = -1; // valor inicial

        for (int i = 0; i < produtosSelecionados.size(); i++) {
            if (produtosSelecionados.get(i).keySet().get(0) == nome) {
                indice = 0;
            }
        }

        // se o valor foi encontrado, remover da lista
        if (indice != -1)
            removerProduto(indice);
    }

    // Exibir o carrinho
    public static void exibirCarrinho() {
        StringBuilder carrinhoTexto = new StringBuilder("Produtos no carrinho:\n");

        for (HashMap<String, Double> produto : produtosSelecionados) {
            for (HashMap.Entry<String, Double> entry : produto.entrySet()) {
                String nomeProduto = entry.getKey();
                Double precoProduto = entry.getValue();
                carrinhoTexto.append("Produto: ").append(nomeProduto).append(" - Preço: R$").append(precoProduto)
                        .append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, carrinhoTexto.toString());
    }
}
