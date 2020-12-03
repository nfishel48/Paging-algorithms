package paging;
import java.util.*;

public class Optimal {

    public static List<Integer> mem = new ArrayList<>();

    public static int swap(Round round){ 
        int faults = 0;
        int ref_len = round.pages.size();  
        int frames = round.frames;

        for(int i = 0; i< ref_len; i++){
            if( mem.contains(round.pages.get(i))){ // if page exists no fault

            }
            else{ // page does not exitst
                if(mem.size() < frames){ // we have empty frmes so we add it.
                    mem.add(round.pages.get(i));
                }
                else{//find the optimal page to switch out 
                    int exists = 0;
                    for(int j = 0; j< mem.size(); j++){ //loop through the refrence values 
                        
                        if(mem.contains(round.pages.get(j))){
                            exists = j; // the new longest until it is needed
                        }
                    }
                    mem.remove(exists);
                    mem.add(round.pages.get(i));
                }
                faults++;

            }
        }
        System.out.println("Optimal:"+faults);
        return faults;
    }
}

