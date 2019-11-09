package me.vkku.sneakAttack.util;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilTest {

    @DisplayName("Test to validate random values")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testRandomInRange(int testValue){

        assertTrue(Arrays.asList(0, 1, 2, 3, 4).contains(Util.randomInRange(testValue)));

    }
}
