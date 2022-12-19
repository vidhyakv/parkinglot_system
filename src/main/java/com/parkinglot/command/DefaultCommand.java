package com.parkinglot.command;

public class DefaultCommand extends Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Sorry! Your command could not be processed");
    }
}
