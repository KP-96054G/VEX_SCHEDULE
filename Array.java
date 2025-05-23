import java.util.*;
import java.text.*;
import java.io.*;
public class Array {
    private int cnt;
    private int len;
    
    public Array(){
        cnt = 0;
        len = 0;
    }
    
    public void pa(ArrayList<String> print){
        for(String p : print){
            System.out.println(p);
        }
    }
    
    public void pi(ArrayList<Integer> print){
        for(Integer p : print){
            System.out.println(p);
        }
    }
    
    public String pl(ArrayList<String> print){
        String ret = " [";
        
        for(int i = 0; i < print.size(); i++){
            if(i != 0){
                ret += ", ";
                }
            ret += print.get(i);
            
        }
        ret += "]";
        if(print.size() == 0){
            ret = " [NO CONFLICTS]";
        }
        return ret;
    }
    
    public void pd(int[][] arr){
        for(int[] r : arr){
            for(int i : r){
                System.out.println(".");
            }
        }
    }
    
    public String shorten(String str){
        int l = str.indexOf(" ");
        String won = str.substring(0, 4);
        won += " ";
        won += str.substring(l+1, l+2);
        won += ".";
        return won;
    }
    
    public void cln(String str){
        if(cnt == 0){
            len = str.length();
        }
        else if(str.length() > len){
            len = str.length();
        }
        else{
            len = len;
        }
    }
    
    public String rlong(){
        String str = "";
        for(int i = 0; i < len+2; i++){
            str += " ";
        }
        return str;
    }
    
    public String fit(String cuh){
        String front = "";
        int frn = 0;
        String last = "";
        int lst = 0;
        int lnc = len - cuh.length();
        if(lnc %2 == 0){
            frn = lnc/2;
            lst = frn;
        }
        else{
            frn = lnc/2;
            lst = frn+1;
        }
        for(int i = 0; i< frn; i++){
            front += " ";
        }
        for(int i = 0; i < lst; i++){
            last += " ";
        }
        return front + cuh + last;
        
    }
    
    public void reset(){
        len = 0;
        cnt = 0;
    }
    
}
