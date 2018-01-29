package supermercado.controller.comandos.gerente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.daos.GerenteDAO;
import supermercado.models.Gerente;

public class AlterarGerente {
public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		Long idade = Long.parseLong("idade");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		

		Gerente g = new Gerente();
		
		g.setCpf(cpf);
		g.setNome(nome);
		g.setIdade(idade);
		g.setTelefone(telefone);
		g.setEndereco(endereco);
		g.setEmail(email);
		
		GerenteDAO dao = new GerenteDAO();
		dao.alterar(g);

		return "gerente-alterado.jsp";
	}
}
