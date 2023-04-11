package model;

import manager.CategoryManager;
import manager.ProductManager;
import model.Category;
import model.Product;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class CategoryProductMain {

    private static Scanner scanner = new Scanner(System.in);

    private static CategoryManager categoryManager = new CategoryManager();
    private static ProductManager productManager = new ProductManager();
    private static CompositeData compositeData = new CompositeData() {
        @Override
        public CompositeType getCompositeType() {
            return null;
        }

        @Override
        public Object get(String key) {
            return null;
        }

        @Override
        public Object[] getAll(String[] keys) {
            return new Object[0];
        }

        @Override
        public boolean containsKey(String key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Collection<?> values() {
            return null;
        }
    };




    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            System.out.println("Please input 0 for exit");
            System.out.println("Please input 1 for add Category");
            System.out.println("Please input 2 for Edit Category by Id");
            System.out.println("Please input 3 for delete Category by ID");
            System.out.println("Please input 4 for add Product");
            System.out.println("Please input 5 for Edit Product by Id");
            System.out.println("Please input 6 for delete Product by ID");
            System.out.println("Please input 7 for print Sum of products");
            System.out.println("Please input 8 for print Max of price product");
            System.out.println("Please input 9 for print Min of price product");
            System.out.println("Please input 10 for print Avg of price product");

            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addCategory();
                    break;
                case "2":
                    editCategoryById();
                    break;
                case "3":
                    deleteCategoryById();
                    break;
                case "4":
                    addProduct();
                    break;
                case "5":
                    editProductById();
                    break;
                case "6":
                    deleteProductById();
                    break;
//                case "7":
//                    printSumProducts();
//                    break;
//                case "8":
//                    printMaxOfPriceProduct();
//                    break;
//                case "9":
//                    printMinProduct();
//                    break;
//                case "10":
//                    printAvgProduct();
//                    break;
                default:
                    System.out.println("Invalid Command");
            }
        }
    }

    private static void editProductById() {
        List<Product> product = productManager.getAll();
        for (Product products : product) {
            System.out.println(product);
        }
        System.out.print("input product id: ");
        int productId = Integer.parseInt(scanner.nextLine());
        if (productManager.getById(productId) == null) {
            System.out.println("wrong product id!");
            return;
        }

    }

        private static void deleteCategoryById () {
            List<Category> categories = categoryManager.getAll();
            for (Category category : categories) {
                System.out.println(category);
            }
            System.out.print("input category id: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (categoryManager.getById(id) != null) {
                categoryManager.removeById(id);
                System.out.println("success!");
            } else {
                System.out.println("wrong id!");
            }
        }

        private static void deleteProductById () {
            List<Product> product = productManager.getAll();
            for (Product product1 : product) {
                System.out.println(product);
            }
            System.out.print("input product id: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (productManager.getById(id) == null) {
                System.out.println("wrong id!");
                return;
            }

            productManager.removeById(id);
            System.out.println("success!");
        }





    private static void editCategoryById() {
            List<Product> products = productManager.getAll();
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.print("input product id: ");
            int productId = Integer.parseInt(scanner.nextLine());
            if (productManager.getById(productId) == null) {
                System.out.println("wrong product id!");
                return;
            }

        System.out.println("success!");
        }



    private static void addProduct() {
        List<Category> all = categoryManager.getAll();
        for (Category category : all) {
            System.out.println(category);
        }
        System.out.println("Please input category id");
        int id = Integer.parseInt(scanner.nextLine());
        Category category = categoryManager.getById(id);
        if (category != null) {
            System.out.println("Please input product name, description, price, quantity, category");
            String productStr = scanner.nextLine();
            String[] productData = productStr.split(",");
            Product product = new Product();
            product.setId(category.getId());
            product.setName(productData[0]);
            product.setDescription(productData[1]);
            product.setPrice(product.getPrice());
            product.setQuantity(product.getQuantity());
            product.setCategory(productData[4]);
            productManager.save(product);
        }
    }

    private static void addCategory() {
        System.out.println("Please input Category name");
        String categoryStr = scanner.nextLine();
        String[] categoryData = categoryStr.split(",");
        Category category = new Category();
        category.setName(categoryData[0]);
        categoryManager.save(category);

    }
}
