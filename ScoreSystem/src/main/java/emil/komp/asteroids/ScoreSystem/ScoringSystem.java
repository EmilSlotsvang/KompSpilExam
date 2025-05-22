package emil.komp.asteroids.ScoreSystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ScoringSystem {

    private RestTemplate restTemplate;

    public ScoringSystem(){
        this.restTemplate = new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @Bean
    public String getPoints() throws Exception {
        String response = restTemplate.getForObject("http://localhost:8080/points?points=1", String.class);
        return response;
    }
}
