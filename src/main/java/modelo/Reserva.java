package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Reserva implements Serializable
{
	int id_reserva;
	int numero_quarto;
	int numero_andar;
	String status;
	String descricao;
	String usuario;
	int quantidade_pessoas;
	String data_entrada;
	String data_saida;
	String data_checkin;
	int notificacao;
	int valor;
	ArrayList<Pessoa> pessoas = new ArrayList<>();
	String telefone;
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public int getNumero_quarto() {
		return numero_quarto;
	}
	public void setNumero_quarto(int numero_quarto) {
		this.numero_quarto = numero_quarto;
	}
	public int getNumero_andar() {
		return numero_andar;
	}
	public void setNumero_andar(int numero_andar) {
		this.numero_andar = numero_andar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getQuantidade_pessoas() {
		return quantidade_pessoas;
	}
	public void setQuantidade_pessoas(int quantidade_pessoas) {
		this.quantidade_pessoas = quantidade_pessoas;
	}
	public String getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	public String getData_saida() {
		return data_saida;
	}
	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}
	public String getData_checkin() {
		return data_checkin;
	}
	public void setData_checkin(String data_checkin) {
		this.data_checkin = data_checkin;
	}
	public int getNotificacao() {
		return notificacao;
	}
	public void setNotificacao(int notificacao) {
		this.notificacao = notificacao;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public void gravarpessoa(Pessoa pessoa)
	{
		pessoas.add(pessoa);
	}
}
