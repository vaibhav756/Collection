package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSorting {
	public static void main(String[] args) {
		Map<Employee1,Integer> map=new HashMap<>();
		map.put(new Employee1(101,"Ram"), 101);
		map.put(new Employee1(102,"Sham"), 457);
		map.put(new Employee1(103,"Kiran"), 245);
		map.put(new Employee1(104,"Amar"), 356);
		
		Set<Map.Entry<Employee1,Integer>> set=map.entrySet();
		List<Map.Entry<Employee1,Integer>> list=new ArrayList<>(set);
		
		
		//Sort by Key
		Collections.sort(list,new Comparator<Map.Entry<Employee1,Integer>>()
		{
			public int compare(Entry<Employee1,Integer> emp1,Entry<Employee1,Integer> emp2)
			{
				//return (emp1.getKey().getEmpId()-emp2.getKey().getEmpId());  //Ascending
				//return -(emp1.getKey().getEmpId()-emp2.getKey().getEmpId());  //Descending
				return emp1.getKey().getEmpName().compareTo(emp2.getKey().getEmpName());
			}
		});
		
		//Sorting by Key using lambda
		//Collections.sort(list,(emp1,emp2)->-(emp1.getKey().getEmpId()-emp2.getKey().getEmpId()));
		
		//Sorting by Value using lambda
		Collections.sort(list,(emp1,emp2)->-(emp1.getValue()-emp2.getValue()));
		System.out.println(list);
		
		//System.out.println(list);
		
		//Sort by Value
		Collections.sort(list,new Comparator<Map.Entry<Employee1,Integer>>(){
			public int compare(Entry<Employee1,Integer> emp1,Entry<Employee1,Integer> emp2)
			{
				//return emp1.getValue()-emp2.getValue();  //Sort by value ascending
				return -(emp1.getValue()-emp2.getValue());	//Sort by value descending
			}
		});
//		System.out.println(list);
	}
}
class Employee1 implements Comparable<Employee1>
{
	public int compareTo(Employee1 emp)
	{
		return empId-emp.getEmpId();
	}
	
	private Integer empId;
	private String empName;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public Employee1() {
	}
	
	public Employee1(Integer empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
	@Override
	public int hashCode()
	{
		return empId;
	}
	
	public boolean equals(Object obj)
	{
		Employee1 emp=(Employee1)obj;
		if((this.empId==emp.getEmpId()) && (this.empName.equals(emp.getEmpName())))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Employee1 [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
