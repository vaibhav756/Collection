package com;

import java.util.Arrays;
import java.util.StringJoiner;

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

//		CustomArrayList data print
//		System.out.println(list);

//		Object[] data = list.getAllElements();
		/*for(Object obj:data)
		{
			System.out.println(obj);
		}*/
		
		//CustomArrayList get method
		//System.out.println(list.get(5));
		
		//CustomArrayList remove method
//		list.remove(1);
		list.update(1, "Ram");
		System.out.println(list);
	}
	
	@Override
	public String toString() {
//		return Arrays.toString(elements);
		StringJoiner sj=new StringJoiner(", ","[","]");
		for(int i=0;i<elements.length;i++)
		{
			sj.add(String.valueOf(elements[i]));
		}
		return sj.toString();
	}

	public void insert(Integer value)
	{
		
		if(index==elements.length)
		{
			//When ArrayList reaches it's maximum limit it grows by currentSize+(currentSize/2)
			//It increases size by 50% of current size.
			Integer newSize=elements.length+(elements.length/2);
			
			//Manual Approach
			/*Object[] tempArr=new Object[newSize];
			for(int i=0;i<elements.length;i++)
			{
				tempArr[i]=elements[i];
			}
			elements=tempArr;*/
			
			//Programatic Approach
			elements=Arrays.copyOf(elements, newSize);
		}
		elements[index++]=value;
	}
	
	public Object[] getAllElements()
	{
		return elements;
	}
	
	public Object get(Integer index)
	{
		if(index>=elements.length)
		{
			throw new ArrayIndexOutOfBoundsException("Array index is greater than array length");
		}
		return elements[index];
	}
	
	public Object remove(Integer index)
	{
		if(index>=elements.length)
		{
			throw new ArrayIndexOutOfBoundsException("Array index is greater than array length");
		}
		Object obj=elements[index];	
		
//		Object[] tempArr=new Object[elements.length-1];
		for(int i=0;i<elements.length-1;i++)
		{
			if(i>=index)
			{
				elements[i]=elements[i+1];
			}
		}
		return obj;
	}

	public Boolean update(Integer index,Object obj)
	{
		if(this.index<=index)
		{
			throw new ArrayIndexOutOfBoundsException("Array index is greater than array length.");
		}
		elements[index]=obj;
		return true;
	}
	
}
