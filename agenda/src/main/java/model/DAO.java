package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "123456";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Teste conexao.
	 */
	public void testeConexao() {
		try {
			Connection conn = conectar();
			System.out.println(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inserir contatos.
	 *
	 * @param contato the contato
	 */
	public void inserirContatos(JavaBeans contato) {
		String create = "insert into contatos(nome,fone,email) values(?,?,?);";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the list
	 */
	public List<JavaBeans> listarContatos() {
		List<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			conn.close();

		} catch (SQLException e) {
			e.getMessage();
		}

		return contatos;
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where id = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome = ?, fone = ?, email = ? where id = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where id = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
