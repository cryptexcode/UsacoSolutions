/*
 ID: cryptex1
 LANG: JAVA
 TASK: milk3
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author macbookair
 */
public class milk3 {

    static class State {

        int A, B, C;

        public State(int a, int b, int c) {
            this.A = a;
            this.B = b;
            this.C = c;
        }
    }

    static void runProcess() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Stack<State> stack = new Stack<State>();
        stack.push(new State(0, 0, C));
        boolean map[][][] = new boolean[21][21][21];
        map[0][0][C] = true;
        ArrayList<Integer> list = new ArrayList();
        
        while (stack.size() > 0) {
            State parent = stack.pop();
            if(parent.A == 0)
                list.add(parent.C);
            
            //System.out.println(parent.A +" "+parent.B+" "+parent.C);

            //C->A
            int moved = Math.min(A-parent.A, parent.C);
            if( !map[parent.A + moved][parent.B][parent.C-moved]){
                stack.push( new State(parent.A + moved, parent.B, parent.C-moved) );
                map[parent.A + moved][parent.B][parent.C-moved] = true;                
            }
            
            //C->B
            moved = Math.min(B-parent.B, parent.C);
            if( !map[parent.A][parent.B + moved][parent.C-moved]){
                stack.push( new State(parent.A, parent.B+ moved, parent.C-moved) );
                map[parent.A][parent.B+ moved][parent.C-moved] = true;                
            }
            
            //A->B
            moved = Math.min(B-parent.B, parent.A);
            if( !map[parent.A-moved][parent.B + moved][parent.C]){
                stack.push( new State(parent.A-moved, parent.B+ moved, parent.C) );
                map[parent.A-moved][parent.B+ moved][parent.C] = true;
            }
            
            //A->C
            moved = Math.min(C-parent.C, parent.A);
            if( !map[parent.A-moved][parent.B][parent.C + moved]){
                stack.push( new State(parent.A-moved, parent.B, parent.C+ moved) );
                map[parent.A-moved][parent.B][parent.C+ moved] = true;
            }
            
            //B->C
            moved = Math.min(C-parent.C, parent.B);
            if( !map[parent.A][parent.B-moved][parent.C + moved]){
                stack.push( new State(parent.A, parent.B-moved, parent.C+ moved) );
                map[parent.A][parent.B-moved][parent.C+ moved] = true;
            }
            
            //B->A
            moved = Math.min(A-parent.A, parent.B);
            if( !map[parent.A +moved][parent.B-moved][parent.C]){
                stack.push( new State(parent.A+moved, parent.B-moved, parent.C) );
                map[parent.A+moved][parent.B-moved][parent.C] = true;
            }            
        }
        
        Collections.sort(list);
        String output = list.toString().replace(",", "");
        output = output.substring(1, output.length()-1);
        
        out.println(output);

        out.close();
        System.exit(0);
    }
}
