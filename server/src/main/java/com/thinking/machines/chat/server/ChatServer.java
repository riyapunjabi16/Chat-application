package com.thinking.machines.chat.server;
import java.text.*;
import java.util.*;
import java.io.*;
import com.thinking.machines.chat.server.pojo.*;
import com.google.gson.*;
import com.google.gson.stream.*;
import com.thinking.machines.tcp.common.event.*;
import com.thinking.machines.tcp.server.*;
import com.thinking.machines.chat.common.util.*;
import com.thinking.machines.chat.common.request.*;
import com.thinking.machines.chat.common.response.*;
import com.thinking.machines.chat.common.*;
import com.thinking.machines.chat.common.enums.*;
import com.thinking.machines.chat.server.util.*;
import com.thinking.machines.tcp.common.pojo.*;
import com.thinking.machines.logger.*;
import com.thinking.machines.chat.server.dao.*;
import java.sql.*;
public class ChatServer implements TCPListener
{
private TCPServer tcpServer;
private Configuration configuration;
//private HashMap<String,UserThread> userThreads;
public ChatServer()
{ 
try
{ 
loadConfiguration();
setupLogger();
java.util.Date now=new java.util.Date();
Logger.log(now,"Configuration loaded............");
DAOConnection.driver=configuration.getDriver();
DAOConnection.connectionString=configuration.getDatabaseConnectionString();
DAOConnection.username=configuration.getDatabaseUsername();
DAOConnection.password=configuration.getDatabasePassword();
Logger.log(now,"Initiating Server..........");
this.tcpServer=new TCPServer(configuration.getChatServerIncomingPortNumber(),configuration.getChatServerOutgoingPortNumber());
Logger.log(now,"Server initiated...........");
populateDataStructures();
Logger.log(now,"Server is listening on port : "+configuration.getChatServerIncomingPortNumber());
startServer();
}
catch(Throwable throwable)
{ 
throwable.printStackTrace();
System.exit(0);
}
}
private void populateDataStructures()
{ 
//this.userThreads=new HashMap<String,UserThread>();
}
private void startServer() throws IOException
{
 this.tcpServer.start(this);
}
private void loadConfiguration() throws IOException
{
Gson gson = new Gson();
JsonReader reader = new JsonReader(new FileReader("configuration.json"));
configuration=gson.fromJson(reader, Configuration.class);
}
private void setupLogger()
{
Logger.setStore(this.configuration.getLogStore());
Logger.setDebugMode(this.configuration.getDebugMode());
Logger.setPrefix("chat_");
Logger.setSuffix("log");
}
public byte[] onData(Client client,byte bytes[])
{
Log log=new Log();
Response response=new Response();
String clientIP=client.getIP();
byte requestBytes[]=bytes;
String requestString=new String(requestBytes);
log.remoteAddress=clientIP;
log.requestString=requestString;
SimpleDateFormat logDateFormat=new SimpleDateFormat("dd/MM/yyyy (hh:mm:ss)");
log.requestTimeString=logDateFormat.format(new java.util.Date());
Request request=ParseUtility.getRequest(requestString);
String action=request.getAction();
boolean valid=true;
if(!Action.isValidAction(action))
{
// nothing to do right now, don't forget the log
valid=false;
} 
if(action.equals(Action.Register))
{
boolean b=true;
Register register=ParseUtility.getObjectFromJSON(request.getPayload(),Register.class);
RegisterResponse registerResponse=new RegisterResponse();
ResponseError responseError=register.getError();
if(responseError!=null)
{ 
// nothing to do right now, dont forget the log
valid=false;
}
Connection connection=DAOConnection.getConnection();
if(connection==null)
{ 
// some serious problem;, don't forget the log
valid=false;
} 
if(valid)
{
b=true;
 try
{
PreparedStatement preparedStatement=connection.prepareStatement("select code from member where username=?");
preparedStatement.setString(1,register.getUsername());
ResultSet resultSet=preparedStatement.executeQuery();
b=resultSet.next();
resultSet.close();
preparedStatement.close();
String reason="";
if(b)
{
valid=false;
reason="Username : "+register.getUsername()+" not available";
} 
if(valid==true && register.getEmailId()!=null && register.getEmailId().trim().length()>0)
{
preparedStatement=connection.prepareStatement("select code from member where email_id=?");
preparedStatement.setString(1,register.getEmailId());
resultSet=preparedStatement.executeQuery();
 b=resultSet.next();
resultSet.close();
preparedStatement.close();
if(b)
{
valid=false;
reason="Another account exists against email Id. : "+register.getEmailId();
}
}
if(valid==true && register.getContactNumber()!=null &&
register.getContactNumber().trim().length()>0)
{
preparedStatement=connection.prepareStatement("select code from member where contact_number=?");
preparedStatement.setString(1,register.getContactNumber());
resultSet=preparedStatement.executeQuery();
b=resultSet.next();
resultSet.close();
preparedStatement.close();
if(b)
{
valid=false;
reason="Another account exists against contact number : "+register.getContactNumber();
}}
response.setMessageTypeId(Protocol.ResponseMessageTypeId);
response.setMessageId(request.getMessageId());
if(valid==false)
{
registerResponse.setStatus(RegisterResponseStatus.Rejected);
registerResponse.setReason(reason);
} 
else
{
String passwordKey=UUID.randomUUID().toString();
String encryptedPassword=PasswordUtility.encrypt(register.getPassword(),passwordKey);
preparedStatement=connection.prepareStatement("insert into member (email_id,username,password,password_key,name,contact_number) values (?,?,?,?,?,?)");
preparedStatement.setString(1,register.getEmailId());
preparedStatement.setString(2,register.getUsername());
preparedStatement.setString(3,encryptedPassword);
preparedStatement.setString(4,passwordKey);
preparedStatement.setString(5,register.getName());
preparedStatement.setString(6,register.getContactNumber());
preparedStatement.executeUpdate();
registerResponse.setStatus(RegisterResponseStatus.Accepted);
} 
connection.close();
}catch(SQLException sqlException)
{
sqlException.printStackTrace(); // abi socha nahin hain, kya karna hain
// setting up something in response
}
response.setPayload(ParseUtility.getJSONString(registerResponse));
}
}
else if(action.equals(Action.Login))
{
boolean b;
String reason=" ";
Login login=ParseUtility.getObjectFromJSON(request.getPayload(),Login.class);
LoginResponse loginResponse=new LoginResponse();
Connection connection=DAOConnection.getConnection();
response.setMessageTypeId(Protocol.ResponseMessageTypeId);
response.setMessageId(request.getMessageId());
if(connection==null)
{ 
// some serious problem;, don't forget the log
valid=false;
reason="Connection problem.";
loginResponse.setStatus(LoginResponseStatus.Rejected);
loginResponse.setReason(reason);
} 
if(valid)
{
b=false;
try
{
PreparedStatement preparedStatement=connection.prepareStatement("select code from member where username=?");
preparedStatement.setString(1,login.getUsername());
ResultSet resultSet=preparedStatement.executeQuery();
b=resultSet.next();
resultSet.close();
preparedStatement.close();
}
catch(SQLException sqlException)
{
valid=false;
reason=sqlException.getMessage();
}
if(b)
{
loginResponse.setStatus(LoginResponseStatus.Accepted);
}
else
{
loginResponse.setStatus(LoginResponseStatus.Rejected);
valid=false;
reason="Username : "+login.getUsername()+" not available";
loginResponse.setReason(reason);
}
}
String responseString=ParseUtility.getJSONString(loginResponse);
response.setPayload(responseString);
}
 else if(action.equals(Action.Logout))
{
}
String responseString=ParseUtility.getResponseMessage(response);
log.responseTimeString=logDateFormat.format(new java.util.Date());
log.responseString=responseString;
Logger.log(new java.util.Date(),new Gson().toJson(log));
return responseString.getBytes();
}
public void onClose(Client client)
{
}
public void onOpen(Client client)
{
}

}