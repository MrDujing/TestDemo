package logging;

import java.io.IOException;
import java.util.logging.*;

public class LoggingTest {
        public static void main(String[] args){
            Logger a = Logger.getLogger("log"); // 获取一个Logger(工厂方法)
            Logger b = Logger.getLogger("log");
            System.out.println(a == b);  // 同名为同一个Logger,单例模式？
            a.setLevel(Level.ALL);
            System.out.println(a.getLevel().toString());
            FileHandler ft = null;
            try {
                ft = new FileHandler("./log.txt", false); // 创建一个输出到文件的Handler，第一个参数为文件路径，第二个为是否追加，默认为false(不追加)
            } catch (IOException e) {
                e.printStackTrace();
            }
            ConsoleHandler ch = new ConsoleHandler(); // 定义控制台输出Handler
            ch.setLevel(Level.INFO); // 设置输出等级，高于这个等级的会输出到对应位置
            System.out.println(a.getLevel().toString());

            ch.setFormatter(new MyFormatter()); // 设置输出格式，传入一个对象
            a.addHandler(ch);   // 将这个Handler添加到对应的Logger上
            ft.setLevel(Level.ALL);
            System.out.println(a.getLevel().toString());

            ft.setFormatter(new MyFormatter());
            a.addHandler(ft);
            a.info("fdaf");
            a.finer("fdsa");

            try{
                int i = 1 / 0;
            }catch (Exception e){
                a.log(Level.SEVERE, "除零了");
            }
        }
    }

    class MyFormatter extends Formatter{

        /**
         重新定义日志的输出格式，默认是XML格式
         */
        @Override
        public String format(LogRecord record) { // 传入的是代表信息的类，可通过其get方法获取各个属性值。
            return record.getLevel() + "：内容：" + record.getMessage() + "\n";
        }
    }

