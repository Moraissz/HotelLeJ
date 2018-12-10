package controle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import DAO.ConexaoFactory;
import DAO.DAOFactory;
import DAO.ReservaDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.InputStreamDownload;
import helper.Datas;
import modelo.Reserva;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Controller
public class UserController {
	@Inject
	private Reserva reserva;
	@Inject
    private Result result;
	
	public void profile() {
		//Como ver o usuario Atual xD
		//Subject usuarioAtual = SecurityUtils.getSubject( );
		//System.out.println(usuarioAtual.getPrincipal( ).toString( ));
		
	}
	public Reserva alterarReserva() {
		 
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
	public void alterarPerfil() {
		
	}
	public void buscarReserva() {
		
	}
	public Reserva reservaBuscada(int id) {
			reserva.setId_reserva(id);
			int tamanho1 = 0;
			Boolean isCheckInDay = false;
			try {
				DAOFactory.abrirConexao();
				ReservaDAO dao = DAOFactory.criarReservaDAO();
				reserva = dao.buscarreserva(id);
				Period periodo1 = Period.between(LocalDate.parse(reserva.getData_entrada()),LocalDate.now()); //data saida é exclusivo
				tamanho1 = periodo1.getDays();
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
			System.out.println("Tamanho1" + tamanho1);
			isCheckInDay = tamanho1 == 1 || tamanho1 == 0 ?  true :false; 
			result.include("checkInDay", isCheckInDay);
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
	public void checkInFeito() {
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			dao.ConfirmarCheckIn(reserva.getId_reserva());
			result.include("checkIn","Check in Confirmado");
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
	
	public void sucesso(String dataEntrada, String dataSaida) {
		List<Reserva> reservasQuarto = new ArrayList<>();
		List<Reserva> reservas= new ArrayList<>();
		LocalDate dateEntrada = LocalDate.parse(dataEntrada);
		LocalDate dateSaida = LocalDate.parse(dataSaida);
		Boolean estado = null;
		String mensagem = "";
		try {
			DAOFactory.abrirConexao();
			ReservaDAO dao = DAOFactory.criarReservaDAO();
			reserva = dao.buscarreserva(reserva.getId_reserva());
			reservasQuarto = dao.buscar_por_quarto(reserva.getNumero_quarto(), reserva.getNumero_andar());
			for(Reserva reservaAtual: reservasQuarto){
				  if(reservaAtual.getStatus().equals("Reservado") && reservaAtual.getId_reserva() != reserva.getId_reserva()) {
					  reservas.add(reservaAtual);
				  }
				}
			for(Reserva reservaAtual: reservas){
				   LocalDate dataInicioReserva = LocalDate.parse(reservaAtual.getData_entrada());
				   LocalDate dataSaidaReserva = LocalDate.parse(reservaAtual.getData_saida());
				   estado = Datas.comparardatas(dateEntrada, dateSaida, dataInicioReserva, dataSaidaReserva);
				   if(!estado) {
					   mensagem = "Você nao pode alterar para esta data";
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
		result.include("mensagem", mensagem);
		
		
	}
	public Download relatorio() {
		Subject usuarioAtual = SecurityUtils.getSubject( );
		System.out.println(usuarioAtual.getPrincipal( ).toString( ));
		 ByteArrayOutputStream exported = new ByteArrayOutputStream();

		    try {
		      InputStream arquivoJasper;
		      arquivoJasper = getClass().getResourceAsStream("/RelatorioUsuario.jasper");
		      var conexao = ConexaoFactory.getConexao();
		      Map<String, Object> parametros = new HashMap<>();
	           parametros.put("usuarioAtual", usuarioAtual.getPrincipal().toString());
		      JasperPrint print = JasperFillManager.fillReport(arquivoJasper, parametros ,conexao);

		      JRExporter exporter = new JRPdfExporter();
		      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, exported);
		      exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);

		      exporter.exportReport();
		    } catch (JRException ex) {
		      System.out.println("Problemas na geracao do PDF." + "\n" + ex);
		    } catch (SQLException ex) {
		      DAOFactory.mostrarSQLException(ex);
		    }
		    byte[] content = exported.toByteArray();
		    return new InputStreamDownload(new ByteArrayInputStream(content), "application/pdf", "Relatorio-Usuario", false,
		        content.length);
		  }
	}


