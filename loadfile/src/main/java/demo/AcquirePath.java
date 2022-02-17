package demo;

public class AcquirePath {
    //class.getResource(String path)
    public static void getPathByClass() {
        //path不以"/"开头,则以类所在的当前目录为起点寻址,使用相对位置寻址
        //若不使用相对位置寻址,则会返回null

        //Maven工程,编译期间会将class及相应的资源文件转移至 classes目录,
        //故AcquirePath的当前目录变为
        // /F:/LoadFile/LoadFile/target/classes/demo/
        System.out.println(AcquirePath.class.getResource(""));
        System.out.println(AcquirePath.class.getResource("."));
        //资源文件会同步转移至classes目录下,使用相对位置可获取
        System.out.println(AcquirePath.class.getResource("../db/db.properties"));
        System.out.println(AcquirePath.class.getResource("../util/util.properties"));
        System.out.println(AcquirePath.class.getResource("../root.properties"));

        //path以"/"开头,则从classpath路径开始,以绝对位置方式寻址
        //若不使用绝对位置寻址,则会返回null
        //maven工程中,classpath指class目录
        System.out.println(AcquirePath.class.getResource("/"));
        System.out.println(AcquirePath.class.getResource("/db/db.properties"));
        System.out.println(AcquirePath.class.getResource("/util/util.properties"));
        System.out.println(AcquirePath.class.getResource("/root.properties"));
        //打印信息如下
        //file:/F:/LoadFile/LoadFile/target/classes/demo/
        //file:/F:/LoadFile/LoadFile/target/classes/demo/
        //file:/F:/LoadFile/LoadFile/target/classes/db/db.properties
        //file:/F:/LoadFile/LoadFile/target/classes/util/util.properties
        //file:/F:/LoadFile/LoadFile/target/classes/root.properties
        //file:/F:/LoadFile/LoadFile/target/classes/
        //file:/F:/LoadFile/LoadFile/target/classes/db/db.properties
        //file:/F:/LoadFile/LoadFile/target/classes/util/util.properties
        //file:/F:/LoadFile/LoadFile/target/classes/root.properties
    }

    public static void getPathByClassLoader() {
        //ClassLoader.getResource()默认其当前位置即classpath,故无需以"/"开头
        //若以"/"开头,反而让编译器找不到路径
        System.out.println(AcquirePath.class.getClassLoader().getResource(""));
        System.out.println(AcquirePath.class.getClassLoader().getResource("."));
        System.out.println(AcquirePath.class.getClassLoader().getResource("/"));
        //默认以classpath为寻址起点,故无需以"/"开头,使用绝对路径寻址
        System.out.println(AcquirePath.class.getClassLoader().getResource("db/db.properties"));
        System.out.println(AcquirePath.class.getClassLoader().getResource("util/util.properties"));
        System.out.println(AcquirePath.class.getClassLoader().getResource("root.properties"));
        //打印结果如下
        //file:/F:/LoadFile/LoadFile/target/classes/
        //file:/F:/LoadFile/LoadFile/target/classes/
        //null
        //file:/F:/LoadFile/LoadFile/target/classes/db/db.properties
        //file:/F:/LoadFile/LoadFile/target/classes/util/util.properties
        //file:/F:/LoadFile/LoadFile/target/classes/root.properties
    }
}


