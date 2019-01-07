package controle;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import DAO.DAOFactory;
import DAO.ReservaDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import helper.Datas;
import modelo.Reserva;

@Controller
public class AdminController {
	
	@Inject
	private Result result;
	
	static Reserva reserva;

	public void profile() {
		
	}
	public Reserva alterarReserva() 
	{
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			reserva = dao.buscarreserva(reserva.getId_reserva());
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
	public void buscarReserva() {
		
	}
	public Reserva reservaBuscada(int id) throws SQLException 
	{
		Reserva reserva2 = new Reserva();
		int tamanho1 = -1;
		Boolean isCheckInDay = false;
		Boolean isCheckInDay2 = false;
		Boolean isCheckInDay3 = false;
		
		DAOFactory.abrirConexao();
		ReservaDAO dao = DAOFactory.criarReservaDAO();
		
		reserva2=dao.buscarreserva(id);
		
		DAOFactory.fecharConexao();
        
		if(reserva2 == null)
		{
			return reserva;
		}
		else
		{
			reserva=reserva2;
			Period periodo1 = Period.between(LocalDate.now(),LocalDate.parse(reserva.getData_entrada())); //data saida é exclusivo
			tamanho1 = periodo1.getDays();
			
			Period periodo2 = Period.between(LocalDate.now(),LocalDate.parse(reserva.getData_saida()));
			int tamanho2 = periodo2.getDays();
			
			isCheckInDay = tamanho1 == 1 || tamanho1 <= 0 ?  true :false; 
			result.include("checkInDay", isCheckInDay);
			
			isCheckInDay2 = tamanho1 == 1 || tamanho1 >= 0 ?  true :false; 
			result.include("checkInDay2", isCheckInDay2);
			
			
			isCheckInDay3 = tamanho2 == 0 ?  true :false; 
			result.include("checkInDay3", isCheckInDay3);
			
			System.out.println("ID:  " +reserva.getId_reserva());
			
			return reserva;
		}
		
	}
	public List<Reserva> todasReservas() 
	{
		
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
	public List<Reserva> reservasCheckIn() throws SQLException 
	{
		List<Reserva> reservas = new ArrayList<>();
		List<Reserva> reservas2 = new ArrayList<>();
		
		DAOFactory.abrirConexao();
		ReservaDAO dao = DAOFactory.criarReservaDAO();
		
		reservas2=dao.buscarporstatus("Finalizado");
		
		for(int i=0;i<reservas2.size();i=i+1)
		{
			if(reservas2.get(i).getStatus().equals("Confirmado"))
			{
				reservas.add(reservas2.get(i));
			}
		}
		DAOFactory.fecharConexao();
		
		return reservas;
		
	}
	public  List<Reserva> reservasSemCheckIn() throws SQLException 
	{
		List<Reserva> reservas = new ArrayList<>();
		List<Reserva> reservas2 = new ArrayList<>();
		
		DAOFactory.abrirConexao();
		ReservaDAO dao = DAOFactory.criarReservaDAO();
		
		reservas2=dao.buscarporstatus("Finalizado");
		
		for(int i=0;i<reservas2.size();i=i+1)
		{
			if(reservas2.get(i).getStatus().equals("Reservado"))
			{
				reservas.add(reservas2.get(i));
			}
		}
		
		DAOFactory.fecharConexao();
		
		return reservas;
	}
	public void reservaDeletada() throws SQLException 
	{
		
		System.out.println("entrou: " +reserva.getId_reserva());
		
		DAOFactory.abrirConexao();
		
		ReservaDAO dao = DAOFactory.criarReservaDAO();
		
		dao.deletarReserva(reserva.getId_reserva());
		
		reserva = null;
		
		DAOFactory.fecharConexao();
		
		
	}
	
	public void reservaFinalizada() throws SQLException 
	{
		
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			dao.alterarReserva2(reserva.getId_reserva());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.include("checkIn","Houve Problema no CheckIn");
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
	public void sucesso(String dataEntrada, String dataSaida) 
	{
		List<Reserva> reservasQuarto = new ArrayList<>();
		List<Reserva> reservas= new ArrayList<>();
		LocalDate dateEntrada = LocalDate.parse(dataEntrada);
		LocalDate dateSaida = LocalDate.parse(dataSaida);
		Boolean estado = null;
		String mensagem = "";
		
		System.out.println("ALOOOOOOOOOOOOOOOOOOOOO:" +reserva.getId_reserva());
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			reserva = dao.buscarreserva(reserva.getId_reserva());
			
			reservas = dao.buscar_por_quarto(reserva.getNumero_quarto(), reserva.getNumero_andar());
			for(Reserva reservaAtual: reservasQuarto){
				  if((reservaAtual.getStatus().equals("Reservado") || reservaAtual.getStatus().equals("Confirmado") ) && reservaAtual.getId_reserva() != reserva.getId_reserva()) {
					  reservas.add(reservaAtual);
				  }
				}
			for(Reserva reservaAtual: reservas){
				   LocalDate dataInicioReserva = LocalDate.parse(reservaAtual.getData_entrada());
				   LocalDate dataSaidaReserva = LocalDate.parse(reservaAtual.getData_saida());
				   estado = Datas.comparardatas(dateEntrada, dateSaida, dataInicioReserva, dataSaidaReserva);
				   if(!estado) {
					   mensagem = "Você não pode alterar para esta data";
					   break;
				   }
				}
			if(estado) {
				dao.alterarReserva(dataEntrada, dataSaida, reserva.getId_reserva());
				mensagem = "Reserva Alterada Com sucesso";
			}
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
		System.out.println(mensagem);
		result.include("mensagem", mensagem);
	}
}
