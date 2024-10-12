# Student-Information-System
GUI development using Swing, event handling and basic CRUD operations in a graphical environment.

This Java project is a Student Information System with a graphical user interface (GUI) using Swing. It allows users to manage student data, including adding, updating, deleting, and viewing student details. The system consists of the following components:

## File Descriptions
### 1. Student.java
- A model class that defines the properties of a student, including:
 - id: The unique identifier for the student.
 - name: The name of the student.
 - email: The student’s email address.
- Provides getter and setter methods to access and modify student data.
- Overrides the toString() method to return a readable string format, displaying the student’s name and ID.

### 2. StudentController.java
- Handles the GUI logic and user interactions for managing students.
- Features:
 - Form Input: Fields for entering student ID, name, and email.
 - Action Buttons: Includes buttons for adding, updating, deleting, and clearing student records.
 - Student List: A JList component to display all students and enable selection.
- Uses an ArrayList to store student data and a DefaultListModel for displaying it in the GUI.
- Implements various Swing listeners for user interaction events like button clicks and list selections.

### 3. StudentInformationSystem.java

- The entry point of the application.
- Initializes the main JFrame (window) for the Student Information System.
- Invokes the StudentController class to manage the GUI.
- Runs the application using the SwingUtilities.invokeLater() method to ensure the GUI is created on the Event Dispatch Thread.

## Features
- Add New Students: Enter student details and add them to the system.
- Update Existing Students: Modify details of a selected student.
- Delete Students: Remove a student from the list.
- Clear Form Fields: Reset all input fields for new entries.
- GUI Interface: Built with Java Swing for an interactive user experience.
