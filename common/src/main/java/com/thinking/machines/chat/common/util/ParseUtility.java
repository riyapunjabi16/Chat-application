package com.thinking.machines.chat.common.util;
import com.thinking.machines.chat.common.*;
import com.thinking.machines.chat.common.request.*;
import com.thinking.machines.chat.common.response.*;
import com.google.gson.*;
public class ParseUtility
{
private ParseUtility() {}
static Gson gson=new GsonBuilder().setPrettyPrinting().create();
public static int getMessageTypeId(String message)
{
int messageTypeID=0;
int comma=message.indexOf(",");
if(comma==-1)
return Protocol.invalidMessageTypeID;
try
{
int i=Integer.parseInt(message.substring(1,comma));
if(Protocol.isValidMessageID(i))
messageTypeID=i;
else
messageTypeID=Protocol.invalidMessageTypeID;
return messageTypeID;
}
catch(NumberFormatException nfe)
{
return Protocol.invalidMessageTypeID;
}
}
public static Request getRequest(String message)
{
Request request=null;
String splits[]=getRequestSplits(message);
if(splits==null) return null;
int messageTypeId;
messageTypeId=Integer.parseInt(splits[0]);
String messageId=splits[1];
String action=splits[2];
if(Action.isValidAction(action)==false) return null;
String payLoad=splits[3];
request=new Request();
request.setMessageTypeId(messageTypeId);
request.setMessageId(messageId);
request.setAction(action);
request.setPayload(payLoad);
return request;
}
public static Response getResponse(String message)
{ //[51,"A",{}]
Response response=null;
String splits[]=getResponseSplits(message);
if(splits==null) return null;
int messageTypeId;
messageTypeId=Integer.parseInt(splits[0]);
String messageId=splits[1];
String payLoad=splits[2];
response=new Response();
response.setMessageTypeId(messageTypeId);
response.setMessageId(messageId);
response.setPayload(payLoad);
return response;
}
private static String [] getRequestSplits(String message)
{
String []splits=null;
//[50,"AAA","CCC",{}]
int length=message.length();
if(length<15) return splits;//min length 15 
if(message.charAt(0)!='[' || message.charAt(length-1)!=']') return splits;
message=message.substring(1,length-1);
length-=2;
//50,"AAA","CCC",{}
int c1,c2,c3;
c1=2;
if(message.charAt(c1)!=',') return splits;
int i=c1+1;
if(message.charAt(i)!='\"') return splits;
i++;
while(i<length)
{ if(message.charAt(i)=='\"') break;
i++;
} if(i==length) return splits;
c2=i+1;
if(message.charAt(c2)!=',') return splits;
i=c2+1;
if(message.charAt(i)!='\"') return splits;
i++;
while(i<length)
{ if(message.charAt(i)=='\"') break;
i++;
} if(i==length) return splits;
c3=i+1;
if(message.charAt(c3)!=',') return splits;
if(message.charAt(c3+1)!='{' || message.charAt(length-1)!='}') return splits;
splits=new String[4];
splits[0]=message.substring(0,c1);
splits[1]=message.substring(c1+2,c2-1);
splits[2]=message.substring(c2+2,c3-1);
splits[3]=message.substring(c3+1);
return splits;
}
private static String [] getResponseSplits(String message)
{
String []splits=null;
//[51,"AAA",{}]
int length=message.length();
if(length<11) return splits;
if(message.charAt(0)!='[' || message.charAt(length-1)!=']') return splits;
message=message.substring(1,length-1);
length-=2;
//50,"AAA",{}
int c1,c2;
c1=2;
if(message.charAt(c1)!=',') return splits;
int i=c1+1;
if(message.charAt(i)!='\"') return splits;
i++;
while(i<length)
{ 
if(message.charAt(i)=='\"') break;
i++;
} 
if(i==length) return splits;
c2=i+1;
if(message.charAt(c2)!=',') return splits;
if(message.charAt(c2+1)!='{' || message.charAt(length-1)!='}') return splits;
splits=new String[3];
splits[0]=message.substring(0,c1);
splits[1]=message.substring(c1+2,c2-1);
splits[2]=message.substring(c2+1);
return splits;
}

static public <T>T getObjectFromJSON(String payLoad,Class<T> c)
{
return c.cast(gson.fromJson(payLoad,c));
}
static public String getJSONString(Object object)
{
return gson.toJson(object);
}
public static String getRequestMessage(Request request)
{
return String.format("[%d,\"%s\",\"%s\",%s]",request.getMessageTypeId(),request.getMessageId(),request.getAction(),request.getPayload());
}
public static String getResponseMessage(Response response)
{
return String.format("[%d,\"%s\",%s]",response.getMessageTypeId(),response.getMessageId(),response.getPayload());
}
}