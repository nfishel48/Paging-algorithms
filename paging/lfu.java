package paging;
import java.util.*;

public class lfu {
    public static List<Integer> memFrames = new ArrayList<>();
    public static List<Integer> timesUsed = new ArrayList<>(); //increment index everytimes it is used
    public static List<Integer> age = new ArrayList<>(); //how many access have been made since the page has been in the frame together with times used this can caludate freqency
    public static List<PrintBuffer> faultList = new ArrayList<>();

    public static int swap(Round round){ 
        int faults = 0;
        for(int i = 0; i< round.pages.size(); i++){
            if (memFrames.contains(round.pages.get(i))){
                for(int j = 0; j<memFrames.size(); j++){ //loop through to find index of what frame matches the page
                    int incrementAge = age.get(j); //get the value of the age
                    incrementAge++;
                    age.set(j,incrementAge);//return the modified value
                    if(memFrames.get(j) == round.pages.get(i)){
                        int increment = timesUsed.get(j); //get the value of how many times this page has been used
                        increment++;
                        timesUsed.set(j,increment);//return the modified value
                    }
                }
            }
            else{
                if(memFrames.size() < round.frames){ 
                    memFrames.add(round.pages.get(i));
                    timesUsed.add(0);//keep track of how many times this varible is used
                    age.add(1);
                    for(int j = 0; j<memFrames.size(); j++){ //loop through and increase the age of all pages
                        if(j == i){
                         //do nothing   
                        }
                        else{
                        int incrementAge = age.get(i); //get the value of the age
                        incrementAge++;
                        age.set(j,incrementAge);//return the modified value
                        }
                    }
                }
                else{//if the size exeeds the frames, least fequently used page is unloaded
                    int lowestFrequency = 100;
                    int lowestFrequencyIndex = 0;
                    for(int k = 0; k<memFrames.size(); k++){//loop through array and find the least used
                        int timesUsedNow = timesUsed.get(k);
                        int ageNow = age.get(k);
                        int freqency = timesUsedNow/ageNow;
                        if(freqency<lowestFrequency){ 
                            lowestFrequency = freqency;
                            lowestFrequencyIndex = k;
                        }
                    }
                    memFrames.set(lowestFrequencyIndex, round.pages.get(i));//overwrite the value at the index of
                    for(int j = 0; j<memFrames.size(); j++){ //loop through to find index of what frame matches the page
                        int incrementAge = age.get(j); //get the value of the age
                        incrementAge++;
                        age.set(j,incrementAge);//return the modified value
                    }
                }
                faults++;
            }
        }
        System.out.println("LFU:"+faults);
        return faults;
    } 
}
