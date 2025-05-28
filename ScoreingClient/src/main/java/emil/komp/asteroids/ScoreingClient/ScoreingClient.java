package emil.komp.asteroids.ScoreingClient;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import emil.komp.asteroids.common.services.IScore;

public class ScoreingClient implements IScore {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String get() {

       try {
           return restTemplate.getForObject("http://localhost:8080/scoreing", String.class);
       }catch (RestClientException e){
              System.err.println("Failed to get score: " + e.getMessage());
              return "0";
       }
    }

    @Override
    public void post() {

    }
}