package com.bridgelabz.emailSender.utility;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
        public static void main(String[] args) {
            System.out.println("Hello World!");

            String message ="Hello Ritesh, this msg for security check";
            String subject="coder Area: comfirmation";
            String to="rohan567@gmail.com";
            String from="ritesh05@gmail.com";

            sendEmail(message,subject,to,from);
        }

        // this is responsible for send email
        private static void sendEmail(String message, String subject, String to, String from) {

            // Variable for gmail host

            String host="smpt.gmail.com";

            // get the system properties

            Properties properties =System.getProperties();
            System.out.println("PROPERTIES"+properties);

            // setting important information for Properties object

            //host Set
            properties.put("mail.smpt.host", host);
            properties.put("mail.smpt.port", 587);
            properties.put("mail.smpt.ssl.enable", true);
            properties.put("mail.smpt.auth", true);

            // step1:to get the session object

            Session session =Session.getInstance(properties, new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication("ritesh05@gamil.com","********");
                }

            });

            session.setDebug (true);

            // Step 2: Compose the message [text multi,media]

            MimeMessage m= new MimeMessage(session);

            try {

                //from mail
                m.setFrom(from);

                //Adding recipient to msg
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                // adding text to msg

                m.setText(message);

                // send the message using Transport
                Transport.send(m);
                System.out.print("Mail sent successfully....");

            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

