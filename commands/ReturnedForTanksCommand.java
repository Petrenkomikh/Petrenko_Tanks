package Tanks.commands;

public abstract class ReturnedForTanksCommand implements Commands, ReturnedForTanks
{
    public abstract void execute() throws CommandEx;
    public abstract void returnForTank();
    //public void set(); - Рассматривать идею в IObject
    //public void get(); - Рассматривать идею в IOBject, вероятно, что правильнее будет Object get();
}
