package brainfuck;

/**
 * Created by Allan Wang on 2016-11-27.
 * Just some sample snippets
 */
public class Showcase {

    public static String
            echo = ",[.[-]>,]", //echos whatever you print

    //prints Hello World; for more samples in many other languages, see
    //http://codegolf.stackexchange.com/questions/55422/hello-world
    bestHelloWorld = "--<-<<+[+[<+>--->->->-<<<]>]<<--.<++++++.<<-..<<.<+.>>.>>.<<<.+++.>>.>>-.<<<+.", //by primo

    toCompile = bestHelloWorld;

    public static void main(String[] args) throws Exception {
        Compiler.brainfuck(toCompile, true);
    }
}
