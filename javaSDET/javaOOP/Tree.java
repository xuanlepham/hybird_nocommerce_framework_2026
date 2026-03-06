package javaOOP;

public abstract class Tree {
    private String flowers;
    //abstract method
    abstract  void setTreeName();
    protected  String getTree(){
        return flowers;
    }
    // non-abstract method
    void cutTree(String treename){
        this.flowers = treename;

    }
}
