package com.springway.protocol;

import java.io.OutputStream;

import com.springway.constants.Command;

public class Protocol {
    
    private static final String STAR = "*";
    private static final String DOLLAR = "$";
    private static final String BLANK = "\r\n";

    /**
     * 
     * @param os
     * @param command
     * @param args
     * @throws Exception
     */
    public static void sendCommand(OutputStream os, Command command, byte[]... args) throws Exception {
        StringBuilder executable_command = new StringBuilder();
        executable_command.append(STAR).append(args.length + 1).append(BLANK);
        executable_command.append(DOLLAR).append(command.name().length()).append(BLANK);
        executable_command.append(command.name()).append(BLANK);
        for (byte[] arg : args) {
            executable_command.append(DOLLAR).append(arg.length).append(BLANK);
            executable_command.append(new String(arg, "UTF-8")).append(BLANK);
        }

        System.out.println(executable_command.toString());

        os.write(executable_command.toString().getBytes("UTF-8"));
        os.flush();
    }

}
