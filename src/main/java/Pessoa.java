
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JOptionPane;



/**
 *
 * @author Larissa Fossato
 */
public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //getters/setters

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getFone() {
        return fone;
    }

    public String getEmail() {
        return email;
    }
    public void inserir() {
        //definnir o comando sql que vai ser utilizado
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        //abrir conexão com o banco
        ConnectionFactory factory = new ConnectionFactory ();
        
        try (Connection c = factory.obtemConexao()) {
           //pré-compilar o comando sql
           PreparedStatement ps = c.prepareStatement(sql);
        }
        catch (Exception e){
         e.printStackTrace();
        }
    }
    public void atualizar() throws SQLException{
        //
        String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
        ConnectionFactory fabrica = new ConnectionFactory();
            //try whith resources
        try (Connection c = fabrica.obtemConexao()){
            //3.preparar o comando com PreparsedStatement
            PreparedStatement ps = c.prepareStatement(sql);
            //4.especificar os valores a serem utilizados nos lugares do placeholders
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            //5: Executa o comando
            ps.execute();
        }
        catch (Exception e){
          e.printStackTrace();
         }
      }
    public void apagar(){
        String sql = "DELETE FROM tb_pessoa WHERE codigo = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
        }
        catch (Exception e){
          e.printStackTrace();
          }
       }
    public void listar(Object aux) throws SQLException{
        //1.definir o comando sql
        String sql = "SELECT * FROM tb_pessoa";
        //2.abrir conexão
        ConnectionFactory factory = new ConnectionFactory();
        //3.Pré compila o comando
        try (Connection c = factory.obtemConexao()){
            PreparedStatement ps = c.prepareStatement(sql);
        //4: Executa o comando e guarda
        ResultSet rs = ps.executeQuery();
        //5: itera (navegador) pelo conjunto de resultado
        while (rs.next()){
            int codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            String fone = rs.getString("fone");
            String email = rs.getString("email");
             String.format("Código: %d\nNome: %d\nNome: %d\nFone: %s, E-mail: %s",
                    codigo,nome,fone,email);
            JOptionPane.showMessageDialog (null, aux);
        }
         }
        catch (Exception e){
         e.printStackTrace();
          }
       }

    void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
     

    


