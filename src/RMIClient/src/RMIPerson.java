/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMIPerson
 * Function: A little class for testing the RMI.
 * 
 */

import java.io.Serializable;

public class RMIPerson implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2099508481355265623L;
	public String name;
	public int age;
	
	public RMIPerson(String n, int a)
	{
		name = n;
		age = a;
	}
	
	public RMIPerson()
	{
	}
}
