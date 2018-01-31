package supermercado.controller.comandos.entregador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.EntregadorDAO;
import supermercado.models.Entregador;


public class ListarEntregador implements Comando{
public String executa(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		

		EntregadorDAO dao = new EntregadorDAO();

		List<Entregador> entregador = dao.getLista();

		request.setAttribute("entregador", entregador);

		
		return "listar-entregador.jsp";

	}
}
