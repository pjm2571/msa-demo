package site.autoever.userservice.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.autoever.userservice.kafa.producer.KafkaProducer;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final KafkaProducer producer;

    @GetMapping
    public String test() {
        return "users!";
    }

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return message;
    }
}