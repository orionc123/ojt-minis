package com.hcl.mtgwrapper.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.hcl.mtgwrapper.model.Card;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@RestController
public class RestClient {
    private static final String ENDPOINT = "https://api.magicthegathering.io/v1";
    private Client client;
    private WebTarget target;

    @PostConstruct
    public void init(){
        client = ClientBuilder.newClient();
    }

    @GetMapping(value = "/card/{multiverseid}", produces = MediaType.APPLICATION_JSON)
    public Card getCard(@PathVariable("multiverseid") int multiverseid) throws IOException {
        String path = String.format("%s/%s/%s", ENDPOINT, "cards", multiverseid);
        //target = client.target(path);

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<Card> card = restTemplate.getForEntity(path,Card.class);
        return card.getBody();

       //return target.request(MediaType.APPLICATION_JSON).get(Card.class);
    }

//        public static Card getCard(String cardId){
//
//    }

//    public static List<Card> getAllCards(){
//
//    }

}
