package paging;
import java.util.*;
public class PrintBuffer {
    public int frames;
    public int requestPage;
    public List<Queue> pages = new ArrayList<>(); //Page numbers requested by the cpu
    public String refString;

    public int[] getPages() {
        int[] intPages = new int[frames]; //send back numbers from array as int array
        for(int i = 0; i<pages.size(); i++){
            intPages[i] = (int)pages.get(i).remove();
        }
        return intPages;
    }
}
