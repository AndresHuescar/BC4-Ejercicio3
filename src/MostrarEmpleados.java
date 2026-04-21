import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarEmpleados {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "RIBERA";
        String password = "ribera";

        String sql = "SELECT ID, NOMBRE, SALARIO FROM EMPLEADO";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                double salario = rs.getDouble("SALARIO");

                System.out.println("ID: " + id +
                        ", Nombre: " + nombre +
                        ", Salario: " + salario);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}