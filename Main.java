import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.text.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> intr = new ArrayList<String>();
        ArrayList<String> intr1 = new ArrayList<String>();
        ArrayList<Integer> brk = new ArrayList<Integer>();
        ArrayList<String> team = new ArrayList<String>();
        ArrayList<String> jud = new ArrayList<String>();
        ArrayList<String> exy =  new ArrayList<String>();
        ArrayList<String> exn = new ArrayList<String>();
        ArrayList<String> jt = new ArrayList<String>();
        ArrayList<String> jp = new ArrayList<String>();
        ArrayList<String> shor = new ArrayList<String>();
        ArrayList<Integer> time = new ArrayList<Integer>();
        ArrayList<String> con = new ArrayList<String>();
        ArrayList<String> con1 = new ArrayList<String>();
        ArrayList<Integer> ts = new ArrayList<Integer>();
        String[][] prin;
        Array print = new Array();
        Checks check = new Checks();
        Scanner in = new Scanner(System.in);
        boolean startb = false;
        boolean run = true;
        boolean test1 = true;
        boolean test2 = true;
        boolean test3 = true;
        boolean conb = false;
        boolean conb2 = false;
        int int1 = 0;
        int brk1 = 6;
        int start = 0;
        int num = 0;
        int run1 = 1;
        int tst = 0;
        String s1 ="";
        String r1 = "";
        String tn = "";
        String pair = "";
        String str2 = "";
        String n1 = "";
        String n2 = "";
        String won = "";
        String tu = "";
        try{
            File judges = new File("Judges.txt");
            Scanner read = new Scanner(judges);
            while(read.hasNextLine()){
                jt.add(read.nextLine());
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Error");
            p.printStackTrace();
        }
        
        try{
            File teams = new File("Teams.txt");
            Scanner reader = new Scanner(teams);
            while(reader.hasNextLine()){
                team.add(reader.nextLine());
            }
        }
        catch(FileNotFoundException k){
            System.out.println("Error");
            k.printStackTrace();
        }
        
        try{
            File inr = new File("Interruptions.txt");
            Scanner reader1 = new Scanner(inr);
            while(reader1.hasNextLine()){
                if(reader1.nextLine().equals("Start Time:")){
                    startb = true;
                    
                }
                if(startb == true){
                    s1 = reader1.nextLine();
                    start = check.start(s1);
                    startb = false;
                }
                else{
                   intr.add(reader1.nextLine()); 
                }
                
            }
        }
        catch(FileNotFoundException r){
            System.out.println("Error");
            r.printStackTrace();
        }
        
        for(int i = 0; i < intr.size(); i++){
            if(intr.get(i).equals("Interruption:")){
                int1 = 1;
            }
            else if(int1 == 1){
                brk.add(check.start(intr.get(i)));
                intr1.add(intr.get(i));
                int1 = 2;
            }
            else if(int1 == 2){
                brk.add(check.start(intr.get(i)));
                intr1.add(intr.get(i));
                int1 = 0;
            }
        }
        
        for(int i = 0; i < jt.size(); i++){
            if(jt.get(i).equals("Has Judged Before:")){
                jud.add(jt.get(i -1));
                if(jt.get(i + 1).equals("Yes")){
                    exy.add(jt.get(i -1));
                    }
                    else if(jt.get(i + 1).equals("No")){
                        exn.add(jt.get(i -1));
                        }
                
            }
            
        }
        
        for(int i = 0; i < exn.size(); i++){
            pair = exy.get(i);
            exy.remove(exy.get(i));
            pair += ", ";
            pair += exn.get(i);
            exn.remove(exn.get(i));
            jp.add(pair);
            i--;
            
        }
        
        if(exy.size() % 2 == 0){
            for(int i = 0; i < exy.size(); i += 2){
                jp.add(exy.get(i) + ", " + exy.get(i +1));
            }
        }
        else{
            for(int i = 0; i < exy.size()-1; i+=2){
                jp.add(exy.get(i) + ", " + exy.get(i +1));
            }
             str2 = exy.get(exy.size() -1);
        }
        
        
        
        System.out.println("Start time: " + s1 + " (" + start + ")");
        System.out.println("");
        start -= 10;
        int siz = team.size()/jp.size();
        for(int i = 1; i < siz+1; i++){
            start += 10;
            String hey = String.valueOf(start);
            if(hey.contains("60")){
                start += 40;
            }
            if(start >= 1300){
                start = 100;
            }
            for(int k = 0; k < brk.size(); k+= 2){
                
                if(start == brk.get(k)){
                    
                    start = brk.get(k +1);
                    
                    
                }
            }
            time.add(start);
            
        }

        for(int i = 0; i < jt.size(); i++){
            
            if(jt.get(i).equals("Conflicts:")){
                con.add("...");
                con.add(jt.get(i-3));
                if(jt.get(i + 1).equals("None")){
                            con.add("!@#$%^&*");
   
                }
                else{
                    while(run){
                        con.add(jt.get(i + run1));
                        run1++;
                        if((i + run1) <= jt.size()-1){
                        if(jt.get(i + run1).contains("1") || jt.get(i + run1).contains("2") || jt.get(i + run1).contains("3") || jt.get(i + run1).contains("4") || jt.get(i + run1).contains("5") || jt.get(i + run1).contains("6") || jt.get(i + run1).contains("7") || jt.get(i + run1).contains("8") || jt.get(i + run1).contains("9")){
                            run = true;
                        }
                        else{
                            run = false;
                            run1 = 1;
                        }
                        }
                        else{
                            run = false;
                            run1 = 1;
                        }
                    }
                }
                
            }
            run = true;
            
        }
        con.add("...");
        
        
        con1.clear();
        int chk = jp.size();
        int n = team.size() - (jp.size() * time.size());
        double ln1 = team.size();
        double ln2 = jp.size();
        int sizer = (int)((ln1/ln2) + 0.5);
        prin = new String[chk][sizer];
        int row = prin.length;
        int col = prin[0].length;
        int rec = 0;
        for(int i = 0; i < sizer; i++){
            if(i < time.size()){
                rec = time.get(i);
                ts.add(rec);
            }
            else{
                rec+=10;
                ts.add(rec);
            }
        }
        
        
        for(int i = 0; i < jp.size(); i++){
            tst = jp.get(i).indexOf(",");
            n1 = jp.get(i).substring(0, tst);
            n2 = jp.get(i).substring(tst+2);
             won = print.shorten(n1);
             tu = print.shorten(n2);
            String ent = won + " & " +  tu + " ";
            shor.add(print.fit(ent));
        
        }
        
        for(int i  = 0; i < shor.size(); i++){
            print.cln(shor.get(i));
        }
        
        
        
        
        for(int i  = 0;  i < row; i++){
            for(int k = 0; k < col; k++){
                if(i == 0){
                    
                    
                    prin[i][k] = "" + shor.get(k) + "  ";
                    
                }
                else{
                        prin[i][k] = "                 " + ".";
                }
            }
            
        }
        
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                System.out.print(prin[i][k]);
            }
            System.out.println();
        }
        if(n > 0){
            for(int i = 0; i < n; i++){
                jp.add(jp.get(i));
            }
        
        }
        for(int i = 0; i < time.size(); i++){
            
            //System.out.println(time.get(i));
            System.out.println("");
            for(int k = 0; k < jp.size(); k++){
                if(num == team.size()){
                    break;
                }
                if (k == chk){
                    k -= chk;
                    i++;
                }
                tst = jp.get(k).indexOf(",");
                n1 = jp.get(k).substring(0, tst);
                n2 = jp.get(k).substring(tst+2);
                for(int j = 0; j < con.size(); j++){
                    run1 = 1;
                    if(con.get(j).equals(n1)){
                        
                            while(test1){
                                if(con.get(j + run1).equals("!@#$%^&*")){
                                    //System.out.println("No conflicts");
                                    test1 = false;
                                }
                                else if(con.get(j + run1).equals("...")){
                                    //System.out.println("End");
                                    test1 = false;
                                }
                                else{
                                    con1.add(con.get(j + run1));
                                    run1++;
                                }
                            }
                        }
                        else if(con.get(j).equals(n2)){
                             while(test2){
                                 if(con.get(j + run1).equals("!@#$%^&*")){
                                     //System.out.println("No conflicts");
                                     test2 = false;
                                     }
                                     else if(con.get(j + run1).equals("...")){
                                         //System.out.println("End");
                                         test2 = false;
                                         }
                                         else{
                                             con1.add(con.get(j + run1));
                                             run1++;
                                             
                                         }
                                 
                             }
                             }
                             
                    }

                    test1= true;
                    test2 = true;
                
                test1 = true;
                test2 = true;
                if(i < time.size()){
                System.out.println(check.end(time.get(i)) + " (" + time.get(i) + ")");
                }
                else if(i > 0){
                    System.out.println(check.end((time.get(time.size()-1))+10) + " (" + (time.get(time.size()-1)+10) + ")");
                }
                System.out.println();
                for(int l = 0; l < con1.size(); l++){
                    
                    //System.out.println(klp);
                    if(con1.get(l).contains(team.get(num).substring(0, team.get(num).length() -1))){
                        conb = true;
                    }
                    
                    
                }
                if(conb){
                    System.out.println("CONFLICT: " + jp.get(k) + print.pl(con1));
                    System.out.println();
                    k++;
                    if(k == jp.size()){
                        k = 0;
                    }
                    if(conb2){
                        System.out.println("CONFLICT: " + jp.get(k) + print.pl(con1));
                        System.out.println();
                        k++;
                        if(k == jp.size()){
                            k = 0;            
                            }
                        System.out.println("New Judge: " + jp.get(k) + print.pl(con1));
                       
                    }
                    else{
                    System.out.println("new Judge: " + jp.get(k));
                    }
                    //System.out.println();
                }
                else{
                System.out.println("JUDGES: " + jp.get(k) + print.pl(con1));
                
                //print.pl(con1);
                }
                System.out.println();
                System.out.println("TEAM: " + team.get(num));
                System.out.println("");
                if(num == team.size()-1){
                    System.out.println("END");
                }
                else{
                System.out.println("To see the next interview press enter");
                System.out.println("If there is an additional conflict, press C");
                }
                String kyu = in.nextLine();
                while(kyu.toUpperCase().equals("C")){
                    k++;
                    if(k == jp.size()){
                        k = 0;
                    }
                    System.out.println();
                    System.out.println("JUDGES: " + jp.get(k) + print.pl(con1));
                    System.out.println();
                    System.out.println("TEAM: " + team.get(num));
                    System.out.println("");
                    if(num == team.size()-1){
                        System.out.println("END");
                        }
                        else{
                    System.out.println("To see the next interview press enter");
                    System.out.println("If there is an additional conflict, press C");
                }
                    kyu = in.nextLine();
            
                }
                
                num++;
                con1.clear();
                conb = false;
                conb2 = false;
                System.out.print("\033[H\033[2J");
            }
        }
        
        
        System.out.println("Extra Judge: " + str2);
        //print.pa(jp);
        
    }   
}
