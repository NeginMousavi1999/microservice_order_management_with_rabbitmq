package ir.msv.productstore.service.impl;

import ir.msv.productstore.data.dto.ProductDTO;
import ir.msv.productstore.data.entity.Product;
import ir.msv.productstore.data.repository.ProductRepository;
import ir.msv.productstore.exception.AppException;
import ir.msv.productstore.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(
                        product -> mapper.map(
                                product,
                                ProductDTO.class
                        )

                )
                .collect(Collectors.toList());
    }

    @Override
    public void add(ProductDTO productDTO) {
        repository.save(
                Product.builder()
                        .name(
                                productDTO.getName()
                        )
                        .count(
                                productDTO.getCount()
                        )
                        .serialNumber(
                                UUID.randomUUID().toString()
                        )
                        .build()
        );
    }

    @Override
    public ProductDTO getBySerialNumber(String serialNumber) {
        return mapper.map(
                findBySerialNumber(serialNumber),
                ProductDTO.class
        );
    }

    @Override
    public void deleteBySerialNumber(String serialNumber) {
        repository.delete(
                findBySerialNumber(serialNumber)
        );
    }

    @Override
    public Product getFullBySerialNumber(String serialNumber) {
        return findBySerialNumber(
                serialNumber
        );
    }

    private Product findBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(
                        serialNumber
                )
                .orElseThrow(
                        () -> new AppException("not found product with this serial number")
                );
    }
}