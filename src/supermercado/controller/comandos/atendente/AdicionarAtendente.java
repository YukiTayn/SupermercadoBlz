package supermercado.controller.comandos.atendente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.AtendenteDAO;
import supermercado.models.Atendente;


public class AdicionarAtendente implements Comando {

	public String executa(HttpServletRequest request, HttpServletResponse response)  throws Exception{

		String nome = request.getParameter("nome");
		Long idade = Long.parseLong("idade");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");


		Atendente a = new Atendente();
		
		a.setNome(nome);
		a.setIdade(idade);
		a.setCpf(cpf);
		a.setEndereco(endereco);
		a.setEmail(email);
		
		AtendenteDAO dao = new AtendenteDAO();
		dao.inserir(a);

		return "atendente-adicionado.jsp";
	}

}
