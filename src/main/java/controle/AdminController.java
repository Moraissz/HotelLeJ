package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOFactory;
import DAO.ReservaDAO;
import br.com.caelum.vraptor.Controller;
import modelo.Reserva;

@Controller
public class AdminController {

	public void profile() {
		
	}
	public void alterarReserva() {
		
	}
	public void buscarReserva() {
		
	}
	public void reservaBuscada() {
		
	}
	public List<Reserva> todasReservas() {
		List<Reserva> reservas = new ArrayList<>();
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			reservas = dao.buscartodas();
			System.out.println(reservas);
			DAOFactory.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservas;
		
		
	}
	public void reservasCheckIn() {
		
	}
	public void reservasSemCheckIn() {
		
	}
	public void sucesso() {
		
	}
}
