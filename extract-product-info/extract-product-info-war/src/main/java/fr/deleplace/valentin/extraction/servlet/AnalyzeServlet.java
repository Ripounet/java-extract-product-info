package fr.deleplace.valentin.extraction.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.deleplace.valentin.extraction.Process;
import fr.deleplace.valentin.extraction.ProductFields;

public class AnalyzeServlet extends HttpServlet {
	
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String targetURL = req.getParameter("targetURL");
    Process process = new Process();
    ProductFields results = process.fetchAndExtract(targetURL);

    PrintWriter out = resp.getWriter();
    out.print("<pre>");
	out.print(results.flatFormat());
	out.print("</pre>");
  }
  
}
