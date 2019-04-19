package tp2;

public class NodeBinario {

	private int valor;
	private NodeBinario izquierdo;
	private NodeBinario derecho;
	
	public NodeBinario(int valor) {
		this.valor = valor;
		this.izquierdo = null;
		this.derecho = null;
	}
	
	public int getValor() {
		return valor;
	}
	
	public NodeBinario getIzquierdo() {
		return izquierdo;
	}
	
	public void setIzquierdo(NodeBinario izquierdo) {
		this.izquierdo = izquierdo;
	}
	
	public NodeBinario getDerecho() {
		return derecho;
	}
	
	public void setDerecho(NodeBinario derecho) {
		this.derecho = derecho;
	}
	
}
