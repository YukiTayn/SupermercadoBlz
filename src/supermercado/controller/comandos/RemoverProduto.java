package supermercado.controller.comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.daos.ProdutoDAO;
import supermercado.models.Produtos;

public class RemoverProduto implements Comando{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		long iddq = Long.parseLong(id);
		
		Produtos p = new Produtos();
		p.setId(iddq);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.remover(p);
		
		return "supermercado?logica=ListarProdutos";
	}

}
