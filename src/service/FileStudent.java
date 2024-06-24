package service;

import fact.Student;

import java.io.*;
import java.util.ArrayList;

public class FileStudent {
    public static void SaveFile(ArrayList<Student> students) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:/WorkSpace/Code/Intellij/JavaL0/managerstudent.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        for(Student student : students){
            bw.write(student.toString());
            bw.newLine();
        }
        bw.close();
        osw.close();
        fos.close();
    }
}
