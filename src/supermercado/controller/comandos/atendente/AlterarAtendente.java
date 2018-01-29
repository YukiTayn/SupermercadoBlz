package supermercado.controller.comandos.atendente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.AtendenteDAO;
import supermercado.models.Atendente;

public class AlterarAtendente implements Comando {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nome = request.getParameter("nome");
		Long idade = Long.parseLong("idade");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		

		Atendente a = new Atendente();
		
		a.setNome(nome);
		a.setIdade(idade);
		a.setEmail(email);
		a.setCpf(cpf);
		a.setEndereco(endereco);
		

		AtendenteDAO dao = new AtendenteDAO();
		dao.alterar(a);

		return "atendente-adicionado.jsp";
	}

}
