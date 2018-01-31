package supermercado.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import supermercado.models.Atendente;



public class AtendenteDAO {
	
		private Connection connection;

		public AtendenteDAO() {
			connection = ConnectionFactory.getConnection();
		}

		public boolean inserir(Atendente atendente) {

			String sql = "insert into atendente(nome, idade, cpf, endereco, email) " + "values (?, ?, ?, ?, ?);";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, atendente.getCpf());
				stmt.setString(2, atendente.getNome());
				stmt.setLong(3, atendente.getIdade());
				stmt.setString(4, atendente.getEndereco());
				stmt.setString(5, atendente.getEmail());
				

				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public List<Atendente> getLista() {
			List<Atendente> result = new ArrayList<>();

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from atendente;");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Atendente a = new Atendente();
					a.setCpf(rs.getString("cpf"));
					a.setNome(rs.getString("nome"));
					a.setIdade(rs.getLong("idade"));
					a.setEndereco(rs.getString("endereco"));
					a.setEmail(rs.getString("email"));
					
					

					// adicionando o objeto à lista
					result.add(a);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}

		public boolean alterar(Atendente atendente) {
			String sql = "update atendente set nome=?, email=?, endereco=?, idade=? where cpf=?;";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, atendente.getCpf());
				stmt.setString(2, atendente.getNome());
				stmt.setString(3, atendente.getEmail());
				stmt.setString(4, atendente.getEndereco());
				stmt.setLong(5, atendente.getIdade());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean remover(Atendente atendente) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from atendente where cpf=?;");
				stmt.setString(1, atendente.getCpf());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public Atendente getByID(String cpf) {
			Atendente result = null;

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from atendente where cpf = ?;");
				stmt.setString(1, cpf);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					// criando o objeto Contato
					result = new Atendente();
					result.setCpf(rs.getString("cpf"));
					result.setNome(rs.getString("nome"));
					result.setIdade(rs.getLong("idade"));
					result.setEmail(rs.getString("email"));
					result.setEndereco(rs.getString("endereco"));

					
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}
	}

