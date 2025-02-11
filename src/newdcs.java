import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;

public class PhoneNumberInfo {
    public static void main(String[] args) {
        String phoneNumber = "+919876543210";  // Replace with your phone number
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber number = phoneUtil.parse(phoneNumber, "IN");
            boolean isValid = phoneUtil.isValidNumber(number);
            System.out.println("Valid Number: " + isValid);

            if (isValid) {
                System.out.println("Region: " + phoneUtil.getRegionCodeForNumber(number));
                System.out.println("Number Type: " + phoneUtil.getNumberType(number));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
