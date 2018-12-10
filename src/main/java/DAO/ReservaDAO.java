package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;
import modelo.Quarto;
import modelo.Reserva;

public class ReservaDAO 
{
	private final Connection conexao;

	public ReservaDAO(Connection conexao) 
	{
		this.conexao = conexao;
	}
	
	public void criarreserva(Reserva reserva) throws SQLException 
	{
        String insercao = "INSERT INTO Reserva (numero_quarto, numero_andar, status, descricao, usuario, quantidade_pessoas, data_entrada, data_saida, data_checkin, notificacao, valor) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1,reserva.getNumero_quarto());
            pstmt.setInt(2,reserva.getNumero_andar());
            pstmt.setString(3,reserva.getStatus());
            pstmt.setString(4,reserva.getDescricao());
            pstmt.setString(5,reserva.getUsuario());
            pstmt.setInt(6,reserva.getQuantidade_pessoas());
            pstmt.setString(7,reserva.getData_entrada());
            pstmt.setString(8,reserva.getData_saida());
            pstmt.setString(9,reserva.getData_checkin());
            pstmt.setInt(10,reserva.getNotificacao());
            pstmt.setString(11,"0");
            int resultado = pstmt.executeUpdate();
            if (resultado == 1)
            {
            	ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					reserva.setId_reserva(rs.getInt(1));
				}
				PessoaDAO dao = new PessoaDAO(conexao);
				for (Pessoa a : reserva.getPessoas()) {
					dao.criarpessoa(a, reserva);
				}
				System.out.println("\nInserção bem sucedida.");
            } 
            else 
            {
                System.out.println("A inserção não foi feita corretamente.");
            }
        }
    }
	
	
	public  Reserva buscarreserva(int id) throws SQLException 
	{
        Reserva reserva = null;
        String selecao = "SELECT * FROM Reserva WHERE id_reserva = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setInt(1,id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	reserva = new Reserva();
                    reserva.setId_reserva(rs.getInt(1));
                    reserva.setNumero_quarto(rs.getInt(2));
                    reserva.setNumero_andar(rs.getInt(3));
                    reserva.setStatus(rs.getString(4));
                    reserva.setDescricao(rs.getString(5));
                    reserva.setUsuario(rs.getString(6));
                    reserva.setQuantidade_pessoas(rs.getInt(7));
                    reserva.setData_entrada(rs.getString(8));
                    reserva.setData_saida(rs.getString(9));
                    reserva.setData_checkin(rs.getString(10));
                    reserva.setNotificacao(rs.getInt(11));
                    reserva.setValor(Integer.parseInt(rs.getString(12)));
                }
            }
        }
        return reserva;
	}
	public ArrayList<Reserva> buscarPorUsuario(String user) throws SQLException 
	{
        Reserva reserva;
        ArrayList<Reserva> reservas = new ArrayList<>();
        String selecao = "SELECT * FROM Reserva WHERE usuario = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
        	pstmt.setString(1,user);
        	try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	 reserva = new Reserva();
                	 reserva.setId_reserva(rs.getInt(1));
                     reserva.setNumero_quarto(rs.getInt(2));
                     reserva.setNumero_andar(rs.getInt(3));
                     reserva.setStatus(rs.getString(4));
                     reserva.setDescricao(rs.getString(5));
                     reserva.setUsuario(rs.getString(6));
                     reserva.setQuantidade_pessoas(rs.getInt(7));
                     reserva.setData_entrada(rs.getString(8));
                     reserva.setData_saida(rs.getString(9));
                     reserva.setData_checkin(rs.getString(10));
                     reserva.setNotificacao(rs.getInt(11));
                     reserva.setValor(Integer.parseInt(rs.getString(12)));
                     reservas.add(reserva);
                }
            }
        }
        return reservas;
    }
	
	public ArrayList<Reserva> buscartodas() throws SQLException 
	{
        Reserva reserva;
        ArrayList<Reserva> reservas = new ArrayList<>();
        String selecao = "SELECT * FROM Reserva";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
        	try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	 reserva = new Reserva();
                	 reserva.setId_reserva(rs.getInt(1));
                     reserva.setNumero_quarto(rs.getInt(2));
                     reserva.setNumero_andar(rs.getInt(3));
                     reserva.setStatus(rs.getString(4));
                     reserva.setDescricao(rs.getString(5));
                     reserva.setUsuario(rs.getString(6));
                     reserva.setQuantidade_pessoas(rs.getInt(7));
                     reserva.setData_entrada(rs.getString(8));
                     reserva.setData_saida(rs.getString(9));
                     reserva.setData_checkin(rs.getString(10));
                     reserva.setNotificacao(rs.getInt(11));
                     reserva.setValor(Integer.parseInt(rs.getString(12)));
                     reservas.add(reserva);
                }
            }
        }
        return reservas;
    }
	
	public ArrayList<Reserva> buscarporstatus(String status) throws SQLException 
	{
        Reserva reserva;
        ArrayList<Reserva> reservas = new ArrayList<>();
        String selecao = "SELECT * FROM Reserva WHERE Status != ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
        	pstmt.setString(1,status);
        	try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	 reserva = new Reserva();
                	 reserva.setId_reserva(rs.getInt(1));
                     reserva.setNumero_quarto(rs.getInt(2));
                     reserva.setNumero_andar(rs.getInt(3));
                     reserva.setStatus(rs.getString(4));
                     reserva.setDescricao(rs.getString(5));
                     reserva.setUsuario(rs.getString(6));
                     reserva.setQuantidade_pessoas(rs.getInt(7));
                     reserva.setData_entrada(rs.getString(8));
                     reserva.setData_saida(rs.getString(9));
                     reserva.setData_checkin(rs.getString(10));
                     reserva.setNotificacao(rs.getInt(11));
                     reserva.setValor(Integer.parseInt(rs.getString(12)));
                     reservas.add(reserva);
                }
            }
        }
        return reservas;
    }
	
	public ArrayList<Reserva> buscar_por_quarto(int nq, int na) throws SQLException 
	{
        Reserva reserva;
        ArrayList<Reserva> reservas = new ArrayList<>();
        String selecao = "SELECT * FROM Reserva WHERE numero_quarto = ? and numero_andar = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
        	pstmt.setInt(1,nq);
        	pstmt.setInt(2,na);
        	try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	 reserva = new Reserva();
                	 reserva.setId_reserva(rs.getInt(1));
                     reserva.setNumero_quarto(rs.getInt(2));
                     reserva.setNumero_andar(rs.getInt(3));
                     reserva.setStatus(rs.getString(4));
                     reserva.setDescricao(rs.getString(5));
                     reserva.setUsuario(rs.getString(6));
                     reserva.setQuantidade_pessoas(rs.getInt(7));
                     reserva.setData_entrada(rs.getString(8));
                     reserva.setData_saida(rs.getString(9));
                     reserva.setData_checkin(rs.getString(10));
                     reserva.setNotificacao(rs.getInt(11));
                     reserva.setValor(Integer.parseInt(rs.getString(12)));
                     reservas.add(reserva);
                }
            }
        }
        return reservas;
    }
	public void alterarReserva(String dataEntrada,String dataSaida, int id) throws SQLException 
	{
        String update = "UPDATE Reserva SET data_entrada = ?, data_saida = ? Where id_reserva = ? "; 
        try (PreparedStatement pstmt = conexao.prepareStatement(update, PreparedStatement.RETURN_GENERATED_KEYS)) {
        	pstmt.setString(1, dataEntrada);
        	pstmt.setString(2, dataSaida);
        	pstmt.setInt(3, id);
            int resultado = pstmt.executeUpdate();
            if (resultado == 1)
            {
            
				System.out.println("\nUpdate bem sucedido.");
            } 
            else 
            {
                System.out.println("Rip Update.");
            }
        }
    }
	public void ConfirmarCheckIn( int id) throws SQLException 
	{
        String update = "UPDATE Reserva SET status = 'Confirmado' Where id_reserva = ? "; 
        try (PreparedStatement pstmt = conexao.prepareStatement(update, PreparedStatement.RETURN_GENERATED_KEYS)) {
        	pstmt.setInt(1, id);
            int resultado = pstmt.executeUpdate();
            if (resultado == 1)
            {
            
				System.out.println("\nCheckIn Confirmado.");
            } 
            else 
            {
                System.out.println("Rip CheckIn.");
            }
        }
    }
	
	public void deletarReserva(int id) throws SQLException 
	{
        String delete = "DELETE FROM Reserva WHERE id_reserva = ?;";
        try (PreparedStatement pstmt = conexao.prepareStatement(delete)) {
            pstmt.setInt(1,id);
            int resultado = pstmt.executeUpdate();
            if (resultado == 1)
            {
            	System.out.println("Delete bem sucessido");
            } 
            else 
            {
                System.out.println("Nao deletado.");
            }
        }
    }
}
