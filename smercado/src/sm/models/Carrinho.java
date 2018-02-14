package sm.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrinho {

	private List<Produto> prod = new ArrayList<>();
	private long usuario;
	private long vendedor;
	private long produto;
	private long preco;
	private long qtd;
	private float valor;

	public void add(Produto p){
        prod.add(p);
    }

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	public long getVendedor() {
		return vendedor;
	}

	public void setVendedor(long vendedor) {
		this.vendedor = vendedor;
	}

	public long getProduto() {
		return produto;
	}

	public void setProduto(long produto) {
		this.produto = produto;
	}

	public long getPreco() {
		return preco;
	}

	public void setPreco(long preco) {
		this.preco = preco;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = preco * qtd;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataVenda;

}
