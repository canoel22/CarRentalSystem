package model;

public class Endereco {
	
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String complemento;
	
	public Endereco(String rua, int numero, String bairro, String cidade, String complemento) {
		rua = this.rua;
		numero = this.numero;
		bairro = this.bairro;
		cidade = this.cidade;
		complemento = this.complemento;
	}
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
