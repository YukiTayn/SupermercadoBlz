package supermercado.controller.comandos.produto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ProdutoDAO;
import supermercado.models.Produtos;

public class AdicionarProduto implements Comando{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String tipo = request.getParameter("tipo");
		
		String quantidade = request.getParameter("quantidade");
		long qtde = Long.parseLong(quantidade);
		
		Calendar validade = null;
		String dataTXT = request.getParameter("validade");
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTXT);
			validade = Calendar.getInstance();
			validade.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Produtos p = new Produtos();
		p.setNome(nome);
		p.setMarca(marca);
		p.setTipo(tipo);
		p.setQuantidade(qtde);
		p.setDataValidade(validade);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.inserir(p);
		
		return "supermercado?logica=ListarProdutos";
	}

}
