/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RemoteStub
 * Function: class of stubs. All the stubs for specific objects inherits this class
 * 
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class RemoteStub {
	RemoteObjectRef ror;

	public RemoteStub() {
		// TODO Auto-generated constructor stub
	}
	public void setROR(RemoteObjectRef _ror)
	{
		ror = _ror;
	}
	public RemoteObjectRef getROR()
	{
		return ror;
	}
	
	// core method of the stub. it sends a message containing method invoke information,
	// wait for the server to acutually invoke the method, receive the response from server
	// and retrieve the return value from it.
	Object execute(Message message) throws Exception
	{
		if(ror == null)
		{
			System.out.println("ror is null. returning null.");
			return null;
		}
		Socket sock = null;
		try {
			sock = new Socket(ror.getServerIP(), ror.getServerPort());
		} catch (Exception e) {
			System.out.println("Error creating socket");
		}
		ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
		
		oos.writeObject(message);
		oos.flush();
		Message response = null;
		Object returnValue = null;
		response = (Message)(ois.readObject());
		returnValue = response.getReturnValue();
		sock.close();
		return returnValue;
	}

}
