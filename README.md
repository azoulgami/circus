
# A Circus Simulation in Java

## Project Overview

This project implements a circus management system in Java, utilizing object-oriented programming (OOP) principles
 and complex data structures and algorithms. It allows for efficient manipulation of employee data within a circus, 
 providing functionalities such as adding, removing, and categorizing employees.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Classes and Structure](#classes-and-structure)
- [How to Run the Project](#how-to-run-the-project)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Employee Management**: Hire and fire employees with ease.
- **Category Organization**: Employees can be categorized based on their roles within the circus.
- **Data Retrieval**: Retrieve employee information by ID, category, or name.
- **Sorting**: Print employee lists sorted alphabetically or by ID.
- **File I/O**: Import employee data from a formatted file.
- **User-friendly Interface**: Command-line interactions for easy management.

## Technologies Used

- Java (JDK 11 or higher)
- BlueJ

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/circus-simulation.git
   ```

2. Navigate to the project directory:

   ```bash
   cd circus-simulation
   ```

3. Open the project in your preferred Java IDE.

4. Ensure that you have JDK 11 or higher installed on your system.

## Usage

1. **Run the Circus_Client Class**: Start the application by running the `Circus_Client` class.
2. **Interact via Command Line**: Follow the prompts to manage circus operations, such as hiring, firing, and viewing employee lists.

## Classes and Structure

### Circus Class

- **Responsibility**: Manages the overall circus operations and holds categories of employees.
- **Key Methods**:
  - `hire(EmployeeNode employee)`: Adds a new employee.
  - `fire(EmployeeNode employee)`: Removes an employee.
  - `printAlphabetically()`: Displays employees in alphabetical order.

### CategoryNode Class

- **Responsibility**: Represents a category containing a collection of employees.
- **Key Methods**:
  - `addEmployee(EmployeeNode employee)`: Adds an employee to the category.
  - `removeEmployee(EmployeeNode employee)`: Removes an employee from the category.
  - `getAllEmployees()`: Retrieves a list of all employees in the category.

### EmployeeNode Class

- **Responsibility**: Represents an individual employee.
- **Key Attributes**:
  - `name`: The name of the employee.
  - `ID`: The unique identifier for the employee.
  - `category`: The category to which the employee belongs.
  - `title`: The title or role of the employee.

## How to Run the Project

1. After setting up the project, run the main method in the `Circus` class.
2. Follow the command line prompts to manage employees and categories.

## Contributing

Contributions are welcome! If you'd like to contribute, please fork the repository and create a pull request.

1. Fork the repo.
2. Create your feature branch:
   ```bash
   git checkout -b feature/YourFeature
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add some feature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/YourFeature
   ```
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

