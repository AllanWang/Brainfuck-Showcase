package brainfuck;

import java.util.Stack;

/**
 * Created by Allan Wang on 2016-11-27.
 * <p>
 * Original code from https://github.com/quwahara/Brainfuck
 * <p>
 * Brainfuck is a "simple" programming language with only 8 characters
 * <>+-[],.
 * See the comments below for their uses
 */
public class Compiler {

    public static void brainfuck(String bf) throws Exception {
        brainfuck(bf, false);
    }

    public static void brainfuck(String bf, boolean numbers) throws Exception {
        int[] loop = new int[bf.length()];
        Stack<Integer> stack = new Stack<>();
        //Get all the while loops and their respective locations
        for (int i = 0; i < bf.length(); i++) {
            switch (bf.charAt(i)) {
                case '[':
                    stack.push(i);
                    break;
                case ']':
                    int start = stack.pop();
                    loop[start] = i;
                    loop[i] = start;
                    break;
                default:
                    break;
            }
        }

        int pc = 0, ptr = 20; //default pointer to 20 to allow for "negative" pointer indices
        byte[] mem = new byte[30000];
        //Start reading Brainf*ck code
        while (pc < bf.length()) {
            switch (bf.charAt(pc)) {
                case '<':
                    ptr--; //move pointer back one
                    break;
                case '>':
                    ptr++; //move pointer forward one
                    break;
                case '-':
                    mem[ptr]--; //remove one from current pointer
                    break;
                case '+':
                    mem[ptr]++; //add one to current pointer
                    break;
                case '[':
                    if (mem[ptr] == 0) pc = loop[pc]; //if pointer is 0, reset pointer to end position
                    break;
                case ']':
                    if (mem[ptr] != 0) pc = loop[pc] - 1; //if pointer is not 0, move back to start position
                    break;
                case '.':
                    if (!numbers) System.out.print((char) mem[ptr]); //print out current character
                    else System.out.print((int) mem[ptr] + " ");
                    break;
                case ',':
                    mem[ptr] = (byte) System.in.read(); //read one byte
                    break;
                default: //ignore other characters
                    break;
            }
            pc++; //move to next character
        }
        System.out.println(); //end line
    }
}
