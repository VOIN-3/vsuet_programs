public class Child {
    private String name;
    private char gender;
    private int age;

    public String getName() {
        return this.name;
    }
    public char getGender() {
        return this.gender;
    }
    public int getAge() {
        return this.age;
    }
    public void setName(String n) {
        this.name = n;
    }
    public void setGender(String g) {
        this.gender = g.toCharArray()[0];
    }
    public void setAge(int a) {
        this.age = a;
    }
    public void printChild() {
        System.out.println(this.getName()+" "+this.getGender()+" "+this.getAge());
    }
}
