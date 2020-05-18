package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Cleiton
 *
 *	A classe JPAUtil tem a funcionalidade de disponibilizar as EntityManager(conexões com o banco de dados)
 *Também é uma classe sington, só vai existir uma instancia dessa classe no projeto todo 
 *
 */

public class JpaUtil {

	public static Connection getConexao() throws SQLException {

		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "sefaz2", "sefaz2");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	
//	private static EntityManagerFactory factory;
//
//    static {
//        factory = Persistence.createEntityManagerFactory("Sefaz");
//    }
//
//    public static EntityManager getEntityManager() {
//        return factory.createEntityManager();
//    }
//
//    public static void close() {
//        factory.close();
//    }
}
