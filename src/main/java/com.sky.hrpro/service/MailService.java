package com.sky.hrpro.service;

import com.sky.hrpro.dao.IdDao;
import com.sky.hrpro.dao.MailRecordDao;
import com.sky.hrpro.entity.MailRecordEntity;
import com.sky.hrpro.util.Constants;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @Author: CarryJey @Date: 2018/10/20 16:18:12
 * desc：邮件发送服务
 */
@Service
public class MailService {
    @Autowired
    private IdDao idDao;

    @Autowired
    private MailRecordDao mailRecordDao;

    /**
     * 发送邮件
     */
    public boolean sendMail(String to,String text,String title){
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.163.com"); // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", "smtp.163.com"); // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true"); // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props); // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(true); // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session); // 加载发件人地址
        try {
            message.setFrom(new InternetAddress(Constants.MAIL_FROM_IP));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 加载收件人地址
            message.setSubject(title); // 加载标题
            Multipart multipart = new MimeMultipart(); // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            BodyPart contentPart = new MimeBodyPart(); // 设置邮件的文本内容
            contentPart.setContent(text, "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges(); // 保存变化
            Transport transport = session.getTransport("smtp"); // 连接服务器的邮箱
            transport.connect("smtp.163.com", Constants.MAIL_FROM_NAME, Constants.MAIL_FROM_PASSWORD); // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            MailRecordEntity mailRecordEntity = new MailRecordEntity();
            mailRecordEntity.setFromAddress(Constants.MAIL_FROM_IP);
            mailRecordEntity.setToAddress(to);
            mailRecordEntity.setContent(text);
            mailRecordEntity.setTitle(title);
            mailRecordEntity.setCreatedTime(System.currentTimeMillis());
            mailRecordEntity.setUpdatedTime(System.currentTimeMillis());

            mailRecordDao.addRecord(mailRecordEntity);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 查询邮件
    */
    public MailRecordEntity getMailRecord(String toAddress){
        return mailRecordDao.getMailRecord(Constants.MAIL_FROM_IP,toAddress);
    }
}

