package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entidade.UsuarioEmail;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *         Essa classe implementa a interface, todos os metodos mostrados na
 *         interface. Lembrando de uma coisa, a implementação ela recebe no
 *         construtor o entityManager, a conexão com o banco de dados, deixando
 *         assim essa classe totalemnte independente
 *
 */

public class UsuarioEmailDAOImpl implements UsuarioEmailDAO {

	private UsuarioEmail usuarioEmail;
	

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia
	 * e executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(UsuarioEmail usuarioEmail) {

		String sql = "insert into USUARIOEMAIL ( cpf, email, nome, senha) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuarioEmail.getCpf());
			ps.setString(2, usuarioEmail.getEmail());
			ps.setString(3, usuarioEmail.getNome());
			ps.setString(4, usuarioEmail.getSenha());
			

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a
	 * ação de merger
	 */
	public void alterar(UsuarioEmail usuarioEmail) {

		String sql = "UPDATE USUARIO SET nome = ?, senha = ?, cpf = ? where email = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuarioEmail.getCpf());
			ps.setString(2, usuarioEmail.getEmail());
			ps.setString(3, usuarioEmail.getNome());
			ps.setString(4, usuarioEmail.getSenha());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(UsuarioEmail usuarioEmail) {

		String sql = "DELETE FROM USUARIO WHERE email = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(2, usuarioEmail.getEmail());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o cpf
	 */
	public UsuarioEmail pesquisar(String email) {

		String sql = "select U.Email, U.CPF, U.NOME, U.SENHA from USUARIO U where email = ?";
		
		UsuarioEmail usuarioEmail = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, email);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				usuarioEmail = new UsuarioEmail();
				usuarioEmail.setCpf(res.getString("CPF"));
				usuarioEmail.setNome(res.getString("NOME"));
				usuarioEmail.setSenha(res.getString("SENHA"));
				usuarioEmail.setEmail(res.getString("EMAIL"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarioEmail;
	}

	/**
	 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a
	 * consulta pelo objeto direto assim from Usuario, que isso é o objeto usuario e
	 * não a tabela
	 */
	public List<UsuarioEmail> listarTodos() {

		String sql = "select U.CPF, U.NOME, U.SENHA from USUARIO U";
		
		List<UsuarioEmail> listaUsuariosEmail = new ArrayList<UsuarioEmail>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				UsuarioEmail usuarioEmail = new UsuarioEmail();
				
				usuarioEmail.setCpf(res.getString("CPF"));
				usuarioEmail.setNome(res.getString("NOME"));
				usuarioEmail.setSenha(res.getString("SENHA"));
				usuarioEmail.setEmail(res.getString("EMAIL"));
				listaUsuariosEmail.add(usuarioEmail);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaUsuariosEmail;

	}

	public UsuarioEmail getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(UsuarioEmail usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

}
