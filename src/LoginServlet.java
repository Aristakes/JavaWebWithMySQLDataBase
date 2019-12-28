import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if(DbConnect.validate(userName , password)){
            RequestDispatcher rd = req.getRequestDispatcher("/welcomeServlet");
            rd.include(req , resp);
        }else{
            out.print("Error UserName or Password not correct");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req , resp);
        }
    }
}
