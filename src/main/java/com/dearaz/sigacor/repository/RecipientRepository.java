package com.dearaz.sigacor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dearaz.sigacor.model.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
	List<Recipient> findByRecipientName(String recipientName);
	List<Recipient> findByRecipientNo(String recipientNo);
	
}
