package tpo.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    @Test
    void analyzeShape() {
        Observer observer = new Observer();
        LightSource lightSource = new LightSource();
        assertThrows(LightSourceNotVisibleException.class, () -> observer.analyzeShape(lightSource));

        lightSource.rise(0.5);
        assertEquals(Shape.DOT, observer.analyzeShape(lightSource));

        lightSource.rise(10);
        assertEquals(Shape.CRESCENT, observer.analyzeShape(lightSource));

        lightSource.rise(70);
        assertEquals(Shape.ALMOST_CIRCLE, observer.analyzeShape(lightSource));

        lightSource.rise(200);
        assertEquals(Shape.CIRCLE, observer.analyzeShape(lightSource));
    }
}