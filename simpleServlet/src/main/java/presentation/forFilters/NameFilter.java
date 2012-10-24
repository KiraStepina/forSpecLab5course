package presentation.forFilters;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 30.9.12
 * Time: 12.27
 * To change this template use File | Settings | File Templates.
 */
public class NameFilter implements Filter {
    @Override
    public boolean check(HttpServletRequest request) {
        String str = request.getParameter("name");
        return (str == null || (!str.matches(".*\\d.*")));
    }
}
