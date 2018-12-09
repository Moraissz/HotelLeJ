package controle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
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
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.InputStreamDownload;
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


