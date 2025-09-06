package com;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMap {

	public static void main(String[] args) {
		
		//HashMap internally uses Node[]
		//Node holds data in {hashCode(Object),key(Object),value(Object),AddressOfNextNode}
		//When we add data in HashMap it follows below steps
		/*
		 * Find HashCode for key((h=key.hashCode()) ^ (h >>> 16)).
		 * Find index based on some calculation.
		 * Create node object and store at particualar index.
		 */
		//HashMap uses hashcode() and equals() method to identify key is unique or not.
		//If object is having same hashcode() doesn't mean Objects are same however if Object is having equal() as true means it must have same hashcode()
		//If objects are having same hashcode hashcollision happens and Hashmap internally uses LinkedList(Before 1.8 after they started using BinaryTree because of performance issue) to hold this objects.
		//1st Object holds address of 2nd Object (hashCode,key,value,NextObjectNodeAddress)
		// (==) operator compare memory refrence.
		
		
		
		String name="AB";
		//System.out.println(name.hashCode());  //s[0]*31^(n-1) + s[1]*31^(n-2)
		//A*31^2-1 + B*31^2-2 (ASCII value of A and B calculated and added in formula) , n is number of elements
		//65*31^1 + 66*31^0 = 2015+66(2081)
		
		//For User Defined objects it is using SHA(Secure Hash Algorithm for identifying hashcode.)
		
		/**
		 * HashMap.get(key) - Calculate hasbcode of the Key and identify index of the key and retrive object.
		 * If multiple Objects are present at same bucket then it will check for .equals() method,whichever value matches will be retrieved.
		 * 
		 * 
		 */
		
		Map<Employee,Integer> map=new HashMap<>();
		map.put(new Employee(101,"Ram"),101);
		map.put(new Employee(102,"Sham"), 102);
		//As we are overriding hashcode() and equals() in the Employee class, it will override Ram employee with value 103
		map.put(new Employee(101,"Kiran"), 103);
		map.put(new Employee(101,"Amit"), 104);
//		System.out.println(map);
		
		Map<Department,Integer> map1=new HashMap<>();
		map1.put(new Department(101,"IT"), 101);
		map1.put(new Department(102,"HR"), 102);
		map1.put(new Department(103,"Development"), 103);
		map1.put(new Department(101,"Testing"), 104);
		
		System.out.println(map1);
		
	}
	
}
class Department
{
	private Integer deptId;
	private String deptName;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	@Override
	public int hashCode()
	{
		return deptId;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Department dept=(Department)obj;
		if(this.deptId==dept.getDeptId())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
class Employee
{
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
	public Employee(Integer empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
	@Override
	public int hashCode() {
		return empId;
//		return Objects.hash(empId, empName);
	}
	
	@Override
	public boolean equals(Object obj) {
		/*if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName);*/
		
		Employee e=(Employee)obj;
		if(e.getEmpId().equals(this.getEmpId()))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
	
}