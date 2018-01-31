package supermercado.controller.comandos.entregador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.EntregadorDAO;
import supermercado.models.Entregador;

public class AlterarEntregador implements Comando{
public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nome = request.getParameter("nome");
		Long idade = Long.parseLong("idade");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		

		Entregador e = new Entregador();
		
		e.setNome(nome);
		e.setIdade(idade);
		e.setEmail(email);
		e.setCpf(cpf);
		e.setEndereco(endereco);
		

		EntregadorDAO dao = new EntregadorDAO();
		dao.alterar(e);

		return "entregador-adicionado.jsp";
	}
}
