/** The Server of single client program**/

/**
 *
 * @author shubh ketan
 */

import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
import java.io.*; 
class Server1 implements ActionListener 
{
	Frame f; 
	TextField t; 
	List l; 
	Button b; 
	ServerSocket ss; 
	Socket s; 
	Server1() 
	{ 
		f=new Frame("Server"); 
		t=new TextField(); 
		l=new List(); 
		b=new Button("Send"); 
		b.addActionListener(this); 
		f.add(t,BorderLayout.NORTH); 
		f.add(l); 
		f.add(b,BorderLayout.SOUTH); 
		f.setVisible(true); 
		f.setSize(300,300); 
		try 
		{ 
			ss=new ServerSocket(3070); //Creates a server socket, bound to the specified port
			while (true) {
				s=ss.accept(); //Listens for a connection to be made to this socket and accepts it
				System.out.println("Connection created");
				while(true) 
				{ 
					ObjectInputStream ois=new ObjectInputStream(s.getInputStream()); //read's client's message on that socket
					ObjectInputStream ois1=new ObjectInputStream(s.getInputStream());
					String str=ois.readObject().toString(); //converts to string
					String str1=ois1.readObject().toString();
					System.out.println(str);
					System.out.println(str1);
					l.add("Friend:-"+str); //puts on the server's window
					l.add("Friend1:-"+str1);
				} 
			}
		} 
		catch(Exception e) 
		{ 
			System.out.println(e.getMessage());
		} 
	} 
	public static void main(String ar[]) 
	{ 
		Server1 s=new Server1(); 
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		try //for server's message to be put on screen and sent to the client
		{
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream()); //sends message to the client
			oos.writeObject(t.getText()); //ACTUALLY send message to the client
			l.add("Me:-"+t.getText()); 
		} 
		catch(Exception e1) 
		{ 
			System.out.println(e1.getMessage()); 
		} 
	} 
}

//no salesman
//no fridge
//no supply
//688949,688950. monika agarwal. gayatri provisional store.