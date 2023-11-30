public class Group {
    public int number;
    public String name;
    public Child[] children = {};

    public void addChild(Child c) {
        for(int i = 0; i < this.children.length; i++) {
            if (this.children[i]==null) {
                this.children[i] = c;
            }
            if (i == this.children.length-1) {
                this.children[i+1] = c;
            }
        }

    }
}