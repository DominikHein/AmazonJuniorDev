import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class StudentInfoSystem {

    private Database db = new Database();

    /*******************************************************
     *
     *  METHODS THAT NEED IMPROVEMENT
     *
     *******************************************************/

    public List<Subject> sortSubjectsByName() {
        List<Subject> subjectsByName =
                (List<Subject>) db.subjects.clone();

        /* TODO 6: Implement the bubble sort algorithm to sort the
                   Subject objects by name.*/
        boolean swapped;
        for (int i = 0; i < subjectsByName.size() - 1; i++){
            swapped = false;
            for (int j = 0; j < subjectsByName.size() - 1 - i; j++){
                Subject currentReg = (Subject) subjectsByName.get(j);
                Subject nextReg = (Subject) subjectsByName.get(j + 1);
                if (currentReg.name.compareTo(nextReg.name) > 0){
                    subjectsByName.set(j, nextReg);
                    subjectsByName.set(j + 1, currentReg);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return subjectsByName;
    }

    public List<Student> sortStudentsByName(){
        List<Student> students = (List<Student>) db.students.clone();

        /* TODO 18: Implement the insertion sort algorithm to sort the
                   Student objects by name.*/
        for (int unsorted_Indx = 1; unsorted_Indx < students.size(); unsorted_Indx++) {
            Student unsortedStudent =
                    (Student)students.get(unsorted_Indx);
            int sorted_Indx = unsorted_Indx - 1;
            while (sorted_Indx >= 0) {
                Student sortedStudent =
                        (Student)students.get(sorted_Indx);

                if (sortedStudent.getName().compareTo(unsortedStudent.getName()) > 0) {
                    students.set(sorted_Indx + 1, sortedStudent);
                    sorted_Indx--;
                } else {
                    break;
                }
            }
            students.set(sorted_Indx + 1, unsortedStudent);
        }
        return students;
    }

    public Student findStudent(Integer studentNumber) {

        List<Student> students = this.sortStudentsByNumber();

        /* TODO 28: Replace the linear search for the student with a
                   binary search. */
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparitor = students.get(mid).studentNumber.compareTo(studentNumber);
            if (comparitor == 0){
                return students.get(mid);
            }else if (comparitor < 0){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return null;
    }

    /*******************************************************
     *
     *  METHODS THAT DO NOT NEED IMPROVEMENT
     *
     *******************************************************/
    public Student findStudent(String name){
        List<Student> students = this.sortStudentsByName();
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparitor = students.get(mid).name.compareTo(name);
            if (comparitor == 0){
                return students.get(mid);
            }else if (comparitor < 0){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return null;
    }

    public List<Exam> findExams(String subjectId){
        List<Exam> sortedExams = this.sortExamsBySubjectId();
        ArrayList<Exam> foundExams = new ArrayList<>();
        for (Exam exam : sortedExams) {
            if (exam.getSubjectId().equals(subjectId)){
                foundExams.add(exam);
                if(foundExams.size() == 2){
                    break;
                }
            }
        }
        return foundExams;
    }

    public Exam findExam(int examId, List<Exam> inExams) {
        for (Exam exam : inExams) {
            if (exam.examId == examId) {
                return exam;
            }
        }
        return null;
    }

    /* Implement using linear search */
    public Subject findSubject(String subjectId){
        List<Subject> subjects = this.sortSubjectsById();
        for (Subject subject : subjects) {
            if(subject.id.equals(subjectId)){
                return subject;
            }
        }
        return null;

    }
    public List<Student> sortStudentsByNumber() {
        List<Student> studentsById =
                (List<Student>) db.students.clone();
        return studentsById;
    }

    public List<Subject> sortSubjectsById(){
        List<Subject> subjectsById =
                (List<Subject>) db.subjects.clone();
        return subjectsById;
    }
    public List<Exam> sortExamsBySubjectId(){
        List<Exam> examsToSort = (List<Exam>) db.exams.clone();
        int regCount = examsToSort.size();
        for (int unsorted_Indx = 1; unsorted_Indx < regCount; unsorted_Indx++) {
            Exam unsortedReg =
                    (Exam)examsToSort.get(unsorted_Indx);
            int sorted_Indx = unsorted_Indx - 1;
            while (sorted_Indx >= 0) {
                Exam sortedReg =
                        (Exam)examsToSort.get(sorted_Indx);
                if (sortedReg.subjectId.compareTo(unsortedReg.subjectId) > 0) {
                    examsToSort.set(sorted_Indx + 1, sortedReg);
                    sorted_Indx--;
                } else {
                    break;
                }
            }
            examsToSort.set(sorted_Indx + 1, unsortedReg);
        }
        return examsToSort;
    }
    public void addStudent(Student student) {
        db.students.add(student);
    }
    public void removeStudent(Student student) {
        db.students.remove(student);
    }
    public int newStudentNumber() {
        List<Student> students = this.sortStudentsByNumber();
        Student lastStudent = students.get(students.size() - 1);
        int lastId = lastStudent.getStudentNumber();
        return lastId++;
    }
    public static void main(String [] args){
        StudentInfoSystem studentInfoSystem = new StudentInfoSystem();

        /* TODO 8: Uncomment the SORT SUBJECTS BY NAME code block */

        System.out.println("\n\nSORT SUBJECTS BY NAME\n");
        List<Subject> subjects = studentInfoSystem.sortSubjectsByName();
        for (Subject subject : subjects) {
            System.out.println(subject);
        }


        /* TODO 20: Uncomment the SORT STUDENTS BY NAME code block. */

        System.out.println("\n\nSORT STUDENTS BY NAME\n");
        List<Student> students = studentInfoSystem.sortStudentsByName();
        for (Student student : students) {
            System.out.println(student);
        }


    }
}
