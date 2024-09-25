package com.thinking.machines.chat.common;
public class Protocol
{
private Protocol()
{
}
public static final int RequestMessageTypeId=50;
public static final int ResponseMessageTypeId=51;
public static final int ErrorMessageTypeId=52;
public static int invalidMessageTypeID=-1;
public static boolean isValidMessageID(int messageTypeID)
{
return messageTypeID==RequestMessageTypeId ||messageTypeID==ResponseMessageTypeId ||messageTypeID==ErrorMessageTypeId;
}
public static boolean isInvalidMessageID(int messageTypeID)
{
return !isValidMessageID(messageTypeID);
}
}