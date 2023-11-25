package com.example.recrutacjazadanie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WallFindByMaterialTest {
    @Test
    void shouldReturnEmptyCollectionWhenPassedMaterialIsNull() {
        // given
        List<Block> blocks = new ArrayList<>();

        Block blockFirst = mock(Block.class);
        when(blockFirst.getMaterial()).thenReturn("silk");

        Block blockSecond = mock(Block.class);
        when(blockSecond.getMaterial()).thenReturn("wood");

        blocks.add(blockFirst);
        blocks.add(blockSecond);
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
        when(expectedBlock.getMaterial()).thenReturn(material);

        Block mockBlock = mock(Block.class);
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
        List<Block> blocks = new ArrayList<>();

        Block expectedBlock = mock(Block.class);
        when(expectedBlock.getMaterial()).thenReturn("metal");

        Block mockBlock = mock(Block.class);
        when(mockBlock.getMaterial()).thenReturn("wood");

        blocks.add(expectedBlock);
        blocks.add(mockBlock);
        Wall wall = new Wall(blocks);

        // when
        List<Block> result = wall.findBlocksByMaterial("silk");

        // then
        assertTrue(result.isEmpty());
    }
}
