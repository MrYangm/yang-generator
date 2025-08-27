package com.yang;

import com.yang.cli.CommandExecutor;

/**
 * @Author: yang
 * @Date: 2025/08/23/12:41
 */
public class Main {

    public static void main(String[] args) {
        //args = new String[]{"generate","-l","-a","-o"};
         // args = new String[]{"config"};
        // args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }

}
