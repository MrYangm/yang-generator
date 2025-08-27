package com.yang.cli.pattern;

import lombok.Setter;

@Setter
public class RemoteControl {
    private Command command;

    public void pressButton() {
        command.execute();
    }
}
