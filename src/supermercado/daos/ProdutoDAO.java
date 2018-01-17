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

		public boolean inserir(Produtos produto) {

			String sql = "insert into contatos (nome, email, endereco, dataNascimento) " + "values (?, ?, ?, ?);";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setLong(1, produto.getId());
				stmt.setString(2, produto.getNome());
				stmt.setString(3, produto.getMarca());
				stmt.setDate(4, new java.sql.Date(produto.getDataValidade().getTimeInMillis()));
				stmt.setString(5, produto.getTipo());
				
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public List<Produtos> getLista() {
			List<Produtos> result = new ArrayList<>();

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Produtos p = new Produtos();
					p.setId(rs.getLong("id"));
					p.setNome(rs.getString("nome"));
					p.setMarca(rs.getString("email"));
					p.setTipo(rs.getString("tipo"));

					// montando a data através do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataValidade"));
					p.getDataValidade();

					// adicionando o objeto à lista
					result.add(p);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}

		public boolean alterar(Produtos produto) {
			String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, produto.getId());
				stmt.setString(2, produto.getNome());
				stmt.setString(3, produto.getMarca());
				stmt.setString(4, produto.getTipo());
				stmt.setDate(5, new java.sql.Date(produto.getDataValidade().getTimeInMillis()));
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean remover(Produtos produto) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
				stmt.setLong(1, produto.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public Produtos getByID(Long id) {
			Produtos result = null;

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?;");
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					// criando o objeto Contato
					result = new Produtos();
					result.setId(rs.getLong("id"));
					result.setNome(rs.getString("nome"));
					result.setMarca(rs.getString("marca"));
					 
					// montando a data através do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataValidade"));
					result.setDataValidade(data);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}
	}

