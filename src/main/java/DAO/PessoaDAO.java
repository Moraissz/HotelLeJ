package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;
import modelo.Reserva;

public class PessoaDAO {

	private final Connection conexao;

	public PessoaDAO(Connection conexao) 
	{
		this.conexao = conexao;
	}
	
	public void criarpessoa(Pessoa pessoa, Reserva reserva) throws SQLException 
	{
        String insercao = "INSERT INTO Pessoa (usuario, nome, tipo, documento, id_reserva) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1,pessoa.getUsuario());
            pstmt.setString(2,pessoa.getNome());
            pstmt.setString(3,pessoa.getTipo());
            pstmt.setString(4,pessoa.getDocumento());
            pstmt.setInt(5,reserva.getId_reserva());
            int resultado = pstmt.executeUpdate();
            if (resultado == 1)
            {
                System.out.println("\nInserção bem sucedida.");
            } 
            else 
            {
                System.out.println("A inserção não foi feita corretamente.");
            }
        }
    }
	
	public  Pessoa buscarpessoa(int id) throws SQLException 
	{
        Pessoa pessoa = null;
        String selecao = "SELECT * FROM Pessoa WHERE id_pessoa = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setInt(1,id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	pessoa = new Pessoa();
                    pessoa.setId_pessoa(rs.getInt(1));
                    pessoa.setUsuario(rs.getString(2));
                    pessoa.setNome(rs.getString(3));
                    pessoa.setTipo(rs.getString(4));
                    pessoa.setDocumento(rs.getString(5));
                    pessoa.setId_reserva(rs.getInt(6));
                }
            }
        }
        return pessoa;
	}
	
	public ArrayList<Pessoa> buscartodas() throws SQLException 
	{
		    Pessoa pessoa;
	        ArrayList<Pessoa> pessoas = new ArrayList<>();
	        String selecao = "SELECT * FROM Pessoa";
	        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
	        	try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                	 pessoa = new Pessoa();
	                	 pessoa.setId_pessoa(rs.getInt(1));
	                     pessoa.setUsuario(rs.getString(2));
	                     pessoa.setNome(rs.getString(3));
	                     pessoa.setTipo(rs.getString(4));
	                     pessoa.setDocumento(rs.getString(5));
	                     pessoa.setId_reserva(rs.getInt(6));
	                     pessoas.add(pessoa);
	                }
	            }
	        }
	        return pessoas;
	}
	
	public ArrayList<Pessoa> buscarporreserva(int id) throws SQLException 
	{
		    Pessoa pessoa;
	        ArrayList<Pessoa> pessoas = new ArrayList<>();
	        String selecao = "SELECT * FROM Pessoa WHERE id_reserva = ?";
	        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
	        	pstmt.setInt(1,id);
	        	try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                	 pessoa = new Pessoa();
	                	 pessoa.setId_pessoa(rs.getInt(1));
	                     pessoa.setUsuario(rs.getString(2));
	                     pessoa.setNome(rs.getString(3));
	                     pessoa.setTipo(rs.getString(4));
	                     pessoa.setDocumento(rs.getString(5));
	                     pessoa.setId_reserva(rs.getInt(6));
	                     pessoas.add(pessoa);
	                }
	            }
	        }
	        return pessoas;
	}
}
