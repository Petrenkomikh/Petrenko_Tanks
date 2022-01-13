package Tanks.commands;

import java.util.List;

public class MacroCommand extends ReturnedForTanksCommand
{

    private List<Commands> commands;
    Integer SumExecutedCommands = 0;

    public MacroCommand(List<Commands> commands)
    {
        this.commands = commands;
    }

    /*
    @Override
    public void execute() throws CommandEx
    {
        try
        {
            for (int i = 0; i < commands; i++) {
                commands.set(i).execute();
                commands.get(i).execute();
                SumExecutedCommands = SumExecutedCommands + 1;
            }
        }
        catch (Exception e)
        {
            alert('ERROR!'); // returnForTank();
        }
    }
     */
    @Override
    public void execute() throws CommandEx
    {
        try
        {
            for (int i = 0; i < commands.size(); i++) {
                commands.get(i).execute();
                SumExecutedCommands = SumExecutedCommands + 1;
            }
        }
        catch (Exception e)
        {
            returnForTank();
        }
        SumExecutedCommands = 0;
    }

    @Override
    public void returnForTank()
    {
        Commands curCommand;
        for(int i = 0; i < SumExecutedCommands; i++)
        {
            curCommand = commands.get(i);
            if(curCommand instanceof ReturnedForTanks)
            {
                ((ReturnedForTanks) curCommand).returnForTank();
                //(curCommand = ???)
            }
        }
    }
}
