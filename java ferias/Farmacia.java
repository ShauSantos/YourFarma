
import javax.swing.JOptionPane;

public class Farmacia {

  public static void main(String[] args) {

    entrada();

    selecionarAba();
    Carrinho.adicionarProduto();
    Carrinho.exibirCarrinho();
  }

  static void entrada() {
    JOptionPane.showMessageDialog(
        null,
        "BEM VINDO(A) a YourFarma,\n onde você encontra todas as variedades e melhores marcas de produtos.\n" +
            "somos abertos 24h, com serviço delivery em toda a Curitiba e região\n - Para prosseguir selecione OK.");
  }

  // seleção das abas
  static void selecionarAba() {
    String[] array = { "Medicamentos", "Dermocosmeticos", "Beleza", "Sair" };
    String resposta = (String) JOptionPane.showInputDialog(
        null,
        "Produtos ",
        "o que você precisa?",
        JOptionPane.PLAIN_MESSAGE,
        null,
        array,
        array[0]);

    switch (resposta) {

      case "Medicamentos":
        Produtos.adicionarMedicamentos();
        Produtos.selecionarProduto();
        break;

      case "Dermocosmeticos":
        Produtos.adicionarDermocosmeticos();
        Produtos.selecionarProduto();
        break;

      case "Beleza":
        Produtos.adicionarSaudeBeleza();
        Produtos.selecionarProduto();
        break;
    }

  }

}
