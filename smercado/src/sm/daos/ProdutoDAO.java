package sm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sm.models.Carrinho;
import sm.models.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public List<Produto> getProdutos() {
		List<Produto> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setTipo(rs.getString("tipo"));
				p.setQuantidade(rs.getLong("quantidade"));
				p.setPreco(rs.getFloat("preco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataValidade"));
				p.setDataValidade(data);

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}
	
	public List<Produto> getProdutosValidos() {
		List<Produto> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto where quantidade > 0;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setTipo(rs.getString("tipo"));
				p.setQuantidade(rs.getLong("quantidade"));
				p.setPreco(rs.getFloat("preco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataValidade"));
				p.setDataValidade(data);

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public String getName(long id) {

		String aux = "";

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select nome from produto where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				aux = rs.getString("nome");

			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return aux;
	}
	
	public Produto getProdutoByID(Long id) {
		Produto result = null;
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = new Produto();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setTipo(rs.getString("tipo"));
				result.setQuantidade(rs.getLong("quantidade"));
				result.setPreco(rs.getFloat("preco"));
			}
			rs.close();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public List<Produto> prodByName(String proc){
		List<Produto> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto where nome like ?");
			stmt.setString(1, '%' + proc + '%');
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto p = new Produto();
				p.setNome(rs.getString("nome"));
				p.setTipo(rs.getString("tipo"));
				p.setQuantidade(rs.getLong("quantidade"));
				p.setPreco(rs.getFloat("preco"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataValidade"));
				p.setDataValidade(cal);
				
				result.add(p);
			}
			rs.close();
			stmt.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean inserir(Produto p) {
		
		String sql = "insert into produto(nome, dataValidade, tipo, quantidade, preco) " + 
		"value(?,?,?,?,?);";
				
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setDate(2, new java.sql.Date(p.getDataValidade().getTimeInMillis()));
			stmt.setString(3, p.getTipo());
			stmt.setLong(4, p.getQuantidade());
			stmt.setFloat(5, p.getPreco());
			
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean apagar(long id) {
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("delete from produto where id = ?");
			stmt.setLong(1, id);
			
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
	public long getQtd(long id) {
		
		long aux = 0;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select quantidade from produto where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				aux = rs.getLong("quantidade");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return aux;
	}
	
	public boolean attCompra(long qtd, long compra, long id) {
		
		CarrinhoDAO dao = new CarrinhoDAO();
		
		long aux = qtd - compra;
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("update produto set quantidade = ? where id = ?;");
			stmt.setLong(1, aux);
			stmt.setLong(2, id);
			
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
