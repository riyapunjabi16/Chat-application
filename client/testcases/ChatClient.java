import com.thinking.machines.tcp.client.*;
import com.thinking.machines.tcp.common.event.*;
import com.thinking.machines.chat.common.*;
import com.thinking.machines.chat.common.request.*;
import com.thinking.machines.chat.common.util.*;
public class ChatClient implements TCPListener
{
private TCPClient tcpClient=new TCPClient(5000,"localhost",5001,"localhost",this);
public static void main(String gg[])
{
String username=gg[0];
String password=gg[1];
Login login=new Login();
login.setUsername(username);
login.setPassword(password);
Request request=new Request();
request.setMessageTypeId(50);
request.setMessageId("dfdgg");
request.setAction("Login");
request.setPayload(ParseUtility.getJSONString(login));
String requestString=ParseUtility.getRequestMessage(request);
tcpClient.send(requestString.getBytes(),new ResponseListener()
{
public void onResponse(byte bytes[])
{
System.out.println(new String(bytes));
}
public void onError(String error)
{
}
});
}
public void onOpen(Client client)
{
}
public void onClose(Client client)
{
}
public void onData(Client client,byte bytes[])
{
}
}