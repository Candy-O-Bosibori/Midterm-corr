public class DoublyLinkedList<T>{
	private Node first;
	private Node last;
	private int size;

	private class Node{
		T data;
		Node prev;
		Node next;

		private Node(){
			data = null;
			prev=null;
			next= null;
		}
	}

	public DoublyLinkedList(){
		first = null;
		last = null;
		size = 0;
	}

	public void insertAtIndex(int index, T item){
		if (index< 1 || index>= size -1 || size == 0 ){
			System.outprintln("Bad index");
			return;
		}
		Node current = first;
		for(int i = 0; i< index; i++){
			current = current.next;
		}

		/*
		INITIAL ANSWER : QUESTION 5.2
		*/

		Node insert = new Node();
		insert.data = item;
		insert.next = current.next;
		current.next.prev= insert;
		insert.prev = current;
		size++;

		/*
		REVISED ANSWER
		*/

		Node insert = new Node();
		insert.data = item;
		
		insert.prev = current.prev;
		insert.next = current;
		
		if (current.prev != null) {
		    current.prev.next = insert;
		}
		current.prev = insert;

		size++;
	}

		

		public void removeAllOccurrences(T item){

		/*
		INITIAL ANSWER QUESTION 5.3
		*/

			Node current = first;
			for (int i =0; i < index -1; i ++){
				if (current.next.data == item ){
					current.next= current.next.next;
				}
				else{
					current = current.next
				}
				if(first.data == item){
					first= first.next;
				}
			}


		}

		/*
		REVISED QUESTION 5.3
		*/

		while (first != null && first.data.equals(item)) {
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        size--;
    }

    	Node current = first;
    	while (current != null && current.next != null) {
        	if (current.next.data.equals(item)) {
            	Node toRemove = current.next;
            	current.next = toRemove.next;
            	if (toRemove.next != null) {
                	toRemove.next.prev = current;
        		    }
		        size--;
		        } else {
		            current = current.next;
		        }
    		}
	
}