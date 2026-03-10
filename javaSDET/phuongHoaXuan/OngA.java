package phuongHoaXuan;

public class OngA {
    // Hàm biến có access modifier là Private thì chỉ được phép sử dụng trong chính Class chứa nó
    // Variable/ Properties
    private String espresso; // biến toàn cục

    public void setEspresso(String espresso) { // biến trong ngoặc là biến local sử dụng biến local set giá trị cho biến toàn cục
        this.espresso = espresso;
    }

    //Method/ Function
    public String getEspresso() {
        return espresso;
    }

    public static void main(String[] args) {
        OngA onga = new OngA();
        onga.espresso="Espresso";
        System.out.println(onga.getEspresso());
    }
}
