package brainfuck;

/**
 * Created by Allan Wang on 2016-11-27.
 * Just some sample snippets
 */
public class Showcase {

    public static String echo = ",[.[-]>,]"; //echos whatever you print

    private static String toCompile = echo;

    public static void main(String[] args) throws Exception {
        Compiler.brainfuck(toCompile);
    }
}
