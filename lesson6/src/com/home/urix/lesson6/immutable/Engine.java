package com.home.urix.lesson6.immutable;

import java.util.Objects;

public class Engine {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Engine engine = (Engine) obj;
        return this.horsePower == engine.horsePower && this.manufacturer.equals(engine.manufacturer);
    }

    @Override
    public int hashCode(){
        return Objects.hash(horsePower,manufacturer);
    }
}
