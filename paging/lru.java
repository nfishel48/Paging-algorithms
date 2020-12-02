package paging;
import java.util.*;

public class lru {

    public static List<Integer> memFrames = new ArrayList<>();
    public static List<Integer> timesUsed = new ArrayList<>(); //increment index everytimes it is used
    public static List<Integer> age = new ArrayList<>(); //how many access have been made since the page has been in the frame together with times used this can caludate freqency
    public static List<PrintBuffer> faultList = new ArrayList<>();

    public static int swap(Round round){ 
        int faults = 0;
        for(int i = 0; i< round.pages.size(); i++){
            if (memFrames.contains(round.pages.get(i))){
                for(int j = 0; j<memFrames.size(); j++){ //loop through to find index of what frame matches the page
                    if(memFrames.get(j) == round.pages.get(i)){
                        int increment = timesUsed.get(i); //get the value of how many times this page has been used
                        increment++;
                        timesUsed.set(j,increment);//return the modified value
                    }
                }
                System.out.println("No fault"); //debug
            }
            else{
                if(memFrames.size() < round.frames){ 
                    memFrames.add(round.pages.get(i));
                    timesUsed.add(0);//keep track of how many times this varible is used
                }
                else{//if the size exeeds the frames, last recently used page is unloaded
                    for(int k = 0; k<memFrames.size(); k++){//loop through array and find the least used

                    }
                }
                faults++;
            }
        }



        return faults;
    }
}
