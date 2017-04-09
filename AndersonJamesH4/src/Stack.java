
public class Stack {
	private Node origin=null;
	private Node end=null;
	private int size=0;
	public Stack(){}

	/**
	 * <b><i>push</b></i> - adds a node to the top of the stack
	 * <p>
	 * @param node
	 * @author james_2pes9af
	 */
	public void push(Node node) {
    	if (origin==null){  
    		origin=node;
    		end=node;
    	}else{
    		node.setNext(origin);
    		origin.setPrevious(node);
    		origin=node;
    	}
    	size++;
    }
	
	/**
	 * <b><i>pop</b></i> - looks at and removes the top element of the stack
	 * <p>
	 * @return Node
	 * @author james_2pes9af
	 */
	public Node pop(){
		Node temp = origin;
		deleteNode(origin);
		return temp;
	}
	
	/**
	 * <b><i>peek</b></i> - looks at the top element of the stack without removing it
	 * <p>
	 * @return Node
	 * @author james_2pes9af
	 */
	public Node peek(){
		return origin;
	}
	
	/**
	 * <b><i>deleteStack</b></i> - deletes the entire stack.
	 * <p>
	 * @author james_2pes9af
	 */
	public void deleteStack(){
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
	
	/**
	 * <b><i>printForward</i></b> - Prints the contents of the stack, from top to bottom.
	 * <p>
	 * @return <b>String</b> - contains each content in a single string separated by commas.
	 * @author james_2pes9af
	 */
	public String printForward(){
		String list="";
		Node current=origin;
		while(current.getNext()!=null){
			list+=current.getContent()+", ";
    		current=current.getNext();
    	}
		list+=current.getContent();
		return list;
	}
	/**
	 * <b><i>printReverse</i></b> - Prints the contents of the stack, from bottom to top.
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
	 * <b><i>deleteNode</i></b> - Deletes a node from the stack.
	 * <p>
	 * Since this is a stack and order is paramount, this method has been made private to ensure stack order is kept.
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
	}
	
	public Node getOrigin(){
		return origin;
	}
	
	public Node getEnd(){
		return end;
	}
	
	public int getSize(){
		return size;
	}
}
