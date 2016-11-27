package brainfuck;

import java.util.Stack;

/**
 * Created by Allan Wang on 2016-11-27.
 *
 * Original code from https://github.com/quwahara/Brainfuck
 */
public class Compiler {
    public static void brainfuck(String bf) throws Exception {
        int[] loop = new int[bf.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < bf.length(); ++i) {
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

        int pc = 0, ptr = 0;
        byte[] mem = new byte[30000];
        while (pc < bf.length()) {
            switch (bf.charAt(pc)) {
                case '<':
                    ptr--; //move pointer back one
                    break;
                case '>':
                    ptr++;//move pointer forward one
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
                    System.out.print((char) mem[ptr]); //print out current character
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
