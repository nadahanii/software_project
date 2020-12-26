package net.codeJava;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class templateController {

	 @Autowired
	 private Notifications service;
	 @GetMapping("/templates")
	 public List<template> list()
	 {
		 return service.read_all_templates();
	 }
	 @GetMapping ("/templates/{id}")
	 public ResponseEntity<template> get_template(@PathVariable Integer id)
	 {
		 try
		 {
		  template temp = service.get(id);
		  return new ResponseEntity<template>(temp,HttpStatus.OK);
		 }catch(NoSuchElementException e)
		 {
			 return new ResponseEntity<template>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @PostMapping("/templates")
	 public void add(@RequestBody template  p)
	 {
		 service.save(p);
	 }
	 
	 @PutMapping("/templates/{id}")
	 public ResponseEntity<?> update(@RequestBody template p , @PathVariable Integer id)
	 {
		 try
		 {
		 template existingTemplate = service.get(id);
		 service.save(p);
		 return new ResponseEntity<>(HttpStatus.OK);
		 }catch(NoSuchElementException e)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/templates/{id}")
	 public ResponseEntity<?> delete(@PathVariable Integer id)
	 {
		 try
		 {
			template temp = service.get(id);
		 service.delete(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		 }catch(NoSuchElementException e)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 
	 
}
