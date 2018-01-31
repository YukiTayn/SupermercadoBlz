package supermercado.controller.comandos.entregador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.EntregadorDAO;
import supermercado.models.Entregador;


public class SelecionarEntregador implements Comando {
		public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			String cpfText = request.getParameter("cpf");
			if (cpfText == null || cpfText.isEmpty() || cpfText.equals("0")) {
				System.out.println("Id inválido");
				return "erro.jsp";
			}

			String cpf = request.getParameter("cpf");
			EntregadorDAO dao = new EntregadorDAO();
			Entregador entregador = dao.getByID(cpf); // ñ consegui resolver (13h 07min ) // consegui resolver (13h 08min)

			if (entregador == null) {
				System.out.println("Entregador nulo");
				return "erro.jsp";
			}
			request.setAttribute("entregador", entregador);
			return "form-alterar.jsp";
		}
}
