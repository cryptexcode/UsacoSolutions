
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 ID: cryptex1
 LANG: JAVA
 TASK: sprime
 */

/**
 *
 * @author macbookair
 */
public class sprime {
    
    static boolean primes[] = new boolean[10000000];
    
    static void sieve(){
        primes[0] = true;
        primes[1] = true;
        
        for(int i=2; i<Math.sqrt(primes.length)+1; i++){
            if( primes[i] == false){                
                for(int j=i*2; j<primes.length; j+=i)
                    primes[j] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));        
        sieve();
        int cand[] = {1,3,5,7,9};
        int singles[] = {2,3,5,7};
        int length = Integer.parseInt(f.readLine());
        
                
        ArrayList<Integer>[] listArr = new ArrayList[length];        
                
        for(int i=0; i<length; i++){
            listArr[i] = new ArrayList();
            if(i==0){
                for(int j=0; j<singles.length; j++) listArr[i].add(singles[j]);
            }else {
                for(int j=0; j<listArr[i-1].size(); j++){
                    for(int k=0; k<cand.length; k++){
                        int temp = (listArr[i-1].get(j) * 10) + cand[k]; 
                        
                        if(i<7){
                            if(primes[temp] == false){                            
                                listArr[i].add(temp);
                            }
                        }
                        else{
                            boolean isPrime = true;
                            for(int ii=2; ii<Math.sqrt(100000000); ii++){
                                if(primes[ii] == false && temp%ii == 0){
                                    isPrime = false;
                                    break;
                                }
                            }
                            if(isPrime)
                                listArr[i].add(temp);
                        }
                    }
                }
            }
        }        
        
        for(int i=0; i<listArr[length-1].size(); i++){
            out.println(listArr[length-1].get(i));
        }
        
        out.close();
        System.exit(0);
    }
}
