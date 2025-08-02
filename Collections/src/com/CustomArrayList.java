package com;

public class CustomArrayList {

	Object[] elements=null;
	int index=0;
	
	public CustomArrayList() {
		elements=new Object[10];
	}
	
	public CustomArrayList(Integer size) {
		elements=new Object[size];
	}
	
	public static void main(String[] args) {

		CustomArrayList list=new CustomArrayList(5);
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		list.insert(70);
		list.insert(80);
		list.insert(90);
		list.insert(100);
		list.insert(110);
		list.insert(120);
		list.insert(130);
		list.insert(140);
		
		Object[] data = list.getAllElements();
		for(Object obj:data)
		{
			System.out.println(obj);
		}
	}
	
	public void insert(Integer value)
	{
		
		if(index==elements.length)
		{
			//When ArrayList reaches it's maximum limit it grows by currentSize+(currentSize/2)
			//It increases size by 50% of current size.
			Integer newSize=elements.length+(elements.length/2);
			Object[] tempArr=new Object[newSize];
			for(int i=0;i<elements.length;i++)
			{
				tempArr[i]=elements[i];
			}
			elements=tempArr;
		}
		elements[index++]=value;
	}
	
	public Object[] getAllElements()
	{
		return elements;
	}
	
}
