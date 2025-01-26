package ir.msv.orderservice.controller;

import ir.msv.orderservice.data.dto.OrderDTO;
import ir.msv.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("/status/{serialNumber}")
    public ResponseEntity<String> get(@PathVariable String serialNumber) {
        return new ResponseEntity<>(
                orderService.getStatus(serialNumber),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<OrderDTO> order(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(
                orderService.add(
                        orderDTO
                ),
                HttpStatus.CREATED
        );
    }
}
