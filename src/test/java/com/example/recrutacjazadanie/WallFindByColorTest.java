package com.example.recrutacjazadanie;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WallFindByColorTest {

    @Test
    void shouldReturnEmptyOptionalWhenPassedColorIsNull() {
        // given
        List<Block> blocks = new ArrayList<>();
        Block mockBlock1 = mock(Block.class);
        when(mockBlock1.getColor()).thenReturn("black");
        when(mockBlock1.getMaterial()).thenReturn("silk");

        Block mockBlock2 = mock(Block.class);
        when(mockBlock2.getColor()).thenReturn("white");
        when(mockBlock2.getMaterial()).thenReturn("wood");

        blocks.add(mockBlock1);
        blocks.add(mockBlock2);

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
        List<Block> blocks = new ArrayList<>();

        Block expectedBlock = mock(Block.class);
        when(expectedBlock.getColor()).thenReturn(color);
        when(expectedBlock.getMaterial()).thenReturn("silk");

        Block mockBlock = mock(Block.class);
        when(mockBlock.getColor()).thenReturn("pink");
        when(mockBlock.getMaterial()).thenReturn("wood");

        blocks.add(expectedBlock);
        blocks.add(mockBlock);
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
        Block mockBlock1 = mock(Block.class);
        when(mockBlock1.getColor()).thenReturn("black");
        when(mockBlock1.getMaterial()).thenReturn("silk");

        Block mockBlock2 = mock(Block.class);
        when(mockBlock2.getColor()).thenReturn("white");
        when(mockBlock2.getMaterial()).thenReturn("wood");

        blocks.add(mockBlock1);
        blocks.add(mockBlock2);
        Wall wall = new Wall(blocks);

        // when
        Optional<Block> result = wall.findBlockByColor(color);

        // then
        assertTrue(result.isEmpty());
    }
}