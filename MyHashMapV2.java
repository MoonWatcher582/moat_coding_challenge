import java.util.*;

public class MyHashMapV2<K extends Comparable<K>, V extends Comparable<V>> { 
	private LinkedList<AbstractMap.SimpleEntry<K,V>>[] map;	//base table
	private int size;					//number of elements
	private int capacity;					//size of table

	public MyHashMapV2(int initCapacity) {
		map = (LinkedList<AbstractMap.SimpleEntry<K,V>>[]) new LinkedList<?>[initCapacity];
		this.size = 0;
		this.capacity = initCapacity;
	}
	
	public MyHashMapV2() {
		this(10);	
	}

	public int size() {
		return size;	
	}

	public int getCapacity() {
		return capacity;
	}

	public int hashKey(K key){
		int hash = key.hashCode();
		if(hash < 0) {
			hash *= -1;
		}
		return hash % this.capacity;
	}

	public V put(K key, V value) {
		int hash = hashKey(key);
		LinkedList<AbstractMap.SimpleEntry<K,V>> list = this.map[hash];
		if(list == null){
			this.map[hash] = new LinkedList<AbstractMap.SimpleEntry<K,V>>();
			this.map[hash].addFirst(new AbstractMap.SimpleEntry(key,value));
			size++;
			return null;
		}
		ListIterator<AbstractMap.SimpleEntry<K,V>> iter = list.listIterator();
		AbstractMap.SimpleEntry<K,V> curr = list.getFirst();
		while(iter.hasNext()) {
			if(curr.getKey().equals(key)) {
				V ret = curr.getValue();
				curr.setValue(value);
				return ret;
			}
			curr = iter.next();
		}
		iter.add(new AbstractMap.SimpleEntry(key,value));
		size++;
		if(size > (double)capacity/2) {
			resize();
		}
		return null;
	}

	public V get(K key) {
		int hash = hashKey(key);
		LinkedList<AbstractMap.SimpleEntry<K,V>> list = this.map[hash];
		if(list == null){
			return null;
		}
		ListIterator<AbstractMap.SimpleEntry<K,V>> iter = list.listIterator();
		AbstractMap.SimpleEntry<K,V> curr = null;
		while(iter.hasNext()) {
			curr = iter.next();
			if(curr.getKey().equals(key)) {
				return curr.getValue();
			}
		}
		if(curr != null) {
			if(curr.getKey().equals(key)) {
				return curr.getValue();
			}
		}
		return null;
	}

	public V remove(K key) {
		int hash = hashKey(key);
		LinkedList<AbstractMap.SimpleEntry<K,V>> list = this.map[hash];
		if(list == null){
			return null;
		}
		ListIterator<AbstractMap.SimpleEntry<K,V>> iter = list.listIterator();
		AbstractMap.SimpleEntry<K,V> curr = null;
		while(iter.hasNext()) {
			curr = iter.next();
			if(curr.getKey().equals(key)) {
				V ret = curr.getValue();
				iter.remove();
				size--;
				return ret;
			}
		}
		if(curr != null) {
			if(curr.getKey().equals(key)) {
				V ret = curr.getValue();
				iter.remove();
				size--;
				return ret;
			}

		}
		return null;
	}

	private void resize(){
		int originalCapacity = this.capacity;
		this.capacity *= 2;
		this.size = 0;
		LinkedList<AbstractMap.SimpleEntry<K,V>>[] oldMap = (LinkedList<AbstractMap.SimpleEntry<K,V>>[]) new LinkedList<?>[originalCapacity];
		for(int i = 0; i < originalCapacity; i++) {
			oldMap[i] = this.map[i];
		}
		this.map = (LinkedList<AbstractMap.SimpleEntry<K,V>>[]) new LinkedList<?>[this.capacity];
		for(int i = 0; i < originalCapacity; i++) {
			LinkedList<AbstractMap.SimpleEntry<K,V>> list = oldMap[i];
			if(list == null) {
				continue;
			}
			ListIterator<AbstractMap.SimpleEntry<K,V>> iter = list.listIterator();
			while(iter.hasNext()){
				AbstractMap.SimpleEntry<K,V> curr = iter.next();
				this.put(curr.getKey(), curr.getValue());
			}
		}	
	}

	public void printTable() {
		for(int i = 0; i < this.getCapacity(); i++) {
			LinkedList<AbstractMap.SimpleEntry<K,V>> list = this.map[i];
			if(list == null) {
				continue;
			}
			ListIterator<AbstractMap.SimpleEntry<K,V>> iter = list.listIterator();
			while(iter.hasNext()){
				AbstractMap.SimpleEntry<K,V> curr = iter.next();
				System.out.println(curr.getKey() + ", " + curr.getValue() + " is at bucket " + i);
			}
		}	
	}
}
