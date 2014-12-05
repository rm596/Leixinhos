/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author andre
 */
@Stateless
public class Email {
    //dados email
    final String username = "leixinho@andremlsantos.com";
    final String password = "P1K8QyD!qJ2k@%a";
    
    /*
     * Enviar Email
     * 
     * @param TO Destinatario
     * @param text Texto Email
     * @param subject Assunto Email
     * @return void
     */
    public void sendEmail(String TO, String text, String subject){
        Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "mail.andremlsantos.com");
            props.put("mail.smtp.ssl.trust", "mail.andremlsantos.com");
            props.put("mail.smtp.port", "25");

            Session session2 = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session2);
                message.setFrom(new InternetAddress("leixinho@andremlsantos.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO));
                message.setSubject(subject);
                message.setText(text);
                Transport.send(message);
                System.out.println("Done");
            } catch (MessagingException e) {
                //throw new RuntimeException(e);
                System.out.println("ERRO MAIL " + e.getMessage());
            }
    }

}
