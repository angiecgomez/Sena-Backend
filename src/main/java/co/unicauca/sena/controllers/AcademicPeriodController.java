package co.unicauca.sena.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import co.unicauca.sena.model.AcademicPeriod;

@Service
public class AcademicPeriodController {
	
	/**
	 * Attributes
	 */
	
	@Autowired
	private Firestore dbFirestore;
	
	/**
	 * Constructor
	 */
	
	public AcademicPeriodController() {
	}
	
	
	/**
	 * Methods
	 */
	
	public List<AcademicPeriod> getAcademicPeriods() {
		

		List<AcademicPeriod> academicPeriods = new ArrayList<AcademicPeriod>();
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("academic_period").get();
		try {
			List<QueryDocumentSnapshot> docs = result.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				AcademicPeriod period = new AcademicPeriod();
				period = doc.toObject(AcademicPeriod.class);
				academicPeriods.add(period);
			}
			return academicPeriods;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	public boolean create(AcademicPeriod academicPeriod) {
		
		Map<String, Object> data = new HashMap<>();
		List<AcademicPeriod> academicPeriods = new ArrayList<AcademicPeriod>();
		
		academicPeriods = getAcademicPeriods();
		
		for(AcademicPeriod period : academicPeriods) {
			if (period.getId().equals(academicPeriod.getId())) {
				return false;
			}
		}
		data.put("id", academicPeriod.getId());
		data.put("name", academicPeriod.getName());
		data.put("startDate", academicPeriod.getStartDate());
		data.put("endDate", academicPeriod.getEndDate());
		
		ApiFuture<DocumentReference> result = dbFirestore.collection("academic_period").add(data);
		
		try {
			if( result.get().getId() != null) {
				return true;
			}
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		return false;
	}

}
