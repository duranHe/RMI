/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: Proxy
 * Function: Communicate with the server during initialization of client
 * 
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Proxy {
	String serverIP;
	int serverPort;
	public Proxy(String _serverIP, int _serverPort) {
		
		serverIP = _serverIP;
		serverPort = _serverPort;
	}
	
	// get the remote object reference with object name specified.
	public RemoteObjectRef getRemoteObjectRef(String objectName) throws Exception
	{
		Socket sock = null;
		try {
			sock = new Socket(serverIP, serverPort);
		} catch (Exception e) {
			System.out.println("Error creating socket");
		}		
		Message message = new Message();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ois = new ObjectInputStream(sock.getInputStream());
		oos = new ObjectOutputStream(sock.getOutputStream());
		message.withObjectName(objectName)
		.withOperation("getRemoteObjectRef");
		
		oos.writeObject(message);
		oos.flush();
		Message response = null;
		RemoteObjectRef tempror = null;
		response = (Message)(ois.readObject());
		tempror = response.getROR();

		sock.close();
		return tempror;
	}
}
