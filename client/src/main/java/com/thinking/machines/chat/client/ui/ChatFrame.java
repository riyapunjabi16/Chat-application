package com.thinking.machines.chat.client.ui;
import javax.swing.*;
import java.io.*;
import com.thinking.machines.chat.client.pojo.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
public class ChatFrame extends JFrame
{
private Dimension desktop;
private RegistrationPanel registrationPanel;
private ChatClient chatClient;
public ChatFrame()
{
super("TMChat");
initComponents();
addListeners();
chatClient=new ChatClient();
}
private void initComponents()
{
registrationPanel=new RegistrationPanel(this);
setLayout(new BorderLayout());
setAppearance();
add(registrationPanel,BorderLayout.CENTER);
desktop=Toolkit.getDefaultToolkit().getScreenSize();
setSize(desktop.width-50,desktop.height-100);
setLocation(25,25);
}
private void setAppearance()
{
}
private void addListeners()
{
}
public void Register(Member member) throws IOException
{
chatClient.register(member);
}
}