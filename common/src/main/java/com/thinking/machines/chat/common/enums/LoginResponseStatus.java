package com.thinking.machines.chat.common.enums;
public class LoginResponseStatus
{
public static final String Accepted="Accepted";
public static final String Rejected="Rejected";
private static java.util.Set<String> loginResponseStatusValue=new java.util.HashSet<>();
static
{
loginResponseStatusValue.add(Accepted);
loginResponseStatusValue.add(Rejected);
}
boolean isValid(String loginResponseStatus)
{
return loginResponseStatusValue.contains(loginResponseStatus);
}
}