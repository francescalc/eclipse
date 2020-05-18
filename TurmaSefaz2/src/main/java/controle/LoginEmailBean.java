package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import dao.UsuarioEmailDAO;
import dao.UsuarioEmailDAOImpl;

import entidade.UsuarioEmail;

@ManagedBean(name = "LoginEmailBean")
@SessionScoped
public class LoginEmailBean {

	private String txtEmail;
	private String txtSenha;

	private List<UsuarioEmail> listaUsuariosEmail;
	private UsuarioEmail usuarioEmail; 
	private String msgCadastroUsuario;
	private UsuarioEmailDAO usuarioEmailDAO;

	
	public LoginEmailBean() {
		this.listaUsuariosEmail = new ArrayList<UsuarioEmail>();
		this.usuarioEmail = new UsuarioEmail();
		this.usuarioEmailDAO = new UsuarioEmailDAOImpl();
	}
	
	

	
	public String entrar() {

		
		boolean achou = false;

		this.listaUsuariosEmail = this.usuarioEmailDAO.listarTodos();
		
		for (UsuarioEmail usuarioPesquisa : listaUsuariosEmail) {

			if (usuarioPesquisa.getCpf().equals(this.txtEmail) && usuarioPesquisa.getSenha().equals(this.txtSenha)) {

				achou = true;
			}
		}

		if (achou) {
			return "VeiculoPeca.xhtml";
		} else {
			return "/index.xhtml";
		}

	}

	/**
	 * Metodo responsavel por criar um novo usuario na lista
	 */
	public void criarUsuario() {

		UsuarioEmail novo = new UsuarioEmail();
			
		novo.setEmail(this.usuarioEmail.getEmail());
		novo.setCpf(this.usuarioEmail.getCpf());
		novo.setNome(this.usuarioEmail.getNome());
		novo.setSenha(this.usuarioEmail.getSenha());

		

		boolean achou = false;
		
		this.listaUsuariosEmail = this.usuarioEmailDAO.listarTodos();
		
		for (UsuarioEmail usuarioPesquisa : listaUsuariosEmail) {
			if (usuarioPesquisa.getCpf().equals(this.usuarioEmail.getCpf())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!!!"));
		}else {

			this.usuarioEmailDAO.inserir(novo);
			
			this.usuarioEmail = new UsuarioEmail();	
		}
	}

	
	
	
	// <---------- getter e setters ->
	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public List<UsuarioEmail> getListaUsuariosEmail() {
		return listaUsuariosEmail;
	}

	public void setListaUsuariosEmail(List<UsuarioEmail> listaUsuariosEmail) {
		this.listaUsuariosEmail = listaUsuariosEmail;
	}

	public UsuarioEmail getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(UsuarioEmail usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public String getMsgCadastroUsuario() {
		return msgCadastroUsuario;
	}

	public void setMsgCadastroUsuario(String msgCadastroUsuario) {
		this.msgCadastroUsuario = msgCadastroUsuario;
	}

	public UsuarioEmailDAO getUsuarioEmailDAO() {
		return usuarioEmailDAO;
	}

	public void setUsuarioEmailDAO(UsuarioEmailDAO usuarioEmailDAO) {
		this.usuarioEmailDAO = usuarioEmailDAO;
	}


	

}
