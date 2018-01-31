package sm.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Entregas {

	private long id;
	private long gerente;
	private long entregador;
	private long produto;
	private long qtd;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataPedido;
	private Calendar dataEntrega;
	private int stt;

	private String produtotxt;
	private String gerentetxt;
	private String enttxt;
	private String stttxt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGerente() {
		return gerente;
	}

	public void setGerente(long gerente) {
		this.gerente = gerente;
	}

	public long getEntregador() {
		return entregador;
	}

	public void setEntregador(long entregador) {
		this.entregador = entregador;
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

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getProdutotxt() {
		return produtotxt;
	}

	public void setProdutotxt(String produtotxt) {
		this.produtotxt = produtotxt;
	}

	public String getGerentetxt() {
		return gerentetxt;
	}

	public void setGerentetxt(String gerentetxt) {
		this.gerentetxt = gerentetxt;
	}

	public String getEnttxt() {
		return enttxt;
	}

	public void setEnttxt(String enttxt) {
		this.enttxt = enttxt;
	}

	public String getStttxt() {
		return stttxt;
	}

	public void setStttxt(String stttxt) {
		this.stttxt = stttxt;
	}

}