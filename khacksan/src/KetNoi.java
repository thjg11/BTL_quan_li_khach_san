import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
    Connection con=null;
    public KetNoi()
    {
        try{

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks", "root", "thuong1");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
