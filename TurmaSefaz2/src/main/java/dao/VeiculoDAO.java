package dao;

import java.util.List;

import entidade.Peca;
import entidade.Veiculo;


/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO é uma interface, onde compartilha a chamada dos metodos, mas não os implementam.
 */

public interface VeiculoDAO {
	
	public void inserir(Veiculo veiculo);
	
	public void alterar(Veiculo veiculo);

	public void remover(Veiculo veiculo);

	public Veiculo pesquisar(String marca);

	public List<Veiculo> listarTodos();
	
	public List<Peca> listarPeca();

}
