package creational_patterns.factorymethod.before;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteShip = ShipFactory.orderShip("WhiteShip", "whiteship@whiteship.com");
        System.out.println(whiteShip);

        Ship blackShip = ShipFactory.orderShip("BlackShip", "blackship@blackship.com");
        System.out.println(blackShip);
    }
}
