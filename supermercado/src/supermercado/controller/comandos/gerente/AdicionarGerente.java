package supermercado.controller.comandos.gerente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.daos.GerenteDAO;
import supermercado.models.Gerente;

public class AdicionarGerente {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		Long idade = Long.parseLong("idade");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");

		Gerente g = new Gerente();

		g.setCpf(cpf);
		g.setNome(nome);
		g.setIdade(idade);
		g.setTelefone(telefone);
		g.setEndereco(endereco);
		g.setEmail(email);

		GerenteDAO dao = new GerenteDAO();
		dao.inserir(g);

		return "gerente-adicionado.jsp";
	}
}
