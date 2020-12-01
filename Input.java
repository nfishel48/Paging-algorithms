import java.lang.*;
import java.io.*;

public class Input {
    
 public static void main(String args[]){
        try 
        { 
        //create file input stream. Note that foo must a member of a user-defined class
    
        InputStream inS = foo.getClass().getResourceAsStream("input.txt");    
        if (inS == null) {
        System.out.println("File not found: input.txt"); 
        return;
        }
        // A Reader reads input as characters, rather than raw data.
        BufferedReader buffR = new BufferedReader(new InputStreamReader(inS));
        //The stream tokenizer parses the characters into words, integers, etc.
        StreamTokenizer in = new StreamTokenizer(buffR);
    
        in.nextToken(); // Get the first token. (A token can be a word, a number,    EOF, etc.)
        while (in.ttype != in.TT_EOF) // Keep going until exhausting tokens 
        { 
        if (in.ttype == in.TT_WORD) {
            if (in.sval.equals("JOB")) {
            ... }
            ...}
    
        in.nextToken(); // Get the next token 
        } 
    } // yrt 
    catch (IOException ex){ 
        System.out.println(ex.getMessage()); 
    } 
    finally { 
        try { 
        if (inS != null) inS.close(); 
        } 
        catch (IOException ex) 
        { 
        System.err.println("Had trouble closing input.txt.");
        } 
    }
}    
}
