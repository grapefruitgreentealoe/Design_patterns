package creational_patterns.factorymethod.after;

import creational_patterns.factorymethod.before.Ship;

public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() { return new WhiteShip(); }
}
