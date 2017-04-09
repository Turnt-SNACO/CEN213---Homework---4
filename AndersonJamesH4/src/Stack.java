
public class Stack {
	private Node origin=null;
	private Node end=null;
	private int size=0;
	public Stack(){}

	public void push(Node node) {
    	if (origin==null){  
    		origin=node;
    		end=node;
    	}else{
    		node.setNext(origin);
    		if (size==1)
    			end=origin;
    		origin=node;
    	}
    	size++;
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
	
	private String printReverse(){
		String list="";
		Node current=end;
		while(current.getPrevious()!=null){
			list+=current.getContent()+", ";
    		current=current.getPrevious();
    	}
		list+=current.getContent();
		return list;
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
	
	
}
