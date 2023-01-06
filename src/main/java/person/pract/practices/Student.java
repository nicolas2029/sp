package person.pract.practices;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    @Override
    public int compareTo(Student o) {
        if (this.cgpa == o.getCgpa()) {
            if (this.name.equals(o.getName())) {
                return this.id - o.id;
            }
            return this.name.compareTo(o.getName());

        }
        return this.cgpa < o.cgpa ? 1 : -1;
    }
}
