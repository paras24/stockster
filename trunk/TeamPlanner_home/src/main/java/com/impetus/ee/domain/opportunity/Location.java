package com.impetus.ee.domain.opportunity;

public enum Location {
    Noida(1),
    Indore(2),
    Bangalore(3);
    
    private int value;

    private Location(int value) {
        this.value = value;        }

    public int getOrdinal() { return value; }

    public static Location getLocation(int value) {
        for(Location operation : values()){
            if(operation.getOrdinal() == value)
                return operation;
        }

        return null;
    }
}