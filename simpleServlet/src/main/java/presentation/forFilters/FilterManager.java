package presentation.forFilters;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 30.9.12
 * Time: 12.57
 * To change this template use File | Settings | File Templates.
 */
public class FilterManager {
    private static final List<Filter> listOfFilter = Arrays.asList(new NameFilter(), new AddressFilter(), new TelephoneFilter());

    public boolean callFilters(HttpServletRequest request) {
        for (Filter aListOfFilter : listOfFilter) {
            if (!aListOfFilter.check(request))
                return false;
        }
        return true;
    }
}
