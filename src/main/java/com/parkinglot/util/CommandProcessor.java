package com.parkinglot.util;

import com.parkinglot.command.Command;
import com.parkinglot.command.DefaultCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandProcessor {

    private Map<String, Command> commandMap = new HashMap<>();

    public void setCommand(String operation, Command command) {
        this.commandMap.put(operation, command);
    }

    public void process(String inputLine) throws Exception {
        String[] inputWords = inputLine.split(" ");
        String operation = inputWords[0];
        String[] args = Arrays.copyOfRange(inputWords, 1, inputWords.length);
        Command command = Optional.ofNullable(this.commandMap.get(operation)).orElse(new DefaultCommand());
        command.execute(args);
    }
}
