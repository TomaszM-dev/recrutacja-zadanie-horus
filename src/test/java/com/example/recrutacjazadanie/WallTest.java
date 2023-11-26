package com.example.recrutacjazadanie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WallTest {
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

        CompositeBlock compositeBlock = Mockito.mock(CompositeBlock.class);
        blocks.add(compositeBlock);

        List<Block> compositeBlocks = new ArrayList<>();
        Block block = Mockito.mock(Block.class);
        Block block2 = Mockito.mock(Block.class);
        compositeBlocks.add(block);
        compositeBlocks.add(block2);

        // when
        Mockito.when(compositeBlock.getBlocks()).thenReturn(compositeBlocks);
        Wall wall = new Wall(blocks);
        Optional<Block> result = wall.findBlockByColor(null);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldFilterOutNullBlockWhenFindingByColor() {
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
    public void shouldFilterOutNullBlockWhenFindingByMaterial() {
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

    @Test
    void shouldCountAllBlocksIfConditionsOfTheMethodAreMet() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(null);
        blocks.add(null);
        blocks.add(Mockito.mock(Block.class));

        CompositeBlock compositeBlock = Mockito.mock(CompositeBlock.class);
        blocks.add(compositeBlock);

        List<Block> compositeBlocks = new ArrayList<>();
        Block block = Mockito.mock(Block.class);
        Block block2 = Mockito.mock(Block.class);
        compositeBlocks.add(block);
        compositeBlocks.add(block2);

        // when
        Mockito.when(compositeBlock.getBlocks()).thenReturn(compositeBlocks);
        Wall wall = new Wall(blocks);

        // then
        int result = wall.count();
        assertEquals(3, result);
    }
}
