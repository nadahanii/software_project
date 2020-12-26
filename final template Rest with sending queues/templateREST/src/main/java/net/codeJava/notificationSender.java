package net.codeJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class notificationSender {
	@Autowired
	private Notifications notificationService;
	@Autowired
	private senderService senderService;
	 @GetMapping ("/send/{subject}/{name}")
	public void send_notification(@PathVariable String subject,@PathVariable String name) {
		 template temp=notificationService.findBySub(subject);
		 String tempContent = temp.getContent();
		 String res="";
		 String methood="";
		 for(int i=0;i<tempContent.length();i++) {
			 if(tempContent.charAt(i)=='(' && tempContent.charAt(i+1)=='n' && tempContent.charAt(i+2)==')') {
				 res+=name;
				 i+=3;
				 methood="mail";
			 }
			 else if(tempContent.charAt(i)=='(' && tempContent.charAt(i+1)=='p' && tempContent.charAt(i+2)==')') {
				 res+=name;
				 i+=3;
				 methood="SMS";
			 }
			 else
				 res+=tempContent.charAt(i);
		 }
		 
		 sendingqueue toBeSent = new sendingqueue();
		 toBeSent.setMethod(methood);
		 toBeSent.setcontent(res);
		 
		 senderService.save(toBeSent);
		 
		 
		 
		 
	 }
	

}
