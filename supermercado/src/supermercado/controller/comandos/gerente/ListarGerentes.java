package supermercado.controller.comandos.gerente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.daos.GerenteDAO;
import supermercado.models.Gerente;

public class ListarGerentes {

public String executa(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		GerenteDAO dao = new GerenteDAO();

		List<Gerente> gerente = dao.getLista();

		request.setAttribute("gerente", gerente);

		return "listarGerente.jsp";

	}
}
