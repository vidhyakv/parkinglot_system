package com.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.parkinglot.command.*;
import com.parkinglot.util.CommandProcessor;

public class ParkingSystem {
    static CommandProcessor commandProcessor;

    public static void main(String[] args) {


        commandProcessor = new CommandProcessor();
        commandProcessor.setCommand("create_parking_lot", new CreateParkingLotCommand());
        commandProcessor.setCommand("setup_fee_model", new ConfigureFeeModel());
        commandProcessor.setCommand("setup_fee_value", new ConfigureFeeModel());
        commandProcessor.setCommand("allot_parking_lot", new AllotParkingLotCommand());
        commandProcessor.setCommand("park", new ParkCommand());


        if (args.length > 0) {
            File inputFile = new File(args[0]);
            List<String> inputLines = new ArrayList<>();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    inputLines.add(line);
                }
                new FileReader(inputFile).close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            inputLines.stream().forEach(ParkingSystem::process);
        } else {
            Scanner scanner = new Scanner(System.in);
            String inputLine;
            while (scanner.hasNextLine() && !((inputLine = scanner.nextLine()).equals("exit"))) {
                process(inputLine);
            }
            System.out.println("done!");
        }
    }

    public static void process(String inputLine) {
        try {
            commandProcessor.process(inputLine);
            System.out.println("Process is completed");
        } catch (Exception e) {
            System.out.println("Something went wrong. Please check your input. " + e.toString());
        }

    }

}
