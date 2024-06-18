package com.batch2.onlineshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.dto.ProductsDTO;
import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.exceptions.InvalidProductDetailsException;
import com.batch2.onlineshopping.exceptions.ProductNotFoundException;
import com.batch2.onlineshopping.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public ProductsDTO addProducts(ProductsDTO productsDTO) throws InvalidProductDetailsException {

		if (productsDTO.getCost() > 0) {

			throw new InvalidProductDetailsException("Cost should not be less than 0.");
		} else if (productsDTO.getQuantity() > 0) {

			throw new InvalidProductDetailsException("Quantity should not be less than 0.");
		} else {

			Products products = new Products(productsDTO.getName(), productsDTO.getCategory(), productsDTO.getBrand(),
					productsDTO.getDescription(), productsDTO.getCost(), productsDTO.getQuantity());

			Products products1 = productsRepository.save(products);

			ProductsDTO productsdto2 = new ProductsDTO(products1.getName(), products1.getCategory(),
					products1.getBrand(), products1.getDescription(), products1.getCost(), products1.getQuantity());
			return productsdto2;
		}
	}

	@Override
	public ProductsDTO getProducts(int id) throws ProductNotFoundException {

		if (!productsRepository.existsById(id)) {
			throw new ProductNotFoundException("Product not found");
		}

		Optional<Products> product = productsRepository.findById(id);

		ProductsDTO productsdto = new ProductsDTO(product.get().getName(), product.get().getCategory(),
				product.get().getBrand(), product.get().getDescription(), product.get().getCost(),
				product.get().getQuantity());
		return productsdto;
	}

	@Override
	public ProductsDTO updateProducts(ProductsDTO productsDTO, int id)
			throws ProductNotFoundException, InvalidProductDetailsException {

		if (!productsRepository.existsById(id)) {

			throw new ProductNotFoundException("Product not found");
		} else if (productsDTO.getCost() > 0) {

			throw new InvalidProductDetailsException("Cost should not be less than 0.");
		} else if (productsDTO.getQuantity() > 0) {

			throw new InvalidProductDetailsException("Quantity should not be less than 0.");
		} else {

			Products products = new Products(productsDTO.getName(), productsDTO.getCategory(), productsDTO.getBrand(),
					productsDTO.getDescription(), productsDTO.getCost(), productsDTO.getQuantity());

			products.setId(id);

			Products products1 = productsRepository.save(products);

			ProductsDTO productsdto2 = new ProductsDTO(products1.getName(), products1.getCategory(),
					products1.getBrand(), products1.getDescription(), products1.getCost(), products1.getQuantity());
			return productsdto2;
		}
	}

	@Override
	public String deleteProducts(int id) throws ProductNotFoundException {
		if (productsRepository.existsById(id)) {

			productsRepository.deleteById(id);

			return "Product deleted successfuly";
		}
		throw new ProductNotFoundException("Product not found");
	}
}
