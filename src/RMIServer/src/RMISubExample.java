/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMISubExample
 * Function: A little class for testing call by reference.
 * 
 */

public class RMISubExample {
	Integer attribute = 0;
	public Integer getAttribute()
	{
		return attribute;
	}
	public void incAttribute(Integer num)
	{
		attribute += num;
	}

}
