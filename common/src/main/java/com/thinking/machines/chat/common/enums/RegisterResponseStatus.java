package com.thinking.machines.chat.common.enums;
public class RegisterResponseStatus
{
public static final String Accepted="Accepted";
public static final String Rejected="Rejected";
private static java.util.Set<String> registerResponseStatusValue=new java.util.HashSet<>();
static
{
registerResponseStatusValue.add(Accepted);
registerResponseStatusValue.add(Rejected);
}
boolean isValid(String registerResponseStatus)
{
return registerResponseStatusValue.contains(registerResponseStatus);
}
}