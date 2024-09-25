package com.thinking.machines.chat.common.request;
import com.thinking.machines.chat.common.annotations.*;
public class Logout implements java.io.Serializable
{
@required
private String username;
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
}