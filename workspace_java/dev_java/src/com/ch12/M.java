package com.ch12;
class N{
	public Object[] toArray() {//toArray
		Object[] objs= null;
		return objs;
	}
}
public class M {
	public N keySet() {//Set->N
		N n = null;
		return n;
	}
	public static void main(String args[]) {
		M m = new M();
		Object objs[]=m.keySet().toArray();
		N n = m.keySet();
		Object keys[] = n.toArray();
	}
}
