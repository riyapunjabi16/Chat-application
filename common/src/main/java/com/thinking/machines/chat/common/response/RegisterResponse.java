package com.thinking.machines.chat.common.response;
import com.thinking.machines.chat.common.annotations.*;
public class RegisterResponse implements java.io.Serializable
{
@required
@com.thinking.machines.chat.common.annotations.Enum(name="RegisterResponseStatus")
private String status;
@MaxLength(value=100)
private String reason;
public RegisterResponse()
{
status="";
reason="";
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
}