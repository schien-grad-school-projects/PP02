

public class ValidationTest {

    public static void main(String[] args){
        testValidCardNumber();
        testInvalidCardNumber();
    }
    public static void testValidCardNumber() {
        Validation validation = new Validation();
        if(!validation.aValidNumber("4539127624598697")){
            System.out.println("testValidCardNumber: Failed");
        }
    }

    public static void testInvalidCardNumber() {
        Validation validation = new Validation();
        if(validation.aValidNumber("4539127624598698")){
            System.out.println("testInvalidCardNumber: Failed");
        }
    }
}