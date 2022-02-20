package tpo.text;

import lombok.Data;

/*
В полной темноте ... точка света. Она начала расползаться в стороны,
превращаясь в узкий полумесяц, и через несколько секунд показались два солнца:
сжигающие белым пламенем .... Яркие цветные сполохи струились сквозь разреженную атмосферу.
 */

@Data
public class LightSource {
    enum Color {
        WHITE, RED, YELLOW
    }

    private double visiblePercent;
    private Color color;
    private double brightness;

    public LightSource() {
        this.visiblePercent = 0;
        this.color = Color.WHITE;
    }

    public LightSource(Color color, double brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    public LightSource(double brightness) {
        this.brightness = brightness;
    }

    public void rise(double seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Seconds must be greater than zero");
        }
        if (visiblePercent < 100) {
            visiblePercent += seconds;
            if (visiblePercent > 100) visiblePercent = 100;
        }
    }
}

