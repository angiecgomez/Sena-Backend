package co.unicauca.sena.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import co.unicauca.sena.model.Competency;

@Service
public class CompetencyController {
	
	/**
	 * Attributes
	 */
	
	@Autowired
	 private Firestore dbFirestore;
	
	/**
	 * Constructor
	 */
	
	public CompetencyController() {
	}
	
	/**
	 * Methods
	 */
	
	public List<Competency> getCompetencies(){
		
		List<Competency> competencies = new ArrayList<Competency>();
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("competency").get();
		try {
			List<QueryDocumentSnapshot> docs = result.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				Competency competency = new Competency();
				competency = doc.toObject(Competency.class);
				competencies.add(competency);
			}
			return competencies;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
