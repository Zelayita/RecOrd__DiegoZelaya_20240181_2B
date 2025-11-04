package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiegoZelaya20240181RecuperacionApplication {

	public static void main(String[] args) {
		// Carga variables del .env al sistema
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(DiegoZelaya20240181RecuperacionApplication.class, args);
	}

}
