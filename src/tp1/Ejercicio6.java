package tp1;

import java.util.Iterator;

public class Ejercicio6 {

	public MyLinkedList resolucion (MyLinkedList listA, MyLinkedList listB) {
		MyLinkedList result = new MyLinkedList();
		Object listAElement;
		for (int i = 0; i < listA.size(); i++) {
			listAElement = listA.get(i);
			if (!listB.contains(listAElement)) {
				result.insertFront(listAElement);
			}
		}
		return result;
	}
	
	public MyLinkedList resolucionIterador(MyLinkedList listA, MyLinkedList listB) {
		MyLinkedList result = new MyLinkedList();
		Iterator<Object> iterator = listA.iterator();
		Object listAElement;
		while (iterator.hasNext()) {
			listAElement = iterator.next();
			if (!listB.contains(listAElement)) {
				result.insertFront(listAElement);
			}
		}
		return result;
	}
	
}
