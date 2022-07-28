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
import com.google.firebase.cloud.FirestoreClient;

import co.unicauca.sena.model.Schedule;

@Service
public class ScheduleController {
	
	/**
	 * Attributes
	 */
	
	@Autowired
	 private Firestore dbFirestore;
	
	/**
	 * Constructor
	 */
	public ScheduleController() {
	}
	
	
	/**
	 * Methods
	 */
	
	public List<Schedule> getSchedules() {
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("schedule").get();
		try {
			List<QueryDocumentSnapshot> docs = result.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				Schedule schedule = new Schedule();
				schedule = doc.toObject(Schedule.class);
				schedules.add(schedule);
			}
			return schedules;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	public boolean create(Schedule schedule) {
		Map<String, Object> data = new HashMap<>();
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		
		schedules = getSchedules();
		
		for(Schedule var : schedules) {
			if (var.getId().equals(schedule.getId())) {
				return false;
			}
		}
		data.put("id", schedule.getId());
		data.put("idPeriod", schedule.getIdPeriod());
		data.put("idUser", schedule.getIdUser());
		data.put("day", schedule.getDay());
		data.put("hour", schedule.getHour());
		data.put("idCompetency", schedule.getIdCompetency());
		data.put("idClassroom", schedule.getIdClassroom());
		
		ApiFuture<DocumentReference> result = dbFirestore.collection("schedule").add(data);
		
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
