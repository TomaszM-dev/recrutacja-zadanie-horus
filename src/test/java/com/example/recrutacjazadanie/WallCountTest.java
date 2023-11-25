package com.example.recrutacjazadanie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WallCountTest {
    @Test
    void shouldCountGivenBlocks() {
        // given
        List<Block> blocks = new ArrayList<>();

        Block mockBlock1 = mock(Block.class);
        Block mockBlock2 = mock(Block.class);
        Block mockBlock3 = mock(Block.class);
        Block mockBlock4 = null;

        blocks.add(mockBlock1);
        blocks.add(mockBlock2);
        blocks.add(mockBlock3);
        blocks.add(mockBlock4);

        Wall wall = new Wall(blocks);

        // when
        int result = wall.count();

        // then
        assertEquals(3,result);
    }
}
