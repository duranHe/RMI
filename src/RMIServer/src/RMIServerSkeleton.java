/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMIServerSkeleton
 * Function: Main function of server side.
 * 
 */


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class RMIServerSkeleton 
{

	public String ipAddr;
	public int listenPort;
	public HashMap<String, Object> objMap;
	public ServerSocket ss;
	
	public RMIServerSkeleton(String arg) throws Exception
	{
		// holds the map between object name and object. Serve as a registry
		objMap = new HashMap<String, Object>();
		
		ipAddr = InetAddress.getLocalHost().getHostAddress();
		listenPort = Integer.parseInt(arg);
		ss = new ServerSocket(listenPort);		
		
		// upon initialization, create two objects, RMIExample and RMISubExample,
		// for future testing
		RMIExample obj1 = new RMIExample();
		objMap.put("RMIExample", obj1);
		RMISubExample obj2 = new RMISubExample();
		objMap.put("RMISubExample", obj2);
	}
	
	// Main function of the server side. Process client side requests
	public void exec(Socket socket) throws Exception
	{
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		
		Message msg = (Message) ois.readObject();
		
		// if it asks server to invoke a method,
		// then the server looks for the object according to object name,
		// then invoke the method.
		if(msg.getOperation().equals("invokeMethod"))
		{
			Object[] args = msg.getArgs();	

			Class<?>[] argTypes = new Class<?>[args.length];
			
			// if an argument is a RemoteObjectRef, then change it to the corresponding actual object 
			for (int i = 0; i < args.length; i++)
			{
				if(args[i] instanceof RemoteObjectRef)
					args[i] = objMap.get(((RemoteObjectRef) args[i]).getObjectName());
					
				argTypes[i] = args[i].getClass();
			}
			
			String objName = msg.getObjectName();
			String methodName = msg.getMethodname();
			
			System.out.println("objName: " + objName);
			System.out.println("methodName: " + methodName);
			
			Object obj = objMap.get(objName);
			
			Method m;
			if(args.length == 0)
				m = obj.getClass().getMethod(methodName);
			else
				m = obj.getClass().getMethod(methodName, argTypes);
			
			Object ret = m.invoke(obj, args);
			
			Message retMsg = new Message().withReturnValue(ret);
			oos.writeObject(retMsg);
			oos.flush();
		}
		
		// if it asks server to return a RemoteObjectRef, then look it up and return it.
		if(msg.getOperation().equals("getRemoteObjectRef"))
		{
			RemoteObjectRef ror = new RemoteObjectRef(ipAddr, listenPort, msg.getObjectName());
			Message retMsg = new Message().withROR(ror);
			oos.writeObject(retMsg);
			oos.flush();
		}
	}
}
