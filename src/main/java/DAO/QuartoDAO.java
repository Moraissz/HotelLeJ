package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Quarto;
import modelo.Usuario;

public class QuartoDAO 
{
	private final Connection conexao;

	public QuartoDAO(Connection conexao) 
	{
		this.conexao = conexao;
	}
	
	public Quarto buscarquarto(int nq, int na) throws SQLException 
	{
        Quarto quarto = null;
        String selecao = "SELECT * FROM Quarto WHERE numero_quarto = ? and numero_andar = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setInt(1,nq);
            pstmt.setInt(2,na);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	quarto = new Quarto();
                    quarto.setNumero_quarto(rs.getInt(1));
                    quarto.setNumero_andar(rs.getInt(2));
                    quarto.setQuantidade_pessoas(rs.getInt(3));
                    quarto.setDescricao(rs.getString(4));
                    quarto.setStatus(rs.getString(5));
                    quarto.setNumero_banheiro(rs.getInt(6));
                }
            }
        }
        return quarto;
	}
	
	public ArrayList<Quarto> buscartodos() throws SQLException 
	{
        Quarto quarto;
        ArrayList<Quarto> quartos = new ArrayList<>();
        String selecao = "SELECT * FROM Quarto";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
        	try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	 quarto = new Quarto();
                	 quarto.setNumero_quarto(rs.getInt(1));
                     quarto.setNumero_andar(rs.getInt(2));
                     quarto.setQuantidade_pessoas(rs.getInt(3));
                     quarto.setDescricao(rs.getString(4));
                     quarto.setStatus(rs.getString(5));
                     quarto.setNumero_banheiro(rs.getInt(6));
                     quartos.add(quarto);
                }
            }
        }
        return quartos;
    }
	
	public void criarquarto(Quarto quarto) throws SQLException 
	{
        String insercao = "INSERT INTO Quarto (numero_quarto, numero_andar, quantidade_pessoas, descricao, status, numero_banheiro) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1,quarto.getNumero_quarto());
            pstmt.setInt(2,quarto.getNumero_andar());
            pstmt.setInt(3,quarto.getQuantidade_pessoas());
            pstmt.setString(4,quarto.getDescricao());
            pstmt.setString(5,quarto.getStatus());
            pstmt.setInt(6,quarto.getNumero_banheiro());
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
	
	public ArrayList<Quarto> buscarquantidadepessoas(int quantidade_pessoas) throws SQLException 
	{
        Quarto quarto;
        ArrayList<Quarto> quartos = new ArrayList<>();
        String selecao = "SELECT * FROM Quarto WHERE quantidade_pessoas >= ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
        	pstmt.setInt(1,quantidade_pessoas);
        	try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	 quarto = new Quarto();
                	 quarto.setNumero_quarto(rs.getInt(1));
                     quarto.setNumero_andar(rs.getInt(2));
                     quarto.setQuantidade_pessoas(rs.getInt(3));
                     quarto.setDescricao(rs.getString(4));
                     quarto.setStatus(rs.getString(5));
                     quarto.setNumero_banheiro(rs.getInt(6));
                     quartos.add(quarto);
                }
            }
        }
        return quartos;
    }
}
