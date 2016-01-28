package com.jjhangu.autogenerateproperties;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by david on 2016-01-25.
 */
public class PropertiesManager {

    private static PropertiesManager propertiesManager;

    private Properties properties;

    public PropertiesManager(Application app){
        Resources resources = app.getResources();
        AssetManager assetManager = resources.getAssets();


        String rootPath = "properties";
        try {
            String[] list = assetManager.list(rootPath);
            properties = new Properties();
            for (int i=0; i<list.length;i ++){
                if(list[i].endsWith(".properties")) {
                    Log.e("list", "list : " + Arrays.toString(list));
                    InputStream inputStream = assetManager.open(rootPath+ "/" + list[i]);

                    properties.load(inputStream);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to open microlog property file");
            e.printStackTrace();
        }
    }

    public static PropertiesManager getInstanceOf(Application app){
        if(propertiesManager == null){
            propertiesManager = new PropertiesManager(app);
        }

        return propertiesManager;
    }

    public String getKey(String key ){
        return this.properties.getProperty(key, "");
    }

    public int getIntegerKey(String key ){
        return Integer.parseInt(this.properties.getProperty(key, "-1"));
    }
}
