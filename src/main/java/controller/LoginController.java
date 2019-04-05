package controller;


import entity.User;
import service.UserService;
import java.io.IOException;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 * Servlet implementation class controller.LoginController
 */
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un=request.getParameter("username");
        String pw=request.getParameter("password"); //admin


        if(checkDb(un, GetPassword(pw)))
        {
            response.sendRedirect("success.html");
            return;
        }
        else
        {
            response.sendRedirect("error.html");
            return;
        }

    }

    private static String GetPassword(String password) {
        //String hash = "21232F297A57A5A743894A0E4A801FC3";
        String myHash="";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            myHash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
        }
        catch (Exception er){}

        return myHash;

    }

    private static Boolean checkDb(String un, String pw){

        UserService userService = new UserService();
        User auser = userService.getByNameByPass(un, pw);

        if (auser != null)
        {
            if (auser.getUserName().equals(un))
            {
                return true;
            }
        }

        return false;
    }
}