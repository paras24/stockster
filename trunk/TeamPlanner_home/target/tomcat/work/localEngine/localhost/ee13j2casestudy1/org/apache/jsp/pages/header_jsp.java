package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
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
      out.write("<div id=\"header\">\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<div id=\"welcomeLine\" class=\"row\">\r\n");
      out.write("\t<div class=\"span6\">Welcome!<strong> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</strong></div>\r\n");
      out.write("\t<div class=\"span6\">\r\n");
      out.write("\t<div class=\"pull-right\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Navbar ================================================== -->\r\n");
      out.write("<div id=\"logoArea\" class=\"navbar\">\r\n");
      out.write("<a id=\"smallScreen\" data-target=\"#topMenu\" data-toggle=\"collapse\" class=\"btn btn-navbar\">\r\n");
      out.write("\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t<span class=\"icon-bar\"></span>\r\n");
      out.write("</a>\r\n");
      out.write("  <div class=\"navbar-inner\">\r\n");
      out.write("   <!-- <a class=\"brand\" href=\"index.html\"><img src=\"assets/img/logo_impetus.png\" alt=\"Impetus\"/></a>-->\r\n");
      out.write("\t\t\r\n");
      out.write("    <ul id=\"topMenu\" class=\"nav pull-right\">\r\n");
      out.write("\t <li class=\"\"><a href=\"special_offer.html\">Team View</a></li>\r\n");
      out.write("\t <li class=\"\"><a href=\"normal.html\">Project</a></li>\r\n");
      out.write("\t <li class=\"\"><a href=\"contact.html\">Resource</a></li>\r\n");
      out.write("\t <li class=\"\">\r\n");
      out.write("\t <a href=\"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" role=\"button\" data-toggle=\"modal\" style=\"padding-right:0\"><span class=\"btn btn-success\">Log out</span></a>\r\n");
      out.write("\t<!--<div id=\"login\" class=\"modal hide fade in\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"login\" aria-hidden=\"false\" >\r\n");
      out.write("\t\t  <div class=\"modal-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\r\n");
      out.write("\t\t\t<h3>Login Block</h3>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"modal-body\">\r\n");
      out.write("\t\t\t<form class=\"form-horizontal loginFrm\">\r\n");
      out.write("\t\t\t  <div class=\"control-group\">\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"inputEmail\" placeholder=\"Email\">\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <div class=\"control-group\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" id=\"inputPassword\" placeholder=\"Password\">\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <div class=\"control-group\">\r\n");
      out.write("\t\t\t\t<label class=\"checkbox\">\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\"> Remember me\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</form>\t\t\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-success\">Sign in</button>\r\n");
      out.write("\t\t\t<button class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t</div>-->\r\n");
      out.write("\t</li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f0.setParent(null);
    // /pages/header.jsp(28,11) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setValue("/j_spring_security_logout");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }
}
