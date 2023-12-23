package com.boot.Servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.Entity.Payload;
import com.boot.Repo.payRepo;
import java.util.*;

@Service
public class PayloadServices {

	@Autowired
	private payRepo payRepo;
	
	public List<Payload> getAll()
	{
		return (List<Payload>) payRepo.findAll();
	}
	
	public Payload getPayloadById(String ShipperId) 
	{
		return payRepo.findById(ShipperId).get();
	}
	
	public void delete(String shipperId)
	{
		payRepo.deleteById(shipperId);
	}
	public void addLoad(Payload payload) {
		String randomShpperIdString = UUID.randomUUID().toString();
		payload.setShipperId(randomShpperIdString);
		payRepo.save(payload);
	}
	
	public void updateLoad(String shipperId, Payload payload) {
		payload.setShipperId(shipperId);
		payRepo.save(payload);
	}
}
