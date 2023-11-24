package com.example.recrutacjazadanie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WallFindByMaterialTest {

    @Test
    void shouldReturnEmptyCollectionWhenPassedMaterialIsNull() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(new SpecificBlock("black", "ytong"));
        blocks.add(new SpecificBlock("white", "sth"));
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial(null);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldFilterOutNullBlock() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(null);
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial("sth");

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldFindSpecificBlockByMaterial() {

        // given
        String material = "ysof";
        SpecificBlock expectedBlock = new SpecificBlock("white",material);
        List<Block> blocks = new ArrayList<>();
        blocks.add(expectedBlock);
        blocks.add(new SpecificBlock("black", "tarr"));
        blocks.add(new SpecificBlock("white", "essa"));
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial(material);

        // then
        assertTrue(result.contains(expectedBlock));
    }


    @Test
    public void shouldReturnEmptyListWhenPassedSpecificMaterialCantBeFound() {
        // given
        String material = "ez";

        List<Block> blocks = new ArrayList<>();
        blocks.add(new SpecificBlock("orange", "tarr"));
        blocks.add(new SpecificBlock("white", "ysof"));
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial(material);

        // then
        assertTrue(result.isEmpty());
    }


}
