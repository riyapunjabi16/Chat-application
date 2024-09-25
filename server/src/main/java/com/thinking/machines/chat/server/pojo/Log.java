package com.thinking.machines.chat.server.pojo;
public class Log
{
public String remoteAddress;
public String requestTimeString;
public String requestString;
public String responseString;
public String responseTimeString;
public String getRemoteAddress()
{
return this.remoteAddress;
}
public String getRequestString()
{
return this.requestString;
}
public String getRequestTimeString()
{
return this.requestTimeString;
}
public String getResponseTimeString()
{
return this.responseTimeString;
}
public String getResponseString()
{
return this.responseString;
}
}