package cadastroee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;

@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Produtos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Produtos</h1>");
            out.println("<ul>");

            List<Produto> produtos = facade.findAll();
            if (produtos != null) {
                for (Produto produto : produtos) {
                    out.println("<li>" + produto.getNome() + " - " + produto.getPrecovenda() + "</li>");
                }
            } else {
                out.println("<li>Nenhum produto encontrado.</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            throw new ServletException("Erro ao processar a solicitação", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para listar produtos";
    }
}