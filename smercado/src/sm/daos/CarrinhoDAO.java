package sm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sm.models.Carrinho;

public class CarrinhoDAO {

	private Connection connection;
	
	public CarrinhoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public Carrinho getCar(Long id) {
		Carrinho result = null;
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from produto where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = new Carrinho();
				result.setProduto(rs.getString("nome"));
				result.setPreco(rs.getFloat("preco"));
				result.setQuantidade(rs.getLong("quantidade"));
				//result.setTotal(result.getQuantidade(), result.getPreco());
			}
			
			rs.close();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public long getProdId(String produto) {
		
		long aux = 0;
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select id from produto where nome = ?;");
			stmt.setString(1, produto);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				aux = rs.getLong("id");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return aux;
	}
}
