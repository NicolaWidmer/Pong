import gui.Window;
public class LinkedBallList {



	
	    
	    BallNode first;
	    BallNode last;
	    int size;
	    
	    Ball get(int index) {
	        return getNode(index).value;
	    }
	    
	    void set(int index, Ball value) {
	        getNode(index).value = value;
	    }
	    
	    boolean isEmpty() {
	        return size == 0;
	    }
	    
	    void addFirst(Ball value) {
	    	BallNode newNode = new BallNode(value);
	        if(isEmpty()) {
	            last = newNode;
	            }
	        else {
	        	first.prev=newNode;
	        	newNode.next = first;
	        	
	        }
	        first = newNode;
	        size++;
	    }
	    
	    void addLast(Ball value) {
	    	BallNode newNode = new BallNode(value);
	        if(isEmpty()) {
	            first = newNode;
	            }
	        else {
	        	newNode.prev=last;
	        	last.next = newNode;
	            }
	        
	        last = newNode;
	        size++;
	    }
	    
	    Ball removeFirst() {
	        if(isEmpty())
	            throw new AssertionError();
	        
	        Ball value = first.value;
	        if(first == last) {
	            // List has only one element, so just clear it
	            clear();
	        }
	        else {
	            first = first.next;
	            first.prev=null;
	            size--;
	        }
	        
	        return value;
	    }
	    
	    Ball removeLast() {
	        if(isEmpty())
	            throw new AssertionError();
	        
	        Ball value = last.value;
	        if(first == last) {
	            // List has only one element, so just clear it
	            clear();
	        }
	        else {
	            // List has more than one element
	            last=last.prev;
	            last.next=null;
	            size--;
	        }
	        return value;
	    }
	    
	    void clear() {
	        first = last = null;
	        size = 0;
	    }
	    
	    Ball[] toArray() {
	    	Ball[] array = new Ball[size];
	        int i = 0;
	        for(BallNode n = first; n != null; n = n.next, i++)
	            array[i] = n.value;
	        return array;
	    }
	    
	    /**
	     * For internal use only.
	     */
	    BallNode getNode(int index) {
	        if(index >= size)
	            throw new AssertionError();
	        
	        BallNode current = first;
	        for(int i = 0; i < index; i++)
	            current = current.next;
	        return current;
	    }
	    
	    void removeNode(BallNode current) {
	    	
	    	
	    			if(current==this.first&&current==this.last) {
	    				this.last=null;
	    				this.first=null;
	    				}
	    			else {
	    				if(current.prev!=null)	{
	    					current.prev.next=current.next;
	    				}
	    				else {				
	    				this.first=current.next; 
	    				this.first.prev=null;
	    				}
	    			
	    				if(current.next!=null) {
	    					current.next.prev=current.prev;
	    				}
	    				else {
	    					this.last=current.prev; 
	    					this.last.next=null;
	    				}
	    			}
	    			size--;
	    			
	    		
	    }
	    
	    void draw(Window w) {
	    	for(BallNode bn=first;bn!=null;bn=bn.next) {
	    		bn.value.draw(w);
	    	}
	    }
	   
	    void step(Window w,Player1 p1,Player2 p2) {
	    	Ball b;
	    	for(BallNode bn=first;bn!=null;bn=bn.next) {
	    		b=bn.value;
	    		b.move();
	    		b.handleeffekts();
	    		if(b.checkcolison()) {
	    			BallNode bh=new BallNode(bn.value);
	    			bh.next=bn.next;
	    			removeNode(bn);
	    			bn=bh;
	    		}
	    		if(b.px<=b.size) {
	    			b.hits(1);
	    			BallNode bh=new BallNode(bn.value);
	    			bh.next=bn.next;
	    			removeNode(bn);
	    			bn=bh;
	    		}
	    		else if(b.px>=w.getWidth()-b.size) {
	    			b.hits(2);
	    			BallNode bh=new BallNode(bn.value);
	    			bh.next=bn.next;
	    			removeNode(bn);
	    			bn=bh;
	    		}
	    		
	    	}
	    }

}
