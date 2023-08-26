/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-07-30 21:15:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class funcoes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


    public String gerarCaixaSelecao(String tabela, String ordem, int valor, boolean ativa){
          String CaixaSelecao;
          CaixaSelecao= "<select name='"+tabela+"'>\n";
          if(ativa == false){
             CaixaSelecao= "<select name='"+tabela+"' disabled='true' >\n";
          }
          br.com.Portaria.model.MoradoresBean infoCS = new br.com.Portaria.model.MoradoresBean();
          br.com.Portaria.util.Conexao jdbc = new br.com.Portaria.util.Conexao();
          if(jdbc.conectar()){
               infoCS.setConexao(jdbc.obterConexao());
               java.util.List infoLista = infoCS.listarMoradores(tabela, ordem);
               if(infoLista != null){
                   for(int i=0; i< infoLista.size(); i++){
                       br.com.Portaria.model.MoradoresBean info_um;
                       info_um = (br.com.Portaria.model.MoradoresBean) infoLista.get(i);
                       CaixaSelecao+="<option value='"+info_um.getCodigo()+"'";
                       if(valor >0){
                          if(info_um.getCodigo() == valor){
                             CaixaSelecao+="selected='selected'"; 
                          }
                       } 
                       CaixaSelecao+=">"+info_um.getNome()+"</option>\n";
                   }
               }else{
                    CaixaSelecao+= "<option>Tabela Vazia!</option>\n"; 
               }
          }else{
               CaixaSelecao+= "<option>Erro ao conectar com o BD!</option>\n";
          }
          jdbc.desconectar();
          CaixaSelecao+="</select>"; 
          return CaixaSelecao;  
    }
    
    public String gerarDataHoje(){
         java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd-MM-yyyy"); 
         java.util.Date dataHoje = new java.util.Date();
         return formato.format(dataHoje);
    }

    public int novoCodigo(){
        br.com.Portaria.model.MoradoresBean mor = new br.com.Portaria.model.MoradoresBean();
         br.com.Portaria.util.Conexao jdbc = new br.com.Portaria.util.Conexao();
         int codigoNovo;
         if(jdbc.conectar()){
               mor.setConexao(jdbc.obterConexao());
               codigoNovo = mor.gerarCodigoNovo();
          }else{
               return 0; 
          }
       jdbc.desconectar();
      return novoCodigo(); 
    }

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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- ESSE AQUI É O QUE VC QUER ADICIONAR NO LUGAR DAQUELE OUTRO?-->\n");
      out.write('\n');
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
