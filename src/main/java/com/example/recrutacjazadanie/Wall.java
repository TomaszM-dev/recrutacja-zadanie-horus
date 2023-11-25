package com.example.recrutacjazadanie;
import java.util.*;

public class Wall implements Structure {
    private List<Block> blocks;
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {

        if (color == null) {
            return Optional.empty();
        }
        return blocks.stream()
                .filter(Objects::nonNull)
                .filter(block -> color.equals(block.getColor()))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        if (material == null) {
            return Collections.emptyList();
        }

        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block != null && material.equals(block.getMaterial())) {
                result.add(block);
            }
        }
        return result;
    }

    @Override
    public int count() {
        int count = 0;

        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                count += ((CompositeBlock) block).getBlocks().size();
            } else if (block != null) {
                count++;
            }
        }
        return count;
    }
}
