package com.drive.drone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * The Class DroneApplicationTests.
 */
@RunWith(MockitoJUnitRunner.class)
public class DroneApplicationTests {
    
    /**
     * Main Spring boot method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void mainTestThrowsException(){
        
        DroneApplication.main(null);
    }
    
    /**
     * Main test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void mainTest(){
        
        String[] args = { "1", "2" };
        DroneApplication.main(args);
        
        DroneApplication.main(null);
    }
    
}
