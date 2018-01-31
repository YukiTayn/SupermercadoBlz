package supermercado.controller.comandos.atendente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.AtendenteDAO;
import supermercado.models.Atendente;

public class ListarAtendente implements Comando {

	public String executa(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		

		AtendenteDAO dao = new AtendenteDAO();

		List<Atendente> atendente = dao.getLista();

		request.setAttribute("atendente", atendente);

		
		return "listar.jsp";

	}
}
