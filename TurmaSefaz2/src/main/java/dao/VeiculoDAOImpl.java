package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Peca;
import entidade.UsuarioEmail;
import entidade.Veiculo;
import util.JpaUtil;
import dao.VeiculoDAO;



public class VeiculoDAOImpl implements VeiculoDAO {

	private Veiculo veiculo;
	

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia
	 * e executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Veiculo veiculo) {

		String sql = "insert into VEICULO ( marca, modelo, ano, cor) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setString(3, veiculo.getAno());
			ps.setString(4, veiculo.getCor());
			

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
	public void alterar(Veiculo veiculo) {

		String sql = "UPDATE USUARIO SET modelo = ?, ano = ?, cor = ? where marca = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setString(3, veiculo.getAno());
			ps.setString(4, veiculo.getCor());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Veiculo veiculo) {

		String sql = "DELETE FROM VEICULO WHERE marca = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getMarca());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o cpf
	 */
	public Veiculo pesquisar(String marca) {

		String sql = "select U.MARCA, U.MODELO, U.ANO, U.COR from VEICULO U where marca = ?";
		
		Veiculo veiculo  = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, marca);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				veiculo = new Veiculo();
				veiculo.setMarca(res.getString("MARCA"));
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setAno(res.getString("ANO"));
				veiculo.setCor(res.getString("COR"));
				 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veiculo;
	}

	/**
	 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a
	 * consulta pelo objeto direto assim from Usuario, que isso é o objeto usuario e
	 * não a tabela
	 */
	public List<Veiculo> listarTodos() {

		String sql = "select U.MARCA, U.MODELO, U.ANO from VEICULO U";
		
		List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Veiculo veiculo = new Veiculo();
				
				veiculo.setMarca(res.getString("MARCA"));
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setAno(res.getString("ANO"));
				veiculo.setCor(res.getString("COR"));
				listaVeiculo.add(veiculo);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return veiculos;
		return null;

	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	

}
