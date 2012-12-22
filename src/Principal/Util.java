package Principal;

public class Util {

    static public double calculaAngulo(int x1, int x2, int y1, int y2) {
////////x1 = xMouse
////////x2 = xPersonagem


        double angulo = 0;

        float dx = x1 - x2;
        float dy = y1 - y2;
        angulo = Math.toDegrees(Math.atan2(dy, dx));
        if (angulo < 0) {
            angulo *= -1;
        } else {
            angulo = 360 - angulo;
        }
        return angulo;
    }
    
    public static double calculaDistancia(int x1, int y1, int x2, int y2) {

        int x = x2 - x1;
        int y = y2 - y1;

        double distancia = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distancia;
    }
}
