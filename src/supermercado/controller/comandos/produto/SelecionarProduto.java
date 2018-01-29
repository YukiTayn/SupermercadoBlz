package supermercado.controller.comandos.produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ProdutoDAO;
import supermercado.models.Produtos;

public class SelecionarProduto implements Comando{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String idTXT = request.getParameter("id");
		
		if (idTXT == null || idTXT.isEmpty() || idTXT.equals("0")) {
			System.out.println("Id inválido");
			return "erro.jsp";
		}
		
		long id = Long.parseLong(idTXT);
		ProdutoDAO dao = new ProdutoDAO();
		Produtos p = dao.getByID(id);
		
		if(p == null) {
			return "erro.jsp";
		}
		
		request.setAttribute("produto", p);
		
		return "alterarProduto.jsp";
	}

}
