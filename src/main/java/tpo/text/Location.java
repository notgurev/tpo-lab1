package tpo.text;

import java.util.List;

public class Location {
    private final List<LightSource> lightSources;

    public Location(List<LightSource> lightSources) {
        this.lightSources = lightSources;
    }

    public double calculateLuminosity() {
        return lightSources.stream()
                .map(ls -> ls.getVisiblePercent() * ls.getBrightness())
                .reduce(Double::sum).orElse(0d);
    }
}
