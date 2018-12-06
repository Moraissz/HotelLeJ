package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO 
{
	private final Connection conexao;

	public UsuarioDAO(Connection conexao) 
	{
		this.conexao = conexao;
	}
	
	public void criarusuario(Usuario usuario) throws SQLException 
	{
        String insercao = "INSERT INTO Usuario (usuario, senha, tipo) VALUES (?, ?, ?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1,usuario.getUsuario());
            pstmt.setString(2,usuario.getSenha());
            pstmt.setString(3,usuario.getTipo());
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
	
	public Usuario buscarusuario(String login, String senha) throws SQLException 
	{
        Usuario usuario = null;
        String selecao = "SELECT * FROM Usuario WHERE usuario = ? and senha = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setString(1,login);
            pstmt.setString(2,senha);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	usuario = new Usuario();
                    usuario.setUsuario(rs.getString(1));
                    usuario.setSenha(rs.getString(2));
                    usuario.setTipo(rs.getString(3));
                }
            }
        }
        return usuario;
	}
	
	
}
