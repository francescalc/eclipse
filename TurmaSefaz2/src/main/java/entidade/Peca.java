package entidade;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="PECA")
public class Peca {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "S_JOGO")
	@SequenceGenerator(name = "S_JOGO", sequenceName = "S_JOGO", allocationSize = 1)
	private Long id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="TAMANHO", nullable = false)
	private String tamanho;
	
	@Column(name="TIPO", nullable= false)
	private String tipo;
	//parte elétrica, mecânica, arrefecimento, hidraulica
	
	
	@Column(name="DESGASTE", nullable= false)
	private String desgaste;
	//curto, médio, longo prazo
	
	@ManyToOne
	@JoinColumn(name = "marca_veiculo", referencedColumnName = "marca", nullable = false)
	private Veiculo veiculo;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDesgaste() {
		return desgaste;
	}

	public void setDesgaste(String desgaste) {
		this.desgaste = desgaste;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	
	
	
	
	
	
	
	
	

}
