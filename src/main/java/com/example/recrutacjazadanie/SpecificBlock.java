package com.example.recrutacjazadanie;

import java.util.List;

public class SpecificBlock implements Block {
    private final String color;
    private final String material;

    public SpecificBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public String toString() {
        return "SpecificBlock{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }


}
