package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import DAO.DAOFactory;
import DAO.ReservaDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import modelo.Reserva;

@Controller
public class UserController {
	@Inject
	private Reserva reserva;
	
	public void profile() {
		//Como ver o usuario Atual xD
		//Subject usuarioAtual = SecurityUtils.getSubject( );
		//System.out.println(usuarioAtual.getPrincipal( ).toString( ));
		
	}
	public void alterarReserva() {
		
	}
	public void alterarPerfil() {
		
	}
	public void buscarReserva() {
		
	}
	public Reserva reservaBuscada(int id) {
			
			reserva.setId_reserva(id);
			try {
				DAOFactory.abrirConexao();
				ReservaDAO dao = DAOFactory.criarReservaDAO();
				reserva = dao.buscarreserva(id);
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
			return reserva;
	}
	public List<Reserva> todasReservas() {
		Subject usuarioAtual = SecurityUtils.getSubject( );
		String user = usuarioAtual.getPrincipal( ).toString( );
		List<Reserva> reservas = new ArrayList<>();
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			reservas = dao.buscarPorUsuario(user);
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
		return reservas;
		
		
	}
	public void reservaDeletada() {
		
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			dao.deletarReserva(reserva.getId_reserva());
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
	
	public void sucesso() {
		
	}

}
