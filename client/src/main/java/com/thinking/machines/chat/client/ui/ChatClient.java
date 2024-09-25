package com.thinking.machines.chat.ui.client;
import com.thinking.machines.chat.common.request.*;
import com.thinking.machines.chat.common.util.*;
import com.thinking.machines.tcp.client.*;
import java.io.*;
public class ChatClient
{
private static TCPClient tcpClient
public String clientSend(Request request)
{
try
{
TCPClient tcpClient=new TCPClient(5000,"localhost");
String req=ParseUtility.getRequestMessage(request);
//System.out.println(req);
return new String(tcpClient.send(req.getBytes()));
}
catch(IOException ioException)
{
return ioException.getMessage();
}
}
}