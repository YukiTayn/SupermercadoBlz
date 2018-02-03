package sm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sm.models.Dados;


public class DadosDAO {

	private Connection connection;

	public DadosDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	
	public List<Dados> getLista(){
		List<Dados> result = new ArrayList<>();
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from dados;");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Dados d = new Dados();
				d.setId(rs.getLong("id"));
				d.setNome(rs.getString("nome"));
				d.setCpf(rs.getString("cpf"));
				d.setEmail(rs.getString("email"));
				d.setTelefone(rs.getString("telefone"));
				d.setTipo(rs.getInt("tipo"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				d.setDataNascimento(data);
				
				result.add(d);
				
			}
			
			rs.close();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int getTipo(String email, String senha) {
		int aux = 0;

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select tipo from dados where email=? and senha=?;");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aux = rs.getInt("tipo");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return aux;
	}
	
	public int getID(String email) {
		int aux = 1;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select id from dados where email = ?;");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				aux = rs.getInt("id");
			}
			
			rs.close();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return aux;
	}
		
	public String nameByID(Long id) {
		String aux = "";
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select nome from dados where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				aux = rs.getString("nome");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return aux;
	}
	
	public Dados getByID(Long id) {
		Dados result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from dados where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Dados();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setCpf(rs.getString("cpf"));
				result.setEmail(rs.getString("email"));
				result.setSenha(rs.getString("senha"));
				result.setTelefone(rs.getString("telefone"));
				result.setTipo(rs.getInt("tipo"));
				
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(dataNascimento);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean login(String email, String senha) {

		int aux = 0;

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select count(*) as tst from dados where email=? and senha=?;");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aux = rs.getInt("tst");

				if (aux > 0 && aux < 5) {
					return true;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

		return false;
	}
	
	//Funcionais
	public boolean alterar(Dados d) {

		String sql = "update dados set nome=?, cpf=?, email=?, telefone=?, senha=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, d.getNome());
			stmt.setString(2, d.getCpf());
			stmt.setString(3, d.getEmail());
			stmt.setString(4, d.getTelefone());
			stmt.setString(5, d.getSenha());
			stmt.setLong(6, d.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean remover(Dados d) {
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from dados where email = ? and senha = ?;");
			stmt.setString(1, d.getEmail());
			stmt.setString(2, d.getSenha());
			
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
	//Inserir
	public boolean novo(Dados d) {
		
		String sql = "insert into dados(nome, dataNascimento, cpf, email, telefone, senha) value(?,?,?,?,?,?);";
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, d.getNome());
			stmt.setDate(2, new java.sql.Date(d.getDataNascimento().getTimeInMillis()));
			stmt.setString(3, d.getCpf());;
			stmt.setString(4, d.getEmail());
			stmt.setString(5, d.getTelefone());
			stmt.setString(6, d.getSenha());
			
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
}
