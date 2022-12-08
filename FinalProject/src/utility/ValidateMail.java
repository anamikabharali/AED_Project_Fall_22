/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.mail.Session;

import javax.mail.Session;

import javax.mail.internet.MimeMessage;
  
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.SendFailedException;
import javax.swing.JOptionPane;


/**
 *
 * @author srivaishnaviaekkati
 */
public class ValidateMail {
    
//SETUP MAIL SERVER PROPERTIES
	//DRAFT AN EMAIL
	//SEND EMAIL
		
	Session newSession = null;
	MimeMessage mimeMessage = null;
        public void preparetoSendEmail(String emailSubject, String emailBody, String receipent) throws MessagingException, AddressException, IOException{
                setupServerProperties();
		draftEmail(emailSubject,emailBody,receipent);
		sendEmail();
        }
//	public static void main(String args[]) throws AddressException, MessagingException, IOException
//	{
//		Mail mail = new Mail();
//		mail.setupServerProperties();
//		mail.draftEmail(emailSubject,emailBody,receipent);
//		mail.sendEmail();
//	}

        private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
        
	private void sendEmail() throws MessagingException {
		String fromUser = "srivaishnavi.a@gmail.com";  //Enter sender email id
		String fromUserPassword = "kziwmqhrdfgzjvou";  //Enter sender gmail password , this will be authenticated by gmail smtp server
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("Email successfully sent!!!");
	}

	private MimeMessage draftEmail(String emailSubject, String emailBody, String receipent) throws AddressException, MessagingException, IOException {
            ArrayList<String> emailReceipients = new ArrayList<>();
            emailReceipients.add("srivaishnavi.a");
            emailReceipients.add(receipent);
		mimeMessage = new MimeMessage(newSession);
		
		for (String rec:emailReceipients)
		{
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(rec));
		}
		mimeMessage.setSubject(emailSubject);
                mimeMessage.setContent(emailBody, "text/html");
	   
      // CREATE MIMEMESSAGE 
	    // CREATE MESSAGE BODY PARTS 
	    // CREATE MESSAGE MULTIPART 
	    // ADD MESSAGE BODY PARTS ----> MULTIPART 
	    // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
	    
	    
//		 MimeBodyPart bodyPart = new MimeBodyPart();
//		 bodyPart.setContent(emailBody,"html/text");
//		 MimeMultipart multiPart = new MimeMultipart();
//		 multiPart.addBodyPart(bodyPart);
//		 mimeMessage.setContent(multiPart);
		 return mimeMessage;
	}	
   
}

