package net.codeJava;

import org.springframework.data.jpa.repository.JpaRepository;

public interface senderRepo extends JpaRepository<sendingqueue, Integer> {
	
}
