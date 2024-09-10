package com.dearaz.sigacor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity @Table(name = "recipient_details")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {“createdAt”, “updatedAt”}, allowGetters = true)
public class Recipient implements Serializable {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String recipientNo;
	
	@NotBlank
	private String recipientName;
	
	@NotBlank
	private String recipientRt;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipientNo() {
		return recipientNo;
	}

	public void setRecipientNo(String recipientNo) {
		this.recipientNo = recipientNo;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientRt() {
		return recipientRt;
	}

	public void setRecipientRt(String recipientRt) {
		this.recipientRt = recipientRt;
	}

	

	

}
