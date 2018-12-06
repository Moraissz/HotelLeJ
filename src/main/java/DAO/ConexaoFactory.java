package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection getConexao() throws SQLException {
    	String DRIVER="com.mysql.cj.jdbc.Driver";
    	String URL="jdbc:mysql://localhost:3306/TrabalhoWEB";
        String USER="root";
        String PASS="sfcJC1998";
        Connection conexao = null;

        try {
            System.out.println("Conectando com o banco de dados.");
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC.");
        }
		return conexao;
    }
    private ConexaoFactory() {
    }
}

