/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.FuncionarioFacadeLocal;
import control.ProjetoFacadeLocal;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

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
        try {
            String acao = request.getParameter("acao");
            String paginaDestino = null;

            if (acao.equals("CadastrarFuncionario")) {
                
                paginaDestino = "CadastrarFuncionario.jsp";
                
            } else if (acao.equals("CadastrarProjeto")) {
                
                paginaDestino = "CadastrarProjeto.jsp";
                
            } else if (acao.equals("cadFunc")) {
                
                Funcionario f = new Funcionario();
                
                f.setNome(request.getParameter("ds_nome"));
                f.setDatanasc(Date.valueOf(request.getParameter("dt_nasc")));
                f.setSexo(request.getParameter("sex").charAt(0));
                f.setEspecialidade(request.getParameter("ds_especialide"));
                f.setCargo(request.getParameter("ds_cargo"));
                f.setSalario(Integer.parseInt(request.getParameter("nr_salario")));
                                            
                facadeFuncionario.create(f);
                
            } else if (acao.equals("cadProj")) {
                                
            }

            request.getRequestDispatcher(paginaDestino).forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ServletGlobal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}