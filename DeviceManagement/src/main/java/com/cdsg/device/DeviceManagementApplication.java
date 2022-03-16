package com.cdsg.device;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.cdsg.device.service.DeviceService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.Query;

import java.io.IOException;
import java.util.List;

import com.cdsg.device.modeldto.*;
@SpringBootApplication
public class DeviceManagementApplication implements CommandLineRunner{
	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	private DeviceService deviceService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DeviceManagementApplication.class, args);
		System.out.println("Device Management System");
	}
	@Override
    public void run(String... args) throws MessagingException, IOException {

        System.out.println("Sending Email...");
//
//     sendEmail();
//		sendEmailWithAttachment();
        System.out.println("List of devices and number of repairs: ");
        List<DeviceInfo> deviceInfos = deviceService.getDeviceInfo();
        for(DeviceInfo di:deviceInfos) {
        	System.out.println(di);
        }
        System.out.println("List of devices with serial and name: ");
       
        List<Object[]> devs = deviceService.getShortDevice();
        for(Object []o:devs) {
        	System.out.println(o[0] + "===" + o[1]);
        }
        
        System.out.println("Find device by serial No by native query: ");
        List<Object[]> devBySerial = deviceService.findDeviceSerial("75678"); 
        for(Object []o:devBySerial) {
        	System.out.println(o[0] + "***" + o[1]);
        }
        System.out.println("Done");
    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        //msg.setTo("liemht@saigontech.edu.vn", "iscquangtrung@saigontech.edu.vn");
        msg.setTo("linhpty17@saigontech.edu.vn", "taiet17@saigontech.edu.vn"
        		, "vunt17@saigontech.edu.vn",  "minhntq18@saigontech.edu.vn");
        msg.setSubject("This email send by AWP Spring Boot Application");
        
        msg.setText("Hello World \n Spring Boot Email \n Send by...");

        javaMailSender.send(msg);

    }

    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("liemht@saigontech.edu.vn");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("my_photo.png", new ClassPathResource("computer3.jpg"));

        javaMailSender.send(msg);

    }

}
