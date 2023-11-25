package com.example.recrutacjazadanie;
import org.junit.jupiter.api.Test;
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
        Block blockFirst = mock(Block.class);
        when(blockFirst.getColor()).thenReturn("black");

        Block blockSecond = mock(Block.class);
        when(blockSecond.getColor()).thenReturn("white");

        blocks.add(blockFirst);
        blocks.add(blockSecond);

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

        Block mockBlock = mock(Block.class);
        when(mockBlock.getColor()).thenReturn("pink");

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
        Block blockFirst = mock(Block.class);
        when(blockFirst.getColor()).thenReturn("black");

        Block blockSecond = mock(Block.class);
        when(blockSecond.getColor()).thenReturn("white");

        blocks.add(blockFirst);
        blocks.add(blockSecond);
        Wall wall = new Wall(blocks);

        // when
        Optional<Block> result = wall.findBlockByColor(color);

        // then
        assertTrue(result.isEmpty());
    }
}