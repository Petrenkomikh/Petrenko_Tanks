package Tanks.commands;

import Tanks.objects.UObject;
import java.util.List;


public class ReTankRotable extends ReturnedForTanksCommand //Напрямую аналогичен классу ReTankMovable (башня на движущем танке)
{

    private UObject rotableObject;

    public ReTankRotable(UObject obj)
    {
        rotableObject = obj;
    }


    @Override
    public void execute() throws CommandEx
    {
        List<Integer> position = (List)rotableObject.get("местоположение");
        List<Integer> velocity = (List)rotableObject.get("скорость движения");
        for(int i = 0;i < position.size();i++)
        {
            position.set(i, position.get(i) + velocity.get(i));
        }
        rotableObject.set("местоположение", position);
    }

    @Override
    public void returnForTank()
    {
        List<Integer> position = (List)rotableObject.get("местоположение");
        List<Integer> velocity = (List)rotableObject.get("скорость движения");
        for(int i = 0;i < position.size();i++)
        {
            position.set(i, position.get(i) - velocity.get(i));
        }
        rotableObject.set("местоположение", position);
    }
}
