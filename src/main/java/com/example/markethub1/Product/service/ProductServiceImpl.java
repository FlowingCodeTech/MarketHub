package com.example.markethub1.Product.service;

import com.example.markethub1.Product.dto.ProductDTO;
import com.example.markethub1.Product.entity.Product;
import com.example.markethub1.Product.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;
    private ModelMapper modelMapper;

    @Override
    public void saveProduct(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO, Product.class));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll().stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()){
            return modelMapper.map(optionalProduct.get(),ProductDTO.class);
        }
        else{
            System.out.println("This Id Not Found!!!");
            return null;
    }
    }

    @Override
    public void updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()){
            Product updatingProduct = optionalProduct.get();
            updatingProduct.setProductName(productDTO.getProductName());
            updatingProduct.setProductType(productDTO.getProductType());
            updatingProduct.setPrice(productDTO.getPrice());
            productRepo.save(updatingProduct);
        }
        else
            System.out.println("This Id Not Found!!!");
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            Product deletingProduct = optionalProduct.get();
            productRepo.delete(deletingProduct);
        }
        else
            System.out.println("This Id Not Found!!!");
    }
}
