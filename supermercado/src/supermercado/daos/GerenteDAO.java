package supermercado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import supermercado.models.Gerente;

public class GerenteDAO {

	private Connection connection;

	public GerenteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Gerente gerente) {

		String sql = "insert into gerente(cpf, nome, idade, telefone, email, endereco) " + "values (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, gerente.getCpf());
			stmt.setString(2, gerente.getNome());
			stmt.setLong(3, gerente.getIdade());
			stmt.setString(4, gerente.getTelefone());
			stmt.setString(5, gerente.getEmail());
			stmt.setString(6, gerente.getEndereco());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Gerente> getLista() {
		List<Gerente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from gerente");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto gerente
				Gerente g = new Gerente();
				g.setCpf(rs.getString("cpf"));
				g.setNome(rs.getString("nome"));
				g.setIdade(rs.getLong("idade"));
				g.setTelefone(rs.getString("telefone"));
				g.setEmail(rs.getString("email"));
				g.setEndereco(rs.getString("endereco"));
				

				// montando a data através do Calendar
				
				// adicionando o objeto à lista
				result.add(g);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Gerente gerente) {
		String sql = "update gerente set nome=?, idade=?, telefone=?, email=?, endereco=?, where cpf=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, gerente.getCpf());
			stmt.setString(2, gerente.getNome());
			stmt.setLong(3, gerente.getIdade());
			stmt.setString(4, gerente.getTelefone());
			stmt.setString(5, gerente.getEmail());
			stmt.setString(6, gerente.getEndereco());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Gerente gerente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from gerente where cpf=?");
			stmt.setString(1, gerente.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Gerente getByCpf(String cpf){
		
		Gerente result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from gerente where cpf = ?;");
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Gerente
				result = new Gerente();
				result.setCpf(rs.getString("cpf"));
				result.setNome(rs.getString("nome"));
				result.setIdade(rs.getLong("idade"));
				result.setTelefone(rs.getString("telefone"));
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


