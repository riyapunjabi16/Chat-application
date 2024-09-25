package com.thinking.machines.chat.common.request;
import com.thinking.machines.chat.common.annotations.*;
import com.thinking.machines.chat.common.response.*;
public class Register implements java.io.Serializable
{
@optional
@MaxLength(value=1000)
private String emailId;
@required
@MaxLength(value=15)
private String username;
@required
@MaxLength(value=15)
private String password;
@optional
@MaxLength(value=25)
private String name;
@optional
@MaxLength(value=15)
private String contactNumber;
public Register()
{
this.emailId="";
this.username="";
this.password="";
this.name="";
this.contactNumber="";
}
public void setEmailId(String emailId)
{
this.emailId=emailId;
} 
public String getEmailId()
{
return this.emailId;
} 
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
public void setName(String name)
{
this.name=name;
} 
public String getName()
{
return this.name;
} 
public void setContactNumber(String contactNumber)
{
this.contactNumber=contactNumber;
} 
public String getContactNumber()
{
return this.contactNumber;
}
public ResponseError getError()
{
//later we will do it
return null;
} 
}