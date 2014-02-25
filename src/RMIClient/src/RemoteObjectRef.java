/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RemoteObjectRef
 * Function: remote object reference. The localize method is in this class
 * 
 */

import java.io.Serializable;


public class RemoteObjectRef implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3055234910228610645L;

	String serverIP;
	int serverPort;
	String objName;

	public RemoteObjectRef(String ip, int port, String name) 
	{
		serverIP = ip;
		serverPort = port;
		objName = name;
	}
	
	// localize. To be specific, generate the stub according to the name of the remote object
	public RemoteStub localize() throws Exception
	{
		String stubName = objName + "_stub";
		Class c = Class.forName(stubName);
		RemoteStub stub = (RemoteStub)c.newInstance();
		stub.setROR(this);
		return stub;
	}
	public String getServerIP()
	{
		return serverIP;
	}
	public int getServerPort()
	{
		return serverPort;
	}
	public String getObjectName()
	{
		return objName;
	}

}
