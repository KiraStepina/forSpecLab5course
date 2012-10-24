package presentation.forFilters;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 30.9.12
 * Time: 12.22
 * To change this template use File | Settings | File Templates.
 */
public interface Filter {
    public boolean check(HttpServletRequest request);
}
