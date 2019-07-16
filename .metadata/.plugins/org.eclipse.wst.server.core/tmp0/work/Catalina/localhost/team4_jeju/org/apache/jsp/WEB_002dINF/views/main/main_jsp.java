/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.20
 * Generated at: 2019-07-16 00:17:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>Encore Tours</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 헤더에 링크 파일 기술 되어 있음. -->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./header_of_main.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- main title header -->\r\n");
      out.write("\t<header class=\"masthead bg-encore_tours_background text-white text-center\">\r\n");
      out.write("\t\t<div class=\"container d-flex align-items-center flex-column\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Masthead Avatar Image -->\r\n");
      out.write("\t\t\t<img class=\"masthead-avatar mb-5\" src=\"\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Masthead Heading -->\r\n");
      out.write("\t\t\t<h1 class=\"masthead-heading text-uppercase mb-0\">메인 문구 / 스케쥴러</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Icon Divider -->\r\n");
      out.write("\t\t\t<div class=\"divider-custom divider-light\">\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-icon\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-globe-asia\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Masthead Subheading -->\r\n");
      out.write("\t\t\t<p class=\"masthead-subheading font-weight-light mb-0\">\r\n");
      out.write("\t\t\tEnjoy Smarter Travel \"Only for You\"</p>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- //end of header -->\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Portfolio Section -->\r\n");
      out.write("\t<section class=\"page-section portfolio\" id=\"portfolio\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Portfolio Section Heading -->\r\n");
      out.write("\t\t\t<h2\tclass=\"page-section-heading text-center text-uppercase text-secondary mb-0\">\r\n");
      out.write("\t\t\t여행 카테고리</h2>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Icon Divider -->\r\n");
      out.write("\t\t\t<div class=\"divider-custom\">\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-icon\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-passport\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Test : Portfolio row Grid Items -->\r\n");
      out.write("\t\t\t<div class=\"d-flex align-items-center justify-content-center\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-auto\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-target=\"#portfolioModal1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\"\r\n");
      out.write("\t\t\t\t\t\t\t width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\t height=\"200\"\r\n");
      out.write("\t\t\t\t\t\t\t alt=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-auto\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-target=\"#portfolioModal1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fas fa-plane-departure fa-2x\">&nbsp;즐길거리</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" \r\n");
      out.write("\t\t\t\t\t\t\t width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\t height=\"200\" \r\n");
      out.write("\t\t\t\t\t\t\t alt=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Test : Portfolio row Grid Items -->\r\n");
      out.write("\t\t\t<div class=\"d-flex align-items-center justify-content-center\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-auto\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-target=\"#portfolioModal1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" \r\n");
      out.write("\t\t\t\t\t\t\t width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\t height=\"200\" \r\n");
      out.write("\t\t\t\t\t\t\t alt=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-auto\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-target=\"#portfolioModal1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fas fa-plane-departure fa-2x\">&nbsp;즐길거리</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" \r\n");
      out.write("\t\t\t\t\t\t\t width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\t height=\"200\" \r\n");
      out.write("\t\t\t\t\t\t\t alt=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Portfolio row 1 Grid Items -->\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Portfolio Item 1 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-target=\"#portfolioModal1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\theight=\"200\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Portfolio Item 2 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#portfolioModal2\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fas fa-plane-departure fa-2x\">&nbsp;즐길거리</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\theight=\"200\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Portfolio Item 3 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#portfolioModal2\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fas fa-plane-departure fa-2x\">&nbsp;즐길거리</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\theight=\"200\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Portfolio row 2 Grid Items -->\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Portfolio Item 4 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-target=\"#portfolioModal1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\theight=\"200\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Portfolio Item 5 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#portfolioModal2\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fas fa-plane-departure fa-2x\">&nbsp;즐길거리</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\theight=\"200\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Portfolio Item 6 -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"portfolio-item mx-auto\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\tdata-target=\"#portfolioModal2\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"portfolio-item-caption-content text-center text-white\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fas fa-plane-departure fa-2x\">&nbsp;즐길거리</i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/team4_jeju/resources/imgs/food_category.png\" width=\"400\"\r\n");
      out.write("\t\t\t\t\t\t\theight=\"200\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<!-- About Section -->\r\n");
      out.write("\t<section class=\"page-section bg-encore_tours_title text-white mb-0\" id=\"about\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- About Section Heading -->\r\n");
      out.write("\t\t\t<h2 class=\"page-section-heading text-center text-uppercase text-white\">\r\n");
      out.write("\t\t\tEncore Tours 소개</h2>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Icon Divider -->\r\n");
      out.write("\t\t\t<div class=\"divider-custom divider-light\">\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-icon\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-envelope-open\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- About Section Content -->\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-4 ml-auto\">\r\n");
      out.write("\t\t\t\t\t<p class=\"lead\">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-4 mr-auto\">\r\n");
      out.write("\t\t\t\t\t<p class=\"lead\">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- About Section Button -->\r\n");
      out.write("\t\t\t<div class=\"text-center mt-4\">\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-xl btn-outline-light\" href=\"\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-plane mr-2\"></i> Encore Tours 경험해보기\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Contact Section -->\r\n");
      out.write("\t<section class=\"page-section\" id=\"contact\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Contact Section Heading -->\r\n");
      out.write("\t\t\t<h2\r\n");
      out.write("\t\t\t\tclass=\"page-section-heading text-center text-uppercase text-secondary mb-0\">무엇이든\r\n");
      out.write("\t\t\t\t물어보세요</h2>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Icon Divider -->\r\n");
      out.write("\t\t\t<div class=\"divider-custom\">\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-icon\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-comments\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"divider-custom-line\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Contact Section Form -->\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-8 mx-auto\">\r\n");
      out.write("\t\t\t\t\t<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->\r\n");
      out.write("\t\t\t\t\t<form name=\"sentMessage\" id=\"contactForm\" novalidate=\"novalidate\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-group floating-label-form-group controls mb-0 pb-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Name</label> <input class=\"form-control\" id=\"name\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"text\" placeholder=\"Name\" required=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-validation-required-message=\"Please enter your name.\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"help-block text-danger\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-group floating-label-form-group controls mb-0 pb-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Email Address</label> <input class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"email\" type=\"email\" placeholder=\"Email Address\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\trequired=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-validation-required-message=\"Please enter your email address.\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"help-block text-danger\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-group floating-label-form-group controls mb-0 pb-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Phone Number</label> <input class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"phone\" type=\"tel\" placeholder=\"Phone Number\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\trequired=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-validation-required-message=\"Please enter your phone number.\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"help-block text-danger\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-group floating-label-form-group controls mb-0 pb-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Message</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea class=\"form-control\" id=\"message\" rows=\"5\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"Message\" required=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-validation-required-message=\"Please enter a message.\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"help-block text-danger\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"success\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-encore_tours btn-lg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"sendMessageButton\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonclick=\"location.href=''\">Send</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./footer_of_main.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
