package StackAndQueue;

import java.util.LinkedList;

class Animal{
	private int order;
	protected String name;
	public Animal(String n){
		name = n;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isOlderThan(Animal a){
		return this.getOrder() < a.getOrder();
	}
}

class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
}

class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}

public class QueueExample {
	
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	public int order = 0;
	
	public void enque(Animal a){
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog) dogs.add((Dog)a);
		else if(a instanceof Cat) cats.add((Cat) a);
	}
	
	public Animal deque(){
		if(dogs.size() == 0){
			return dequeCat();
		}else if(cats.size() == 0){
			return dequeDog();
		}
		
		Dog d = dogs.peek();
		Cat c = cats.peek();
		
		if(c.isOlderThan(d)){
			return cats.poll();
		}
		return dogs.poll();
	}
	
	public Dog dequeDog(){
		return dogs.poll();
	}
	
	public Cat dequeCat(){
		return cats.poll();
	}
}
