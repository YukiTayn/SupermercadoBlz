package supermercado.controller.comandos.atendente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.AtendenteDAO;
import supermercado.models.Atendente;

public class RemoverAtendente implements Comando {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cpf = request.getParameter("cpf");
		
		Atendente a = new Atendente();
		AtendenteDAO dao = new AtendenteDAO();
		dao.remover(a);
		

		return "supermercado?logica=ListarAtendente";

	}
}
