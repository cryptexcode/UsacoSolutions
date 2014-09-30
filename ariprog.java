
/*
ID: cryptex1
LANG: JAVA
TASK: ariprog
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookair
 */
public class ariprog {
    
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        
        int n = Integer.parseInt(f.readLine());
        int m = Integer.parseInt(f.readLine());

        int[] list = new int[m*m + m*m + 1];
        ArrayList<Integer> numList = new ArrayList();
        ArrayList<int[]> sorted = new ArrayList<int[]>();
        
        for(int i=0; i<list.length; i++) list[i]=0;
        
        for(int i=0; i<=m; i++){
            for(int j=i; j<=m; j++){                
                list[i*i + j*j] = 1;
                if(!numList.contains(i*i + j*j)){
                    numList.add(i*i + j*j);
                }
            }
        }
        
        Collections.sort(numList);
//        System.out.println(numList);
//        for(int i=0; i<list.length; i++){
//            if(list[i] == 1)
//                System.out.print(i+" ");
//            //numList.add(i);
//        }

        for(int i=0; i<=numList.size()-n+1; i++){
            for(int j=i+1; j<=numList.size()-n+1; j++){
                String s= "";
                int diff = numList.get(j) - numList.get(i);
                int k=2;
               
                for( ; k<n; k++){
                    if ((numList.get(i) + k*diff) >= list.length) break;
                    else if (list[(numList.get(i) + k*diff) ] == 1){s+=" "+(numList.get(i) + k*diff);}
                    else break;
                }
                
                if(k>=n){
                    sorted.add(new int[]{numList.get(i), diff});
                }                                
            }
        }
        
        if(sorted.size() == 0)
            out.println("NONE");
        else{
            Collections.sort(sorted, new Comparator<int[]>(){
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] < o2[1]) return -1;
                    if(o1[1] > o2[1]) return 1;
                    if(o1[0] < o2[0]) return -1;
                    if(o1[0] < o2[0]) return 1;
                    return 0;
                } 
            });
            
            for(int i=0; i<sorted.size(); i++){
                out.println(sorted.get(i)[0]+" "+sorted.get(i)[1]);
            }
        }
        out.close();
        System.exit(0); 
    }
}
