package kaya.springframework.FlightSearch.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    private JavaMailSender sender;

    public EmailUtil(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendItinerary(String toAddress, String filePath){
        MimeMessage mimeMessage = sender.createMimeMessage();

       try {
           MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
           messageHelper.setTo(toAddress);
           messageHelper.setSubject("Itinerary to your Flight");
           messageHelper.setText("Please find your Itinerary attached");
           messageHelper.addAttachment( "Itinerary", new File(filePath));
           sender.send(mimeMessage);
       }catch (MessagingException e){
           e.printStackTrace();
       }

    }
}
