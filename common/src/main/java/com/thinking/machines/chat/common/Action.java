package com.thinking.machines.chat.common;
import java.util.*;
public class Action
{
private Action(){};
public final static String Register="Register";
public final static String Login="Login";
public final static String Logout="Logout";
public final static String AddFriend="AddFriend";
public final static String AcceptFriendRequest="AcceptFriendRequest";
public final static String DeleteFriend="DeleteFriend";
public final static String DeclineFriendRequest="DeclineFriendRequest";
public final static String SendMessage="SendMessage";
public final static String AcceptMessage="AcceptMessage";
public final static String UpdatePassword="UpdatePassword";
public final static String DeleteAccount="DeleteAccount";
public final static String UpdateAccount="UpdateAccount";
public final static String RequestAccepted="RequestAccepted";
private final static java.util.Set<String> actionsSet;
static
{ 
actionsSet=new HashSet<>();
actionsSet.add(Register);
actionsSet.add(Login);
actionsSet.add(Logout);
actionsSet.add(AddFriend);
actionsSet.add(AcceptFriendRequest);
actionsSet.add(DeleteFriend);
actionsSet.add(DeclineFriendRequest);
actionsSet.add(SendMessage);
actionsSet.add(AcceptMessage);
actionsSet.add(UpdatePassword);
actionsSet.add(DeleteAccount);
actionsSet.add(UpdateAccount);
actionsSet.add(RequestAccepted);
}
public static boolean isValidAction(String action)
{
return actionsSet.contains(action);
}
}