/**
 * 
 */
package com.drive.drone.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.drive.drone.model.InputData;
import com.drive.drone.service.impl.DroneServiceImpl;

/**
 * The Class DroneServiceTest.
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class DroneServiceTest {
    
    /** The service. */
    @InjectMocks
    DroneServiceImpl service;
    
    /**
     * Sets the up.
     */
    @Before
    public void setUp(){
        
    }
    
    /**
     * Gets the identificator test.
     *
     * @return the identificator test
     */
    @Test
    public void getIdentificatorTest(){
        InputData in = new InputData();
        in.setCoordX("40");
        in.setCoordY("40");
        in.setRange("2");
        
        service.getIdentificator(in);
    }
}
