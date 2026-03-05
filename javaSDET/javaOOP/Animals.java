package javaOOP;

public class Animals {
    private   String animalName ;
    // private chỉ dùng trong class

    protected String animalAge = "5";

    protected String getAnimalName(){ // Hàm lấy ra giá trị private animalName
        return  animalName;
    }
    protected void setAnimalName(String annimalName){ // hàm gán giá trị private animalName
        this.animalName =annimalName;
    }
}
