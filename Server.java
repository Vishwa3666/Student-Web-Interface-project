import java.io.*;
import java.net.*;
class Server{

public static void main(String[] args) throws Exception
{
ServerSocket ss = new ServerSocket(2002); 
System.out.println("Server started");
Socket s=ss.accept();
System.out.println("Connection accepted");
ObjectOutputStream outstream = new ObjectOutputStream(s.getOutputStream());
ObjectInputStream instream = new ObjectInputStream(s.getInputStream());
Main m = (Main)instream.readObject();
Main n = new Main(m.ss1,m.ss2,m.ss3,m.ss4,m.ss5);
outstream.writeObject(n);
ss.close();
}

}