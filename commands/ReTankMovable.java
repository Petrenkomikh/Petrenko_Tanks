package Tanks.commands;

import Tanks.objects.UObject;
import java.util.List;

public class ReTankMovable extends ReturnedForTanksCommand
{

    private UObject movableObject;

    public ReTankMovable(UObject obj)
    {
        movableObject = obj;
    }


    @Override
    public void execute() throws CommandEx
    {
        List<Integer> position = (List)movableObject.get("местоположение");
        List<Integer> velocity = (List)movableObject.get("скорость движения");
        for(int i = 0;i < position.size();i++)
        {
            position.set(i, position.get(i) + velocity.get(i));
        }
        movableObject.set("местоположение", position);
    }

    @Override
    public void returnForTank()
    {
        List<Integer> position = (List)movableObject.get("местоположение");
        List<Integer> velocity = (List)movableObject.get("скорость движения");
        for(int i = 0;i < position.size();i++)
        {
            position.set(i, position.get(i) - velocity.get(i));
        }
        movableObject.set("местоположение", position);
    }
}
