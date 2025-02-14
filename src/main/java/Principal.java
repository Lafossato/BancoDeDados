
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author Larissa Fossato
 */
public class Principal {
    public static void main(String[] args) throws SQLException {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
        int opcao;
        do{
        opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch (opcao){
            case 1:{
                String nome = JOptionPane.showInputDialog("Nome?");
                String fone = JOptionPane.showInputDialog("Fone?");
                String email = JOptionPane.showInputDialog("Email?");
                Pessoa p = new Pessoa ();
                p.setNome(nome);
                p.setFone(fone);
                p.setEmail(email);
                p.inserir();
              break;
            }
            case 2:{
               String nome = JOptionPane.showInputDialog("Nome?");
               String fone = JOptionPane.showInputDialog("Fone?");
               String email = JOptionPane.showInputDialog("Email?");
               int codigo =
               Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
               Pessoa p = new Pessoa ();
               p.setNome(nome);
               p.setFone(fone);
               p.setEmail(email);
               p.setCodigo(codigo);
               p.atualizar();
              break;
        }
            case 3:{
                int codigo =
                Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
                Pessoa p = new Pessoa ();
                p.setCodigo(codigo);
                p.apagar();
              break;
            }
            case 4:{
                Pessoa p = new Pessoa();
                p.listar();
              break;
        }
            case 0:
                JOptionPane.showMessageDialog(null, "Obrogsda, volte sempre!");
              break;
            default:
    JOptionPane.showMessageDialog(null, "Opção inválida");
          }
       }while (opcao != 0);
    }
}
