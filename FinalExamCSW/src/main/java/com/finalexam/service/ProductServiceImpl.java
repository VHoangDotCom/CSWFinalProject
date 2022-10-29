package com.finalexam.service;

import com.finalexam.entity.ProductEntity;
import com.finalexam.model.Product;
import com.finalexam.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(product, productEntity);
        productRepository.save(productEntity);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();

        List<Product> productList = productEntities
                .stream()
                .map(pro -> new Product(pro.getId()
                , pro.getName(),
                        pro.getPrice(),
                        pro.getQuantity()))
                .collect(Collectors.toList());

        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        Product product = new Product();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

    @Override
    public Product sellProduct(Long id, Product product) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productEntity.setQuantity(product.getQuantity() - 1);

        productRepository.save(productEntity);
        return product;
    }

    @Override
    public boolean deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productRepository.delete(productEntity);
        return true;
    }
}
