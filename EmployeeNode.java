import java.util.*; 
/**
 * Represents an employee with associated details such 
 * as ID, name, category, and title.
 */
public class EmployeeNode {
    private String name;
    private String ID;
    private String category;
    private String title;
    
    /**
     * Constructs an EmployeeNode with the specified details.
     *
     * @param name     The name of the employee.
     * @param ID       The unique identifier for the employee.
     * @param category The category associated with the employee.
     * @param title    The job title of the employee.
     */
    public EmployeeNode(String name, String ID, String category, String title) {
        this.name=name;
        this.ID=ID;
        this.category=category;
        this.title=title;
    }
    
    
    
    /**
     * Retrieves the ID of the employee.
     *
     * @return The unique identifier of the employee.
     */
    public String getID() {
        return this.ID;
    }
    
     /**
     * Retrieves the name of the employee.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return this.name;
    }
    
     /**
     * Retrieves the category of the employee.
     *
     * @return The category under which the employee falls.
     */
    public String getCategory() {
        return this.category;
    }
    
    /**
     * Retrieves the job title of the employee.
     *
     * @return The job title of the employee.
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Compares 2 Employees and checks if they're equal.
     *
     * @param other employee to compare to
     *
     * @return True if employees are equal,false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof EmployeeNode) {
            EmployeeNode other=(EmployeeNode)o;
            return (other instanceof EmployeeNode && this.name.equals(other.name) &&
                this.ID.equals(other.name) &&
                this.category.equals(other.name) &&
                this.title.equals(other.name));
        }
        else {
            return false;
        }
        
        
    }
    
    /**
     * 
     * Returns hashcode value for EmployeeNode
     * 
     * @return hashcode value for EmployeeNode
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, ID,category,title);
    }
    
    /**
     * Returns a string representation of the EmployeeNode.
     * This representation includes all of the employees data.
     *
     * @return A string representation of the employee's data.
     */
    @Override
    public String toString() {
        return this.name+"\t\t"+this.ID+"\t\t"+this.category+"\t\t"+this.title;
    }
}