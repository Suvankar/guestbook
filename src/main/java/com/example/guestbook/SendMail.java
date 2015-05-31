package com.example.guestbook;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Suvankar Bose (esuvbos) on 5/30/15.
 */
public class SendMail extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "...";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("suvankar.bose@gmail.com", "IINSPIN Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("suvankar.bose@gmail.com", "Mr. User"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        }

    }
}
