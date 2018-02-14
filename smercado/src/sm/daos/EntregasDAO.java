package sm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sm.models.Entregas;


public class EntregasDAO {
	private Connection connection;

	public EntregasDAO() {
		connection = ConnectionFactory.getConnection();
	}

	ProdutoDAO pdao = new ProdutoDAO();
	DadosDAO ddao = new DadosDAO();
	
	
	public List<Entregas> getEnt(){
		List<Entregas> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from entregas;");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));
				
				result.add(e);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	

	public List<Entregas> Abertas() {
		List<Entregas> result = new ArrayList<>();

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from entregas where dataEntrega is null and stt = 1;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				long aux = 0;

				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				e.setStttxt("Aberto");

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data);

				result.add(e);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	public List<Entregas> Pegas() {
		List<Entregas> result = new ArrayList<>();

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from entregas where dataEntrega is null  and stt = 2;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				long aux = 0;

				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				e.setStttxt("Pego");

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data);

				result.add(e);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	public List<Entregas> Concluidos() {
		List<Entregas> result = new ArrayList<>();

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from entregas where dataEntrega is not null and stt = 3;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data1);

				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("dataEntrega"));
				e.setDataEntrega(data2);

				long aux = 0;
				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				e.setStttxt("Concluidos");

				result.add(e);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	public List<Entregas> Negados() {
		List<Entregas> result = new ArrayList<>();

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from entregas where dataEntrega is not null and stt = 4;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data1);

				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("dataEntrega"));
				e.setDataEntrega(data2);

				long aux = 0;
				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				e.setStttxt("Negados");

				result.add(e);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	
	
	
	public List<Entregas> getEntAbID(Long id) {
		List<Entregas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from entregas where id_entregador = ? and dataEntrega is null and stt = 1;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data1);

				long aux = 0;
				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				result.add(e);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public List<Entregas> getEntPgID(Long id) {
		List<Entregas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from entregas where id_entregador = ? and dataEntrega is null and stt = 2;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data1);

				long aux = 0;
				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				result.add(e);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public List<Entregas> getEntConcID(Long id) {
		List<Entregas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from entregas where id_entregador = ? and dataEntrega is not null and stt = 3;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data1);

				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("dataEntrega"));
				e.setDataEntrega(data2);

				long aux = 0;
				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				result.add(e);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	public List<Entregas> getEntNegID(Long id) {
		List<Entregas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from entregas where id_entregador = ? and dataEntrega is not null and stt = 4;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Entregas e = new Entregas();
				e.setId(rs.getLong("id"));
				e.setGerente(rs.getLong("id_gerente"));
				e.setEntregador(rs.getLong("id_entregador"));
				e.setProduto(rs.getLong("id_produto"));
				e.setQtd(rs.getLong("qtd"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("dataPedido"));
				e.setDataPedido(data1);

				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("dataEntrega"));
				e.setDataEntrega(data2);

				long aux = 0;
				aux = rs.getLong("id_produto");
				String hey = pdao.getName(aux);
				e.setProdutotxt(hey);

				aux = rs.getLong("id_entregador");
				String yoo = ddao.nameByID(aux);
				e.setEnttxt(yoo);

				aux = rs.getLong("id_gerente");
				String xd = ddao.nameByID(aux);
				e.setGerentetxt(xd);

				result.add(e);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}

	
	
	
	public boolean FecharEntrega(long id) {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("update entregas set dataEntrega = ?, stt = 3 where id = ?;");

			Calendar aux = Calendar.getInstance();
			stmt.setDate(1, new java.sql.Date(aux.getTimeInMillis()));
			stmt.setLong(2, id);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}

		return true;
	}

	public boolean CancelarEntrega(long id) {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("update entregas set dataEntrega = ?, stt = 4 where id = ?;");

			Calendar aux = Calendar.getInstance();
			stmt.setDate(1, new java.sql.Date(aux.getTimeInMillis()));
			stmt.setLong(2, id);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}

		return true;
	}

	public boolean PegarEntrega(long id) {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("update entregas set stt = 2 where id = ?;");

			stmt.setLong(1, id);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}

		return true;
	}

	public boolean PedirEntrega(Entregas ent) {
		
		String sql = "insert into entregas(id_gerente, id_entregador, id_produto, qtd, dataPedido, stt) value(?,?,?,?,?,1);";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, ent.getGerente());
			stmt.setLong(2, ent.getEntregador());
			stmt.setLong(3, ent.getProduto());
			stmt.setLong(4, ent.getQtd());
			stmt.setDate(5, new java.sql.Date(ent.getDataPedido().getTimeInMillis()));
			
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
