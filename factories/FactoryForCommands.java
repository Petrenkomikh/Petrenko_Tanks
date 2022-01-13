package Tanks.factories;

import Tanks.commands.Commands;
import Tanks.objects.UObject;

public interface FactoryForCommands
{
    Commands newCommandMovable(UObject obj);
    Commands newCommandBurnable(UObject obj);
    Commands newCommandRotable(UObject obj);
}
