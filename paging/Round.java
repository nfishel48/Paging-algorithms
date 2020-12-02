package paging;
import java.util.*;

/*
This class represents a single "try" or as im calling them to not get confused with try/catch a "round"
*/
public class Round {
    public int frames; //Number of frames in memory
    public List<Integer> pages = new ArrayList<>(); //Page numbers requested by the cpu
}
