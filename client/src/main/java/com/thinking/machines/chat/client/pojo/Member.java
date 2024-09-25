package com.thinking.machines.chat.client.pojo;
public class Member implements java.io.Serializable
{
private String emailId;
private String username;
private String password;
private String name;
private String contactNumber;
public Member()
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
}