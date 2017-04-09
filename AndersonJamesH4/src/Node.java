
public class Node {
	private Node previous,next;
	//private String content;
	private Comparable content;

	public Node (Comparable content){
		this.content=content;
		this.next=null;		this.previous=null;
	}
	public Node(){}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Comparable getContent() {
		return content;
	}
	public void setContent(Comparable content) {
		this.content = content;
	}
}
