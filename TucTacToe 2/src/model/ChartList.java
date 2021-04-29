package model;

import java.util.Arrays;

public class ChartList<T extends Comparable<T>> {

	private Object[] data;
	private int size;

	
	public ChartList(int capacity) {
		this.data = new Object[capacity];
		this.size = 0;
	}

	
	private void checkAccessBounds(int i) {
		if (i < 0 || i > this.capacity())
			throw new ArrayIndexOutOfBoundsException(i + " is not a valid index");
	}

	
	public void add(T item) {
		for (int i = 0; i < this.capacity(); i++) {
			T current = this.get(i);
			int newSize=0;
			if (current == null) {
				this.data[i] = item;
				size++;
				return;			
			} else {
				if (item.compareTo(current) < 0) { 
					// item should be placed here...
					
					// starting from the end, move each element one position down
					for (int j=this.capacity()-1; j>i;j--) {
						data[j]=data[j-1];						
						if (data[j]!=null && newSize==0) { // update newSize if it was not updated....
							newSize=j+1;
						}
					}
					//put the item in the i position;
					data[i]=item;
					size= newSize;
					return;
				}
			}		
		}
		// System.out.println("Item not added");
	}	
	
	public void addGame(Game game, Player player) {
		for (int i = 0; i < this.capacity(); i++) {
			Game current = (Game) this.get(i);
			int newSize=0;
			if (current == null) {
				this.data[i] = game;
				size++;
				return;			
			} else {
				if (game.bestMatch(current, player) < 0) { 
					// item should be placed here...
					
					// starting from the end, move each element one position down
					for (int j=this.capacity()-1; j>i;j--) {
						data[j]=data[j-1];						
						if (data[j]!=null && newSize==0) { // update newSize if it was not updated....
							newSize=j+1;
						}
					}
					//put the item in the i position;
					data[i]=game;
					size= newSize;
					return;
				}
			}		
		}
		// System.out.println("Item not added");
	}	
	
	public void addExtend(T item) {
		if(this.capacity() == this.size) {
			this.growSize();
		}
			for (int i = 0; i < this.capacity(); i++) {
				T current = this.get(i);
				int newSize=0;
				if (current == null) {
					this.data[i] = item;
					size++;
					return;			
				} else {
					if (item.compareTo(current) < 0) { 
						// item should be placed here...
						
						// starting from the end, move each element one position down
						for (int j=this.capacity()-1; j>i;j--) {
							data[j]=data[j-1];						
							if (data[j]!=null && newSize==0) { // update newSize if it was not updated....
								newSize=j+1;
							}
						}
						//put the item in the i position;
						data[i]=item;
						size= newSize;
						return;
					}
				}	
		}
		// System.out.println("Item not added");
	}	
	
	@SuppressWarnings("unchecked")
	public T get(int i) {
		checkAccessBounds(i);
		return (T) data[i];
	}

	
	public int size() {
		return size;
	}

	
	public int capacity() {
		return data.length;
	}

	
	public boolean isEmpty() {
		return this.size == 0;
	}

	public void clear() {
		this.data = new Object[data.length];
	}
	
	public T remove(int i) {
		checkAccessBounds(i);
		T dead = this.get(i);
		for (int j = i; j < this.size; j++) {
			// System.out.println("j= " + j);
			if (j+1 < this.capacity()) {
				data[j]= data[j+1];
				// System.out.println("data["+j + "] = data[" + (j+1)+"]" );
			}else {
				data[j]=null;
				// System.out.println("data["+j + "] = null" );
			}
			
		}
		size--;
		return dead;
	}

	
	public void addAll(T[] chart) {			
		for (int i = 0; i < chart.length; i++) {
			if (chart[i]!=null)
			this.add(chart[i]);
		}
	}

	
	@SuppressWarnings("unchecked")
	public T[] toArray(T[] type) {
		return (T[]) Arrays.copyOf(this.data, size, type.getClass());
	}
	
	public void growSize() {               //When this function is called the capacity of the data array gets dupled.
		Object temp[];
		temp = null;
		
		temp = new Object[data.length + 1];
		for(int i=0; i<data.length;i++) {
			temp[i] = data[i];
		}
		
		data = temp;
	}
	
	
	
}
