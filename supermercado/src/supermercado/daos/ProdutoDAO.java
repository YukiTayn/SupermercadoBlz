package supermercado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import supermercado.models.Produtos;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public List<Produtos> getLista() {
		List<Produtos> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Produtos p = new Produtos();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				// p.setDataValidade(rs.getDate(columnIndex));
				p.setTipo(rs.getString("tipo"));
				p.setQuantidade(rs.getLong("quantidade"));

				result.add(p);
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public boolean inserir(Produtos p) {

		String sql = "insert into produto(nome, marca, dataValidade, tipo, quantidade) values(?,?,?,?,?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getMarca());
			stmt.setDate(3, new java.sql.Date(p.getDataValidade().getTimeInMillis()));
			stmt.setString(4, p.getTipo());
			stmt.setLong(5, p.getQuantidade());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean remover(Produtos p) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produto where id = ?;");
			stmt.setLong(1, p.getId());
			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Produtos getByID(Long id) {
		Produtos result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Produtos();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setMarca(rs.getString("marca"));
				result.setTipo(rs.getString("tipo"));
				result.setQuantidade(rs.getLong("quantidade"));

				Calendar validade = Calendar.getInstance();
				validade.setTime(rs.getDate("dataValidade"));
				result.setDataValidade(validade);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean alterar(Produtos p) {

		String sql = "update produto set nome=?, marca=?, tipo=?, quantidade=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getMarca());
			stmt.setString(3, p.getTipo());
			stmt.setLong(4, p.getQuantidade());
			stmt.setLong(5, p.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}