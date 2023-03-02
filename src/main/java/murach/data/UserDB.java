package murach.data;

import murach.business.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDB {
    public static void insert(User user, String path) throws IOException {
        String filePath = "/WEB-INF/EmailList.txt";

        // Mở tệp để ghi
        PrintWriter out = new PrintWriter(new FileWriter(filePath, true));

        // Ghi thông tin người dùng vào tệp
        out.println(user.getFirstName() + "," + user.getLastName() + "," + user.getEmail());

        // Đóng tệp
        out.close();
    }
}
