package servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AndroidServlet extends HttpServlet {
    private static final long serialVersionUID = 6159285953322414434L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        //PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");
        // flag=new String(flag.getBytes("ISO-8859-1"),"gbk");
        System.out.print(flag);
        AndroidTest(request, response, flag);
    }

    private void AndroidTest(HttpServletRequest request, HttpServletResponse response, String flag) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("yes ");
        out.flush();
        out.close();
    }

}
