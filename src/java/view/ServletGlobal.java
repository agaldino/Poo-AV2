/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AlocacaoFacadeLocal;
import control.FuncionarioFacadeLocal;
import control.ProjetoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alocacao;
import model.AlocacaoPK;
import model.Funcionario;
import model.Projeto;

/**
 *
 * @author vitor
 */
@WebServlet(name = "ServletGlobal", urlPatterns = {"/ServletGlobal"})
public class ServletGlobal extends HttpServlet {

    @EJB
    FuncionarioFacadeLocal facadeFuncionario;
    @EJB
    ProjetoFacadeLocal facadeProjeto;
    @EJB
    AlocacaoFacadeLocal facadeAlocacao;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        String paginaDestino = null;

        if (acao.equals("CadastrarFuncionario")) {

            paginaDestino = "GerenciarFuncionario.jsp?mod=cad";

        } else if (acao.equals("CadastrarProjeto")) {

            paginaDestino = "GerenciarProjeto.jsp?mod=cad";

        } else if (acao.equals("cadFunc")) {

            PrintWriter out = response.getWriter();

            Funcionario f = new Funcionario();

            if (!request.getParameter("dt_nasc").equals("")) {
                f.setNome(request.getParameter("ds_nome"));
                f.setDatanasc(Date.valueOf(request.getParameter("dt_nasc")));
                f.setSexo(request.getParameter("sex").charAt(0));
                f.setEspecialidade(request.getParameter("ds_espec"));
                f.setCargo(request.getParameter("ds_cargo"));
                f.setSalario(Integer.parseInt(request.getParameter("nr_salario")));
                f.setBAtivo(request.getParameter("b_ativo").equals("true") ? 1 : 0);

                if (validaFuncionario(f)) {

                    facadeFuncionario.create(f);
                    out.println("<script>alert('Funcionario cadastrado com sucesso.'); window.location.href='index.jsp';</script>");
                } else {
                    out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarFuncionario.jsp?mod=cad';</script>");
                    out.close();
                }
            } else {
                out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarFuncionario.jsp?mod=cad';</script>");
                out.close();
            }

        } else if (acao.equals("cadProj")) {

            PrintWriter out = response.getWriter();

            Projeto p = new Projeto();

            if (!request.getParameter("dt_Inicio").equals("")) {

                p.setNomeprojeto(request.getParameter("ds_nome"));
                p.setFinanciado(request.getParameter("ds_financiador"));
                p.setResponsavel(request.getParameter("ds_responsavel"));
                p.setInvestimento(Integer.parseInt(request.getParameter("nr_investimento")));
                p.setDtinicio(Date.valueOf(request.getParameter("dt_Inicio")));

                if (validaProjeto(p)) {

                    facadeProjeto.create(p);
                    out.println("<script>alert('Projeto cadastrado com sucesso.'); window.location.href='index.jsp';</script>");
                    out.close();
                } else {
                    out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarProjeto.jsp?mod=cad';</script>");
                    out.close();
                }
            } else {
                out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarProjeto.jsp?mod=cad';</script>");
                out.close();
            }

        } else if (acao.equals("listFunc")) {

            request.setAttribute("funcionarios", facadeFuncionario.findAll());
            paginaDestino = "ListarFuncionario.jsp";

        } else if (acao.equals("editFunc")) {

            request.setAttribute("funcionario", facadeFuncionario.find(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("GerenciarFuncionario.jsp?mod=edit").forward(request, response);

        } else if (acao.equals("listProj")) {

            request.setAttribute("projetos", facadeProjeto.findAll());
            paginaDestino = "ListarProjeto.jsp";

        } else if (acao.equals("editProj")) {

            request.setAttribute("projeto", facadeProjeto.find(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("GerenciarProjeto.jsp?mod=edit").forward(request, response);

        } else if (acao.equals("editarFuncionario")) {

            PrintWriter out = response.getWriter();
            Funcionario f = new Funcionario();

            if (request.getParameter("editCod").equals("")) {
                f.setCodfuncionario(Integer.parseInt(request.getParameter("editCod")));
                f.setNome(request.getParameter("ds_nome"));
                f.setDatanasc(Date.valueOf(request.getParameter("dt_nasc")));
                f.setSexo(request.getParameter("sex").charAt(0));
                f.setEspecialidade(request.getParameter("ds_espec"));
                f.setCargo(request.getParameter("ds_cargo"));
                f.setSalario(Integer.parseInt(request.getParameter("nr_salario")));
                f.setBAtivo(request.getParameter("b_ativo").equals("true") ? 1 : 0);

                if (validaFuncionario(f)) {

                    facadeFuncionario.create(f);
                    out.println("<script>alert('Funcionario ediado com sucesso.'); window.location.href='index.jsp';</script>");
                } else {
                    out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarFuncionario.jsp';</script>");
                    out.close();
                }
            } else {
                out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarFuncionario.jsp';</script>");
                out.close();
            }

            facadeFuncionario.edit(f);

        } else if (acao.equals("editarProjeto")) {

            PrintWriter out = response.getWriter();
            Projeto p = new Projeto();

            if (!request.getParameter("editCod").equals("")) {
                p.setCodprojeto(Integer.parseInt(request.getParameter("editCod")));
                p.setNomeprojeto(request.getParameter("ds_nome"));
                p.setFinanciado(request.getParameter("ds_financiador"));
                p.setResponsavel(request.getParameter("ds_responsavel"));
                p.setInvestimento(Integer.parseInt(request.getParameter("nr_investimento")));
                p.setDtinicio(Date.valueOf(request.getParameter("dt_Inicio")));

                if (validaProjeto(p)) {

                    facadeProjeto.create(p);
                    out.println("<script>alert('Projeto editado com sucesso.'); window.location.href='index.jsp';</script>");
                    out.close();
                } else {
                    out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarProjeto.jsp';</script>");
                    out.close();
                }
            } else {
                out.println("<script>alert('Complete corretamente o dados.'); window.location.href='GerenciarProjeto.jsp';</script>");
                out.close();
            }

        } else if (acao.equals("excluiProjeto")) {

            Projeto p = new Projeto();
            p.setCodprojeto(Integer.parseInt(request.getParameter("id")));
            facadeProjeto.remove(p);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (acao.equals("excluiFuncionario")) {

            Funcionario f = new Funcionario();
            f.setCodfuncionario(Integer.parseInt(request.getParameter("id")));
            facadeFuncionario.remove(f);
            request.getRequestDispatcher("ListarFuncionario.jsp").forward(request, response);

        } else if (acao.equals("alocarprojfunc")) {

            paginaDestino = "Alocar.jsp";

        } else if (acao.equals("alocar")) {

            PrintWriter out = response.getWriter();
            Alocacao a = new Alocacao();
            Projeto p = new Projeto();
            Funcionario f = new Funcionario();
            AlocacaoPK pk = new AlocacaoPK();

            if (!request.getParameter("codProjeto").equals("") || !request.getParameter("codFuncionario").equals("")) {

                p.setCodprojeto(Integer.parseInt(request.getParameter("codProjeto")));
                f.setCodfuncionario(Integer.parseInt(request.getParameter("codFuncionario")));
                pk.setCodprojeto(p.getCodprojeto());
                pk.setCodfuncionario(f.getCodfuncionario());


                a.setProjeto(p);
                a.setFuncionario(f);
                a.setDataalocacao(new Date(System.currentTimeMillis()));
                a.setAlocacaoPK(pk);


                facadeAlocacao.create(a);
                out.println("<script>alert('Alocação realizada com sucesso.'); window.location.href='index.jsp';</script>");
                out.close();
            } else {
                out.println("<script>alert('Complete corretamente o dados.'); window.location.href='Alocar.jsp';</script>");
                out.close();
            }
        } else if (acao.equals("listarAlocacao")) {

            request.setAttribute("alocacoes", facadeAlocacao.findAll());
            request.getRequestDispatcher("ListarAlocacao.jsp").forward(request, response);
        }

        request.getRequestDispatcher(paginaDestino).forward(request, response);

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean validaFuncionario(Funcionario f) {
        if (f.getNome().equals("") || f.getDatanasc() == null || f.getEspecialidade().equals("") || f.getSalario() == null || f.getCargo().equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean validaProjeto(Projeto p) {
        if (p.getNomeprojeto().equals("") || p.getDtinicio() == null || p.getFinanciado().equals("") || p.getInvestimento() == null || p.getResponsavel().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
