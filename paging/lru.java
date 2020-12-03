package paging;
import java.util.*;

public class lru {

    public static List<PrintBuffer> faultList = new ArrayList<>();

    public static int swap(Round round){ 
        HashSet<Integer> s = new HashSet<>(round.frames);
        LinkedHashMap<Integer, Integer> memFrames = new LinkedHashMap<>(round.frames, .75f, true);
        int faults = 0;
        for(int i = 0; i< round.pages.size(); i++){
            if(s.size() < round.frames){ 
                if (!s.contains(round.pages.get(i))) 
                { 
                    s.add(round.pages.get(i)); 
                    faults++;
                }
                memFrames.put(round.pages.get(i), i); 
                
                }
            else{
                if (!s.contains(round.pages.get(i))) 
                { 
                    int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE; 
                    Iterator<Integer> itr = s.iterator(); 
                    while (itr.hasNext()) { 
                        int temp = itr.next(); 
                        if (memFrames.get(temp) < lru) 
                        { 
                            lru = memFrames.get(temp); 
                            val = temp; 
                        } 
                    } 
                    s.remove(val); 
                    memFrames.remove(val); 
                    s.add(round.pages.get(i)); 
                    faults++; 
                } 
                // Update the current page index 
                memFrames.put(round.pages.get(i), i); 
            } 
            }
        System.out.println("LRU:"+faults);
        return faults;
    }
}
