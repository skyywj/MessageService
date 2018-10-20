package com.sky.hrpro.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: CarryJey @Date: 2018/10/20 16:43:30
 */
@SpringBootTest
@Component
@RunWith(SpringRunner.class)
public class TestMailService {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail() {
        /**
         * 注意：如果邮件内容违规是发不出去的。
         * 请参看网易企业退信常见问题：http://help.163.com/09/1224/17/5RAJ4LMH00753VB8.html
         */
        String to = "857516673@qq.com";
        String text = "明天早上我在家等你 一起去爬山";
        String title = "明天去爬山";
        mailService.sendMail(to, text, title);
    }
}
