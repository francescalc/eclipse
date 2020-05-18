package controle;



import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;

import entidade.Peca;
import entidade.Veiculo;


@ManagedBean(name = "VeiculoBean")
@SessionScoped
public class VeiculoBean {

	private Veiculo veiculo;
	private VeiculoDAO veiculoDAO;
	private List<Peca> listaPeca;
	private Peca pecaAdiciona;
	private Peca tipoSelecionado;
	private Peca desgasteSelecionado;
	
	
	public VeiculoBean() {
		this.veiculoDAO = new VeiculoDAOImpl();
		this.veiculo = new Veiculo();
		this.listaPeca = new ArrayList<Peca>();
		
	}
	
	
public void salvarCadastro() {
		
		this.veiculoDAO.inserir(this.veiculo);
		this.veiculo = new Veiculo();
	}




public void adicionarPeca() {

	Peca novo = new Peca();
	
	novo.setTipo(this.tipoSelecionado.getTipo());
	novo.setNome(this.pecaAdiciona.getNome());
	novo.setTamanho(this.pecaAdiciona.getTamanho()); 
	novo.setDesgaste(this.desgasteSelecionado.getDesgaste());
	
	this.veiculo.getListaPeca().add(novo);
	
	
}


public Veiculo getVeiculo() {
	return veiculo;
}


public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
}


public VeiculoDAO getVeiculoDAO() {
	return veiculoDAO;
}


public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
	this.veiculoDAO = veiculoDAO;
}


public List<Peca> getListaPeca() {
	return listaPeca;
}


public void setListaPeca(List<Peca> listaPeca) {
	this.listaPeca = listaPeca;
}


public Peca getPecaAdiciona() {
	return pecaAdiciona;
}


public void setPecaAdiciona(Peca pecaAdiciona) {
	this.pecaAdiciona = pecaAdiciona;
}


public Peca getTipoSelecionado() {
	return tipoSelecionado;
}


public void setTipoSelecionado(Peca tipoSelecionado) {
	this.tipoSelecionado = tipoSelecionado;
}


public Peca getDesgasteSelecionado() {
	return desgasteSelecionado;
}


public void setDesgasteSelecionado(Peca desgasteSelecionado) {
	this.desgasteSelecionado = desgasteSelecionado;
}

}




