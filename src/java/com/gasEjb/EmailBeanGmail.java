/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasEjb;


 
import javax.ejb.LocalBean;
import java.util.Properties;
 
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author mmixco
 */
@Stateless
@LocalBean
public class EmailBeanGmail {
    
    final String miCorreo = "soporte2@gruporvq.com";
    final String miContraseña = "sicgas2017";
    final String servidorSMTP = "smtp.gmail.com";
    final String puertoEnvio = "465";
 
   
    String mailReceptor = null;
    String asunto = null;
    String cuerpo = null;
    
    /*<editor-fold defaultstate="collapsed" desc="Variables">*/    


    //private String vpass = "ICZ6102*Soy";
    //private String vpass = "informatica";
    /*</editor-fold>*/
   
    /*<editor-fold defaultstate="collapsed" desc="Template">*/
    public String template2 (String mensaje ){
        
        System.out.println("template 2-->");
        String template = "<html>\n" +
"<head>\n" +
"</head>\n" +
"<body>\n" +
"<table style=\"min-width:332px;max-width:600px;border:1px solid #e0e0e0;border-bottom:0;border-top-left-radius:3px;border-top-right-radius:3px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#4184F3\" width=\"100%\">\n" +
"    <tbody>\n" +
"        <tr>\n" +
"            <td colspan=\"3\" height=\"32px\"></td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td width=\"22px\"></td>\n" +
"            <td style=\"font-family:Roboto-Regular,Helvetica,Arial,sans-serif;font-size:20px;color:#ffffff;line-height:.2\"><H1>Notificacion</H1></td><td width=\"32px\"></td></tr><tr><td colspan=\"3\" height=\"14px\"></td>\n" +
"        </tr>\n" +
"    </tbody>\n" +
"</table>\n" +
" \n" +
"<table style=\"min-width:332px;max-width:600px;border:1px solid #f0f0f0;border-bottom:1px solid #c0c0c0;border-top:0;border-bottom-left-radius:3px;border-bottom-right-radius:3px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#FAFAFA\" width=\"100%\">\n" +
"<tbody>\n" +
"    <tr height=\"16px\">\n" +
"        <td rowspan=\"3\" width=\"32px\"></td>\n" +
"        <td></td>\n" +
"        <td rowspan=\"3\" width=\"32px\"></td>\n" +
"    </tr>\n" +
"    <tr>\n" +
"        <td>Hola mario </td>\n" +
"    </tr>\n" +
"    <tr>\n" +
"        <td>"+mensaje+"</td>\n" +
"    </tr>\n" +
"    <tr>\n" +
"        <td></td>\n" +
"        <td></td>\n" +
"        <td>\n" +
"            <a style=\"\n" +
"        background-color: #4CAF50; /* Green */\n" +
"            border: none;\n" +
"            color: white;\n" +
"            padding: 15px 32px;\n" +
"            text-align: center;\n" +
"            text-decoration: none;\n" +
"            display: inline-block;\n" +
"            font-size: 16px;\" href = \"http://192.168.160.27:8080/tag/\">Autorizar </a>\n" +
"        </td>\n" +
"    </tr>\n" +
" </table>\n" +
"</body>\n" +
"</html> ";
            
 
 

    return template;
    }
    
    


    

        
    public String enviarTmp2(String mailReceptor, String asunto,  String cuerpo) throws MessagingException  {
     
        
        
        cuerpo = template2(cuerpo);
        System.out.println("---->tmp2");
        System.out.println("---->tmp2");
        
        this.mailReceptor = mailReceptor;
        this.asunto = asunto;
        this.cuerpo = cuerpo;

        Properties props = new Properties();
        props.put("mail.smtp.user", miCorreo);
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puertoEnvio);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", puertoEnvio);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SecurityManager security = System.getSecurityManager();

        
            Authenticator auth = new autentificadorSMTP();
            Session session = Session.getInstance(props, auth);
            // session.setDebug(true);
            MimeBodyPart textPart = new MimeBodyPart();            
            Multipart mp = new MimeMultipart();      
            mp.addBodyPart(textPart);
            textPart.setContent(cuerpo, "text/html");  
            MimeMessage msg = new MimeMessage(session);
            
            msg.setContent(cuerpo, "text/html; charset=utf-8");
            msg.setSubject(asunto);            
            msg.setFrom(new InternetAddress(miCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
            mailReceptor));
            Transport.send(msg);
        

      
       
        return "";
    }
    
    
    private class autentificadorSMTP extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miContraseña);
        }
    }
    
       
    
}

