package com.example.sergio.manejodatos;

import android.content.Context;

import com.example.sergio.manejodatos.pojo.Plant;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PlantPullParser {
    private static final String PLANT_BOTANICAL="BOTANICAL";
    private static final String PLANT_PRICE="PRICE";

    private Plant currentPlant =null;
    private String currentTag = null;
    List<Plant> plantList = new ArrayList<>();

    public List<Plant> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            InputStream stream = context.getAssets().open("plant_catalog.xml");
            xpp.setInput(stream,null);

            int eventType = xpp.getEventType();

            while ( eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        handleStartTag(xpp.getName());
                        break;
                    case XmlPullParser.END_TAG:
                        currentTag=null;
                        break;
                    case XmlPullParser.TEXT:
                        handleText(xpp.getText());
                        break;
                }
                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return plantList;
    }

    private void handleStartTag(String xmlTag) {
        if(xmlTag.equals("PLANT")){
            currentPlant = new Plant();
            plantList.add(currentPlant);
        }else{
            currentTag=xmlTag;
        }
    }

    private void handleText(String xmlText) {
        if(currentPlant !=null && currentTag!=null){
            if (currentTag.equals(PLANT_BOTANICAL)){
                currentPlant.setBOTANICAL(xmlText);
            }
            if (currentTag.equals(PLANT_PRICE)){
                currentPlant.setPRICE(xmlText);
            }
        }
    }

}
