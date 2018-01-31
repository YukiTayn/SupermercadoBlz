package sm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sm.models.Vendas;


public class VendasDAO {

	private Connection connection;

	public VendasDAO() {
		connection = ConnectionFactory.getConnection();
	}

	DadosDAO ddao = new DadosDAO();
	long aux = 0;
	
	public List<Vendas> getVendas() {
		List<Vendas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from vendas;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				long aux = 0;

				Vendas v = new Vendas();
				v.setId(rs.getLong("id"));
				v.setUsuario(rs.getLong("id_user"));				
				v.setVendedor(rs.getLong("id_vend"));
				v.setProduto(rs.getLong("id_produto"));
				v.setQtd(rs.getLong("qtd"));
				v.setValor(rs.getFloat("valor"));

				aux = rs.getLong("id_user");
				DadosDAO ddao = new DadosDAO();
				String yoo = ddao.nameByID(aux);
				v.setUserTXT(yoo);

				aux = rs.getLong("id_produto");
				ProdutoDAO dao = new ProdutoDAO();
				String hey = dao.getName(aux);
				v.setProdTXT(hey);

				aux = rs.getLong("id_vend");
				if(aux > 0 && aux < 999999) {
					String xd = ddao.nameByID(aux);
					v.setVendTXT(xd);
				}else {
					String xd = "#Online#";
					v.setVendTXT(xd);
				}
				

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataVenda"));
				v.setDataVenda(data);

				result.add(v);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public List<Vendas> getVendasByID(Long id) {
		List<Vendas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from vendas where id_user = ? and id_vend is not null;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Vendas v = new Vendas();
				v.setId(rs.getLong("id"));
				v.setUsuario(rs.getLong("id_user"));
				v.setVendedor(rs.getLong("id_vend"));
				v.setProduto(rs.getLong("id_produto"));
				v.setQtd(rs.getLong("qtd"));
				v.setValor(rs.getFloat("valor"));

				ProdutoDAO dao = new ProdutoDAO();
				String hey = dao.getName(id);
				v.setProdTXT(hey);
				

				aux = rs.getLong("id_vend");
				String xd = ddao.nameByID(aux);
				v.setVendTXT(xd);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataVenda"));
				v.setDataVenda(data);

				result.add(v);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public List<Vendas> getVendasVend(Long id) {
		List<Vendas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from vendas where id_vend = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				long aux = 0;

				Vendas v = new Vendas();
				v.setId(rs.getLong("id"));
				v.setUsuario(rs.getLong("id_user"));
				v.setVendedor(rs.getLong("id_vend"));
				v.setProduto(rs.getLong("id_produto"));
				v.setQtd(rs.getLong("qtd"));
				v.setValor(rs.getFloat("valor"));

				aux = rs.getLong("id_user");
				DadosDAO ddao = new DadosDAO();
				String yoo = ddao.nameByID(aux);
				v.setUserTXT(yoo);

				aux = rs.getLong("id_produto");
				ProdutoDAO dao = new ProdutoDAO();
				String hey = dao.getName(aux);
				v.setProdTXT(hey);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataVenda"));
				v.setDataVenda(data);

				result.add(v);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public List<Vendas> getVendasOnline(Long id) {
		List<Vendas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from vendas where id_vend is null and id_user = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				long aux = 0;

				Vendas v = new Vendas();
				v.setId(rs.getLong("id"));
				v.setUsuario(rs.getLong("id_user"));
				v.setProduto(rs.getLong("id_produto"));
				v.setQtd(rs.getLong("qtd"));
				v.setValor(rs.getFloat("valor"));

				aux = rs.getLong("id_user");
				DadosDAO ddao = new DadosDAO();
				String yoo = ddao.nameByID(aux);
				v.setUserTXT(yoo);

				aux = rs.getLong("id_produto");
				ProdutoDAO dao = new ProdutoDAO();
				String hey = dao.getName(aux);
				v.setProdTXT(hey);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataVenda"));
				v.setDataVenda(data);

				result.add(v);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}
	
	public boolean newVenda(Vendas v) {
		
		String sql = "insert into vendas(id_user,id_vend,id_produto,qtd,valor,dataVenda) value(?,?,?,?,?,?);";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, v.getUsuario());
			stmt.setLong(2, v.getVendedor());
			stmt.setLong(3, v.getProduto());
			stmt.setLong(4, v.getQtd());
			stmt.setFloat(5, v.getValor());
			stmt.setDate(6, new java.sql.Date(v.getDataVenda().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
		return true;
	}
	
	public boolean newVendaOnline(Vendas v) {
		
		String sql = "insert into vendas(id_user,id_produto,qtd,valor,dataVenda) value(?,?,?,?,?);";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, v.getUsuario());
			stmt.setLong(2, v.getProduto());
			stmt.setLong(3, v.getQtd());
			stmt.setFloat(4, v.getValor());
			stmt.setDate(5, new java.sql.Date(v.getDataVenda().getTimeInMillis()));
			
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
