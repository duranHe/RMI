/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMISubExample_stub
 * Function: The stub for RMISubExample object, which is located at the server side.
 * 
 */

public class RMISubExample_stub extends RemoteStub{
	public Integer getAttribute() throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("getAttribute")
		.withOperation("invokeMethod")
		.withArgs(new Object[0]);
		Integer returnValue = (Integer)(execute(message));
		return returnValue;
	}
	public void incAttribute(Integer num) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("incAttribute")
		.withArgs(new Object[]{num})
		.withOperation("invokeMethod");
		execute(message);
	}

}
