package com.thinking.machines.chat.common.response;
import com.thinking.machines.chat.common.annotations.*;
import java.util.*;
public class LoginResponse implements java.io.Serializable
{
@required
@com.thinking.machines.chat.common.annotations.Enum(name="RegisterResponseStatus")
private String status;
@MaxLength(value=100)
private String reason;
private List<String> friendList;
private List<String> offlineMessages;
private List<String> friendRequests;
public LoginResponse()
{
status="";
reason="";
friendList=null;
friendRequests=null;
offlineMessages=null;
}
public void setStatus(String status)
{
this.status=status;
}
public String getStatus()
{
return this.status;
}
public void setReason(String reason)
{
this.reason=reason;
}
public String getReason()
{
return this.reason;
}
public void setFriendList(List<String> friendList)
{
this.friendList=friendList;
}
public List<String> getFriendList()
{
return this.friendList;
}
public void setOfflineMessages(List<String> offlineMessages)
{
this.offlineMessages=offlineMessages;
}
public List<String> getOfflineMessages()
{
return this.offlineMessages;
}
}