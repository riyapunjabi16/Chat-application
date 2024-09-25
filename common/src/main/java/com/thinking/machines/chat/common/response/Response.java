package com.thinking.machines.chat.common.request;
public class Response
{
private int messageTypeId;
private String messageId;
String payload;
public Response()
{
this.messageTypeId=0;
this.messageId="";
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
public void setPayload(String payload)
{
this.payload=payload;
}
public String getPayload()
{
return this.payload;
}
}