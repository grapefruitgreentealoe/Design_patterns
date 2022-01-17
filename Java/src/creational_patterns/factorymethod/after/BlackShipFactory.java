package creational_patterns.factorymethod.after;

import creational_patterns.factorymethod.before.Ship;

public class BlackShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
