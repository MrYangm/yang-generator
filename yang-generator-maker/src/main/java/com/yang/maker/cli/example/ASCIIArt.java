package com.yang.maker.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)  // ② 使用 @Command 注解标记该类并为其命名，mixinStandardHelpOptions 属性设置为 true 可以给应用程序自动添加 --help 和 --version 选项。
public class ASCIIArt implements Runnable {  // ① 创建一个实现 Runnable 或 Callable 接口的类，这就是一个命令

    @Option(names = { "-s", "--font-size" }, description = "Font size")  // ③ 使用 @Option 注解定义选项，这里定义了一个字体大小选项，用户可以通过 -s 或 --font-size 来指定字体大小。
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", // ④ 使用 @Parameters 注解定义位置参数，这里定义了一个单词参数，用户可以输入多个单词，默认值为 "Hello, picocli"。
               description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };  // ⑤ Picocli 会将命令行参数转换为强类型值，并自动注入到注解字段中。

    @Override
    public void run() {  //⑥ 在类的 run 或 call 方法中定义业务逻辑，当命令解析成功（用户敲了回车）后被调用。
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);  // ⑦在 main 方法中，通过 CommandLine 对象的 execute 方法来处理用户输入的命令，剩下的就交给 Picocli 框架来解析命令并执行业务逻辑啦~
        System.exit(exitCode);  // ⑧ 通过 CommandLine.execute 方法返回一个退出代码。可以调用 System.exit 并将该退出代码作为参数，从而向调用进程表示成功或失败。
    }
}
