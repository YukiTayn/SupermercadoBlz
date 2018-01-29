package supermercado.controller.comandos.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ClienteDAO;
import supermercado.models.Cliente;


public class SelecionarCliente implements Comando{
public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cpfText = request.getParameter("cpf");
		if (cpfText == null || cpfText.isEmpty() || cpfText.equals("0")) {
			System.out.println("Id inválido");
			return "erro.jsp";
		}

		String cpf = request.getParameter("cpf");
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.getByID(cpf); // ñ consegui resolver (13h 07min ) // consegui resolver (13h 08min)

		if (cliente == null) {
			System.out.println("Cliente nulo");
			return "erro.jsp";
		}
		request.setAttribute("cliente", cliente);
		return "form-alterar.jsp";
	}
}


