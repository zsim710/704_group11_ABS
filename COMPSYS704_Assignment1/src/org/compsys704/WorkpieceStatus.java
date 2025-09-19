package org.compsys704;

/**
 * Enum representing the status of a workpiece in the manufacturing process
 */
public enum WorkpieceStatus {
    CREATED("Created - waiting to start processing"),
    PROCESSING("Currently being processed"),
    COMPLETED("Processing completed successfully"),
    FAULTED("Processing stopped due to fault");
    
    private final String description;
    
    WorkpieceStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return description;
    }
}