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
                 // Check if current page is not already 
                // present in the set 
                if (!s.contains(round.pages.get(i))) 
                { 
                    // Find the least recently used pages 
                    // that is present in the set 
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
                    // Remove the indexes page 
                    s.remove(val); 
                   //remove lru from hashmap 
                    memFrames.remove(val); 
                    // insert the current page 
                    s.add(round.pages.get(i)); 
                    // Increment page faults 
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
