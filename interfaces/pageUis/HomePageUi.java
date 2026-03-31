package pageUis;

public class HomePageUi {

    // Biến none static khởi tạo đối tượng hoặc kế thừa mới gọi ra dùng được, gọi trực tiếp ra sử dụng
    // Không dùng cách none static vì toàn bộ là biến
    // public final String LOGIN_LINK = "//a[@class='ico-register']";

    //Biến static
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    // public: Gọi hàm biến ra sử dụng bình thường
    // private/ default: Khác package không dùng được
    // protected: Các class bên page OP không kế thừa PUI nên không áp dụng


    // static: cho phép gọi trực tiếp từ tên Class. đến biến HomePageUi.REGISTER_LINK
    // final: ngăn việc update lại giá trị trong quá trình chạy
    // String: Vì By locator của Selenium đều nhận vào là String
    // REGISTER_LINK: static final quy ước 1 biến là Hằng Số (hằng số là số không thay đổi)
    // Convention cho Hằng Số phải Viết hoa, có nhiều hơn 1 từ thì phải dùng giấu _ dưới để tách
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-register']";


}
