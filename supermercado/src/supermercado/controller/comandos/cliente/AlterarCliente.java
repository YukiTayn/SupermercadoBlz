package supermercado.controller.comandos.cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ClienteDAO;
import supermercado.models.Cliente;


public class AlterarCliente implements Comando{
public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		Long idade = Long.parseLong("idade");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;


		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cliente c = new Cliente();
		c.setCpf(cpf);
		c.setNome(nome);
		c.setIdade(idade);
		c.setTelefone(telefone);
		c.setEndereco(endereco);
		c.setEmail(email);
		c.setDatanascimento(dataNascimento);

		ClienteDAO dao = new ClienteDAO();
		dao.alterar(c);

		return "contato-adicionado.jsp";
	}
}
