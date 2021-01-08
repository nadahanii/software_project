package net.codeJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deq_controller {
	
	@Autowired
	private dequeueing_service deq_service;
	@Autowired
	private senderService send_service;
	
	@GetMapping ("/dequeue")
	public void dequeuing()
	{
		dequeueing tempDeq = new dequeueing();
		List<sendingqueue> sentNotifications ;
		sentNotifications = send_service.list();
		
		
		System.out.println("The queued messages : ");
		
		for(int i=0;i<sentNotifications.size();i++)
		{
			if(sentNotifications.get(i).getStatus().equalsIgnoreCase("waiting"))
			{
			
			System.out.println("Send to: " + sentNotifications.get(i).getReceiver());
			System.out.println("By : " + sentNotifications.get(i).getMethod());
			System.out.println(sentNotifications.get(i).getcontent());
			tempDeq.setContent(sentNotifications.get(i).getcontent());
			tempDeq.setMethod(sentNotifications.get(i).getMethod());
			tempDeq.setStatus("succeded");
			tempDeq.setReceiver(sentNotifications.get(i).getReceiver());
			deq_service.save(tempDeq);
			
			}
			
			
			
		}
		
		for(int j=0;j<sentNotifications.size();j++)
		{
			int x=0;
			x=sentNotifications.get(j).getId();
			send_service.delete(x);
		}
		
		
	}
	
	
}