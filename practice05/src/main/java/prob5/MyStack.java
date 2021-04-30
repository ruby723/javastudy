package prob5;

public class MyStack {
	private int top;
	private int stackSize;
	private String stackArr[];
	
	public MyStack(int stackSize) {
		top=-1;
		stackArr=new String[stackSize];
		this.stackSize=stackSize;
	}
	
	public void push(String string) {
		if(top==stackSize-1) {
			resize();
		}
		stackArr[++top]=string;
		
	}
	
	private void resize() {
		String temp []=new String[stackSize*2];
		for(int i=0;i<=top;i++) {
			temp[i]=stackArr[i];
		}
		stackArr=temp;
	}

	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		
		String t=stackArr[top];
		stackArr[top--]=null;
		return t;
	}
	
	public void printStack() {
		System.out.println("Stack list");
		for(int i=top;i>=0;--i) {
			System.out.println(stackArr[i]);
		}
	}

	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		else {
			return false;
		}
	}
}