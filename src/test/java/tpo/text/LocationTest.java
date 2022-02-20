package tpo.text;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {
    @Test
    void calculateLuminosity() {
        List<LightSource> lightSources = List.of(new LightSource(10));
        Location location = new Location(lightSources);
        assertEquals(0, location.calculateLuminosity());
        lightSources.forEach(lightSource -> lightSource.rise(1));
        assertEquals(10, location.calculateLuminosity());
    }

    @Test
    void calculateLuminosityWithSeveralLightSources() {
        List<LightSource> lightSources = List.of(
                new LightSource(10),
                new LightSource(20)
        );
        Location location = new Location(lightSources);
        assertEquals(0, location.calculateLuminosity());
        lightSources.forEach(lightSource -> lightSource.rise(5));
        assertEquals(150, location.calculateLuminosity());
    }
}