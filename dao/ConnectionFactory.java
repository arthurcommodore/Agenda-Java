package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String url;
    private String usuario;
    private String senha;


    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "postgres", "123");
        }catch(Exception e) {
            throw new RuntimeException("Erro de conexão", e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if(con != null)
                con.close();

        }catch(Exception e) {
            throw new RuntimeException("Erro de conexão", e);
        }        
    }

}
