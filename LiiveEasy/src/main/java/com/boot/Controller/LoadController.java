package com.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.Entity.Payload;
import com.boot.Servce.PayloadServices;

import jakarta.validation.Valid;

@RestController
public class LoadController {

	@Autowired
	private PayloadServices services;

	@PostMapping("/load")
	public ResponseEntity<ApiResponse> addLoad(@Valid @RequestBody Payload payload) {
		try {
			this.services.addLoad(payload);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Load details added succesfully"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("failed to add"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("load/{loadId}")
	public ResponseEntity<ApiResponse> updateLoad(@Valid @PathVariable("loadId") String shipperId,
			@RequestBody Payload payload) {

		try {
			if (services.getPayloadById(shipperId) == null) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid shipperId"), HttpStatus.NOT_FOUND);
			}
			this.services.updateLoad(shipperId, payload);
			return new ResponseEntity<>(new ApiResponse("Updated Successfully"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("failed to update"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/load")
	public ResponseEntity<List<Payload>> getLoad() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(services.getAll());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("load/{loadId}")
	public ResponseEntity<Payload> getLoadById(@PathVariable("loadId") String shipperId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(services.getPayloadById(shipperId));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("load/{loadId}")
	public ResponseEntity<ApiResponse> deleteLoad(@PathVariable("loadId") String shipperId) {
		try {
			this.services.delete(shipperId);
			return new ResponseEntity<>(new ApiResponse("Deleted Successfully "), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiResponse("Invalid Shepper Id or Load with this Id does not exist"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
