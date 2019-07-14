package bid.techtur.musictaste;

import bid.techtur.musictaste.dto.ArtistDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableFeignClients(basePackages = "bid.techtur.musictaste.client")
@ComponentScan
public class MusicTasteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicTasteApplication.class, args);
	}

}
