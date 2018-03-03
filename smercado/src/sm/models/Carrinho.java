package sm.models;

public class Carrinho {

	private int indice;
	private String produto;
	private long quantidade;
	private long qCompra;
	private float preco;
	private float total;


	public long getqCompra() {
		return qCompra;
	}

	public void setqCompra(long qCompra) {
		this.qCompra = qCompra;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(long quantidade, float preco) {
		this.total = quantidade * preco;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
