class psp
{
public static void main(String gg[])
{
String g="[50,\"292\"35\",\"Login\",{\"username\":\"rrr\",\"password\":\"kbc\"}]";
String k=g.substring(1,g.length()-1);
int i=0;
int start=0;
String pc1,pc2,pc3,pc4;
int doubleCount=0;
int messageTypeID=0;
String messageID;
String action;
String payload;
for(i=0;i<k.length();i++)
{
if(k.charAt(i)==',')
{
 i++;
 break;
}
}
pc1=k.substring(0,i-1);
try
{
messageTypeID=Integer.parseInt(pc1);
}
catch(NumberFormatException nfe)
{
System.out.println("Wrong messageID");
}
if(messageTypeID!=50)
{
System.out.println("Wrong messageID");
}
if(k.charAt(i)=='"') start=i+1;
for(i=i;i<k.length();i++)
{
if(k.charAt(i)=='"')
{
doubleCount++;
continue;
}
if(doubleCount==2 ) 
{
i++;
if(k.charAt(i-1)==',')
{
doubleCount=0;
break;
}
else 
{
doubleCount--;
continue;
}
}
}
pc2=k.substring(start,i-2);
messageID=pc2;
//System.out.println(pc2);
start=i+1;
for(i=i;i<k.length();i++)
{
if(k.charAt(i)=='"')
{
i++;
doubleCount++;
continue;
}
if(doubleCount==2 ) 
{
doubleCount=0;
break;
}
}
pc3=k.substring(start,i-2);
action=pc3;
start=i;
for(i=i;i<k.length();i++)
{
if(k.charAt(i)=='}') break;
}
pc4=k.substring(start,i+1);
payload=pc4;
System.out.println(messageTypeID+messageID+action+payload);
}
}