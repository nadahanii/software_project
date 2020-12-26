package net.codeJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class senderService {

	@Autowired
	private senderRepo repo;
	
	public List<sendingqueue> list ()
	{
		return repo.findAll();
	}
	public void save(sendingqueue temp)
	{
		repo.save(temp);
	}
	public sendingqueue get(Integer id )
	{
		return repo.findById(id).get();
	}
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}
	
}
