import java.util.*;

/**
 * 
 * A comparator that compares two EmployeeNode objects by name
 * lexicographically
 * 
 * @author Ali Zoulgami
 * 
 */

public class alphabeticalComparator implements Comparator<EmployeeNode> {
    public int compare(EmployeeNode e1, EmployeeNode e2) {
        return e1.getName().compareTo(e2.getName());
    }

}