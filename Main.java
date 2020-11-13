public class Main {
    public static void main(String[] args) {

        Saab95 saabalada = new Saab95();

        saabalada.setTurboOn();
        saabalada.startEngine();
        saabalada.incrementSpeed(10);
        saabalada.move();
        System.out.println(saabalada.getLocY());

        saabalada.gas(0.2);

        saabalada.incrementSpeed(4);

        System.out.println(saabalada.getCurrentSpeed());

    }


}