package Tanks.commands;

import Tanks.objects.UObject;

public class ReTankFuelBurnable extends ReturnedForTanksCommand
{
    private UObject burnableObject;

    public ReTankFuelBurnable(UObject obj)
    {
        burnableObject = obj;
    }

    @Override
    public void execute() throws CommandEx
    {
        Integer tankFuelBurnableConsumption = (Integer)burnableObject.get("расход топлива");
        Integer tankFuelBurnable = (Integer)burnableObject.get("топливо");
        tankFuelBurnable = tankFuelBurnable - tankFuelBurnableConsumption;
        burnableObject.set("топливо", tankFuelBurnable);
    }

    @Override
    public void returnForTank()
    {
        Integer tankFuelBurnableConsumption = (Integer)burnableObject.get("расход топлива");
        Integer tankFuelBurnable = (Integer)burnableObject.get("топливо");
        tankFuelBurnable = tankFuelBurnable + tankFuelBurnableConsumption;
        burnableObject.set("топливо", tankFuelBurnable);
    }
}
