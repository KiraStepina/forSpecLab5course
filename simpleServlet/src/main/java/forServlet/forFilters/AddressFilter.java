package forServlet.forFilters;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 30.9.12
 * Time: 12.38
 * To change this template use File | Settings | File Templates.
 */
public class AddressFilter implements Filter{
    @Override
    public boolean check(HttpServletRequest request) {
        String str = request.getParameter("address");
        return str == null || !str.contains("$");
    }
}
