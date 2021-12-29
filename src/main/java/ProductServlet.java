import dao.CategoryDao;
import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(req, resp);
                break;
            case "delete":
                deleteForm(req, resp);
                break;
            case "edit":
                editForm(req, resp);
                break;
            case "detail":
                detailForm(req,resp);
                break;
            case "search":
                searchForm(req,resp);
                break;
            default:
                listProduct(req, resp);
        }
    }

    private void searchForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/search.jsp");
        dispatcher.forward(req, resp);
    }

    private void detailForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int index = productService.findIndexById(id);
        req.setAttribute("product", productService.findAll().get(index));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/detail.jsp");
        dispatcher.forward(req,resp);
    }

    private void editForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int index = productService.findIndexById(id);
        Product product = productService.findAll().get(index);
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/delete.jsp");
        dispatcher.forward(req, resp);
    }

    private void createForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", CategoryDao.getAllCategory());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list.jsp");
        req.setAttribute("productList", productList);//ten file- du lieu
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
            case "search":
                searchProduct(req,resp);
                break;
            default:

        }
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Product> searchList = productService.searchProduct(name);
        req.setAttribute("searchList", searchList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/searchResult.jsp");
        dispatcher.forward(req,resp);
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String producer = req.getParameter("producer");
        String image = req.getParameter("image");
        Product product = new Product(id, name, idCategory, price, description, producer, image);

        int index = productService.findIndexById(id);
        productService.editProduct(index, product);
        resp.sendRedirect("/product");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int index = productService.findIndexById(id);
        productService.deleteProduct(index);
        resp.sendRedirect("/product");

    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String producer = req.getParameter("producer");
        String image = req.getParameter("image");
        Product product = new Product(id, name, idCategory, price, description, producer, image);

        productService.save(product);
        resp.sendRedirect("/product");
    }
}

