package presentation.forFilters;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HomeUser
 *         Date: 30.9.12
 *         Time: 12.38
 */
public class AddressFilter implements Filter {
    @Override
    public boolean check(HttpServletRequest request) {
        String str = request.getParameter("address");
        return str == null || !str.contains("$");
    }
}
