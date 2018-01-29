package supermercado.controller.comandos.gerente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.GerenteDAO;
import supermercado.models.Gerente;

public class SelecionarGerentes implements Comando {
	
		public String executa(HttpServletRequest request, HttpServletResponse response)  throws Exception {
			String cpfText = request.getParameter("cpf");
			if(cpfText==null || cpfText.isEmpty() || cpfText.equals("0")){
				System.out.println("Cpf inválido");
				return "erro.jsp";
			}
			
			String cpf = request.getParameter("cpf");
			GerenteDAO dao = new GerenteDAO();
			Gerente gerente = dao.getByCpf(cpf);  // ñ consegui resolver (13h 07min ) // consegui resolver (13h 08min)
			
			if(gerente == null){
				System.out.println("gerente nulo");
				return "erro.jsp";
			}
			request.setAttribute("gerente", gerente);
			return "form-alterar.jsp";
		}
}
