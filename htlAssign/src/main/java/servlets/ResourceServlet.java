package servlets;

import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=GET",
                "sling.servlet.resourceTypes=services/node",
                "sling.servlet.selectors=data",
                "sling.servlet.extensions=" + "json"
        })

public class ResourceServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;



    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String resourcePath = "/content/my-options";
// req is the SlingHttpServletRequest
        ResourceResolver resourceResolver = req.getResourceResolver();
        Resource res = resourceResolver.getResource(resourcePath);
        Iterable<Resource> resourceIterator =resourceResolver.getChildren(res);
        List<ValueMap> resList = new ArrayList<ValueMap>();
        for (Resource resourceObj : resourceIterator) {
            ValueMap resMap = resourceObj.getValueMap();
            resList.add(resMap);
        }
        Gson gson= new Gson();
        String json = gson.toJson(resList);
        resp.getWriter().write(json);
    }
}