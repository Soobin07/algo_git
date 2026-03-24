package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q1713 {

    static class Student {
        int id;
        int count;
        int time;

        Student(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Student> frame = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean found = false;

            for (Student s : frame) {
                if (s.id == num) {
                    s.count++;
                    found = true;
                    break;
                }
            }

            if (found) continue;

            if (frame.size() < N) {
                frame.add(new Student(num, 1, i));
            } else {
                Student remove = frame.get(0);

                for (Student s : frame) {
                    if (s.count < remove.count) {
                        remove = s;
                    } else if (s.count == remove.count) {
                        if (s.time < remove.time) {
                            remove = s;
                        }
                    }
                }

                frame.remove(remove);
                frame.add(new Student(num, 1, i));
            }
        }

        Collections.sort(frame, (a, b) -> a.id - b.id);

        StringBuilder sb = new StringBuilder();
        for (Student s : frame) {
            sb.append(s.id).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
