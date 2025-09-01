package com.yang.maker.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

// 登录命令行工具示例，实现了 picocli 的 Callable 接口
public class Login implements Callable<Integer> {
    // 用户名选项，非交互式
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    // 密码选项，交互式输入
    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true)
    String password;

    // 校验密码选项，交互式输入
    @Option(names ={"-cp", "checkPassword"}, arity = "0..1", description = "Check Passphrase", interactive = true)
    String checkPassword;

    // 命令执行入口，输出密码和校验密码
    public Integer call()  {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    /**
     * 自动补充缺失的交互式选项
     * @param clazz 命令类
     * @param args 用户输入参数
     * @return 补充后的参数数组
     */
    public static String[] autoAddInteractiveOptions(Class<?> clazz, String[] args) {
        // 将原始参数转为列表，便于操作
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        // 遍历所有字段，查找交互式选项
        for (Field field : clazz.getDeclaredFields()) {
            Option option = field.getAnnotation(Option.class);
            if (option != null && option.interactive()) {
                boolean found = false;
                // 检查参数列表中是否已包含该选项名
                for (String name : option.names()) {
                    if (argList.contains(name)) {
                        found = true;
                        break;
                    }
                }
                // 如果未包含，则补充第一个选项名
                if (!found) {
                    argList.add(option.names()[0]);
                }
            }
        }
        // 返回补充后的参数数组
        return argList.toArray(new String[0]);
    }

    // 主方法，自动补充交互式选项后执行命令
    public static void main(String[] args) {
        String[] newArgs = autoAddInteractiveOptions(Login.class, args);
        new CommandLine(new Login()).execute(newArgs);
    }
}
