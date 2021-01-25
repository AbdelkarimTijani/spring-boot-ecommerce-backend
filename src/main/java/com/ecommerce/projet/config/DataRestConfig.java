package com.ecommerce.projet.config;

import com.ecommerce.projet.entity.Product;
import com.ecommerce.projet.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        //Disable POST PUT DELETE FOR PRODUCT
        HttpMethod[] productMethodsDisabled = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.DELETE
        };
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(productMethodsDisabled))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(productMethodsDisabled));

        //Disable POST PUT DELETE FOR PRODUCT CATEGORY
        HttpMethod[] categoryMethodsDisabled = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.DELETE
        };
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(categoryMethodsDisabled))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(categoryMethodsDisabled));
    }
}
