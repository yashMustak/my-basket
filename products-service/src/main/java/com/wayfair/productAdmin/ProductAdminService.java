package com.wayfair.productAdmin;

import com.wayfair.products.Product;

public interface ProductAdminService {
    public Product addProduct(Product product);
    public void deleteProduct(Long productId);
    public Product getProductById(Long id);

}
