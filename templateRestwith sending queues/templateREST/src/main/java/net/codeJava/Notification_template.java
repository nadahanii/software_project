package net.codeJava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Notification_template extends JpaRepository<template, Integer> {
	
	@Query("SELECT t from template t WHERE t.subject=:subject ")
	public template findBySubject (String subject);
	 
}
