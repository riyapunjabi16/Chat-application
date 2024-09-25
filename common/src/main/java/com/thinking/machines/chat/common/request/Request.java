package com.thinking.machines.chat.common.request;
public class Request
{
private int messageTypeId;
private String messageId;
String action;
String payload;
public Request()
{
this.messageTypeId=0;
this.messageId="";
this.action="";
this.payload="";
}
public void setMessageTypeId(int messageTypeId)
{
this.messageTypeId=messageTypeId;
}
public int getMessageTypeId()
{
return this.messageTypeId;
}
public void setMessageId(String messageId)
{
this.messageId=messageId;
}
public String getMessageId()
{
return this.messageId;
}
public void setAction(String action)
{
this.action=action;
}
public String getAction()
{
return this.action;
}
public void setPayload(String payload)
{
this.payload=payload;
}
public String getPayload()
{
return this.payload;
}
}