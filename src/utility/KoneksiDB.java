package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * @author user
 */

public class KoneksiDB {
    public Connection conn;
    public Statement stat; 
    public KoneksiDB(){
        try {
            String url = "jdbc:mysql://localhost/db_leuwi";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            stat = conn.createStatement();
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
}