import java.util.*;
import java.io.*;

/**
     * 
     * Represents a circus that contains a collection of 
     * employees repersented by the EmployeeNode class and 
     * actions to be done repersented by the methods.
     * 
     * @author Ali Zoulgami.
     * 
     */
public class Circus {
    private Map<String,CategoryNode> cmap;
    
    /**
     * 
     * Constructs a Circus where all the employees are
     * stored internally in a HashMap who's keys are String
     * repersentations of the employees categories
     * and values are CategoryNodes(see CategoryNode class).
     *
     * @param category The name of the category.
     */
    public Circus () {
        this.cmap=new HashMap();
    }
    
    
    /**
     * 
     * Represents a category that contains a collection of 
     * all employees of that category.
     * 
     * @author Ali Zoulgami.
     * 
     */
    private class CategoryNode {
        private String category;
        private Map<String,EmployeeNode> emap;
        
        /**
         * Constructs a CategoryNode with the specified 
         * category name and a map who's keys are the 
         * employees'ID and values are the EmployeeNodes
         * within that category.
         *
         * @param category The name of the category.
         */
        public CategoryNode(String category) {
            this.category=category;
            this.emap=new HashMap<>();
        }
        
        /**
         * 
         * Retrieves the name of the category.
         *
         * @return The name of the category.
         */
        public String getCategory() {
            return this.category;
        }
        
        /**
         * 
         * Retrieves the EmployeeNode passed in.
         *
         * @param employee trying to retrieve.
         * 
         * @return EmployeeNode that was passed in, 
         * or {@code null} if EmployeeNode does not exist.
         * 
         */
        public EmployeeNode getEmployee(EmployeeNode employee) {
            return this.emap.get(employee.getID());
        }
        
        /**
         * 
         * Generates List of all employees that are of
         * the category.
         * 
         * @return List of employees that are of the
         * category.
         * 
         */
        public ArrayList<EmployeeNode> getAllEmployees() {
            ArrayList list=new ArrayList(emap.values());
            return list;
        }
        
        /**
         * Adds an employee to the category.
         *
         * @param employee The EmployeeNode to be added
         * to the category.
         * 
         */
        public void addEmployee(EmployeeNode employee) {
            this.emap.put(employee.getID(),employee);
        }
        
        /**
         * Removes an employee from the category.
         *
         * @param employee The EmployeeNode to be removed
         * from the category.
         * 
         */
        public void removeEmployee(EmployeeNode employee) {
            this.emap.remove(employee.getID());
        }
        
        /**
         * 
         * Returns wether or not employee exists within
         * the category.
         * 
         * @param employee to be searched for.
         * 
         */
        public boolean contains (EmployeeNode employee) {
            return this.emap.containsKey(employee.getID());
        }
        
        /**
         * 
         * Returns hashcode value for CategoryNode.
         * 
         * @return hashcode value for CategoryNode.
         * 
         */
        @Override
        public int hashCode() {
            return Objects.hash(category);
        }
        
         /**
         * Returns a string representation of the 
         * CategoryNode.
         * This representation includes the name of 
         * the category.
         *
         * @return A string representation of the 
         * category's name.
         * 
         */
        @Override
        public String toString() {
            return getCategory();
        }
    }
    
    
    /**
     * 
     * Retrieves the EmployeeNode passed in.
     * 
     * @param employee the employee to be retrieved.
     * 
     * @return EmployeeNode if employee exists 
     * and {code @null} if value doesn't exist.
     * 
     */
    public EmployeeNode getEmployee(EmployeeNode employee) {
        return this.cmap.get(employee.getCategory()).getEmployee(employee);
    }
    
    /**
     * 
     * Retrieves the Employee that correlates to the ID
     * passed in.
     * 
     * @param ID the ID of the employee to be retrieved.
     * 
     * @return EmployeeNode if employee exists and 
     * {code @null} if value doesn't exist.
     * 
     */
    public EmployeeNode getEmployee(String ID) {
        ArrayList<EmployeeNode> list=generateList();
        for(EmployeeNode employee:list) {
            if(employee.getID().equals(ID)) {
                return employee;
            }
        }
        return null;
    }
    
    /**
     * 
     * Returns total number of employees.
     * 
     * @return total number of employees.
     * 
     */
    public int total() {
        int total=0;
        for(CategoryNode c:this.cmap.values()) {
            total+=c.emap.size();
        }
        return total;
    }
    
    /**
    * Adds a new category.
    *
    * @param category The category to be added.
    * 
    */
    public void addCategory(String category) {
        this.cmap.put(category,new CategoryNode(category));
    }
    
    /**
    * Adds new employee.
    *
    *@param Employee Informtation.
    * 
    */
    public void hire(String name,String ID, String category, String title) {
        hire(new EmployeeNode(name,ID,category,title));
    }
    
    /**
    * Adds new EmployeeNode.
    *
    * @param employee to be added.
    * 
    */
    public void hire(EmployeeNode employee) {        
        if(!this.cmap.containsKey(employee.getCategory())) {
            this.cmap.put(employee.getCategory(),new CategoryNode(employee.getCategory()));
        }
        this.cmap.get(employee.getCategory()).addEmployee(employee);
    }
    
    /**
    * Adds all employees from array.
    *
    * @param data array containing EmployeeNode.
    * 
    */
    public void hire(EmployeeNode[] data) {
        for(EmployeeNode employee:data) {
            hire(employee);
        }
    }
    
    /**
    * Adds all employees from list.
    *
    * @param data list containing EmployeeNode.
    * 
    */
    public void hire(List<EmployeeNode> data) {
        for(EmployeeNode employee:data) {
            hire(employee);
        }
    }
    
    /**
    * Adds all employees from set.
    *
    * @param data set containing EmployeeNode.
    * 
    */
    public void hire(Set<EmployeeNode> data) {
        for(EmployeeNode employee:data) {
            hire(employee);
        }
    }
    
    /**
    *Adds all employees from file.
    *Must be formatted correctly:
        *(Full Name(Last,First,Middle),ID,Category,Title)).
    *
    *
    * @param f File containing employee information 
    * to be read.
    * 
    */
    public void hire(File f) throws FileNotFoundException {
        Scanner input=new Scanner(f);
        while(input.hasNextLine()) {
            String text=input.nextLine();
            if(!text.isEmpty()) {
                Scanner data=new Scanner(text);
                hire(data.next()+" "+data.next()+" "+data.next(),data.next(),data.next(),data.next());
            }
        }
    }
    
    /**
    * Removes EmployeeNode.
    *
    * @param employee EmployeeNode to be removed.
    * 
    */
    public void fire(EmployeeNode employee) {
        this.cmap.get(employee.getCategory()).removeEmployee(employee);
    }
    
    /**
    * Removes EmployeeNode by ID.
    *
    * @param ID of employee to be removed.
    * 
    */
    public void fire(String ID) {
        EmployeeNode employee=getEmployee(ID);
        this.cmap.get(employee.getCategory()).removeEmployee(employee);
    }
    
    /**
    * Removes Category and all corresponding employees.
    *
    * @param category The category to be removed.
    * 
    */
    public void removeCategory(String category) {
        this.cmap.remove(category);
    }
    
    /**
     * 
     * Returns wether or not employee works for the Circus.
     * 
     * @param employee to be searched for.
     * 
     * @return true if employee works for the circus, 
     * false if not.
     * 
     */
    public boolean contains(EmployeeNode employee) {
        return this.cmap.get(employee.getCategory()).contains(employee);
    }
    
     /**
     * 
     * Returns wether or not employee works for the Circus 
     * by employee ID.
     * 
     * @param ID of employee to be searched for.
     * 
     * @return true if employee works for the circus,
     * false if not.
     * 
     */
    public boolean contains(String ID) {
        ArrayList<EmployeeNode> list=generateList();
        EmployeeNode employee;
        for(EmployeeNode e:list) {
            if(e.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * Prints all current employees in 
     * alphabetical order(a-z).
     * 
     * @see alphabeticalComparator.
     *   
     */
    public void printAlphabetically() {
        ArrayList<EmployeeNode> list=generateList();
        Collections.sort(list,new alphabeticalComparator());  
        printEmployeeList(list);
    }
    
    /**
     * 
     * Prints current employees of category in 
     * alphabetical order(a-z).
     * 
     * @param categoy to print alphabetically.
     * 
     * @see alphabeticalComparator.
     *   
     */
    public void printCategoryAlphabetically(String category) {
        LinkedList<EmployeeNode> list=new LinkedList(this.cmap.get(category).emap.values());
        Collections.sort(list,new alphabeticalComparator());  
        printEmployeeList(list);
    }
    
    /**
     * 
     * Prints all employees by category alphabetically.
     * 
     * @see alphabeticalComparator.
     * 
     */
    public void printAllEmployeesByCategoryAlphabetically() {
        ArrayList<String> list=new ArrayList(this.cmap.keySet());
        Collections.sort(list);
        for(String s:list) {
            System.out.println(s+"  :");
            System.out.println("-----------------------------------------------------------------------");
            printCategoryAlphabetically(s);
            System.out.println();
        }
    }
    
    /**
     * 
     * Prints all current employees sorted by ID.
     * 
     * @see IDComparator.
     *   
     */
    public void printByIdNum() {
        ArrayList<EmployeeNode> list=generateList();
        Collections.sort(list,new IDComparator());  
        printEmployeeList(list);
    }
    
    /**
     * 
     * Prints current employees of category by ID.
     * 
     * @param categoy to print by ID.
     * 
     * @see IDComparator.
     *   
     */
    public void printCategoryByIdNum(String category) {
        LinkedList<EmployeeNode> list=new LinkedList(this.cmap.get(category).emap.values());
        Collections.sort(list,new IDComparator());  
        printEmployeeList(list);
    }
    
    /**
     * 
     * Prints all employees by category by ID.
     * 
     * @see IDComparator.
     * 
     */
    public void printAllEmployeesByCategoryByIdNum() {
        ArrayList<String> list=new ArrayList(this.cmap.keySet());
        Collections.sort(list);
        for(String s:list) {
            System.out.println(s+"  :");
            System.out.println("-----------------------------------------------------------------------");
            printCategoryByIdNum(s);
            System.out.println();
        }
    }
    
    /**
     * 
     * Prints all Circus categories.
     * 
     */
    public void printCategories() {
        for(String s:this.cmap.keySet())  {
            System.out.println(s);
        }
    }
    
    /**
     * 
     * Terminates the porgram
     * 
     */
    public void quit() {
        System.exit(0);
    }
    /**
     * 
     * Returns string repersentation of all employees.
     * 
     * @return string repersentation of all employees.
     * 
     */
    @Override
    public String toString() {
        ArrayList<EmployeeNode> list=generateList();
        String s="";
        for(EmployeeNode employee:list) {
            s+=employee.toString()+"\n";
        }
        return s;
    }
    
    
    /**
     * 
     * Generates list of all employees.
     * 
     * @return list of all employees.
     * 
     */
    private ArrayList<EmployeeNode> generateList() {
        ArrayList<EmployeeNode> list=new ArrayList();
        for(CategoryNode c:cmap.values()) {
            list.addAll(c.getAllEmployees());
        }
        return list;
    }
    
    /**
     * 
     * prints list of employees.
     * 
     * @param list of employees.
     * 
     */
    private void printEmployeeList(Collection<EmployeeNode> list) {
        for(EmployeeNode employee: list) {
            System.out.println(employee);
        }
    }
   
}