package supermercado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import supermercado.models.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Cliente cliente) {

		String sql = "insert into cliente (nome, idade, cpf, endereco, email) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setLong(2, cliente.getIdade());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(5, cliente.getEndereco());
			stmt.setString(4, cliente.getEmail());
			

			stmt.setDate(5, new java.sql.Date(cliente.getDatanascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Cliente> getLista() {
		List<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Cliente c = new Cliente();
				
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getLong("idade"));
				c.setCpf(rs.getString("cpf"));
				c.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDatanascimento(data);
				
				c.setEmail(rs.getString("email"));
				


				// adicionando o objeto à lista
				result.add(c);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Cliente cliente) {
		String sql = "update cliente set nome=?,idade=?, endereco=?, email=?, dataNascimento=? where cpf=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setLong(6, cliente.getIdade());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());
			stmt.setDate(5, new java.sql.Date(cliente.getDatanascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Cliente c) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where cpf=?;");
			stmt.setString(1, c.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cliente getByID(String cpf) {
		Cliente result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente where cpf = ?;");
			stmt.setString(1, cpf); // não consegui resolver isso  (09h 00min)   // Agora eu consegui (09h 07min)
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Cliente();
				result.setCpf(rs.getString("cpf"));
				result.setNome(rs.getString("nome"));
				result.setIdade(rs.getLong("idade"));
				result.setEndereco(rs.getString("endereco"));
				result.setEmail(rs.getString("email"));
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDatanascimento(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}