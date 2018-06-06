package com.drive.drone;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drive.drone.model.InputData;
import com.drive.drone.service.DroneService;

/**
 * The Class DroneApplication.
 */
@SpringBootApplication
public class DroneApplication implements CommandLineRunner {
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DroneApplication.class);
    
    /** The service. */
    @Autowired
    private DroneService service;
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(
        String[] args){
        SpringApplication.run(DroneApplication.class, args);
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    public void run(
        final String... args) throws Exception{
        
        try {
            LOGGER.info("Starting process... ");
            
            service.getIdentificator(askData());
            
            System.out.println(service.getIdentificator(askData()));
            
            LOGGER.info("End process... ");
            
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
    }
    
    /**
     * Ask data.
     *
     * @return the input data
     */
    private InputData askData(){
        InputData in = new InputData();
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce la coordenada X:");
            in.setCoordX(br.readLine());
            System.out.println("Introduce la coordenada Y");
            in.setCoordX(br.readLine());
            System.out.println("Introduce el rango");
            in.setRange(br.readLine());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return in;
    }
}
