package com.example.recrutacjazadanie;


import java.util.*;
import java.util.stream.Collectors;

import static io.micrometer.common.util.StringUtils.isNotBlank;

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
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        if (material == null) {
            return Collections.EMPTY_LIST;
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
        List<Block> result = new ArrayList<>();

        for (Block block : blocks) {
            if (block.getColor() != null && isNotBlank(block.getColor()) && block.getMaterial() != null && isNotBlank(block.getMaterial())) {
                result.add(block);
            }
        }
        return result.size();


    }
}
