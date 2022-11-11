package org.ec.example.community.dto.hello;

import org.ec.example.community.dto.hello.dto.HelloRequest;
import org.ec.example.community.dto.hello.dto.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HelloResponse> getHello(@PathVariable Long id) {
        HelloResponse helloResponse = helloService.getHello(id);
        return new ResponseEntity<>(helloResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HelloResponse> postHello(@RequestBody HelloRequest helloRequest) {
        HelloResponse helloResponse = helloService.postHello(helloRequest);
        return new ResponseEntity<>(helloResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HelloResponse> putHello(@RequestBody HelloRequest helloRequest, @PathVariable Long id) {
        HelloResponse helloResponse = helloService.putHello(helloRequest, id);
        return new ResponseEntity<>(helloResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteHello(@PathVariable Long id) {
        helloService.deleteHello(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
