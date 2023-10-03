import javax.swing.JOptionPane;

public class Pagamento{
    static int confirmação;
    static int formaDePagamento;
    static String chavePix= "890654789-33";
    
    static void pagamento(){
             formaDePagamento= Integer.parseInt(JOptionPane.showInputDialog(null, "Para finalizar a compra, selecione sua forma de pagamento:\n"+
             "1 - Pix\n"+
             "2 - Dinheiro (pagamento na entrega)\n"+
             "3 - Cartão de débito/ crédito (pagamento na entrega)\n")) ;   
       
         switch(formaDePagamento){
         case 1:
         //mostsrar chave 
         JOptionPane.showMessageDialog(null,"Seu pedido foi confirmado com sucesso!\n"
         +"Você selecionou o pagamento por Pix.\n"
         + "Para enviarmos, você possui 10 min de tempo restantes para confirmar o pagamento.\n"+
         "Caso contrário, seu pedido não será enviado.\n"+
         "Obs.: Recibos devem ser enviados pelo nosso número de ctt (41 99345-7965).\n"
                    +"Chave do tipo copia e cola (CPF): " + chavePix);
            
         break;

         case 2: 
         //Finalização de pagamento Dinheiro
         JOptionPane.showMessageDialog(null, "Já estamos preparando sua entrega.\n"
         +"Seleção: Pagamento por dinheiro.\n"+
         "Tempo de entrega: de 30 minutos a 1h.", "Seu pedido foi confirmado com sucesso!", formaDePagamento);
         break;

         case 3:
         //Finalização de pagamento Cartão
         JOptionPane.showMessageDialog(null, "Já estamos preparando sua entrega.\n"+
         "Seleção: Pagamento por cartão.\n"+
         "Tempo de entrega: de 30 minutos a 1h.", "Seu pedido foi confirmado com sucesso!", formaDePagamento);
         break;

         default:
         // Caso opção inválida
         JOptionPane.showMessageDialog(null, "Seleção de forma de pagamento inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
         break;
         }
    }
}