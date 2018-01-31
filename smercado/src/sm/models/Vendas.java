package sm.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Vendas {

	private long id;
	private long usuario;
	private long vendedor;
	private long produto;
	private long qtd;
	private float valor;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataVenda;
	private String prodTXT;
	private String userTXT;
	private String vendTXT;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		this.valor = valor;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getProdTXT() {
		return prodTXT;
	}

	public void setProdTXT(String prodTXT) {
		this.prodTXT = prodTXT;
	}

	public String getUserTXT() {
		return userTXT;
	}

	public void setUserTXT(String userTXT) {
		this.userTXT = userTXT;
	}

	public String getVendTXT() {
		return vendTXT;
	}

	public void setVendTXT(String vendTXT) {
		this.vendTXT = vendTXT;
	}

}