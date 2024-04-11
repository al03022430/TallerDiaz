package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class basededatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Datos de conexión
        String hostname = "127.0.0.1";
        int port = 3306;
        String username = "root";
        String password = "jvvrma98";
        String databaseName = "TallerDiaz";

        // URL de conexión
        String url = "jdbc:mysql://" + hostname + ":" + port + "/" + databaseName + "?useSSL=false";

        // Objeto de conexión
        Connection connection = null;

        try {
            // Establecer conexión
            connection = DriverManager.getConnection(url, username, password);

            // Verificar si la conexión es exitosa
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos MySQL.");

                // Insertar un nuevo cliente en la tabla Clientes
                String sql = "INSERT INTO Clientes (Nombre, Apellido, Telefono) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "hola");
                statement.setString(2, "mundo");
                statement.setString(3, "123456789");

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Se ha agregado un nuevo cliente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL:");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		

	}

}
