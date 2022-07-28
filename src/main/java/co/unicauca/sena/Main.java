package co.unicauca.sena;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Punto de inicio de la aplicación
 * @param args
 */

//Application Entry Point
@SpringBootApplication
public class Main {
	
	public static void main(String args[]) throws IOException {
		
		SpringApplication.run(Main.class, args);
		
		/*try {
			FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/ServiceAccountKey.json").getInputStream()))
					  .setDatabaseUrl("https://web-system-sena-default-rtdb.firebaseio.com")
					  .build();
			if(FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
