package com.stu.test;

class A{
	public void aGetValue(){
		System.out.println("A���е�a����");
	}
	public void aGet(){
		System.out.println("A���еķ���");
	}
}
class B extends A{
	@Override
	public void aGetValue(){
		System.out.println("B���и�дA���е�a����");
	}
	public void bGetValue(){
		System.out.println("B���е�b����");
	}
};

public class Transformation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();		//����ת����ʧ�������г��˸�д����ķ���
//		a.aGetValue();
//		a.aGet();
		B b = (B)a;			//����ת�Ͷ����Ե��ã������õ��������и�д����ķ���
		b.aGetValue();		
		b.aGet();
		b.bGetValue();
	}
}

