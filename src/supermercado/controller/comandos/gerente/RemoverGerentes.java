package supermercado.controller.comandos.gerente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.daos.GerenteDAO;
import supermercado.models.Gerente;

public class RemoverGerentes {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cpf = request.getParameter("cpf");
		
		Gerente g = new Gerente();
		GerenteDAO dao = new GerenteDAO();
		dao.remover(g);
		

		return "supermercado?logica=ListarGerente";

	}
}
