package agh.cs.oop1;


import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class World {
    private static final String parametersPath = "parameters.json";

    public static void main(String []args) throws FileNotFoundException {

        try {
            final Configuration config = Configuration.fromJson(World.parametersPath);
            System.out.println(config.toString());
            LoopedMap map = new LoopedMap(config.width, config.height, config.jungleWidth(), config.jungleHeight());

        }catch(FileNotFoundException ex){
            System.out.println("Application cannot be launched!");
        }catch (IllegalArgumentException ex){
            System.out.println("Illegal configuration! Check parameters.json file.\n"+ex.toString());
        }
    }

}
