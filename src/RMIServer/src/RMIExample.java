/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMIExample
 * Function: Main test example for the project.
 * 
 */

public class RMIExample {
	Integer attribute;
	RMIPerson person;
	
	public RMIExample()
	{
		attribute = 0;
		person = new RMIPerson();
	}
	
	public Integer add2(Integer a, Integer b)
	{
		return a + b;
	}
	public Integer add3(Integer a, Integer b, Integer c)
	{
		return a + b + c;
	}
	public String concat2(String a, String b)
	{
		return a + b;
	}
	public String concat3(String a, String b, String c)
	{
		return a + b + c;
	}
	public Integer length(String a)
	{
		return a.length();
	}
	public Integer getAttribute()
	{
		return attribute;
	}
	public void incAttribute()
	{
		attribute++;
	}
	
	// call by reference
	public Integer getAttributeByRef(RMISubExample subExample)
	{
		return subExample.getAttribute();
	}
	
	// call by reference
	public void incAttributeByRef(RMISubExample subExample, Integer num)
	{
		subExample.incAttribute(num);
	}
	public RMIPerson getPerson()
	{
		return person;
	}
	
	public void init(RMIPerson p)
	{
		person.age = p.age;
		person.name = p.name;
	}
	
	public void modify(String n, Integer a)
	{
		person.name = n;
		person.age = a;
	}
}
