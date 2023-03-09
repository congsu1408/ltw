/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

import murach.business.User;

import java.io.*;
import java.util.Scanner;

public class UserDB {

    public void insert(User user, String path) {
        try {
            File file = new File(path);
            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file, true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName() + "|" + user.getListLikeMusic() + "\n");
            //Closing BufferedWriter Stream
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean emailExisted(String emailNeedtCheck, String path) {
        try {
            Scanner in = new Scanner(new File(path));
            while (in.hasNextLine()) {
                String[] email = in.nextLine().split("\\|");
                if (emailNeedtCheck.equals(email[0])) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}

// email|firstName|lastname|kdjk