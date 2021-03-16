package com.hcl.mtgwrapper.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.magicthegathering.javasdk.resource.ForeignData;
import io.magicthegathering.javasdk.resource.Legality;
import io.magicthegathering.javasdk.resource.Ruling;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card implements Serializable {
    String name;
    String layout;
    int cmc;
    String[] colors;
    String[] colorIdentity;
    String type;
    String[] supertypes;
    String[] types;
    String[] subtypes;
    String rarity;
    String set;
    String setName;
    String text;
    String flavor;
    String artist;
    String number;
    String power;
    String toughness;
    String gameFormat;
    String legality;
    String id;
    int multiverseid;

//    private String id;
//    private String layout;
//    private String name;
//    private String[] names;
//    private String manaCost;
//    private double cmc;
//    private String[] colors;
//    private String[] colorIdentity;
//    private String type;
//    private String[] supertypes;
//    private String[] types;
//    private String[] subtypes;
//    private String rarity;
//    private String text;
//    private String originalText;
//    private String flavor;
//    private String artist;
//    private String number;
//    private String power;
//    private String toughness;
//    private String loyalty;
//    private int multiverseid = -1;
//    private String[] variations;
//    private String imageName;
//    private String watermark;
//    private String border;
//    private boolean timeshifted;
//    private int hand;
//    private int life;
//    private boolean reserved;
//    private String releaseDate;
//    private boolean starter;
//    private String set;
//    private String setName;
//    private String[] printings;
//    private String imageUrl;
//    private Legality[] legalities;
//    private BigDecimal priceHigh;
//    private BigDecimal priceMid;
//    private BigDecimal priceLow;
//    private BigDecimal onlinePriceHigh;
//    private BigDecimal onlinePriceMid;
//    private BigDecimal onlinePriceLow;
//    private Ruling[] rulings;
//    private ForeignData[] foreignNames;
}
