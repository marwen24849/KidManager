package fsb.ucar.kidcaremanager.controller;

import fsb.ucar.kidcaremanager.dto.PaymentDto;
import fsb.ucar.kidcaremanager.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> doFindAll(){
        return ResponseEntity.ok(paymentService.findAllPayment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> doFindById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.findPaymentById(id));
    }


    @PostMapping
    public ResponseEntity<Map<String, String>> doAdd(@RequestBody PaymentDto model){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        paymentService.addPayment(model)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> doUpdate(@PathVariable Long id, @RequestBody PaymentDto  model){
        return ResponseEntity.ok(paymentService.updatePayment(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> doDeleteById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.deletePaymentById(id));
    }
}
