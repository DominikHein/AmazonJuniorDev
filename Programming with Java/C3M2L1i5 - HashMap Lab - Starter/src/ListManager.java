
// TODO 1: Import HashMap, Map, and Set types


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ListManager {

    // TODO 2: Create a new hash map named studentsMap //
    HashMap studentMap = new HashMap();


    public ListManager(Student [] students){
        /* TODO 3:  Iterate through the studentsArray and add the
                    data to the studentsMap. Use the students'
                    last names as the keys and the student
                    objects as the values  */
        for (Student student : students){
            studentMap.put(student.lastName, student);
        }
    }


    public void listStudents( ){

        // TODO 4: Check if studentsMap is empty.
        if (studentMap.isEmpty()){
            // TODO 5: If studentsMap is empty, print an alert saying that
            System.out.println("The system has no students in the waiting list");
        }
        else {

        /* TODO 6: If the studentMap is not empty, print a list of all
                   student  */
            System.out.println("Listing all students\n");
            Set hashEntries = studentMap.entrySet();

            for (Object entry : hashEntries){
                Map.Entry mapEntry = (Map.Entry) entry;
                Student student = (Student) mapEntry.getValue();
                System.out.println(student);
            }

        }
    }

    public void findStudent(String lastName){

        /* TODO 7: Check to see if studentMap contains the
                   lastName as a key If the key is not found. Print an
                   error message and return.*/
        if (studentMap.containsKey(lastName)){
            System.out.println("Student Found\n");

        /* TODO 8: Get a reference to the Student whose key is the
                   lastName */
        Student student = (Student)studentMap.get(lastName);

        // TODO 9: If the student exists, print the Student object
            System.out.println(student);
        }else {
            // TODO 10: If the student doesn't exist. Print error message */
            System.out.println("\nStudent with name '" + lastName + "' does not exist.");
        }
    }


    public void updateStudentStatus(String lastName, String newStatus) {
        /* TODO 12: Use the get() method on studentMap to obtain a
                    reference to the Student object */
        Student student = (Student) studentMap.get(lastName);

        /* TODO 13: If the student exists, change the status to
                    newStatus, and print a confirmation message. */
        if (student != null) {

            student.status = newStatus;
            studentMap.put(lastName, student);
            System.out.println("Student (" + lastName + ") status was changed");

        } else {

            // TODO 14: Print an error message if the student doesn't exist.
            System.out.println("Student does not exist. Status was not updated");
        }
    }


    public void removeStudent(String lastName) {

        /* TODO 16: using the lastName parameter, attempt to remove
                    a student from the studentsMap */
        Student student = (Student) studentMap.remove(lastName);

        if (student != null) {
        /* TODO 17:  print a message confirmation and student
                     information if the student was successfully
                     removed. */
            System.out.println("Student removed.");
            System.out.println(student);
        } else {
        /* TODO 18: If the student is not removed, print
                    a statement that the student was not removed. */
            System.out.println("Student does not exist. Student was not removed");
        }
    }
}