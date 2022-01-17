package creational_patterns.factorymethod.after;

import creational_patterns.factorymethod.before.Ship;

public class Client {
    public static void main(String[] args) {
        /* 변경이 일어남 */
        Ship whiteShip = new WhiteShipFactory().orderShip("WhiteShip", "whiteship@whiteship.com");
        System.out.println(whiteShip);

        Ship blackShip = new BlackShipFactory().orderShip("BlackShip", "blackship@blackship.com");
        System.out.println(blackShip);

        /* 변경이 일어나지 않음 */
        Client client = new Client();
        client.print(new WhiteShipFactory(), "WhiteShip", "whiteship@whiteship.com");
        client.print(new BlackShipFactory(), "BlackShip", "blackship@blackship.com");

    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
