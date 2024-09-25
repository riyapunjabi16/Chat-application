package com.thinking.machines.chat.common.store;
import com.thinking.machines.common.pojo.*;
import java.util.*;
public class Store implements java.io.Serializable
{
private Store()
{
}
static private HashMap<String,String> racksRegister=new HashMap<>();
static private HashMap<String,HashMap> racks=new HashMap<>();
static public <T1,T2> void keep(String action,String messageId,Pair<T1,T2> pair)
{
racksRegister.put(messageId,action);
HashMap<String,Object> rack=racks.get(action);
if(rack==null)
{
rack=new HashMap<String,Object>();
racks.put(action,rack);
}
rack.put(messageId,pair);
}
static public <T1,T2> Pair<T1,T2> get(String messageId)
{
String action=racksRegister.get(messageId);
return (Pair<T1,T2>)racks.get(action).get(messageId);
}
}