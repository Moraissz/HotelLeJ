package controle;
import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import DAO.DAOFactory;
import DAO.UsuarioDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import helper.GeradorSenha;
import modelo.Usuario;

@Controller
public class AuthController {

	  @Inject
	  private Result result;
	public void login() {
		
	}
	public void cadastrar() {
		
	}
	public void cadastrado(Usuario usuario) {
		var senha = usuario.getSenha();
		var cripSenha = GeradorSenha.gerarHash(senha);
		usuario.setSenha(cripSenha);
		usuario.setTipo("user");
		try {
			DAOFactory.abrirConexao();
			UsuarioDAO dao =  DAOFactory.criarUsuarioDAO();
			dao.criarusuario(usuario);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DAOFactory.fecharConexao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
