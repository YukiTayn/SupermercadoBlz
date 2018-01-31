package supermercado.controller.comandos.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ClienteDAO;
import supermercado.models.Cliente;



public class RemoverCliente implements Comando{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cpf = request.getParameter("cpf");
		
		Cliente c = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		dao.remover(c);
		

		return "supermercado?logica=ListarCliente";

	}
}
