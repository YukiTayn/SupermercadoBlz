package supermercado.controller.comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}
