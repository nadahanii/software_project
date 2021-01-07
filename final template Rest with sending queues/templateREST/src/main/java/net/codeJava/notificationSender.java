package net.codeJava;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class notificationSender {
	@Autowired
	private Notifications notificationService;
	@Autowired
	private senderService senderService;
	 @GetMapping ("/send/{id}/{method}/{name}")
	 public void send_notification(@PathVariable int id,@PathVariable String method,@PathVariable String name,@RequestBody ArrayList<String> placeholders)
	 {
		 sendingqueue toBeSent = new sendingqueue();
		 template temp = notificationService.get(id);
		 String tempContent = temp.getContent();
		 String methood = method;
		 String res="";
		 int c=0 , j=0;
		 for(int i=0;i<tempContent.length();i++)
		 {
			 if(tempContent.charAt(i)=='('  && placeholders.size()!=0)
			 {
				 res+=placeholders.get(j);
				 j++;
				
				 i+=3;
				 c++;
				 
			 }
			 
			 else
			 {
				 res+=tempContent.charAt(i);
			 }
		 }
		 
		 
		 
		 
		 if(c!=placeholders.size())
		 {
			 toBeSent.setStatus("failed");
			 
		 }
		 
		 else
		 {
			 if((methood.equalsIgnoreCase("SMS") && name.length()==11) || (methood.equalsIgnoreCase("email") && name.contains("@") && name.contains(".com")))
			 {
				 toBeSent.setStatus("waiting");
			 }
			 
			 else
			 {
				 toBeSent.setStatus("failed");
			 }
			 
		 }
		 
		 
		 
		 
		 toBeSent.setReceiver(name);
		 toBeSent.setcontent(res);
		 toBeSent.setMethod(methood);
		 senderService.save(toBeSent);
		 
	 }
	 
	 
	 @DeleteMapping("/sending/{id}")
	 public ResponseEntity<?> delete(@PathVariable Integer id)
	 {
		 try
		 {
			sendingqueue temp = senderService.get(id);
		 senderService.delete(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		 }catch(NoSuchElementException e)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 
	
	

}
