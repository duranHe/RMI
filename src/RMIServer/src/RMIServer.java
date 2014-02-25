/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMIServer
 * Function: Main entry of server side.
 * 
 */


import java.net.Socket;


public class RMIServer 
{
	public static void main(String[] args) throws Exception
	{
		
		if(args.length != 1)
		{
			System.out.println("USAGE: listenPort");
			return;
		}
		
		RMIServerSkeleton server = new RMIServerSkeleton(args[0]);
		System.out.println("Server IP: " + server.ipAddr);
		System.out.println("Server Listen Port: " + server.listenPort);
		
		// loop to accept client side requests
		while(true)
		{
			System.out.println("Waiting for request");
			Socket socket = server.ss.accept();
			System.out.println("Client request received");
			server.exec(socket);
		}
	}
}
