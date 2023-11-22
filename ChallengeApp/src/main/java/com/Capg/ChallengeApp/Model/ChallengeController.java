package com.Capg.ChallengeApp.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {
	
	@Autowired
	private ChallengeService challengeService;
	
	@GetMapping("/challenge")
	public List<Challenge> getAllChallenges(){
		return  challengeService.getAllChallenges();
	}
	
	@PostMapping("/challenge")
	public String addChallenge(@RequestBody Challenge c) {
		boolean isChallengeAdded=challengeService.addChallenge(c);
		if(isChallengeAdded) {
			return "Challenge added sucessfully";
		}
		else {
			return "Challenge is not added successfully";
		}
	}
	
	@GetMapping("/challenges/{month}")
	public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
		Challenge challenge=challengeService.getChallenge(month);
		if(challenge!=null) {
			return new ResponseEntity<Challenge>( HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Challenge>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> updateChallenge(@PathVariable long id,@RequestBody Challenge uc){
		boolean isChallengeUpdated=challengeService.updateChallenge(id,uc);
		if(isChallengeUpdated) {
			return new ResponseEntity("Challenge updated Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Did not find the challenge with this id", HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> deleteChallenge(@PathVariable long id){
		boolean isChallengeDeleted=challengeService.deleteChallenge(id);
		if(isChallengeDeleted) {
			return new ResponseEntity("Challenge deleted Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Did not find the challenge with this id", HttpStatus.NOT_FOUND);
		}
	}
}
