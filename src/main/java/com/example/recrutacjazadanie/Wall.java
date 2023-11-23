package com.example.recrutacjazadanie;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {

        // Stop execution when color is null
        if (color == null) {
            return Optional.empty();
        }

        return blocks.stream()
                .filter(Objects::nonNull)
                // checking if color is  equal to color of a specific block
                .filter(block -> color.equals(block.getColor()))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
