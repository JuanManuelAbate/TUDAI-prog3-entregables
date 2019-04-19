package tp2;

//ejercicio 6
public class ArbolBinario {

	private NodeBinario first;
	
	public ArbolBinario() {
		first = null;
	}
	
	//Complejidad O(n), en el peor de los casos trabajara como una lista.
	public void insert(int nuevoValor) {
		if (first == null) {
			NodeBinario nb = new NodeBinario(nuevoValor);
			first = nb;
		}
		else {
			NodeBinario tmp = first;
			insertPrivado(tmp,nuevoValor);
		}
	}
	
	private void insertPrivado(NodeBinario ref, int nuevoValor) {
		if (nuevoValor > ref.getValor()) {
			if (ref.getDerecho() == null) {
				NodeBinario nb = new NodeBinario(nuevoValor);
				ref.setDerecho(nb);
			}
			else {
				insertPrivado(ref.getDerecho(), nuevoValor);
			}
		}
		else {
			if (ref.getIzquierdo() == null) {
				NodeBinario nb = new NodeBinario(nuevoValor);
				ref.setIzquierdo(nb);
			}
			else {
				insertPrivado(ref.getIzquierdo(), nuevoValor);
			}
		}
	}
	
	//Complejidad O(n) visita todos los nodos siempre.
	public MyLinkedList getFrontera() {
		NodeBinario tmp = first;
		MyLinkedList resultado = new MyLinkedList();
		getFronteraPrivate(resultado, tmp);
		return resultado;
	}
	
	private void getFronteraPrivate(MyLinkedList resultado, NodeBinario nb) {
		if (nb == null) {
			return;
		}
		if (nb.getIzquierdo() == null && nb.getDerecho() == null) {
			resultado.insertFront(nb.getValor());
		}
		else {
			getFronteraPrivate(resultado, nb.getDerecho());
			getFronteraPrivate(resultado, nb.getIzquierdo());
		}
	}
	
}
