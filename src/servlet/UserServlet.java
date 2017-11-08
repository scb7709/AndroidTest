package servlet;

import enity.ReportTest;
import impl.ReportTestImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class UserServlet extends HttpServlet {
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
        ReportTest(request, response, flag);
    }

    private void ReportTest(HttpServletRequest request, HttpServletResponse response, String flag) throws IOException {
        ReportTestImpl reportTest = new ReportTestImpl();
        List<ReportTest> reportTestReportTestList = reportTest.getReportTestList(flag);
        if (reportTestReportTestList != null && reportTestReportTestList.size() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("flag", flag);
            session.setAttribute("reportTestReportTestList", reportTestReportTestList);
            response.sendRedirect("reportTestReportTestList.jsp");
        }


    }



}
