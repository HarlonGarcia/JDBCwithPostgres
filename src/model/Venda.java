package model;

public class Venda {
	private int id;
	private int id_vendedor;
	private int codigo_camisa;
	private double valor;
	private int quantidade;
	
	public int getId_vendedor() {
		return id_vendedor;
	}
	
	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
	}
	
	public int getCodigo_camisa() {
		return codigo_camisa;
	}
	
	public void setCodigo_camisa(int codigo_camisa) {
		this.codigo_camisa = codigo_camisa;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}