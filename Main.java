package Tanks;

import Tanks.commands.Commands;
import Tanks.commands.CommandEx;
import Tanks.commands.MacroCommand;
import Tanks.factories.FactoryForCommands;
import Tanks.factories.ReturnedForTanksCommandsFactory;
import Tanks.objects.UObject;
import Tanks.objects.UObjectImplementation;


import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static FactoryForCommands factory = new ReturnedForTanksCommandsFactory();

    public static void main(String[] args)
    {
        Integer tankFuelBurnable = 100; //топливо
        Integer tankFuelBurnableConsumption = 2; //расход топлива
        UObject Tank_1 = new UObjectImplementation();
        UObject Tank_2 = new UObjectImplementation();
        ArrayList<Integer> position = new ArrayList<>();
        ArrayList<Integer> velocity = new ArrayList<>();
        position.add(15);
        position.add(15);
        velocity.add(15);
        velocity.add(15);

        Tank_1.set("местоположение", position);
        Tank_1.set("скорость движения", velocity);
        Tank_1.set("топливо", tankFuelBurnable); // изучить класс
        Tank_1.set("расход топлива", tankFuelBurnableConsumption); //изучить класс

        ArrayList<Commands> commands = new ArrayList<>();
        addCommands(commands, Tank_1);
        print(Tank_1); // вывести

        Commands macroCommand = new MacroCommand(commands);
        try
        {
            macroCommand.execute();
        }
        catch (CommandEx e)
        {
            e.printStackTrace();
        }
        print(Tank_1); // вывести

        commands = new ArrayList<>();
        addCommands(commands, Tank_1);
        addCommands(commands, Tank_2);

        macroCommand = new MacroCommand(commands);
        try
        {
            macroCommand.execute();
        }
        catch (CommandEx e)
        {
            e.printStackTrace();
        }
        print(Tank_1); // вывести
    }

    public static void print(UObject obj)
    {
        System.out.println("местоположение танка: " + (ArrayList<Integer>)obj.get("местоположение"));
        System.out.println("остаток топлива танка: " + (Integer)obj.get("топливо") + "\n");
    }
    public static void addCommands(List<Commands> commands, UObject obj)
    {
        commands.add(factory.newCommandMovable(obj));
        commands.add(factory.newCommandBurnable(obj));
        commands.add(factory.newCommandRotable(obj));
    }

}