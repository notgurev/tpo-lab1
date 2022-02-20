package tpo.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightSourceTest {
    @Test
    void riseNegativeSeconds() {
        LightSource lightSource = new LightSource();
        assertThrows(IllegalArgumentException.class, () -> lightSource.rise(-5));
    }

    @Test
    void riseChangesPercent() {
        var lightSource = new LightSource();
        double first = lightSource.getVisiblePercent();
        lightSource.rise(1);
        double second = lightSource.getVisiblePercent();
        assertTrue(second > first);
    }

    @Test
    void riseAbove100() {
        var lightSource = new LightSource();
        lightSource.rise(100);
        assertEquals(100, lightSource.getVisiblePercent());
        lightSource.rise(5);
        assertEquals(100, lightSource.getVisiblePercent());
    }

    @Test
    void starDefaultState() {
        LightSource lightSource = new LightSource(LightSource.Color.RED, 10);
        assertAll(
                () -> assertEquals(LightSource.Color.RED, lightSource.getColor()),
                () -> assertEquals(0, lightSource.getVisiblePercent())
        );
    }
}