package com.example.recrutacjazadanie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WallCountTest {

    @Test
    void shouldExcludeBlocksWithNullOrEmptyColorOrMaterial() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(new SpecificBlock("asda", null));
        blocks.add(new SpecificBlock("white", "sth"));
        blocks.add(new SpecificBlock("white", ""));
        blocks.add(new SpecificBlock(null, "sth"));

        Wall wall = new Wall(blocks);

        // when
        int result = wall.count();

        // then
        assertEquals(1,result);

    }
}
