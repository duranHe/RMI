/* 
 * Name: Yuning He
 * 		 Peixin Zheng
 * 
 * Andrew ID: yuningh
 * 			  peixinz
 * 
 * Class Name: RMIClient
 * Function: Main entry of Client side
 * 
 */
import java.util.HashMap;
import java.util.Scanner;


public class RMIClient {
	

	public static void main(String[] args) throws Exception
	{
		if(args.length != 2)
		{
			System.out.println("Usage: RMIClient [Server_IP] [Server_Port]");
			return;
		}
		String serverIP = args[0];
		int serverPort = Integer.parseInt(args[1]);
		
		Proxy proxy = new Proxy(serverIP, serverPort);
		
		RemoteObjectRef ror = proxy.getRemoteObjectRef("RMIExample");
		RMIExample_stub stub = (RMIExample_stub)ror.localize();
		RemoteObjectRef rorSub = proxy.getRemoteObjectRef("RMISubExample");
		RMISubExample_stub stubSub = (RMISubExample_stub)rorSub.localize();
		
		//Below are demos that we provide for you
		System.out.println("Demos:");
		
		System.out.println("2 + 3 = " + stub.add2(2, 3));
		System.out.println("2 + 3 + 4 = " + stub.add3(2, 3, 4));
		System.out.println("Carnegie + Mellon = " + stub.concat2("Carnegie", "Mellon"));
		System.out.println("Carnegie + Mellon + University = " + stub.concat3("Carnegie", "Mellon", "University"));
		System.out.println("Length of alphabet: " + stub.length("abcdefghijklmnopqrstuvwxyz"));
		
		stub.incAttribute();
		System.out.println("Attribute of RMIExample: " + stub.getAttribute());
		stub.incAttributeByRef(stubSub, 1234);
		System.out.println("Attribute of RMISubExample: " + stub.getAttributeByRef(stubSub));
		
		RMIPerson person = new RMIPerson("Bovik", 20);
		stub.init(person);
		System.out.println("Name: " + person.name + " age: " + person.age);
		
		stub.modify("Kesden", 30);
		person = stub.getPerson();
		System.out.println("Name: " + person.name + " age: " + person.age);
		
		//You can now test our programs yourself

		//Map of available methods: <methodName, number of arguments>
		HashMap<String, Integer> methodSet = new HashMap<String, Integer>();
		methodSet.put("add2", 2);
		methodSet.put("add3", 3);
		methodSet.put("concat2", 2);
		methodSet.put("concat3", 3);
		methodSet.put("length", 1);
		methodSet.put("incAttribute", 0);
		methodSet.put("getAttribute", 0);
		methodSet.put("incAttributeByRef", 2);
		methodSet.put("getAttributeByRef", 1);
		methodSet.put("getPerson", 0);
		methodSet.put("modify", 2);
		
		System.out.println("\nNow you can test our programs yourself");
		Scanner s = new Scanner(System.in);
		String line;
		String note = "You can test all the methods in RMIExample stub\n";
		note += "RMISubExample stubSub is used for passing reference. You can use it as a input argument\n";
		note += "We do not provide testing for stubSub because they are the same in RMIExample stub\n";
		note += "You may refer to the report regarding what method is available and what are the arguments\n";
		note += "\nInput format: methodName argument1 argument2 ... argumentN";
		System.out.println(note);
		String[] command;
		while(true)
		{
			System.out.print("Client>");
			line = s.nextLine();
			command = line.split(" ");
			String method = command[0];
			if(!methodSet.containsKey(method))
				System.out.println("Unavailable method");
			else
			{
				if(command.length != methodSet.get(method) + 1)
					System.out.println("Method " + method + " takes " + methodSet.get(method) + " input arguments");
				else
				{
					try
					{
						// dispatch the method invoke to different methods in the stub
						if(method.equals("add2"))
							System.out.println(stub.add2(Integer.parseInt(command[1]), Integer.parseInt(command[2])));
						if(method.equals("add3"))
							System.out.println(stub.add3(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3])));
						if(method.equals("concat2"))
							System.out.println(stub.concat2(command[1], command[2]));
						if(method.equals("concat3"))
							System.out.println(stub.concat3(command[1], command[2], command[3]));
						if(method.equals("length"))
							System.out.println(stub.length(command[1]));
						if(method.equals("incAttribute"))
							stub.incAttribute();
						if(method.equals("getAttribute"))
							System.out.println(stub.getAttribute());
						if(method.equals("incAttributeByRef"))
						{
							if(!command[1].equals("stubSub"))
							{
								System.out.println("Invalid argument type");
								continue;
							}
							stub.incAttributeByRef(stubSub, Integer.parseInt(command[2]));
						}
						if(method.equals("getAttributeByRef"))
						{					
							if(!command[1].equals("stubSub"))
							{
								System.out.println("Invalid argument type");
								continue;
							}
							System.out.println(stub.getAttributeByRef(stubSub));
						}
						if(method.equals("modify"))
							stub.modify(command[1], Integer.parseInt(command[2]));
						if(method.equals("getPerson"))
						{
							person = stub.getPerson();
							System.out.println("Name: " + person.name + " age: " + person.age);
						}
					}
					catch(Exception e)
					{
						System.out.println("Invalid argument type");
					}
				}
			}
		}
	}
}
