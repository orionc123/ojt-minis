package com.hcl.mtgwrapper.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.hcl.mtgwrapper.model.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class RestClient {
    private static final String ENDPOINT = "https://api.magicthegathering.io/v1";
    private static Client client;

    @PostConstruct
    public void init(){
        client = ClientBuilder.newClient();
    }

    @GetMapping("/card/{multiverseid}")
    public static Card getCard(@PathVariable("multiverseid") int multiverseid){
        String path = String.format("%s/%s/%s", ENDPOINT, "cards", multiverseid);
        WebTarget target = client.target(path);
        return target.request(MediaType.APPLICATION_JSON).get(Card.class);
    }

//        public static Card getCard(String cardId){
//
//    }

//    public static List<Card> getAllCards(){
//
//    }

}
