package supermercado.controller.comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.daos.AtendenteDAO;
import supermercado.models.Atendente;

public class SelecionarAtendente implements Comando {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cpfText = request.getParameter("cpf");
		if (cpfText == null || cpfText.isEmpty() || cpfText.equals("0")) {
			System.out.println("Id inválido");
			return "erro.jsp";
		}

		String cpf = request.getParameter("cpf");
		AtendenteDAO dao = new AtendenteDAO();
		Atendente atendente = dao.getByID(cpf); // ñ consegui resolver (13h 07min ) // consegui resolver (13h 08min)

		if (atendente == null) {
			System.out.println("Atendente nulo");
			return "erro.jsp";
		}
		request.setAttribute("atendente", atendente);
		return "form-alterar.jsp";
	}
}
