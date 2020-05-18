package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOEMAIL")
public class UsuarioEmail {

	@Id
	@Column(name="E-mail", nullable = false)
	private String email;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="SENHA", nullable = false)
	private String senha;
	
	
	@Column(name="CPF", nullable = false)
	private String cpf;
	
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
