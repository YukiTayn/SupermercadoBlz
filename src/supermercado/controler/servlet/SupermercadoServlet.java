package supermercado.controler.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;



@WebServlet("/supermercado")
public class SupermercadoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resposta = "erro.jsp";
		Comando comando = null;
		
		try {
			String logica = request.getParameter("logica");
			String nomeClasse = "supermercado.controller.comandos." + logica;
			Class n = Class.forName(nomeClasse);
			
			comando = (Comando) n.newInstance();
			resposta = comando.executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(resposta);
		rd.forward(request, response);
	}
}
