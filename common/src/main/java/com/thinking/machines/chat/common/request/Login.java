package com.thinking.machines.chat.common.request;
import com.thinking.machines.chat.common.annotations.*;
public class Login implements java.io.Serializable
{
@required
private String username;
@required 
private String password;
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
}