package com.drive.drone.service;

import java.util.List;

import com.drive.drone.model.InputData;

/**
 * The Interface DroneService.
 */
public interface DroneService {
    
    /**
     * Gets the identificator.
     *
     * @param in the in
     * @return the identificator
     */
    List<String> getIdentificator(
        InputData in);
    
}
