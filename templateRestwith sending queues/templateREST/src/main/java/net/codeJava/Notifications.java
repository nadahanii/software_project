package net.codeJava;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class Notifications {
	
	@Autowired
	private Notification_template notificationTemp;
	public List<template> read_all_templates ()
	{
		return notificationTemp.findAll();
	}
	public void save(template temp)
	{
		notificationTemp.save(temp);
	}
	public template get(Integer id )
	{
		return notificationTemp.findById(id).get();
	}
	public void delete(Integer id)
	{
		notificationTemp.deleteById(id);
	}
	
	public template findBySub(String sub)
	{
		return notificationTemp.findBySubject(sub);
	}
	
	
	
}
