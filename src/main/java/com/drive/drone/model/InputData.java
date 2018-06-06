package com.drive.drone.model;

/**
 * The Class InputData.
 */
public class InputData {
    
    /** The coord X. */
    private String coordX;
    
    /** The coord Y. */
    private String coordY;
    
    /** The range. */
    private String range;
    
    /**
     * Gets the coord X.
     *
     * @return the coord X
     */
    public String getCoordX(){
        return coordX;
    }
    
    /**
     * Sets the coord X.
     *
     * @param coordX the new coord X
     */
    public void setCoordX(
        String coordX){
        this.coordX = coordX;
    }
    
    /**
     * Gets the coord Y.
     *
     * @return the coord Y
     */
    public String getCoordY(){
        return coordY;
    }
    
    /**
     * Sets the coord Y.
     *
     * @param coordY the new coord Y
     */
    public void setCoordY(
        String coordY){
        this.coordY = coordY;
    }
    
    /**
     * Gets the range.
     *
     * @return the range
     */
    public String getRange(){
        return range;
    }
    
    /**
     * Sets the range.
     *
     * @param range the new range
     */
    public void setRange(
        String range){
        this.range = range;
    }
    
}
