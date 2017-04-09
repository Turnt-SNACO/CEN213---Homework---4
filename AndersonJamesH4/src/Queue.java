
public class Queue {
	private Node origin=null;
	private Node end=null;
	private int size=0;
	public Queue(){}
	
	/**
	 * <b><i>getSize</i></b> - Gets number of nodes in the queue
	 * <p>
	 * @return <b>int</b>
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * <b><i>enqueue</i></b> - Adds a node to the end of the queue.
	 * <p>
	 * @param node - node to be added
	 * @author james_2pes9af
	 */
	public void enqueue(Node node) {
    	if (origin==null){  
    		origin=node;
    		end=node;
    	}else{
    		Node current = origin;
    		while(current.getNext()!=null){
    			current=current.getNext();
    		}
    		current.setNext(node);
    		node.setPrevious(current);
    		end=node;
    	}
    	size++;
    }
	
	/**
	 * <b><i>dequeue</b></i> - looks ar the first node in the queue and removes it.
	 * <p>
	 * @return <b>Node</b>
	 * @author james_2pes9af
	 */
	public Node dequeue(){
		Node temp = origin;
		deleteNode(origin);
		return temp;
	}
	
	/**
	 * <b><i>peek</i></b> - looks at the first node in the queue
	 * <p>
	 * @return <b>Node<b>
	 * @author james_2pes9af
	 */
	public Node peek(){
		return origin;
	}

	/**
	 * <b><i>deleteNode</i></b> - Deletes a node from the queue.
	 * <p>
	 * Since this is a queue and order is paramount, this method has been made private to ensure queue order is kept.
	 * <p>
	 * @param node - The Node targeted for deletion.
	 * @author james_2pes9af
	 */
	private void deleteNode(Node node){
		if (node!=origin)
			node.getPrevious().setNext(node.getNext());
		else
			origin=node.getNext();
		if (node!=end)
			node.getNext().setPrevious(node.getPrevious());
		else
			end=node.getPrevious();
		size--;
	}
	
	/**
	 * <b><i>printForward</i></b> - Prints the contents of the queue, going forward.
	 * <p>
	 * Iterates forward through the queue and generates a string that is comma delimited containing the content of each node.
	 * <p>
	 * @return <b>String</b> - contains each content in a single string separated by commas.
	 * @author james_2pes9af
	 */
	public String printForward(){
		String list="";
		if (origin!=null){
			Node current=origin;
			while(current.getNext()!=null){
				list+=current.getContent()+", ";
	    		current=current.getNext();
	    	}
			list+=current.getContent();
			return list;
		}
		return "The list is empty.";
	}
	
	/**
	 * <b><i>printReverse</i></b> - Prints the contents of the queue, going backwards.
	 * <p>
	 * Iterates backwards through the queue and generates a string that is comma delimited containing the content of each node.
	 * <p>
	 * @return <b>String</b> - contains each content in a single string separated by commas.
	 * @author james_2pes9af
	 */
	public String printReverse(){
		String list="";
		if (end!=null){
			Node current=end;
			while(current.getPrevious()!=null){
				list+=current.getContent()+", ";
	    		current=current.getPrevious();
	    	}
			list+=current.getContent();
			return list;
		}
		return "The list is empty";
	}
	
	/**
	 * <b><i>detelteList</i></b> - Deletes the entire queue.
	 * <p>
	 * @author james_2pes9af
	 */
	public void deleteQueue(){
		Node current=origin;
		while(current!=null){
			current.setPrevious(null);
			Node temp = current.getNext();
			current.setNext(null);
			current=temp;
		}
		origin= null;
		end=null;
	}
	
	public Node getOrigin(){
		return origin;
	}
	public Node getEnd(){
		return end;
	}
	
}
