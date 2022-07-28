package co.unicauca.sena.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import co.unicauca.sena.model.Schedule;
import co.unicauca.sena.model.User;

@Service
public class UserController {
	
	/**
	 * Attributes
	 */
	
	@Autowired
	 private Firestore dbFirestore;
	
	/**
	 * Constructor
	 */
	
	public UserController() {
	}
	
	/**
	 * Methods
	 * 
	 */
	
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		ApiFuture<QuerySnapshot> result = dbFirestore.collection("user").get();
		try {
			List<QueryDocumentSnapshot> docs = result.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				User user = new User();
				user = doc.toObject(User.class);
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	
	public User getUser(String email, String password) {
		CollectionReference collectionReference = dbFirestore.collection("user");
		ApiFuture<QuerySnapshot> result = collectionReference.whereEqualTo("email", email).whereEqualTo("password", password).get();
		 
		try {
			List<QueryDocumentSnapshot> users = result.get().getDocuments();
			
			User user = new User();
			for(DocumentSnapshot doc : users) {
				user = doc.toObject(User.class);
			}
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public List<User> getActiveUsers() {
		CollectionReference collectionReference = dbFirestore.collection("user");
		ApiFuture<QuerySnapshot> results = collectionReference.whereEqualTo("state", "true").get();
		List<User> users = new ArrayList<User>();
		 
		try {
			List<QueryDocumentSnapshot> docs = results.get().getDocuments();
			for(DocumentSnapshot doc : docs) {
				User user = new User();
				user = doc.toObject(User.class);
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	public List<Schedule> getSchedulesUsers(String id){
		CollectionReference collectionReference = dbFirestore.collection("schedule");
		ApiFuture<QuerySnapshot> result = collectionReference.whereEqualTo("idUser", id).get();
		
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
