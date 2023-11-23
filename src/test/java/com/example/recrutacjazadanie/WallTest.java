package com.example.recrutacjazadanie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void shouldReturnEmptyOptionalWhenPassedColorIsNull() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(new SpecificBlock("black", "ytong"));
        blocks.add(new SpecificBlock("white", "sth"));
        Wall wall = new Wall(blocks);

        // when
        Optional<Block> result = wall.findBlockByColor(null);

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
        Optional<Block> result = wall.findBlockByColor("white");

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldFindSpecificBlockByColor() {

        // given
        String color = "black";
        SpecificBlock expectedBlock = new SpecificBlock(color,"yton");
        List<Block> blocks = new ArrayList<>();
        blocks.add(expectedBlock);
        blocks.add(new SpecificBlock("black", "tarr"));
        blocks.add(new SpecificBlock("white", "ysof"));
        Wall wall = new Wall(blocks);

        // when
        Optional<Block> result = wall.findBlockByColor(color);

        // then
        assertEquals(result.get(), expectedBlock);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenPassedSpecificColorCantBeFound() {
        // given
        String color = "pink";

        List<Block> blocks = new ArrayList<>();
        blocks.add(new SpecificBlock("orange", "tarr"));
        blocks.add(new SpecificBlock("white", "ysof"));
        Wall wall = new Wall(blocks);

        // when
        Optional<Block> result = wall.findBlockByColor(color);

        // then
        assertTrue(result.isEmpty());
    }



}