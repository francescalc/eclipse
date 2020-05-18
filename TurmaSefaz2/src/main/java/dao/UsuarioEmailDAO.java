package dao;

import java.util.List;

import entidade.UsuarioEmail;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO � uma interface, onde compartilha a chamada dos metodos, mas n�o os implementam.
 */

public interface UsuarioEmailDAO {
	public void inserir(UsuarioEmail usuarioEmail);
	
	public void alterar(UsuarioEmail usuarioEmail);

	public void remover(UsuarioEmail usuarioEmail);

	public UsuarioEmail pesquisar(String marca);

	public List<UsuarioEmail> listarTodos();

}
