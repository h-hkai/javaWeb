package mail;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
/**
 * <p> @Description: 邮件发送工具类 </p>
 * @author alexli
 * @Date   2017年6月22日 上午10:34:41 
 */
public class MailUtils {

    String to = "";         // 收件人邮箱地址
    String from = "";       // 发件人邮箱地址
    String host = "";       // smtp主机
    String username = "";   //用户名
    String password = "";   //密码
    String filename = "";    // 附件文件名
    String subject = "";     // 邮件主题
    String content = "";     // 邮件正文
    Vector file = new Vector();// 附件文件集合

    public MailUtils() {}

    public MailUtils(String to, String from, String smtpServer,
            String username, String password, String subject, String content) {
        this.to = to;
        this.from = from;
        this.host = smtpServer;
        this.username = username;
        this.password = password;
        this.subject = subject;
        this.content = content;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPassWord(String pwd) {
        this.password = pwd;
    }

    public void setUserName(String usn) {
        this.username = usn;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @param strText
     * @return
     * @Description: 把主题转为中文 utf-8
     * @author alexli
     * @Date   2017年6月22日 上午10:37:07
     */
    public String transferChinese(String strText) {
        try {
            strText = MimeUtility.encodeText(new String(strText.getBytes(),
                    "utf-8"), "utf-8", "B");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strText;
    }

    public void attachfile(String fname) {
        file.addElement(fname);
    }

    /**
     * @return
     * @Description: 发送邮件，发送成功返回true 失败false
     * @author alexli
     * @Date   2017年6月22日 上午10:37:47
     */
    public boolean sendMail() {

        // 构造mail session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMIP");
        props.setProperty("mail.host", "localhost");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 构造MimeMessage 并设定基本的值
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));

            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to));
            subject = transferChinese(subject);
            msg.setSubject(subject);

            // 构造Multipart
            Multipart mp = new MimeMultipart();

            // 向Multipart添加正文
            MimeBodyPart mbpContent = new MimeBodyPart();
            mbpContent.setContent(content, "text/html;charset=utf-8");

            // 向MimeMessage添加（Multipart代表正文）
            mp.addBodyPart(mbpContent);

            // 向Multipart添加附件
            Enumeration efile = file.elements();
            while (efile.hasMoreElements()) {

                MimeBodyPart mbpFile = new MimeBodyPart();
                filename = efile.nextElement().toString();
                FileDataSource fds = new FileDataSource(filename);
                mbpFile.setDataHandler(new DataHandler(fds));
                String filename = new String(fds.getName().getBytes(), "ISO-8859-1");

                mbpFile.setFileName(filename);
                // 向MimeMessage添加（Multipart代表附件）
                mp.addBodyPart(mbpFile);

            }

            file.removeAllElements();
            // 向Multipart添加MimeMessage
            msg.setContent(mp);
            msg.setSentDate(new Date());
            msg.saveChanges();

            // 发送邮件
            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (Exception mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * @param args
     * @Description: 邮件测试main方法
     * @author alexli
     * @Date   2017年6月22日 上午10:40:36
     */
    public static void main(String[] args) {
        MailUtils sendmail = new MailUtils();
        sendmail.setHost("smtp.exmail.qq.com");
        sendmail.setUserName("");
        sendmail.setPassWord("");
        sendmail.setTo("");
        sendmail.setFrom("");
        sendmail.setSubject("张小米");
        sendmail.setContent("<a href=\"https://baidu.com\">Link text</a>");
        //添加附件
//      sendmail.attachfile("d:\\CoolFormat3.4.rar");
        System.out.println(sendmail.sendMail());
    }
}
