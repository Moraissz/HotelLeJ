package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {

    private static Connection conexao = null;

    public static PessoaDAO criarPessoaDAO() 
    {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new PessoaDAO(conexao);
        }
    }
    
    public static UsuarioDAO criarUsuarioDAO() 
    {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new UsuarioDAO(conexao);
        }
    }
    
    public static QuartoDAO criarQuartoDAO() 
    {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new QuartoDAO(conexao);
        }
    }
    
    public static ReservaDAO criarReservaDAO() 
    {
        if (conexao == null) {
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new ReservaDAO(conexao);
        }
    }

    public static void abrirConexao() throws SQLException 
    {
        if (conexao == null) {
            conexao = ConexaoFactory.getConexao();
        } else {
            throw new IllegalStateException("A conexão já está aberta.");
        }
    }

    public static void fecharConexao() throws SQLException
    {
        if (conexao != null) {
            System.out.println("Terminando a conexão com o banco de dados.");
            conexao.close();
            conexao = null;
            System.out.println("Conexão com o banco de dados terminada.");
        } else {
            throw new IllegalStateException("A conexão com o BD já está fechada.");
        }
    }

    public static void iniciarTransacao() throws SQLException
    {
        conexao.setAutoCommit(false);
    }

    public static void terminarTransacao() throws SQLException 
    {
        conexao.commit();
        conexao.setAutoCommit(true);
    }

    public static void abortarTransacao() throws SQLException
    {
        conexao.rollback();
        conexao.setAutoCommit(true);
    }

    public static void mostrarSQLException(SQLException ex) 
    {
        SQLException e = ex;
        while (e != null) {
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Mensagem: " + e.getMessage());
            Throwable t = e.getCause();
            while (t != null) {
                System.out.println("Causa: " + t);
                t = t.getCause();
            }
            e = e.getNextException();
        }
    }

}

