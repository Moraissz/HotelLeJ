package modelo;

public class Quarto 
{
	int numero_quarto;
	int numero_andar;
    int quantidade_pessoas;
    String descricao;
    String status;
    int numero_banheiro;
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
	public int getQuantidade_pessoas() {
		return quantidade_pessoas;
	}
	public void setQuantidade_pessoas(int quantidade_pessoas) {
		this.quantidade_pessoas = quantidade_pessoas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumero_banheiro() {
		return numero_banheiro;
	}
	public void setNumero_banheiro(int numero_banheiro) {
		this.numero_banheiro = numero_banheiro;
	}
}
