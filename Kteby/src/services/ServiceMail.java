/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author bedou
 */
public class ServiceMail {
    
      // Recipient's email ID needs to be mentioned.
      String to ;

      // Sender's email ID needs to be mentioned
      String from ;

      // Assuming you are sending email from localhost
      String host  ;
      
      
      String code;

    public ServiceMail(String to, String from,String password, String host,String sub, String code) {
        this.to = to;
        this.from = from;
        this.host = host;
        
        Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(code);    
           String msg ="<head>\n" +
"<title>Rating Reminder</title>\n" +
"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\">\n" +
"<meta content=\"width=device-width\" name=\"viewport\">\n" +
"<style type=\"text/css\">\n" +
"            @font-face {\n" +
"              font-family: &#x27;Kteby Std&#x27;;\n" +
"              font-weight: 600;\n" +
"              font-style: normal;\n" +
"              src: local(&#x27;Kteby Std Bold&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-bold.woff) format(&#x27;woff&#x27;);\n" +
"            }\n" +
"\n" +
"            @font-face {\n" +
"              font-family: &#x27;Kteby Std&#x27;;\n" +
"              font-weight: 500;\n" +
"              font-style: normal;\n" +
"              src: local(&#x27;Kteby Std Medium&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-medium.woff) format(&#x27;woff&#x27;);\n" +
"            }\n" +
"\n" +
"            @font-face {\n" +
"              font-family: &#x27;Kteby Std&#x27;;\n" +
"              font-weight: 400;\n" +
"              font-style: normal;\n" +
"              src: local(&#x27;Kteby Std Regular&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-regular.woff) format(&#x27;woff&#x27;);\n" +
"            }\n" +
"        </style>\n" +
"<style media=\"screen and (max-width: 680px)\">\n" +
"            @media screen and (max-width: 680px) {\n" +
"                .page-center {\n" +
"                  padding-left: 0 !important;\n" +
"                  padding-right: 0 !important;\n" +
"                }\n" +
"                \n" +
"                .footer-center {\n" +
"                  padding-left: 20px !important;\n" +
"                  padding-right: 20px !important;\n" +
"                }\n" +
"            }\n" +
"        </style>\n" +
"</head>\n" +
"<body style=\"background-color: #f4f4f5;\">\n" +
"<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; height: 100%; background-color: #f4f4f5; text-align: center;\">\n" +
"<tbody><tr>\n" +
"<td style=\"text-align: center;\">\n" +
"<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" id=\"body\" style=\"background-color: #fff; width: 100%; max-width: 680px; height: 100%;\">\n" +
"<tbody><tr>\n" +
"<td>\n" +
"<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"page-center\" style=\"text-align: left; padding-bottom: 88px; width: 100%; padding-left: 120px; padding-right: 120px;\">\n" +
"<tbody><tr>\n" +
"<td style=\"padding-top: 24px;\">\n" +
"<img src=\"https://d1pgqke3goo8l6.cloudfront.net/wRMe5oiRRqYamUFBvXEw_logo.png\" style=\"width: 56px;\">\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td colspan=\"2\" style=\"padding-top: 72px; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #000000; font-family: 'Postmates Std', 'Helvetica', -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; font-size: 48px; font-smoothing: always; font-style: normal; font-weight: 600; letter-spacing: -2.6px; line-height: 52px; mso-line-height-rule: exactly; text-decoration: none;\">Reset your password</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"padding-top: 48px; padding-bottom: 48px;\">\n" +
"<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%\">\n" +
"<tbody><tr>\n" +
"<td style=\"width: 100%; height: 1px; max-height: 1px; background-color: #d9dbe0; opacity: 0.81\"></td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"-ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095a2; font-family: 'Postmates Std', 'Helvetica', -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; font-size: 16px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: -0.18px; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;\">\n" +
"                                      You're receiving this e-mail because you requested a password reset for your Postmates account.\n" +
"                                    </td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"padding-top: 24px; -ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095a2; font-family: 'Postmates Std', 'Helvetica', -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; font-size: 16px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: -0.18px; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;\">\n" +
"                                      Please tap the button below to choose a new password.\n" +
"                                    </td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>\n" +
"<a data-click-track-id=\"37\" href=\"https://postmates.com/\" style=\"margin-top: 36px; -ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #ffffff; font-family: 'Postmates Std', 'Helvetica', -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; font-size: 12px; font-smoothing: always; font-style: normal; font-weight: 600; letter-spacing: 0.7px; line-height: 48px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 220px; background-color: #00cc99; border-radius: 28px; display: block; text-align: center; text-transform: uppercase\" target=\"_blank\">\n" +
"                                        Reset Password\n" +
"                                      </a>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" id=\"footer\" style=\"background-color: #000; width: 100%; max-width: 680px; height: 100%;\">\n" +
"<tbody><tr>\n" +
"<td>\n" +
"<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"footer-center\" style=\"text-align: left; width: 100%; padding-left: 120px; padding-right: 120px;\">\n" +
"<tbody><tr>\n" +
"<td colspan=\"2\" style=\"padding-top: 72px; padding-bottom: 24px; width: 100%;\">\n" +
"<img src=\"https://d1pgqke3goo8l6.cloudfront.net/DFcmHWqyT2CXk2cfz1QB_wordmark.png\" style=\"width: 124px; height: 20px\">\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td colspan=\"2\" style=\"padding-top: 24px; padding-bottom: 48px;\">\n" +
"<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%\">\n" +
"<tbody><tr>\n" +
"<td style=\"width: 100%; height: 1px; max-height: 1px; background-color: #EAECF2; opacity: 0.19\"></td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"-ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095A2; font-family: 'Postmates Std', 'Helvetica', -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; font-size: 15px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: 0; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;\">\n" +
"                                          If you have any questions or concerns, we're here to help. Contact us via our <a data-click-track-id=\"1053\" href=\"https://support.postmates.com/buyer\" style=\"font-weight: 500; color: #ffffff\" target=\"_blank\">Help Center</a>.\n" +
"                                        </td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"height: 72px;\"></td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody></table>\n" +
"\n" +
"\n" +
"\n" +
"</body>" ;
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  

      // Get system properties
      
    
}
