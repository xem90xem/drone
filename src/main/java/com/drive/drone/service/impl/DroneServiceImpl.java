package com.drive.drone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.drive.drone.model.InputData;
import com.drive.drone.model.Urbanization;
import com.drive.drone.service.DroneService;

/**
 * The Class DroneServiceImpl.
 */
@Service
public class DroneServiceImpl implements DroneService {
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DroneServiceImpl.class);
    /** The urbanization. */
    private Urbanization[][] urbanization;
    
    /*
     * (non-Javadoc)
     * @see
     * com.drive.drone.service.DroneService#getIdentificator(com.drive.drone.
     * model.InputData)
     */
    @Override
    public List<String> getIdentificator(
        InputData in){
        
        List<String> listOutput = new ArrayList<>();
        
        LOGGER.info("Generate map");
        int tam = Integer.parseInt(in.getRange()) * 2;
        tam++;
        urbanization = new Urbanization[tam][tam];
        
        // get urb origen id
        String urbOriId = obtenerIdentificadorUrbanización(in.getCoordX(), in.getCoordY(), in.getRange());
        
        // crear matriz
        setMap(urbanization, urbOriId);
        
        LOGGER.info("Print urbanization list... ");
        for (int x = 0; x < urbanization.length; x++) {
            System.out.print("|");
            for (int y = 0; y < urbanization[x].length; y++) {
                System.out.print(urbanization[x][y].getId());
                if (y != urbanization[x].length - 1)
                    System.out.print("\t");
            }
            System.out.println("|");
        }
        
        return listOutput;
    }
    
    /**
     * Sets the map.
     *
     * @param urbanizaciones the new map
     */
    private static void setMap(
        Urbanization[][] urbanization,
        String urbOriId){
        try {
            
            String idAdy = "";
            boolean origen = false;
            LOGGER.info("Setting map... ");
            for (int i = 0; i < urbanization.length; i++) {
                
                for (int j = 0; j < urbanization.length; j++) {
                    
                    Urbanization item = new Urbanization();
                    
                    if (origen) {
                        // cuando sea la primera de la FILA recuperamos el
                        // id de la urbanizacion de ARRIBA para enviarlo a
                        // obtenerAdyacente
                        if (j == 0 && i >= 1) {
                            idAdy = obtenerAdyacente(urbanization[i - 1][j].getId(), "ABAJO");
                        } else {
                            // Si no recuperamos la urbanizacion de la izquierda
                            idAdy = obtenerAdyacente(urbanization[i][j - 1].getId(), "DERECHA");
                        }
                        
                        item.setId(idAdy + String.valueOf(i) + String.valueOf(j));
                    } else {
                        // añadir origen
                        item.setId(urbOriId);
                        origen = true;
                    }
                    
                    urbanization[i][j] = item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Dummy
    private String obtenerIdentificadorUrbanización(
        String coordX,
        String coordY,
        String rango){
        
        return "id_0";
    }
    
    // Dummy
    private static String obtenerAdyacente(
        String idOrigen,
        String direccion){
        
        return "id_";
    }
}
