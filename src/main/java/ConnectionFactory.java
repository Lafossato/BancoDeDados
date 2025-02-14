
import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Larissa Fossato
 */
public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "Lari41687";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "aula_10";
    
    public Connection obtemConexao() {
          try{
            Connection c = DriverManager.getConnection(
              "jdbc:mysql://" + host + ":" + porta + "/" + bd,
              usuario,
              senha
);
    return c;
}
    catch (Exception e){
    e.printStackTrace();
    return null;
}
    }
}
