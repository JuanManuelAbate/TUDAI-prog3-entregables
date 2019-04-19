package tp2;

import java.util.Iterator;

public class MyLinkedList implements Iterable<Object>{ 
	
	private Node first;
	private int size;
	
	public MyLinkedList() { 
		first = null;
		size = 0;
	}
	
	@Override
	public Iterator<Object> iterator() {
		return new MyIterator(first);
	}

	public void insertFront(Object o) { 
		Node tmp = new Node(o, null); 
		tmp.setNext(first);
		first = tmp;
		size = size + 1;
	}
	
	//saca el primero y lo devuelve
	public Object extractFront() { 
		Object frontValue = first.getInfo();
		first = first.getNext();
		size = size - 1;
		return frontValue;
	} 
	
	//imprime por pantalla los primeros n
	public void print(int n) {
		Node tmp = first;
		for (int i = 0; i < n; i++) {
			System.out.println(tmp.getInfo());
			tmp = tmp.getNext();
		}
	} 
	
	//se fija si esta vacia
	public boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}
	
	//devuelve el tamaño
	public int size () {
		return size;
	}
	
	//devuelve el valor del index
	public Object get(int index) {
		Node tmp = first;
		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}
		return tmp.getInfo();
	}
	
	//Se fija si un elemento esta contenido en la lista O(n)
	public boolean contains(Object elem) {
		Node tmp = first;
		boolean result = false;
		for (int i = 0; i < size; i++) {
			if (tmp.getInfo().equals(elem)) {
				result = true;
				break;
			}
			tmp = tmp.getNext();
		}
		return result;
	}
	
	//Por casos practicos solo funciona para listas de int.
	public void insertOrder(Object e) {
		int elem = (int) e;
		if (first == null || (int) first.getInfo() >= elem) {
			insertFront(elem);
		}
		else {
			Node tmp = first;
			while ( tmp.getNext() != null && (int) tmp.getNext().getInfo() < elem) {
				tmp = tmp.getNext();
			}
			Node newNode = new Node();
			newNode.setInfo(elem);
			newNode.setNext(tmp.getNext());
			tmp.setNext(newNode);
		}			
	}
	
	//ejercicio 2 complejidad de O(n)
	public boolean containsRecursivo(Object elem) {
		Node tmp = first;
		return containsRecursivoInterno(tmp,elem);
	}
	
	private boolean containsRecursivoInterno(Node puntero, Object elem) {
		if (puntero == null) {
			return false;
		}
		else {
			if (puntero.getInfo().equals(elem)) {
				return true;
			}
			else
				return containsRecursivoInterno(puntero.getNext(), elem);
		}
	}

}