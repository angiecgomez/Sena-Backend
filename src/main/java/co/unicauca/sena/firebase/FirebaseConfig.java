package co.unicauca.sena.firebase;

import java.io.FileInputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirebaseConfig {

	@Bean
	public Firestore firestore() throws Exception {

		FileInputStream serviceAccount = new FileInputStream("./ServiceAccountKey.json");
		
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
		
		FirebaseApp dbFirestore = FirebaseApp.initializeApp(options);
		return FirestoreClient.getFirestore(dbFirestore);
	}
}
