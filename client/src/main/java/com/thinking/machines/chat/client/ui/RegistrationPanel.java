package com.thinking.machines.chat.client.ui;
import  com.thinking.machines.chat.client.pojo.*;
import com.thinking.machines.chat.common.request.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.chat.common.*;
import com.thinking.machines.chat.common.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class RegistrationPanel extends JPanel
{
private ChatFrame chatFrame;
private JLabel titleLabel;
private JLabel usernameLabel;
private JLabel passwordLabel;
private JLabel confirmPasswordLabel;
private JLabel emailIdLabel;
private JLabel contactNumberLabel;
private JLabel displayNameLabel;
private JTextField usernameTextField;
private JPasswordField passwordPasswordField;
private JPasswordField confirmPasswordPasswordField;
private JTextField emailIdTextField;
private JTextField contactNumberTextField;
private JTextField displayNameTextField;
private JButton registerButton;
public RegistrationPanel(ChatFrame chatFrame)
{ 
initComponents();
addListeners();
this.chatFrame=chatFrame;
}
private void initComponents()
{
titleLabel=new JLabel("Registration");
usernameLabel=new JLabel("Username");
passwordLabel=new JLabel("Password");
confirmPasswordLabel=new JLabel("Confirm password");
emailIdLabel=new JLabel("Email id.");
contactNumberLabel=new JLabel("Contact number");
displayNameLabel=new JLabel("Display name");
usernameTextField=new JTextField();
passwordPasswordField=new JPasswordField();
confirmPasswordPasswordField=new JPasswordField();
emailIdTextField=new JTextField();
contactNumberTextField=new JTextField();
displayNameTextField=new JTextField();
registerButton=new JButton("Register");
setAppearance();
setLayout(new GridLayout(9,3));
add(titleLabel);
add(new JLabel(""));
add(displayNameLabel);
add(displayNameTextField);
add(usernameLabel);
add(usernameTextField);
add(passwordLabel);
add(passwordPasswordField);
add(confirmPasswordLabel);
add(confirmPasswordPasswordField);
add(emailIdLabel);
add(emailIdTextField);
add(contactNumberLabel);
add(contactNumberTextField);
add(registerButton);
add(new JLabel(""));
}
private void setAppearance()
{
}
private void addListeners()
{
registerButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev) 
{
String displayName=displayNameTextField.getText().trim();
String username=usernameTextField.getText().trim();
String password=new String(passwordPasswordField.getPassword()).trim();
String confirmedPassword=new String(confirmPasswordPasswordField.getPassword()).trim();
String emailId=emailIdTextField.getText().trim();
String contactNumber=contactNumberTextField.getText().trim();
Member member=new Member();
member.setUsername(username);
member.setPassword(password);
member.setEmailId(emailId);
member.setContactNumber(contactNumber);
member.setName(displayName);
try
{
chatFrame.Register(member);
}
catch(IOException io)
{
//confirm this 
}

}
}
);
}
}