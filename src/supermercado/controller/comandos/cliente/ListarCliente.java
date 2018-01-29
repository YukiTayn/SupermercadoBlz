package supermercado.controller.comandos.cliente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ClienteDAO;
import supermercado.models.Cliente;

public class ListarCliente implements Comando{
public String executa(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		

		ClienteDAO dao = new ClienteDAO();

		List<Cliente> cliente = dao.getLista();

		request.setAttribute("cliente", cliente);

		
		return "listar-cliente.jsp";

	}
}
