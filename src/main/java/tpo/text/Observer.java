package tpo.text;

public class Observer {
    public Shape analyzeShape(LightSource lightSource) {
        var visiblePercent = lightSource.getVisiblePercent();
        if (visiblePercent <= 0) {
            throw new LightSourceNotVisibleException();
        }
        if (visiblePercent < 1) {
            return Shape.DOT;
        }
        if (visiblePercent <= 50) {
            return Shape.CRESCENT;
        }
        if (visiblePercent < 100) {
            return Shape.ALMOST_CIRCLE;
        }
        return Shape.CIRCLE;
    }
}

