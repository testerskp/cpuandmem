package com.stu.test;

class A{
	public void aGetValue(){
		System.out.println("A类中的a方法");
	}
	public void aGet(){
		System.out.println("A类中的方法");
	}
}
class B extends A{
	@Override
	public void aGetValue(){
		System.out.println("B类中复写A类中的a方法");
	}
	public void bGetValue(){
		System.out.println("B类中的b方法");
	}
};

public class Transformation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();		//向上转型遗失了子类中除了复写父类的方法
//		a.aGetValue();
//		a.aGet();
		B b = (B)a;			//向下转型都可以调用，并调用的是子类中复写父类的方法
		b.aGetValue();		
		b.aGet();
		b.bGetValue();
	}
}

