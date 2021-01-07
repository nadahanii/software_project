package net.codeJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dequeueing_service {
	
	
	@Autowired
	private dequeueing_repo deq_repo;
	
	
	public List<dequeueing> list ()
	{
		return deq_repo.findAll();
	}
	public void save(dequeueing temp)
	{
		deq_repo.save(temp);
	}
	public dequeueing get(Integer id )
	{
		return deq_repo.findById(id).get();
	}
	public void delete(Integer id)
	{
		deq_repo.deleteById(id);
	}

}
