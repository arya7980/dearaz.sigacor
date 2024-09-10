package com.dearaz.sigacor.controller;

import com.dearaz.sigacor.model.Recipient;
import com.dearaz.sigacor.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/recipient")
public class RecipientController {
	
	@Autowired
	RecipientRepository recipientRepository;
	
	@GetMapping("/")
	public List<Recipient> getAll(){		
		return recipientRepository.findAll();
	}
	
	@PostMapping("/")
	public Recipient addRecipient(@Valid @RequestBody Recipient recipient) {		
		return recipientRepository.save(recipient);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Recipient> updateRecipient(@PathVariable(value="id")Long id,
//			@Valid @RequestBody Recipient detailRecipient){
//
//		Optional<Recipient> recipient = recipientRepository.findById(id);
//		if(recipient == null) {
//			return ResponseEntity.notFound().build();
//		}
//
//		recipient.setNomorUndangan(detailRecipient.getNomorUndangan());;
//		recipient.setNama(detailRecipient.getNama());
//		recipient.setDomisiliRt(detailRecipient.getDomisiliRt());
//
//		Recipient updateRecipient = recipientRepository.save(recipient);
//
//		return ResponseEntity.ok(updateRecipient);
//	}
	
	@DeleteMapping("/{id}")
	public String deleteRecipient(@PathVariable (value="id") Long id) {
		Optional <Recipient> recipient = recipientRepository.findById(id);
		
		String result = "";
		if(recipient == null) {
			result = "id" + id + "not found";
			return result;
		}
		
		result = "id" + id + "Deleted successfully.";
		recipientRepository.deleteById(id);
		
		return result;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Recipient>> getRecipientId(@PathVariable(value="id") Long id){
//		Recipient rcp = recipientRepository.findOne(id);
		Optional <Recipient> rcp = recipientRepository.findById(id);
		
		if(rcp == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(rcp);
	}
	
	@GetMapping("/sortRecipient")
	public List<Recipient> sortRecipient(@RequestParam(value="nama") String recipientName){
		return recipientRepository.findByRecipientName(recipientName);
	}

}
