package controle;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import DAO.DAOFactory;
import DAO.QuartoDAO;
import DAO.ReservaDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import helper.Datas;
import modelo.Pessoa;
import modelo.Quarto;
import modelo.Reserva;


@Controller
public class ReservasController 
{
	private Result result;
	
	static String entrada;
	static String saida;
	
	static int numeroquarto;
	static int numeroandar;
	static int quantidade;
	
	public List<Quarto> rooms(String dataEntrada, String dataSaida, String qtdPessoas) throws SQLException 
	{
		ArrayList<Quarto > quartos = new ArrayList();
		    if(dataEntrada == null || dataSaida == null || qtdPessoas == null)
		    {
		    	System.out.println("alooooo2");
		    }
		    else
		    {
		    	LocalDate dateEntrada = LocalDate.parse(dataEntrada);
				LocalDate dateSaida = LocalDate.parse(dataSaida);
				int quantidade = Integer.parseInt(qtdPessoas);
				
				DAOFactory.abrirConexao();
				QuartoDAO dao= DAOFactory.criarQuartoDAO();
				ReservaDAO dao2= DAOFactory.criarReservaDAO();
				
				ArrayList<Quarto> receber = dao.buscarquantidadepessoas(quantidade);
				
				ArrayList<Reserva> reservas;
				
				 boolean pode=true;
				
				for(int i=0;i<receber.size();i=i+1)
				{
					pode = true;
					System.out.printf("ENCONTRADO: %d\n",receber.get(i).getNumero_quarto());
					reservas=dao2.buscar_por_quarto(receber.get(i).getNumero_quarto(), receber.get(i).getNumero_andar());
					System.out.println("TAMANHO: "+reservas.size());
					for(int j=0;j<reservas.size();j=j+1)
		            {
		            	pode = Datas.comparardatas(dateEntrada, dateSaida, LocalDate.parse(reservas.get(j).getData_entrada()), LocalDate.parse(reservas.get(j).getData_saida()));
		            	System.out.println("ALOOOOOOOOOOOOOOOOOOOOOOOOOOOO:    "+reservas.get(j).getData_entrada()+"     "+receber.get(i).getNumero_quarto());
		            	
		            	if(pode == false)
		            	{
		            		break;
		            	}
		            }
					if(pode == true)
					{
						System.out.println("ESSE PODE:   "+receber.get(i).getNumero_quarto() + " ");
						quartos.add(receber.get(i));
					}
				}
				DAOFactory.fecharConexao();
				
				entrada=dataEntrada;
				saida=dataSaida;
		    }
		
	    return quartos;
		
	}
	public Quarto finalizar(String quarto1, String andar, String pessoas) throws SQLException 
	{
		numeroquarto=Integer.parseInt(quarto1);
		numeroandar=Integer.parseInt(andar);
		quantidade=Integer.parseInt(pessoas);
		
		
		DAOFactory.abrirConexao();
		
		QuartoDAO dao =  DAOFactory.criarQuartoDAO();
		
		Quarto quarto=dao.buscarquarto(numeroquarto,numeroandar);
		
		DAOFactory.fecharConexao();
		

		
		
		return quarto;
		
	}
	public void sucesso(String pessoa_nome, String pessoa_documento,String pessoas, String Telefone, String Consideracao) throws SQLException 
	{
		
		
		
		DAOFactory.abrirConexao();
		
		Reserva reserva = new Reserva();
		
		ReservaDAO dao2=DAOFactory.criarReservaDAO();
		
		Subject usuarioAtual = SecurityUtils.getSubject( );
		String user = usuarioAtual.getPrincipal( ).toString( );
		
		reserva.setNumero_quarto(numeroquarto);
		reserva.setNumero_andar(numeroandar);
		reserva.setQuantidade_pessoas(Integer.parseInt(pessoas));
		reserva.setStatus("Reservado");
		reserva.setDescricao(Consideracao);
		reserva.setUsuario(user);
		reserva.setData_entrada(entrada);
		reserva.setData_checkin("Sem");
		reserva.setData_saida(saida);
		reserva.setNotificacao(0);
		reserva.setValor(60*quantidade);
		reserva.setTelefone(Telefone);
		
		Pessoa pessoa=new Pessoa();
		pessoa.setNome(pessoa_nome);
		pessoa.setDocumento(pessoa_documento);
		pessoa.setTipo("Usuario");
		pessoa.setUsuario(user);
		reserva.gravarpessoa(pessoa);
		
		dao2.criarreserva(reserva);
		
		DAOFactory.fecharConexao();
	}
}
