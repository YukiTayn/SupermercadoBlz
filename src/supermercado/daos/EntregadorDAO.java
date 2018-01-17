package supermercado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import supermercado.models.Entregador;
public class EntregadorDAO {
	
private Connection connection;

		public EntregadorDAO() {
			connection = ConnectionFactory.getConnection();
		}

		public boolean inserir(Entregador entregador) {

			String sql = "insert into contatos (nome, email, endereco, dataNascimento) " + "values (?, ?, ?, ?);";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, entregador.getCpf());
				stmt.setString(2, entregador.getNome());
				stmt.setLong(3, entregador.getIdade());
				stmt.setString(4, entregador.getEmail());
				stmt.setString(5, entregador.getEndereco());

				
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public List<Entregador> getLista() {
			List<Entregador> result = new ArrayList<>();

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Entregador e = new Entregador();
					e.setCpf(rs.getString("cpf"));
					e.setNome(rs.getString("nome"));
					e.setIdade(rs.getLong("idade"));
					e.setEmail(rs.getString("email"));
					e.setEndereco(rs.getString("endereco"));

					

					// adicionando o objeto à lista
					result.add(e);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}

		public boolean alterar(Entregador entregador) {
			String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, entregador.getCpf());
				stmt.setString(2, entregador.getNome());
				stmt.setLong(5, entregador.getIdade());
				stmt.setString(3, entregador.getEmail());
				stmt.setString(4, entregador.getEndereco());
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean remover(Entregador entregador) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from contatos where cpf=?");
				stmt.setString(1, entregador.getCpf());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public Entregador getByID(String cpf) {
			Entregador result = null;

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where cpf = ?;");
				stmt.setString(1, cpf);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					// criando o objeto Contato
					result = new Entregador();
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

