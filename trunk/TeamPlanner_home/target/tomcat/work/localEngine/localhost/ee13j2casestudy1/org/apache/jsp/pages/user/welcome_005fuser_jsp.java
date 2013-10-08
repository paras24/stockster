package org.apache.jsp.pages.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_s_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" media=\"screen\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      if (_jspx_meth_s_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      if (_jspx_meth_s_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\t\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      if (_jspx_meth_s_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      if (_jspx_meth_s_005furl_005f5(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_s_005furl_005f6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005furl_005f7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"userListJSONURLHidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userListJSONURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"deleteUserURLHidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deleteUserURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      if (_jspx_meth_s_005furl_005f8(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"newUser\"></a>\r\n");
      out.write("<table id=\"userListTable\">\r\n");
      out.write("</table>\r\n");
      out.write("<div id=\"userListPager\"></div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() \r\n");
      out.write("{\t\r\n");
      out.write("\tdrawTable();\r\n");
      out.write("\t$('#newUser').fancybox({\t\t\t\t\r\n");
      out.write("\t\t autoDimensions: false,\r\n");
      out.write("\t\t onComplete: function() {\r\n");
      out.write("\t\t \t$.fancybox.resize();\r\n");
      out.write("\t\t }\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("function drawTable()\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(\"#userListTable\").jqGrid( \r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tdatatype: function(postdata) {\r\n");
      out.write("\t\t\t\t\t\tgridInitialize();\r\n");
      out.write("\t\t\t\t\t},      \r\n");
      out.write("\t\t\t\t\tpager:'#userListPager',\r\n");
      out.write("\t\t\t\t\tautowidth: true,\t\t\t\t\r\n");
      out.write("\t\t\t\t\trownumbers: true,\t\t\t\t\r\n");
      out.write("\t\t\t\t\theight:\"100%\",\r\n");
      out.write("\t\t\t\t\tsortname : 'modified',\r\n");
      out.write("\t\t\t\t\tsortorder : 'desc',\r\n");
      out.write("\t\t\t\t\tcolNames:['ID','Name', 'Date Created', 'Last Modified',''],\r\n");
      out.write("\t\t\t\t\tcolModel:[\r\n");
      out.write("\t\t\t\t\t\t\t  {name:'userID', hidden:true},\r\n");
      out.write("\t\t\t\t\t\t\t  {name:'email' , align:'left', width : 140, searchoptions:{sopt:['cn']}},\r\n");
      out.write("\t\t\t\t\t          {name:'created', align:'center', width : 100, formatter: convertTimeStampToDate,search:false},\r\n");
      out.write("\t\t\t\t\t          {name:'modified', align:'center', width : 100, formatter: convertTimeStampToDate,search:false},\r\n");
      out.write("\t\t\t\t\t      \t  {name:'options',index:'options',align:'center',width:70,editable: false,formatter:actionsLinkFormatter,search:false, sortable:false},\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t          ],\r\n");
      out.write("\t\t\t\t\tsortname: 'modified',\r\n");
      out.write("\t\t\t\t\temptyrecords: \"No users found.\",\r\n");
      out.write("\t\t\t\t\tbeforeSelectRow:function(){return false},\r\n");
      out.write("\t\t\t\t\tviewrecords: true,\t\t\t\t\r\n");
      out.write("\t\t            rowNum:10,\t\t            \r\n");
      out.write("\t\t            rowList:[10,20,30],\r\n");
      out.write("\t\t            jsonReader : {\r\n");
      out.write("\t\t                root: \"users\",\r\n");
      out.write("\t\t                total: \"totalPages\",\r\n");
      out.write("\t\t                page:\"currentPage\",\r\n");
      out.write("\t\t                records: \"totalDisplayRecords\",\r\n");
      out.write("\t\t                repeatitems: false,\t                \r\n");
      out.write("\t\t              },\t   \r\n");
      out.write("\t\t            search : {\r\n");
      out.write("\t\t            \t     caption: \"Find User\",\r\n");
      out.write("\t\t            \t     Find: \"Find\",\r\n");
      out.write("\t\t            \t     Reset: \"Reset\",\r\n");
      out.write("\t\t            \t   }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tjQuery(\"#userListTable\").jqGrid('navGrid',\"#userListPager\",{addfunc:newUser,addtitle:'Add User', searchtitle : \"Find Users\", refreshtitle : \"Reload View\",edit:false,add:true,del:false,search: true, refresh:true});\r\n");
      out.write("\t\t$(\"#userListTable\").css('overflow-x','hidden');\r\n");
      out.write("\t\t$(\"#userListTable\").css('overflow-y','auto');\r\n");
      out.write("\t\t$(\".ui-pg-selbox\").css('width','50');\r\n");
      out.write("\t\t$(\".ui-pg-selbox\").css('height','23');\r\n");
      out.write("\t\t$(\".ui-pg-input\").css('width','15');\r\n");
      out.write("\t\t$(\".ui-pg-input\").css('height','12');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\tfunction gridInitialize() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar urlValue = $('#userListJSONURLHidden').val();\r\n");
      out.write("\t\tvar displayLength=jQuery(\"#userListTable\").jqGrid(\"getGridParam\",\"postData\").rows;\r\n");
      out.write("\t\tvar searchString=jQuery(\"#userListTable\").jqGrid(\"getGridParam\",\"postData\").searchString;\r\n");
      out.write("\t\tif(typeof searchString=='undefined') {\r\n");
      out.write("\t\t\tsearchString=\"\";\t\t\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\tvar sortColName=jQuery(\"#userListTable\").jqGrid(\"getGridParam\",\"postData\").sidx;\r\n");
      out.write("\t\tvar sortOrder=jQuery(\"#userListTable\").jqGrid(\"getGridParam\",\"postData\").sord;\r\n");
      out.write("\t\tvar displayStart=(jQuery(\"#userListTable\").jqGrid(\"getGridParam\",\"postData\").page-1)*displayLength;\r\n");
      out.write("\t\turlValue = urlValue+\"?displayLength=\"+displayLength+\"&searchString=\"+searchString+\"&sortColName=\"+sortColName+\"&sortOrder=\"+sortOrder+\"&displayStart=\"+displayStart;\r\n");
      out.write("\tjQuery.ajax({\r\n");
      out.write("        url: urlValue,\t\t\t            \r\n");
      out.write("        dataType:\"json\",\r\n");
      out.write("        complete: function(json,stat){\t\t\t            \t \r\n");
      out.write("           if(stat==\"success\")  {\r\n");
      out.write("         \t  var grid = jQuery(\"#userListTable\")[0];\r\n");
      out.write("              grid.addJSONData(JSON.parse(json.responseText));\r\n");
      out.write("           }\r\n");
      out.write("        }\r\n");
      out.write("     });\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction newUser()\r\n");
      out.write("\t{\r\n");
      out.write("\t\t$('#newUser').trigger(\"click\");\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("function actionsLinkFormatter(cellvalue, options, rowObject)\r\n");
      out.write("{\r\n");
      out.write("\tvar userID = rowObject['userID'];\r\n");
      out.write("\tvar email = rowObject['email'];\r\n");
      out.write("\tvar userActions = \r\n");
      out.write("\t/* \"<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editUser(&quot;\"+userID+\"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit \"+email+\"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>\"+ */\r\n");
      out.write("\t\"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteUser(&quot;\"+userID+\"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete \"+email+\"'><span align='center' class='ui-icon ui-icon-trash'></span></a>\";\r\n");
      out.write("\treturn userActions ;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function deleteUser(userID)\t\r\n");
      out.write("{\r\n");
      out.write("\t\tvar $dialog = $('<div></div>')\r\n");
      out.write("\t\t.html(\"Are you sure you want to delete the user?\")\r\n");
      out.write("\t\t.dialog({\r\n");
      out.write("\t\t\tautoOpen: false,\r\n");
      out.write("\t\t\ttitle: 'Team Planner',\r\n");
      out.write("\t\t\tresizable: false,\r\n");
      out.write("\t\t\theight:140,\r\n");
      out.write("\t\t\tmodal: true,\r\n");
      out.write("\t\t\tbuttons: {\r\n");
      out.write("\t\t\t\t\"Delete\": function() {\r\n");
      out.write("\t\t\t\t\tvar urlvalue = $(\"#deleteUserURLHidden\").val()+\"?userID=\"+userID;\r\n");
      out.write("\t\t\t\t\tvar val = $.ajax( {\r\n");
      out.write("\t\t\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\t\t\turl : urlvalue,\t\t\r\n");
      out.write("\t\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(result) \r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#userListTable\").trigger(\"reloadGrid\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\t\r\n");
      out.write("\t\t\t\t\t$( this ).dialog( \"close\" );\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tCancel: function() {\r\n");
      out.write("\t\t\t\t\t$( this ).dialog( \"close\" );\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$dialog.dialog('open');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function convertTimeStampToDate(cellvalue, options, rowObject) \r\n");
      out.write("{\t\t\t\t\t\r\n");
      out.write("\tvar pubDate = new Date(cellvalue);\r\n");
      out.write("\tvar hours=pubDate.getHours();\r\n");
      out.write("\tvar meridian=\"AM\";\r\n");
      out.write("\tif (hours > 12) {\r\n");
      out.write("\t\tmeridian = \"PM\";\r\n");
      out.write("\t\thours = hours - 12;\r\n");
      out.write("\t}\r\n");
      out.write("    if (hours == 12) \r\n");
      out.write("\t\tmeridian = \"PM\";\r\n");
      out.write("    if (hours < 10 && hours>0)\r\n");
      out.write("\t\thours = \"0\" + hours;\r\n");
      out.write("    if (hours==0) {\r\n");
      out.write("\t\thours=12;\t\r\n");
      out.write("\t    meridian = \"AM\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\tvar date=pubDate.getDate();\r\n");
      out.write("\tif (date < 10)\r\n");
      out.write("\t\tdate=\"0\"+date;\r\n");
      out.write("\tvar month=pubDate.getMonth()+1;\r\n");
      out.write("\tif (month < 10)\r\n");
      out.write("\t\tmonth=\"0\"+month;\r\n");
      out.write("\tvar min=pubDate.getMinutes();\r\n");
      out.write("\tif (min < 10)\r\n");
      out.write("\t\tmin=\"0\"+min;\r\n");
      out.write("\tvar formattedDate = month+'-'+date+'-'+pubDate.getFullYear()+' '+hours+':'+min+' '+meridian;//weekday[pubDate.getDay()] + ' '+ monthname[pubDate.getMonth()] + ' '+ pubDate.getDate() + ', ' + pubDate.getFullYear()+' '+pubDate.toLocaleTimeString();\t\t\t\t \t\t\t\t  \t\t\t\t\t\t\t\r\n");
      out.write("\treturn formattedDate;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\t\t\t\t\r\n");
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
    // /pages/user/welcome_user.jsp(6,12) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setValue("/resources/assets/css/ui.jqgrid.css");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f1 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f1.setParent(null);
    // /pages/user/welcome_user.jsp(8,29) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setValue("/resources/assets/js/fancybox/jquery.fancybox-1.3.4.css");
    int _jspx_eval_s_005furl_005f1 = _jspx_th_s_005furl_005f1.doStartTag();
    if (_jspx_th_s_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f2 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f2.setParent(null);
    // /pages/user/welcome_user.jsp(9,58) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f2.setValue("/resources/assets/js/fancybox/jquery.mousewheel-3.0.4.pack.js");
    int _jspx_eval_s_005furl_005f2 = _jspx_th_s_005furl_005f2.doStartTag();
    if (_jspx_th_s_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f3 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f3.setParent(null);
    // /pages/user/welcome_user.jsp(10,58) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f3.setValue("/resources/assets/js/fancybox/jquery.fancybox-1.3.4.pack.js");
    int _jspx_eval_s_005furl_005f3 = _jspx_th_s_005furl_005f3.doStartTag();
    if (_jspx_th_s_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f4 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f4.setParent(null);
    // /pages/user/welcome_user.jsp(11,58) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f4.setValue("/resources/assets/js/grid.locale-en.js");
    int _jspx_eval_s_005furl_005f4 = _jspx_th_s_005furl_005f4.doStartTag();
    if (_jspx_th_s_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f5 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f5.setParent(null);
    // /pages/user/welcome_user.jsp(12,58) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f5.setValue("/resources/assets/js/jquery.jqGrid.min.js");
    int _jspx_eval_s_005furl_005f5 = _jspx_th_s_005furl_005f5.doStartTag();
    if (_jspx_th_s_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f6 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f6.setParent(null);
    // /pages/user/welcome_user.jsp(15,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f6.setVar("userListJSONURL");
    // /pages/user/welcome_user.jsp(15,0) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f6.setValue("/user/userListJson.action");
    int _jspx_eval_s_005furl_005f6 = _jspx_th_s_005furl_005f6.doStartTag();
    if (_jspx_th_s_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f7 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f7.setParent(null);
    // /pages/user/welcome_user.jsp(16,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f7.setVar("deleteUserURL");
    // /pages/user/welcome_user.jsp(16,0) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f7.setValue("/user/delete.action");
    int _jspx_eval_s_005furl_005f7 = _jspx_th_s_005furl_005f7.doStartTag();
    if (_jspx_th_s_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f8 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f8.setParent(null);
    // /pages/user/welcome_user.jsp(20,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f8.setVar("form");
    // /pages/user/welcome_user.jsp(20,0) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f8.setValue("/user/form");
    int _jspx_eval_s_005furl_005f8 = _jspx_th_s_005furl_005f8.doStartTag();
    if (_jspx_th_s_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f8);
    return false;
  }
}
