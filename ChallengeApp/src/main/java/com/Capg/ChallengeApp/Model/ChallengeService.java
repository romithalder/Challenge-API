package com.Capg.ChallengeApp.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
	private List<Challenge> challenges=new ArrayList<>();
	private long id=1L;
	
	public ChallengeService() {
		Challenge c1=new Challenge(1L," January", "Learn a new Programming Language");
		challenges.add(c1);
	}
	
	public List<Challenge> getAllChallenges(){
		return challenges;
	}
	
	
	public boolean addChallenge(Challenge c) {
		if(c!=null) {
			c.setId(id++);
			challenges.add(c);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Challenge getChallenge(String month) {
		for(Challenge challenge:challenges) {
			if(challenge.getMonth().equalsIgnoreCase(month)) {
				return challenge;
			}
		}
		return null;
	}

	public boolean updateChallenge(Long id2, Challenge uc) {
		// TODO Auto-generated method stub
		for(Challenge challenge:challenges) {
			if(challenge.getId()==id2) {
				challenge.setMonth(uc.getMonth());
				challenge.setDescription(uc.getDescription());
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteChallenge(Long id) {
		return challenges.removeIf(challenge-> challenge.getId()==(id));
	}

	

}
