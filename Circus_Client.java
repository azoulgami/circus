import java.io.File;

public class Circus_Client {
    public static void main() throws java.io.FileNotFoundException {
        //Creates new circus
        Circus circus=new Circus();
        
        
        //hires a ton of employees by reading it from a file
        
        circus.hire(new File("CircusEmployees.txt"));
        System.out.println();
        
        System.out.println("Current Circus Employees:");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        System.out.println(circus);
        
        
        System.out.println();
        System.out.println();
        
        
        //#1: Print list alphabetically     O(n log n) effeciency
        System.out.println("Current Circus Employees printed alphabetically:");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        
        //prints employees alphabetically
        circus.printAlphabetically();
        
        
        System.out.println();
        System.out.println();
        
        
        //#2: Print list by ID num     O(n log n) effeciency
        System.out.println("Current Circus Employees printed by ID num  :");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        
        //prints employees alphabetically
        circus.printByIdNum();
        
        
        System.out.println();
        System.out.println();
        
        
        //#3: Insert new employee     O(1) effeciency
        System.out.println("Creates new Employee named Bob  :");
        //Creates new employee
        EmployeeNode Bob=new EmployeeNode("Bobbby Bob B","123-456-789","Clown","Newbie");
        System.out.println(Bob);
        
        //hires first employee
        circus.hire(Bob);
        
        System.out.println();
        System.out.println("Current Circus Employees with new employee named Bob :");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        System.out.println(circus);
        
        
        System.out.println();
        System.out.println();
        
        
        //#4: Remove employee     O(1) effeciency
       
        //fires employee Bob who was just hired :(
        circus.fire(Bob);
        
        System.out.println("Current Circus Employees with Bob fired :");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        System.out.println(circus);
        
        
        System.out.println();
        System.out.println();
                
        
        //#5: Print only a particular category list 
        //#   of employees alphabetically     
        //#   O(n log n) effeciency
        System.out.println("Current Circus Clown Employees printed alphabetically:");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        //prints employees alphabetically
        circus.printCategoryAlphabetically("Clown");
        
        
        System.out.println();
        System.out.println();
        
        
        //#6: Print all employees by category alphabeticaly
        //#   O(n log n) effeciency
        System.out.println("Current Circus  Employees printed by category alphabetically:");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        //prints employees alphabetically
        circus.printAllEmployeesByCategoryAlphabetically();
        
        
        System.out.println();
        System.out.println();
        
        
        //#7: Add a category
        //#   O(1) effeciency
        //Add category
        circus.addCategory("Intern");
        System.out.println("Current Circus  categoires:");
        System.out.println("_____________________________________________________________________________________________________");
        
        circus.printCategories();   
        
        System.out.println();
        System.out.println();
        
        
        //#7: Remove a category and all corresponding employees
        //#   O(1) effeciency
        
        //Create a bunch of employees who are interns
        EmployeeNode Sam=new EmployeeNode("Sam Sammy S","123-456-789","Intern","Newbie");
        EmployeeNode Tom=new EmployeeNode("Tom Tommy T","123-827-789","Intern","Newbie");
        EmployeeNode Ralph=new EmployeeNode("Ralph Ralphy R","123-928-789","Intern","Newbie");

        //hire them
        circus.hire(Sam);
        circus.hire(Tom);
        circus.hire(Ralph);
        
        System.out.println("Current Circus Employees after hiring:");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        
        System.out.println(circus);
        
        System.out.println();
        System.out.println();
        
        System.out.println("Current Circus  categoires before remomving intern:");
        System.out.println("_____________________________________________________________________________________________________");
        circus.printCategories();
        
        System.out.println();
        System.out.println();

        
         //removes category and all interns :(
        circus.removeCategory("Intern");
        
        System.out.println("Current Circus  categoires after remomving intern:");
        System.out.println("_____________________________________________________________________________________________________");
        circus.printCategories();
        
        System.out.println();
        System.out.println();

        
        System.out.println("Current Circus Employees after removing category and all correspoinding employees:");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
        System.out.println(circus);
        
        
        //#9: Quit
        //#   O(1) effeciency
        //circus.quit(); uncomment to use
    }
}