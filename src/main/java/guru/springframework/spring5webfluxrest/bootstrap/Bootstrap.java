package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
  private final CategoryRepository categoryRepository;
  private final VendorRepository vendorRepository;

  public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
    this.categoryRepository = categoryRepository;
    this.vendorRepository = vendorRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (categoryRepository.count().block() == 0) {
      System.out.println("######## LOADING DATA ON BOOTSTARP #####");

      categoryRepository.save(Category.builder().description("Fruits").build()).block();
      categoryRepository.save(Category.builder().description("Nuts").build()).block();
      categoryRepository.save(Category.builder().description("Breads").build()).block();
      categoryRepository.save(Category.builder().description("Meats").build()).block();
      categoryRepository.save(Category.builder().description("Eggs").build()).block();

      System.out.println("Loaded Categories : " + categoryRepository.count().block());

        vendorRepository.save(Vendor.builder().firstName("Joe").lastName("Buck").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Michel").lastName("Hy").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Jessie").lastName("Weston").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Bill").lastName("Narshi").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Jimmy").lastName("Buffett").build()).block();

        System.out.println("Loaded Vendor : " + vendorRepository.count().block());
    }
  }
}
