package com.hcl.mtgwrapper.client;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.api.MTGAPI;
import io.magicthegathering.javasdk.resource.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/*
    This class utilizes the built-in Java SDK for consuming the MTG API.
    https://github.com/MagicTheGathering/mtg-sdk-java
 */
@RestController
@RequestMapping("sdk")
public class SDKRestClient {

    @PostConstruct
    public void init(){
        MTGAPI.setConnectTimeout(60);
        MTGAPI.setReadTimeout(60);
        MTGAPI.setWriteTimeout(60);
    }

    @GetMapping("card/{id}")
    public static Card getCard(@PathVariable("id") int multiverseid){
        return CardAPI.getCard(multiverseid);
    }

    @GetMapping("cards")
    public static List<Card> getAllCards(){
        return CardAPI.getAllCards();
    }
}
