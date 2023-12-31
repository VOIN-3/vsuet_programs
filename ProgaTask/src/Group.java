import java.util.ArrayList;

public class Group {
    private int number;
    private String name;
    private ArrayList<Child> children = new ArrayList<>();

    public int getNumber() {
        return this.number;
    }
    public String getName() {
        return this.name;
    }
    public ArrayList<Child> getChildren() {
        return this.children;
    }
    public void setNumber(int n) {
        this.number = n;
    }
    public void setName(String n) {
        this.name = n;
    }
    public void addChild(Child c) {
        this.children.add(c);
    }
    public void printGroup() {
        ArrayList<Child> c = this.getChildren();
        System.out.println("Группа №"+this.getNumber()+" '"+this.getName()+"':");
        for(Child child : c) {
            child.printChild();
        }
    }
    public ArrayList<String> export() {
        ArrayList<String> f = new ArrayList<String>();
        f.add(Integer.toString(this.getNumber()));
        f.add(this.getName());
        for(int i=0; i<this.getChildren().size(); i++) {
            f.add(this.getChildren().get(i).getName()+" "+this.getChildren().get(i).getGender()+" "+this.getChildren().get(i).getAge());
        }
        return f;
    }
}