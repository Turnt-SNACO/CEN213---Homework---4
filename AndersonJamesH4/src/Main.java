public class Main {
	
	public static Stack stackFromQueue(Queue queue){
		Stack target = new Stack();
		Node current = queue.getEnd();
		while (current!=null){
			Node temp = new Node();
			temp.setContent(current.getContent());
			target.push(temp);
			current=current.getPrevious();
		}
		return target;
	}
	public static Stack stackFromStack(Stack stack){
		Stack target = new Stack();
		Node current = stack.getEnd();
		while(current!=null){
			Node temp = new Node();
			temp.setContent(current.getContent());
			target.push(temp);
			current=current.getPrevious();
		}
		return target;
	}
	public static Queue queueFromStack(Stack stack){
		Queue target = new Queue();
		Node current = stack.getOrigin();
		while(current!=null){
			Node temp = new Node();
			temp.setContent(current.getContent());
			target.enqueue(temp);
			current=current.getNext();
		}
		return target;
	}
	public static void main(String[]args){
		Node ace = new Node("ace");
		Node apple = new Node("apple");
		Node bubblegum = new Node("bubblegum");
		Node xylophone = new Node("xylophone");
		Node zebra = new Node("zebra");
		Node num = new Node (4);
		
		//create queue
		Queue q = new Queue();
		q.enqueue(ace);
		q.enqueue(bubblegum);
		q.enqueue(zebra);
		q.enqueue(apple);
		q.enqueue(xylophone);
		q.enqueue(num);
		
		//show queue in correct order
		System.out.println(q.printForward());
		//test peek
		System.out.println(q.peek().getContent());
		//test dequeue
		System.out.println(q.dequeue().getContent());
		//verify first item dequeued
		System.out.println(q.printForward());
		
		//test moving queue to stack
		Stack fromQueue = stackFromQueue(q);
		
		//verify order maintained
		System.out.println(fromQueue.printForward());
		
		//test transferred stack's peek
		System.out.println(fromQueue.peek().getContent());
		
		//test transferred stack's pop
		System.out.println(fromQueue.pop().getContent());
		
		//test transferred stack's pop
		System.out.println(fromQueue.pop().getContent());
		
		//test transferred stack's order
		System.out.println(fromQueue.printForward());
		
		//new nodes for new Stack
		Node alpha = new Node("a");
		Node beta = new Node('b');
		Node one = new Node (1);
		Node ten = new Node (10);
		Node two = new Node (2);
		Stack s = new Stack();
		
		//push nodes to stack
		s.push(alpha);
		s.push(beta);
		s.push(one);
		s.push(ten);
		
		//verify stack  order
		System.out.println(s.printForward());
		
		//test push
		s.push(two);
		System.out.println(s.printForward());
		
		//test peek
		System.out.println(s.peek().getContent());
		
		//test pop
		System.out.println(s.pop().getContent());
		System.out.println(s.printForward());
		
		//test to Queue
		Queue fromStack = queueFromStack(s);
		
		//check order of queue
		System.out.println(fromStack.printForward());
		
		//check peek
		System.out.println(fromStack.peek().getContent());
		
		//check dequeue
		System.out.println(fromStack.dequeue().getContent());
		System.out.println(fromStack.printForward());
		
		
		
		
	}
}
