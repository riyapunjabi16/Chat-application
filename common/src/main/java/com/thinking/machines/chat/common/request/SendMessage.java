package com.thinking.machines.chat.common;
import com.thinking.machines.chat.common.annotations.*;
public class SendMessage implements java.io.Serializable
{
@required
private String username;
@required
private String friendUsername;
@MaxLength(100)
private String message;
public void setUsername(String username)
{
this.username=username;
}
public void setFriendUsername(String friendUsername)
{
this.friendUsername=friendUsername;
}
public void setMessage(String message)
{
this.message=message;
}

public String  getUsername()
{
return this.username;
}
public String getFriendUsername()
{
return this.friendUsername;
}
public String getMessage()
{
return this.message;
}
}