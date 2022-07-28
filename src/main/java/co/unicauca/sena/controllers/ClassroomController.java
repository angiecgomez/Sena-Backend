package co.unicauca.sena.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import co.unicauca.sena.model.Classroom;
import co.unicauca.sena.model.Schedule;

@Service
public class ClassroomController {

	/**
	 * Attributes
	 */
	
	@Autowired
	 private Firestore dbFirestore;
	
	/**
	 * Constructor
	 */
	
	public ClassroomController() {
	}
	
	/**
	 * Methods
	 */
	
	public List<Classroom> getClassrooms() {
		
		List<Classroom> classrooms = new ArrayList<Classroom>();
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("classroom").get();
		try {
			List<QueryDocumentSnapshot> docs = result.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				Classroom classroom = new Classroom();
				classroom = doc.toObject(Classroom.class);
				classrooms.add(classroom);
			}
			return classrooms;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	public List<Classroom> getActiveClassrooms() {
		
		List<Classroom> classrooms = new ArrayList<Classroom>();
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("classroom").whereEqualTo("state", "true").get();
		try {
			List<QueryDocumentSnapshot> docs = result.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				Classroom classroom = new Classroom();
				classroom = doc.toObject(Classroom.class);
				classrooms.add(classroom);
			}
			return classrooms;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	public boolean setClassroomState(String id) {

		ApiFuture<QuerySnapshot> result = dbFirestore.collection("classroom").whereEqualTo("cod", id).get();
		
		try {
			QueryDocumentSnapshot docs = result.get().getDocuments().get(0);
			String cod = docs.getId();
			
			//for(QueryDocumentSnapshot doc : docs) {
				//cod = doc.getId();
			//}
			//System.out.println("cod:" +cod);
			
			ApiFuture<DocumentSnapshot> snapshot = dbFirestore.collection("classroom").document(cod).get();
			String classroom = snapshot.get().get("state").toString();
			
			ApiFuture<WriteResult> writeResult;
			
			if( classroom.equals("true")) {
				writeResult = dbFirestore.collection("classroom").document(cod).update("state",false);
			} else {
				writeResult = dbFirestore.collection("classroom").document(cod).update("state",true);
			} 
			if (writeResult.get().getUpdateTime() != null) {
				return true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean create(Classroom classroom) {
		
		Map<String, Object> data = new HashMap<>();
		List<Classroom> classrooms = new ArrayList<Classroom>();
		
		classrooms = getClassrooms();
		
		for(Classroom room : classrooms) {
			if (room.getCod().equals(classroom.getCod())) {
				return false;
			}
		}
		data.put("cod", classroom.getCod());
		data.put("name", classroom.getName());
		data.put("type", classroom.getType());
		data.put("location", classroom.getLocation());
		data.put("capacity", classroom.getCapacity());
		data.put("state", classroom.getState());
		
		ApiFuture<DocumentReference> result = dbFirestore.collection("classroom").add(data);
		
		try {
			if( result.get().getId() != null) {
				return true;
			}
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		return false;
		
	}
	
	public boolean update(Classroom classroom) {
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("classroom").whereEqualTo("cod", classroom.getCod()).get();
		
		try {
			QueryDocumentSnapshot docs = result.get().getDocuments().get(0);
			String id = docs.getId();
			
			Map<String, Object> data = new HashMap<>();
			data.put("cod", classroom.getCod());
			data.put("name", classroom.getName());
			data.put("type", classroom.getType());
			data.put("location", classroom.getLocation());
			data.put("capacity", classroom.getCapacity());
			data.put("state", classroom.getState());
			
			ApiFuture<WriteResult> snapshot = dbFirestore.collection("classroom").document(id).set(data);
			
			if (snapshot.get().getUpdateTime() != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean delete(String id) {
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("classroom").whereEqualTo("cod", id).get();
		try {
			QueryDocumentSnapshot docs = result.get().getDocuments().get(0);
			String cod = docs.getId();
			
			
			ApiFuture<WriteResult> snapshot = dbFirestore.collection("classroom").document(cod).delete();
			
			if (snapshot.get().getUpdateTime() != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public List<Schedule> getSchedulesClassrooms(String cod){
		
		CollectionReference collectionReference = dbFirestore.collection("schedule");
		ApiFuture<QuerySnapshot> result = collectionReference.whereEqualTo("idClassroom", cod).get();
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		try {
			List<QueryDocumentSnapshot> snapshot = result.get().getDocuments();
			
			
			for(DocumentSnapshot doc : snapshot) {
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

}
