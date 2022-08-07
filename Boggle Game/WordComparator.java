import java.util.*;
  
public class WordComparator implements Comparator<String>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(String a, String b) //compares words based on length 
    {
    	if (a.length() > b.length())
    		return -1;
    	if (a.length() < b.length())
    		return 1;
    	
        return a.compareTo(b);//if same length, uses normal string comparison
        
    }
}
