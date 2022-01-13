package Tanks.factories;

import Tanks.commands.Commands;
import Tanks.commands.ReTankFuelBurnable;
import Tanks.commands.ReTankMovable;
import Tanks.commands.ReTankRotable;
import Tanks.objects.UObject;

public class ReturnedForTanksCommandsFactory implements FactoryForCommands
{
    @Override
    public Commands newCommandMovable(UObject obj)
    {
        return new ReTankMovable(obj);
    }

    @Override
    public Commands newCommandBurnable(UObject obj)
    {
        return new ReTankFuelBurnable(obj);
    }

    @Override
    public Commands newCommandRotable(UObject obj)
    {
        return new ReTankRotable(obj);
    }
}
