package servlet;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class AddLinkDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
    
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        Date date = Calendar.getInstance().getTime();
        TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        sdf.setTimeZone(tz);
        String str = sdf.format(date);
        //String str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
        //System.out.println(str);
        //LinkData data = new LinkData(title,comment,date);
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //String str = sdf.format(date);
        String user = req.getUserPrincipal().getName();
        LinkData data = new LinkData(title,url,comment,str,user);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        resp.sendRedirect("/kutikomi.html");
    }
}