import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {

  public static void entrada() {

    String escolha;
    escolha = JOptionPane.showInputDialog(null,
        "finalizar a compra, precisaremos de alguns de seus dados.\n Você já possui cadastro na farmácia?\n digite S para sim, N para não");

    switch (escolha) {
      case "S":
        login();
        break;
      case "s":
        login();
        break;
      case "N":
        Cadastro.dadosCliente();
        break;
      case "n":
        Cadastro.dadosCliente();
        break;

    }
  }

  public static void login() {
    JPanel panel = new JPanel(new GridLayout(2, 2));
    JTextField cpf = new JTextField();
    panel.add(new JLabel("CPF:"));
    panel.add(cpf);

    while (true) {

      // Exibe o JOptionPane com o painel personalizado
      int result = JOptionPane.showConfirmDialog(null, panel, "Informe seu CPF para realizar o login",
          JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
        String cpfUsuario = cpf.getText();

        if (cpfUsuario.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!");

        } else {
          break;
        }
      }

    }
  }
}
