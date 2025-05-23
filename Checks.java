
public class Checks {
    public Checks(){
        
    }
    
    public int start(String str){
        String first = "";
        String second = "";
        String s = "";
        if(str.length() == 4){
            first = str.substring(0,1);
            second = str.substring(2);
            s = first + second;
        }
        else{
            first = str.substring(0,2);
            second = str.substring(3);
            s = first + second;
        }
        return Integer.valueOf(s);
        //return 800;
    }
    
    public String end(Integer w){
        String str = String.valueOf(w);
        //System.out.println(str.length());
        if(str.length() == 3){
            str = str.substring(0,1) + ":" + str.substring(1);
        }
        else{
            str = str.substring(0,2) + ":" + str.substring(2);
        }
        return str;
    }
}
