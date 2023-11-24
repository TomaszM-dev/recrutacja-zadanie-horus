package com.example.recrutacjazadanie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WallFindByMaterialTest {

    @Test
    void shouldReturnEmptyCollectionWhenPassedMaterialIsNull() {
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
        List<Block> result = wall.findBlocksByMaterial("silk");

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldFindSpecificBlockByMaterial() {

        // given
        String material = "silk";
        List<Block> blocks = new ArrayList<>();

        Block expectedBlock = mock(Block.class);
        when(expectedBlock.getColor()).thenReturn("white");
        when(expectedBlock.getMaterial()).thenReturn(material);

        Block mockBlock = mock(Block.class);
        when(mockBlock.getColor()).thenReturn("pink");
        when(mockBlock.getMaterial()).thenReturn("wood");

        blocks.add(expectedBlock);
        blocks.add(mockBlock);
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial(material);

        // then
        assertTrue(result.contains(expectedBlock));
    }


    @Test
    public void shouldReturnEmptyListWhenPassedSpecificMaterialCantBeFound() {
        // given
        String material = "silk";

        List<Block> blocks = new ArrayList<>();

        Block expectedBlock = mock(Block.class);
        when(expectedBlock.getColor()).thenReturn("white");
        when(expectedBlock.getMaterial()).thenReturn("metal");

        Block mockBlock = mock(Block.class);
        when(mockBlock.getColor()).thenReturn("pink");
        when(mockBlock.getMaterial()).thenReturn("wood");

        blocks.add(expectedBlock);
        blocks.add(mockBlock);
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial(material);

        // then
        assertTrue(result.isEmpty());
    }
}
