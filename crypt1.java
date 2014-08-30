/*
ID: cryptex1
LANG: JAVA
TASK: crypt1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class crypt1 {
    
    static void makeCombinations(ArrayList<Integer> list, int length, int[] set){
        
        for(int i=0; i<set.length; i++){
            for(int j=0; j<set.length; j++){
                
                if(length == 3)
                    for(int k=0; k<set.length; k++){
                        list.add( set[i]*100 + set[j]*10 + set[k]);
                    }
                else{
                    list.add( set[i]*10 + set[j]);
                }
            }
        }        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        
        int n = Integer.parseInt(f.readLine());
        int[] set = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        int count = 0;
        
        while(st.hasMoreTokens()){
            set[count] = Integer.parseInt(st.nextToken());
            count++;
        }
        
       // int n=5;
        //int[] set = {2,3,4,6,8};
        
        ArrayList<Integer> firstSet = new ArrayList<Integer>();
        ArrayList<Integer> secondSet = new ArrayList<Integer>();
        
        makeCombinations(firstSet, 3, set);
        //System.out.println(firstSet);
        
        makeCombinations(secondSet, 2, set);
        //System.out.println(secondSet);
        
        int counter = 0;
        
        for(int i=0; i<firstSet.size(); i++){
            for(int j=0; j<secondSet.size(); j++){
                int result = firstSet.get(i) * secondSet.get(j);
                int mul1 = firstSet.get(i) * (secondSet.get(j)%10);
                int mul2 = firstSet.get(i) * (secondSet.get(j)/10);
                
                ArrayList<Integer> digitList = new ArrayList();
                int checker = 1;
                if(result / 10000 >0 || mul1/1000>0 || mul2/1000>0) checker = 0;
                
                //System.out.println(mul1+" "+mul2+ " "+secondSet.get(j)%10);
                if(checker == 1)
                while(true)
                {
                    int flag = 0;
                    
                    for(int k=0; k<set.length; k++){
                        if( (mul1 % 10) == set[k]) { flag = 1; break;}                     
                    }
                                        
                    mul1/=10;
                    if(flag == 0) checker = 0;
                    if(mul1 == 0 || checker == 0) break;
                }
                //System.out.println(mul1+" (1) "+checker);
                
                if(checker == 1){
                    while(true)
                    {
                        int flag = 0;

                        for(int k=0; k<set.length; k++){
                            if( (mul2 % 10) == set[k]) { flag = 1; break;}                     
                        }

                        mul2/=10;
                        if(flag == 0) checker = 0;
                        if(mul2 == 0 || checker == 0) break;
                    }
                }
                //System.out.println(mul2+" (2) "+checker);
                
                if(checker == 1){
                    while(true)
                    {
                        int flag = 0;

                        for(int k=0; k<set.length; k++){
                            if( (result % 10) == set[k]) { flag = 1; break;}                     
                        }

                        result/=10;
                        if(flag == 0) checker = 0;
                        if(result == 0 || checker == 0) break;
                    }
                }
                
                if(checker == 1) counter++;
                   // System.out.println(firstSet.get(i)+" "+secondSet.get(j)+" "+firstSet.get(i) * (secondSet.get(j)%10)+" "+firstSet.get(i) * (secondSet.get(j)/10)+" "+ (firstSet.get(i) * secondSet.get(j)));
                
                
            }
            
        }
        
        System.out.println(counter);
        out.println(counter);
        out.close();                                  // close the output file
        System.exit(0);  
    }
}
