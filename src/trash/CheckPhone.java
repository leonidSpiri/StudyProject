package trash;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {
    public static Boolean checkPhone(String phone) {
        if (null == phone || "".equalsIgnoreCase(phone)) {
            return false;
        } else {
            String regex = "(\\+7|8)[\\s(]*\\d{3}[)\\s]*\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    public static void main(String[] args) {
        String phone;
        StringBuilder newPhone = new StringBuilder();
        Scanner in = new Scanner(System.in);
        phone = in.nextLine();
        Boolean isRight = checkPhone(phone);
        if (isRight) {
            phone = phone.replace("+7", "8");
            phone = phone.replaceAll("-", "");
            phone = phone.replaceAll(" ", "");
            phone = phone.replace("(", "");
            phone = phone.replace(")", "");
            newPhone.append(phone.charAt(0));
            newPhone.append(" (");
            for (int i = 0; i < 3; i++)
                newPhone.append(phone.charAt(i + 1));
            newPhone.append(") ");

            for (int i = 0; i < 3; i++)
                newPhone.append(phone.charAt(i + 4));
            newPhone.append("-");

            for (int i = 0; i < 2; i++)
                newPhone.append(phone.charAt(i + 7));
            newPhone.append("-");
            for (int i = 0; i < 2; i++)
                newPhone.append(phone.charAt(i + 9));
            System.out.println(newPhone);
        } else
            System.out.println("error");
    }
}
