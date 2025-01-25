package ir.msv.productstore.controller;

import ir.msv.productstore.data.dto.ProductDTO;
import ir.msv.productstore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(
                service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("{serialNumber}")
    public ResponseEntity<ProductDTO> get(@PathVariable String serialNumber) {
        return new ResponseEntity<>(
                service.getBySerialNumber(serialNumber),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody ProductDTO productDTO) {
        service.add(
                productDTO
        );
        return new ResponseEntity<>(
                "successfully added product ...",
                HttpStatus.OK
        );
    }

    @DeleteMapping("{serialNumber}")
    public ResponseEntity<String> delete(@PathVariable String serialNumber) {
        service.deleteBySerialNumber(
                serialNumber
        );
        return new ResponseEntity<>(
                "successfully deleted product ...",
                HttpStatus.OK
        );
    }
}
