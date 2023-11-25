package com.example.recrutacjazadanie;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class CompositeBlockTest {
    @Test
    void shouldCountAllCompositeBlocks() {
        // given
        Block blockFirst = mock(Block.class);
        Block blockSecond = mock(Block.class);

        CompositeBlock compositeBlock = mock(CompositeBlock.class);
        when(compositeBlock.getBlocks()).thenReturn(Arrays.asList(blockFirst, blockSecond));

        Wall wall = new Wall(Arrays.asList(compositeBlock));

        // when
        int totalCount = wall.count();

        // then
        assertEquals(2, totalCount);

        // Verify
        verify(compositeBlock, times(1)).getBlocks();
    }
}
