package com.thinking.machines.chat.server.pojo;
public class Configuration 
{
private  int chatServerIncomingPortNumber;
private  int chatServerOutgoingPortNumber;
private   String driver;
private  String databaseConnectionString;
private   String databaseUsername;
private   String databasePassword;
private    String logStore;
private   String debugMode;
public Configuration()
{
chatServerIncomingPortNumber=0;
chatServerOutgoingPortNumber=0;
driver="";
databaseConnectionString="";
databaseUsername="";
databasePassword="";
}
public   void setChatServerIncomingPortNumber(int chatServerIncomingPortNumber)
{
this.chatServerIncomingPortNumber=chatServerIncomingPortNumber;
}
public   void setChatServerOutgoingPortNumber(int chatServerOutgoingPortNumber)
{
this.chatServerOutgoingPortNumber=chatServerOutgoingPortNumber;
}
public void setDatabaseConnectionString(String databaseConnectionString)
{
this.databaseConnectionString=databaseConnectionString;
} 
public  void setDatabaseUsername(String databaseUsername)
{
this.databaseUsername=databaseUsername;
}
public   void setDatabasePassword(String databasePassword)
{
this.databasePassword=databasePassword;
}
public  void setDriver(String driver)
{
this.driver=driver;
}
public  int getChatServerIncomingPortNumber()
{
return chatServerIncomingPortNumber;
}
public  int getChatServerOutgoingPortNumber()
{
return chatServerOutgoingPortNumber;
}

public   String getDatabaseConnectionString()
{
return databaseConnectionString;
} 
public     String getDatabaseUsername()
{
return databaseUsername;
}
public     String getDatabasePassword()
{
return databasePassword;
}
public     String getDriver()
{
return driver;
}
public     void setDebugMode(String vDebugMode)
{
debugMode=vDebugMode;
}
public     String getDebugMode()
{
return debugMode;
}
public    void setLogStore(String vLogStore)
{
logStore=vLogStore;
}
public     String getLogStore()
{
return logStore;
}
}