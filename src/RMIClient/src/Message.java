/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: Message
 * Function: The message used to communicate between client and server side.
 * 			 It is used for both getting remote object reference and method invoke.
 * 
 */
import java.io.Serializable;


public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12071128105750717L;
	
	// attributes needed
	private String objectName;
	private String methodName;
	private String operation;
	private RemoteObjectRef ror;
	private Object[] args;
	private Class<?>[] argTypes;
	private Object returnValue;

	public Message() {
		objectName = null;
		methodName = null;
		operation = null;
		ror = null;
		args = null;
		argTypes = null;
		returnValue = null;
	}
	public String getObjectName()
	{
		return objectName;
	}
	
	// methods which set the values are designed to return the modified Message object,
	// so that calls can be chained together.
	public Message withObjectName(String _objectName)
	{
		objectName = _objectName;
		return this;
	}
	public String getMethodname()
	{
		return methodName;
	}
	public Message withMethodName(String _methodName)
	{
		methodName = _methodName;
		return this;
	}
	public String getOperation()
	{
		return operation;
	}
	public Message withOperation(String _operation)
	{
		operation = _operation;
		return this;
	}
	public RemoteObjectRef getROR()
	{
		return ror;
	}
	public Message withROR(RemoteObjectRef _ror)
	{
		ror = _ror;
		return this;
	}
	public Object[] getArgs()
	{
		return args;
	}
	public Class<?>[] getArgTypes() {
		return argTypes;
	}
	public Object getReturnValue()
	{
		return returnValue;
	}
	
	// set both args and argTypes
	public Message withArgs(Object[] _args)
	{
		args = _args;

		argTypes = new Class<?>[_args.length];
		for (int i = 0; i < _args.length; i++)
		{
			argTypes[i] = _args[i].getClass();
		}
		return this;
	}
	public Message withReturnValue(Object _returnValue)
	{
		returnValue = _returnValue;
		return this;
	}

}
