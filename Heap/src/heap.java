
public class heap {
	private node heap[] = new node[15];
	
	
	
	
	// swap two node
	public void swap(int n, int m){
		node temp;
		temp=heap[n];
		heap[n]=heap[m];
		heap[m]=temp;
	}
	// to maintain the heap balance
	/*check whether the parent of the element has lower priority , swap if 
	 * yes and then continue to check the parent of the parent up to root element 
	 * */
	public void balance(int pos , node n){
		int nPos = pos;
		if(pos<=0){
			return;
			
		}else{
			pos/=2;	
			if(n.getPriority()>heap[pos].getPriority()){
				swap(nPos,pos);
				balance(pos,n);
			}else{
				
				return;
			}
		}
		
		
	}
	// to add element into heap
	public void addElement(int pos, node n){
		
		//base case for adding element 
		if(pos==heap.length){
			System.out.println("Heap is Full ......");
			return;
		}
		// if given position is null then enter it here
		if(heap[pos]==null){
			heap[pos]=n;
			balance(pos,n);
			return;
		}else{ //move to the next element of array.
			pos++;
			addElement(pos, n);
		}
		
	}
	
	// Generic addition of element just to avoid the junk
	public void add(node n){
		addElement(0, n);
	}
	
	// show heap element and their ordering
	
	public void show(){
		for(int i =0 ; i< heap.length;i++){
			if(heap[i]!=null)
			System.out.println(heap[i].toString()+"     "+i);
		}
		
	}
	// to search the particular Element
	public int search(node n){
		for(int i=0 ; i<heap.length;i++){
			if(heap[i]==n){
				return i;
			}else if (heap[i]==null){
				break;
				
			}
		}
		return -1;
	}
	// to change the priority of any existing element
	/*First search the element index if it exist change the priority and then balance the
	 * heap 
	 * */
	
	public void changePrior(node n , int prior){
		int pos = search(n);
		if(pos!=-1){
		
			n.setPriority(prior);
			balance(pos,n);

		}
			}
	// to get highest priority element
	public node top(){
		if(heap[0]!=null)
		return heap[0];
		return null;
	}
	
	public static void main(String[] args){
		
		heap h = new heap();
		node n1= new node("hello",5);
		node n2= new node("hello",2);
		node n3= new node("hello",3);
		node n4= new node("hello",4);
		node n5= new node("hello",1);
		node n6= new node("hello",6);
		h.add(n1);
		h.add(n2);
		h.add(n3);
		h.add(n4);
		h.add(n5);
		h.add(n6);
		h.show();
		System.out.println("\n\n\n\n\n");
		h.changePrior(n5, 8);
		h.show();
	}
	

}
