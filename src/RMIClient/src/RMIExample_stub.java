/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMIExample_stub
 * Function: The stub for RMIExample object, which is located at the server side.
 * 			 It has the same method names as RMIExample, but inside these methods,
 * 			 the stub prepares the invoke information in a Message object, and 
 * 			 send it through execute() method.
 * 
 */

public class RMIExample_stub extends RemoteStub{

	public RMIExample_stub() {
		// TODO Auto-generated constructor stub
	}
	public Integer add2(Integer a, Integer b) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("add2")
		.withArgs(new Object[]{a, b})
		.withOperation("invokeMethod");
		Integer returnValue = (Integer)(execute(message));
		return returnValue;
	}
	public Integer add3(Integer a, Integer b, Integer c) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("add3")
		.withArgs(new Object[]{a, b, c})
		.withOperation("invokeMethod");
		Integer returnValue = (Integer)(execute(message));
		return returnValue;
	}
	public String concat2(String a, String b) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("concat2")
		.withArgs(new Object[]{a, b})
		.withOperation("invokeMethod");
		String returnValue = (String)(execute(message));
		return returnValue;
	}
	public String concat3(String a, String b, String c) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("concat3")
		.withArgs(new Object[]{a, b, c})
		.withOperation("invokeMethod");
		String returnValue = (String)(execute(message));
		return returnValue;
	}
	public Integer length(String a) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("length")
		.withArgs(new Object[]{a})
		.withOperation("invokeMethod");
		Integer returnValue = (Integer)(execute(message));
		return returnValue;
	}
	public Integer getAttribute() throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("getAttribute")
		.withArgs(new Object[0])
		.withOperation("invokeMethod");
		Integer returnValue = (Integer)(execute(message));
		return returnValue;
	}
	public void incAttribute() throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("incAttribute")
		.withArgs(new Object[0])
		.withOperation("invokeMethod");
		execute(message);
	}
	
	// This is the call by reference method. In RMIExample, the argument for this method
	// is RMISubExample. But in the stub, we need to change it to the stub of RMISubExample
	public Integer getAttributeByRef(RMISubExample_stub subExample_stub) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("getAttributeByRef")
		.withArgs(new Object[]{subExample_stub.getROR()})
		.withOperation("invokeMethod");
		Integer returnValue = (Integer)(execute(message));
		return returnValue;
	}
	
	// another call by reference method
	public void incAttributeByRef(RMISubExample_stub subExample_stub, Integer num) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("incAttributeByRef")
		.withArgs(new Object[]{subExample_stub.getROR(), num})
		.withOperation("invokeMethod");
		execute(message);
	}
	public RMIPerson getPerson() throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("getPerson")
		.withArgs(new Object[0])
		.withOperation("invokeMethod");
		RMIPerson returnValue = (RMIPerson)(execute(message));
		return returnValue;
	}
	public void init(RMIPerson p) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("init")
		.withArgs(new Object[]{p})
		.withOperation("invokeMethod");
		execute(message);
	}
	public void modify(String n, Integer a) throws Exception
	{
		Message message = new Message();
		message.withObjectName("RMIExample")
		.withMethodName("modify")
		.withArgs(new Object[]{n, a})
		.withOperation("invokeMethod");
		execute(message);
	}
}
