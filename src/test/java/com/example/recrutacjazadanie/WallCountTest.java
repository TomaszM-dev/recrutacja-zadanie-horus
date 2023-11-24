package com.example.recrutacjazadanie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WallCountTest {

    @Test
    void shouldExcludeBlocksWithNullOrEmptyColorOrMaterial() {
        // given
        List<Block> blocks = new ArrayList<>();
        Block mockBlock1 = mock(Block.class);
        when(mockBlock1.getColor()).thenReturn("");
        when(mockBlock1.getMaterial()).thenReturn("silk");

        Block mockBlock2 = mock(Block.class);
        when(mockBlock2.getColor()).thenReturn("white");
        when(mockBlock2.getMaterial()).thenReturn(null);

        Block mockBlock3 = mock(Block.class);
        when(mockBlock2.getColor()).thenReturn("white");
        when(mockBlock2.getMaterial()).thenReturn("metal");

        blocks.add(mockBlock1);
        blocks.add(mockBlock2);
        blocks.add(mockBlock3);

        Wall wall = new Wall(blocks);

        // when
        int result = wall.count();

        // then
        assertEquals(1,result);

    }
}
