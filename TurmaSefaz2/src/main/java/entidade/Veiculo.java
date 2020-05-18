package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEICULO")
public class Veiculo {

	@Id
	@Column(name="MODELO", nullable = false)
	private String modelo;
	
	
	@Column(name="MARCA", nullable = false)
	private String marca;
	
		
	@Column(name="COR", nullable = false)
	private String cor;
	
	
	@Column(name="ANO", nullable = false)
	private String ano;

	
@OneToMany(mappedBy="peca", cascade= CascadeType.ALL)
	private List<Peca> pecas;
	
	
	
	public List<Peca> getPecas() {
	return pecas;
}


public void setPeças(List<Peca> pecas) {
	this.pecas = pecas;
}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}
	
	


	
	
	
}
	
	