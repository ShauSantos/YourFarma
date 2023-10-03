
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Produtos {

    static ArrayList<HashMap<String, Double>> listaDeProdutos = new ArrayList<>();
    public static HashMap<Integer, String> elementoAdicionado = new HashMap<>();
    public static HashMap<Integer, Double> precoAdicionado = new HashMap<>();
    public static int proximoIndice = 0; // Índice global para os produtos

    public static void adicionarProduto(String nome, double preco) {
        HashMap<String, Double> produto = new HashMap<>();
        produto.put(nome, preco);
        listaDeProdutos.add(produto);
        proximoIndice++; // Incrementa o índice global
    }

    public static void adicionarMedicamentos() {
        adicionarProduto("Paracetamol 20 comprimidos", 20.99);
        adicionarProduto("Prometazina 30 comprimidos", 29.99);
        adicionarProduto("Ibuprofeno gotas 20ml", 15.99);
        adicionarProduto("Antialérgico Koid D xarope 120ml", 35.59);
        adicionarProduto("Antiácido Sonrisal", 5.90);
        adicionarProduto("Xarope para tosse Vick", 33.00);
        adicionarProduto("Clorfeniramina", 5.99);
    }

    public static void adicionarDermocosmeticos() {

        HashMap<String, Double> dermocosmeticos = new HashMap<>();
        adicionarProduto("Shampoo", 5.99);
        adicionarProduto("Sabonete", 2.99);
        listaDeProdutos.add(dermocosmeticos);
    }

    public static void adicionarSaudeBeleza() {

        HashMap<String, Double> Saude = new HashMap<>();
        adicionarProduto("Shampoo", 5.99);
        adicionarProduto("Sabonete", 2.99);
        listaDeProdutos.add(Saude);
    }

    public static void selecionarProduto() {
        // Percorre os elementos e seus preços
        String mensagem = "Lista de Produtos\n";
        Carrinho carrinho = new Carrinho();
        // Percorre os elementos e seus preços
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            HashMap<String, Double> produtos = listaDeProdutos.get(i);
            for (Map.Entry<String, Double> entry : produtos.entrySet()) {
                String elemento = entry.getKey();
                Double preço = entry.getValue();
                carrinho.adicionarProduto(elemento, preço);

                mensagem += "[" + i + "] " + elemento + " - R$" + preço + "\n";
            }
        }

        while (true) {
            String elementoSelecionado = JOptionPane.showInputDialog(null, mensagem +
                    "Selecione a posição do seu produto, ou 'sair' para encerrar a compra");

            if (elementoSelecionado == null || elementoSelecionado.equalsIgnoreCase("sair")) {
                break; // Sai do loop se o usuário pressionar Cancelar ou digitar 'sair'
            }

            int elementoAdd = Integer.parseInt(elementoSelecionado);

            if (elementoAdd >= 0 && elementoAdd < listaDeProdutos.size()) {
                HashMap<String, Double> produtosSelecionados = listaDeProdutos.get(elementoAdd);
                for (Map.Entry<String, Double> entry : produtosSelecionados.entrySet()) {
                    String produtoSelecionado = entry.getKey();
                    Double precoProdutoSelecionado = entry.getValue();
                    elementoAdicionado.put(elementoAdd, produtoSelecionado);
                    precoAdicionado.put(elementoAdd, precoProdutoSelecionado);
                    JOptionPane.showMessageDialog(null,
                            "Produto selecionado: " + produtoSelecionado + " - R$" + precoProdutoSelecionado);
                }

                // Pergunta se o usuário deseja continuar comprando
                int continuarComprando = JOptionPane.showConfirmDialog(null,
                        "Deseja continuar comprando?",
                        "Continuar Comprando", JOptionPane.YES_NO_OPTION);

                if (continuarComprando == JOptionPane.NO_OPTION) {
                    break; // Sai do loop se o usuário não desejar continuar comprando
                }
                if (continuarComprando == JOptionPane.YES_OPTION) {
                    Farmacia.selecionarAba();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Posição inválida.");

            }

        }

    }
}
