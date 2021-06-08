package uz.bahodirsmind.paymentdemo;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import uz.bahodirsmind.paymentdemo.domain.*;
import uz.bahodirsmind.paymentdemo.repository.*;
import uz.bahodirsmind.paymentdemo.util.CustomUtils;

import java.math.BigDecimal;
import java.util.Base64;

import static uz.bahodirsmind.paymentdemo.payload.enums.Countries.*;
import static uz.bahodirsmind.paymentdemo.payload.enums.Countries.KRG;

@SpringBootApplication
public class PaymentDemoApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ResourceLoader resourceLoader;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final DetailRepository detailRepository;
    private final InvoiceRepository invoiceRepository;
    private final PaymentRepository paymentRepository;

    public PaymentDemoApplication(CategoryRepository categoryRepository, ProductRepository productRepository, ResourceLoader resourceLoader, CustomerRepository customerRepository, OrderRepository orderRepository, DetailRepository detailRepository, InvoiceRepository invoiceRepository, PaymentRepository paymentRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.resourceLoader = resourceLoader;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.detailRepository = detailRepository;
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;
    }

    @Value("${spring.sql.init.enabled}")
    private boolean modeInitial;

    public static void main(String[] args) {
        SpringApplication.run(PaymentDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (modeInitial) {

            try {
                 /*
                 Initializing categories
                 */
                Category books = categoryRepository.save(new Category("books"));
                Category fruits = categoryRepository.save(new Category("fruits"));
                Category phones = categoryRepository.save(new Category("phones"));
                Category laptops = categoryRepository.save(new Category("laptops"));
                Category clothes = categoryRepository.save(new Category("clothes"));

                 /*
                 Initializing products
                 */
                String booksImg = Base64.getEncoder().encodeToString(IOUtils.toByteArray(resourceLoader.getResource("classpath:books.jpg").getInputStream()));
                String fruitsImg = Base64.getEncoder().encodeToString(IOUtils.toByteArray(resourceLoader.getResource("classpath:fruits.jpg").getInputStream()));
                String clothesImg = Base64.getEncoder().encodeToString(IOUtils.toByteArray(resourceLoader.getResource("classpath:clothes.jpg").getInputStream()));
                String laptopsImg = Base64.getEncoder().encodeToString(IOUtils.toByteArray(resourceLoader.getResource("classpath:laptops.jpg").getInputStream()));
                String phonesImg = Base64.getEncoder().encodeToString(IOUtils.toByteArray(resourceLoader.getResource("classpath:phones.jpg").getInputStream()));

                Product product1 = productRepository.save(new Product("Big 4", books, "good book", BigDecimal.valueOf(500.03), booksImg));
                Product product2 = productRepository.save(new Product("GoldMind", books, "best seller book", BigDecimal.valueOf(450.00), booksImg));
                Product product3 = productRepository.save(new Product("apple", fruits, "deligious fruit", BigDecimal.valueOf(120.30), fruitsImg));
                Product product4 = productRepository.save(new Product("banana", fruits, "deligious fruit", BigDecimal.valueOf(330.00), fruitsImg));
                Product product5 = productRepository.save(new Product("jacket", clothes, "wear it", BigDecimal.valueOf(420.00), clothesImg));
                Product product6 = productRepository.save(new Product("jeans", clothes, "jeans really cool", BigDecimal.valueOf(560.20), clothesImg));
                Product product7 = productRepository.save(new Product("acer A3", laptops, "really good laptop", BigDecimal.valueOf(5100.00), laptopsImg));
                Product product8 = productRepository.save(new Product("lenova C3", laptops, "really good laptop", BigDecimal.valueOf(5200.00), laptopsImg));
                Product product9 = productRepository.save(new Product("Asus A2", laptops, "really good laptop", BigDecimal.valueOf(5600.00), laptopsImg));
                Product product10 = productRepository.save(new Product("Mackbook>", laptops, "really good laptop", BigDecimal.valueOf(9220.00), laptopsImg));
                Product product11 = productRepository.save(new Product("Acer E-5", laptops, "really good laptop", BigDecimal.valueOf(7800.00), laptopsImg));
                Product product12 = productRepository.save(new Product("Acer M2", laptops, "really good laptop", BigDecimal.valueOf(5050.00), laptopsImg));
                Product product13 = productRepository.save(new Product("IPhone 6S", phones, "really good phone", BigDecimal.valueOf(6600.00), phonesImg));

                /*
                Initializing customers
                */

                Customer customer1 = customerRepository.save(new Customer("customer1", UZB, "Tashkent", "+998999999999"));
                Customer customer2 = customerRepository.save(new Customer("customer2", UZB, "Tashkent", "+998933333333"));
                Customer customer3 = customerRepository.save(new Customer("customer3", ENG, "Fergana", "+998944444444"));
                Customer customer4 = customerRepository.save(new Customer("customer4", ENG, "Fergana", "+998944444444"));
                Customer customer5 = customerRepository.save(new Customer("customer5", KRG, "Andijan", "+998944444444"));
                Customer customer6 = customerRepository.save(new Customer("customer6", KRG, "Andijan", "+998944444444"));
                Customer customer7 = customerRepository.save(new Customer("customer7", USA, "Namangan", "+998944444444"));

                /*
                Initializing orders
                 */
                Order order1 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-11-04"), customer1));
                Order order2 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-05-11"), customer2));
                Order order3 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2015-10-04"), customer1));
                Order order4 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-02-08"), customer2));
                Order order5 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-01-02"), customer2));
                Order order6 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-11-22"), customer3));
                Order order7 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2017-06-19"), customer3));
                Order order8 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2018-06-19"), customer4));
                Order order9 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2015-06-19"), customer4));
                Order order10 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-02-19"), customer5));
                Order order11 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-10-19"), customer5));
                Order order12 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-06-19"), customer6));
                Order order13 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2019-12-19"), customer6));
                Order order14 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-07-17"), customer7));
                Order order15 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-05-11"), customer7));
                Order order16 = orderRepository.save(new Order(CustomUtils.comfortStrFormToDate("2016-03-22"), customer7));

                /*
                Initializing order details
                 */
                detailRepository.save(new Detail(order1, product1, (short) 12));
                detailRepository.save(new Detail(order1, product2, (short) 1));
                detailRepository.save(new Detail(order1, product3, null));
                detailRepository.save(new Detail(order2, product4, (short) 15));
                detailRepository.save(new Detail(order2, product5, (short) 5));
                detailRepository.save(new Detail(order3, product4, (short) 12));
                detailRepository.save(new Detail(order3, product1, (short) 9));
                detailRepository.save(new Detail(order4, product5, (short) 1));
                detailRepository.save(new Detail(order4, product2, (short) 7));
                detailRepository.save(new Detail(order5, product6, (short) 5));
                detailRepository.save(new Detail(order5, product7, (short) 4));
                detailRepository.save(new Detail(order6, product3, (short) 15));
                detailRepository.save(new Detail(order7, product7, null));
                detailRepository.save(new Detail(order7, product8, (short) 11));
                detailRepository.save(new Detail(order7, product1, (short) 9));
                detailRepository.save(new Detail(order8, product8, (short) 30));
                detailRepository.save(new Detail(order8, product7, (short) 2));
                detailRepository.save(new Detail(order9, product9, (short) 8));
                detailRepository.save(new Detail(order10, product10, (short) 2));
                detailRepository.save(new Detail(order11, product5, (short) 1));
                detailRepository.save(new Detail(order11, product4, (short) 12));
                detailRepository.save(new Detail(order11, product6, (short) 19));
                detailRepository.save(new Detail(order12, product3, (short) 9));
                detailRepository.save(new Detail(order12, product4, (short) 2));

                /*
                Initializing invoices
                 */
                Invoice invoice1 = invoiceRepository.save(new Invoice(order1, BigDecimal.valueOf(500.03), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice2 = invoiceRepository.save(new Invoice(order2, BigDecimal.valueOf(5032.00), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice3 = invoiceRepository.save(new Invoice(order4, BigDecimal.valueOf(130.20), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice4 = invoiceRepository.save(new Invoice(order5, BigDecimal.valueOf(8560.15), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice5 = invoiceRepository.save(new Invoice(order6, BigDecimal.valueOf(8400.30), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice6 = invoiceRepository.save(new Invoice(order7, BigDecimal.valueOf(100.25), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice7 = invoiceRepository.save(new Invoice(order9, BigDecimal.valueOf(9600.40), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice8 = invoiceRepository.save(new Invoice(order11, BigDecimal.valueOf(700.35), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice9 = invoiceRepository.save(new Invoice(order14, BigDecimal.valueOf(7565.15), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));
                Invoice invoice10 = invoiceRepository.save(new Invoice(order15, BigDecimal.valueOf(7400.00), CustomUtils.comfortStrFormToDate("2016-11-15"), CustomUtils.comfortStrFormToDate("2016-11-17")));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
