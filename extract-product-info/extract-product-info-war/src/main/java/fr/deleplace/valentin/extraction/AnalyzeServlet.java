package fr.deleplace.valentin.extraction;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
