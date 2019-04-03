package com.github.fworks.propertiesgwt.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gwt.thirdparty.json.JSONObject;

public class PropertiesServlet extends HttpServlet {

  public static final String PROPERTIES_FILES_PARAM = "PROPERTIES_FILES";
  protected String initParameter;

  private static final Map<String, String> propertiesMap = new HashMap<>();

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    initParameter = config.getInitParameter(PROPERTIES_FILES_PARAM);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String[] files = initParameter.split(",");
    for (String fileName : files) {
      loadFile(fileName);
    }
    System.out.println(propertiesMap);
    resp.getWriter().write(new JSONObject(propertiesMap) + "");

  }

  public void loadFile(String fileName) throws IOException {
    ServletContext context = getServletContext();
    InputStream is = context.getResourceAsStream("/WEB-INF/classes/" + initParameter);
    Scanner input = new Scanner(is);
    while (input.hasNextLine()) {
      String line = input.nextLine();
      if (line.contains("=")) {
        String[] split2 = line.split("=");
        propertiesMap.put(split2[0].trim(), split2[1].trim());
      }
    }
    input.close();
    is.close();
  }
}
