package supermercado.models;

import java.util.Calendar;

public class Produtos {

	Long id;
	String nome;
	String marca;
	Calendar dataValidade;
	String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
