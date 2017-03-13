package objectstructures;

import java.util.ArrayList;

public class Person {
	/*
	 * Stating needed states
	 */
	private String name;
	private char gender;
	private Person mother; 
	private Person father;
	private ArrayList<Person> children = new ArrayList<Person>(); 
	
	/*
	 * Constructor code. Currently name can be any string. 
	 */
	public Person(String inName, char inGender){
		//Currently no validation
		name = inName;
		inGender = Character.toLowerCase(inGender);
		if(inGender == 'm' || inGender == 'f'){
			gender = inGender;
		}
	}
	
	
	/*
	 * Get-methods. Mostly self-explanatory
	 */
	String getName(){
		return name; 
	}
	
	char getGender(){
		return gender;
	}
	
	Person getMother(){
		if(mother != null){
			return mother; 
		}
		else{
			return null; 
		}
	}
	
	Person getFather(){
		if(father != null){
			return father; 
		}
		else{
			return null; 
		}
	}
	
	int getChildCount(){
		return children.size();
	}
	
	Person getChild(int n){
		if(n < children.size()){
			return children.get(n);
		}
		else{
			throw new IllegalArgumentException("Argument is out of bounds");
		}
	}
	
	//Used in addChild, and setFather/Mother
	boolean hasThisChild(Person checkChild){
		return children.contains(checkChild);
	}
	
	/*
	 * Alterating methods:
	 * Same logic as setFather-method below, but changes mother-state
	 */
	void setMother(Person newMom){
		if(newMom == null){
			mother = newMom;
			return;
		}
		else if(newMom.getGender() != 'f'){
			throw new IllegalArgumentException("Mother's gender invalid");
		}
		else if(newMom == this){
			throw new IllegalArgumentException("Mother cannot be set to self"); 
		}
		if(mother != null){
			Person prevMother = mother;
			mother = newMom;
			prevMother.removeChild(this);
		}
		else{
			mother = newMom;
		}
		
		
		//Check if mother has this person as child, and if not, adds child (.addChild() with mother.
		if(!(mother.hasThisChild(this))){
			mother.addChild(this);
		}
	}
	/*
	 * Sets father to Person-object in argument, removes self from children-list in last father. Then adds self to new father's list of children
	 * Or: "Disconnects" previous father and connects new father. 
	 */
	void setFather(Person newFather){
		if(newFather == null){
			father = newFather;
			return;
		}
		else if(newFather.getGender() != 'm'){
			throw new IllegalArgumentException("Father's gender invalid");
		}
		else if(newFather == this){
			throw new IllegalArgumentException("Father cannot be set to self");
		}
		//remove last father:
		if(father != null){ 
			Person prevFather = father; 
			father = newFather; 
			prevFather.removeChild(this); //removeChild will not have exceptions if 'this' is not found
			
		}
		else{ //If father is null
			father = newFather;
		}
		
		if(!(father.hasThisChild(this)) && father != null){
			father.addChild(this);
		}
		
		//Check if father has this person as child and is not null, if not; adds child. 
		
	}
	
	/*
	 * If child is not already in child-list (children), adds child and sets father/mother accoring to gender. 
	 * If-statement nr. 2 prevents an infinite loop of addChild and setFather calling back and forth. 
	 * setFather/Mother has similar logic. 
	 * Keep in mind: This is used by the parent. 
	 */
	void addChild(Person newChild){
		if(newChild == this){
			return;
		}
		if(!(children.contains(newChild))){
			children.add(newChild);
			if(gender == 'm'){
				if(newChild.getFather() != this){
					newChild.setFather(this);
				}
			}
			else if(gender == 'f'){
				if(newChild.getMother() != this){
					newChild.setMother(this);
				}
			}
		}
	}
	
	/*
	 * Removes child from list of children. Then, if this is child's parent, removes self as parent. 
	 */
	void removeChild(Person child){
		if(children.contains(child)){
			children.remove(child);
			if(child.getFather() == this){
				child.setFather(null);
			}
			else if(child.getMother() == this){
				child.setMother(null);
			}
		}
	}
	
	/*
	 * Main-method to test code w/o JUnit
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person dad = new Person("Dad", 'm');
		Person mom = new Person("Mom", 'f');
		Person son1 = new Person("Son1", 'm');
		Person son2 = new Person("Son2", 'm');
		Person dad2 = new Person("Dad2", 'm');
		
		son1.setFather(dad); son1.setMother(mom);
		dad.addChild(son2); mom.addChild(son2);
		
		son1.setFather(dad2);
		System.out.println(dad.getChildCount());
		System.out.print(dad.getChild(0).getName()); //System.out.println(dad.getChild(1).getName());
		System.out.print(son1.getFather().getName()); System.out.print(son2.getFather().getName());
		
		dad2.removeChild(son1);
	}

}
