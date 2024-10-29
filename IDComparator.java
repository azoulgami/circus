import java.util.*;
/**
 * 
 * A comparator that compares two EmployeeNode objects by ID
 * lexicographically
 * 
 * @author Ali Zoulgami
 * 
 */
public class IDComparator implements Comparator<EmployeeNode> {
    public int compare(EmployeeNode e1, EmployeeNode e2) {
        return e1.getID().compareTo(e2.getID());
    
    }

}