
public class Stack {
	private Node origin=null;
	private Node end=null;
	public Stack(){}

	public void push(Node node) {
    	if (origin==null){  
    		origin=node;
    		end=node;
    	}else{
    		node.setNext(origin);
    		origin.setPrevious(node);
    		origin=node;
    	}
    }
	public Node pop(){
		Node temp = origin;
		deleteNode(origin);
		return temp;
	}
	public Node peek(){
		return origin;
	}
	
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
	
}
