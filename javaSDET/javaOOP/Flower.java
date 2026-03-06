package javaOOP;

public class Flower extends Tree{

    @Override
    void setTreeName() {

    }

    public static void main(String[] args) {
        // Tree tree = new Tree(); không cho phép
        Flower flower = new Flower();

        flower.cutTree("hong");

        System.out.println(flower.getTree());
    }

}
