package com.example.Product_Layer.service;

import com.example.Product_Layer.entity.Product;
import com.example.Product_Layer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //fetch all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //fetch a single product by ID
    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

    }

    //create a new product
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    //Update a existing Product
    public Product updateProduct(Long id, Product updatedProduct){
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(product);

    }

    public void deleteProduct(Long id ){
        productRepository.deleteById(id);
    }

}
