package org.ec.example.community.dto.hello;

import org.ec.example.community.dto.hello.dto.HelloRequest;
import org.ec.example.community.dto.hello.dto.HelloResponse;
import org.ec.example.community.dto.hello.exception.HelloNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public HelloResponse getHello(Long id) {
        Hello hello = helloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hello Entity is not found."));
        return new HelloResponse(hello.getId(), hello.getContent());
    }

    public HelloResponse postHello(HelloRequest helloRequest) {
        Hello hello = helloRepository.save(new Hello(helloRequest.getContent()));
        return new HelloResponse(hello.getId(), hello.getContent());
    }

    public HelloResponse putHello(HelloRequest helloRequest, Long id) {
        Hello hello = helloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hello Entity is not found."));
        Hello updated = new Hello(hello.getId(), helloRequest.getContent());
        helloRepository.save(updated);
        return new HelloResponse(updated.getId(), updated.getContent());
    }

    public Long deleteHello(Long id) {
        if (!helloRepository.existsById(id))
            throw new HelloNotFound("Hello Entity is not found.");
        helloRepository.deleteById(id);
        return id;
    }
}
