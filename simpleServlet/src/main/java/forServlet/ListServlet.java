package forServlet;

import bussiness.Client;
import bussiness.valueListHandler.ValueListHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 29.9.12
 * Time: 14.10
 * To change this template use File | Settings | File Templates.
 */
public class ListServlet extends HttpServlet {
    private static final int PAGE_SIZE = 2;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }
    public String clientListToString(List<Client> listOfClient){
        String result="<list>";
        for (int i=0; i<listOfClient.size(); i++){
            result+=listOfClient.get(i).toString();
        }
        result+="</list>";
        return result;
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = tFactory.newTransformer(new StreamSource(getServletContext().getResourceAsStream("WEB-INF/base.xsl")));
            HttpSession session = request.getSession();
            ValueListHandler listHandler = (ValueListHandler) session.getAttribute("listHandler");
            if (listHandler == null){
                session.setAttribute("listHandler",new ValueListHandler());
                listHandler = (ValueListHandler) session.getAttribute("listHandler");
            }
            String direction = request.getParameter("direction");
            String list = "";
            if (direction == null || direction.equalsIgnoreCase("first")){
                list = clientListToString(listHandler.getFirstElement(PAGE_SIZE));
            }else if (direction.equalsIgnoreCase("prev")){
                list = clientListToString(listHandler.getPreviousElements(PAGE_SIZE));
            }else if (direction.equalsIgnoreCase("next")) {
                list = clientListToString(listHandler.getNextElements(PAGE_SIZE));
            } else if (direction.equalsIgnoreCase("last")){
                list = clientListToString(listHandler.getLastElement(PAGE_SIZE));
            }
            StringReader reader = new StringReader(list);
            transformer.transform(new StreamSource(reader), new StreamResult(response.getOutputStream()));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("************* The result is in output.out *************");
    }
}
