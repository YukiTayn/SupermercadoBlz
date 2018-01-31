package supermercado.controller.comandos.entregador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.EntregadorDAO;
import supermercado.models.Entregador;

public class RemoverEntregador implements Comando{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cpf = request.getParameter("cpf");
		
		Entregador e = new Entregador();
		EntregadorDAO dao = new EntregadorDAO();
		dao.remover(e);
		

		return "supermercado?logica=ListarEntregador";

	}
}
