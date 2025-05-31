package org.example.spbootpr1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SimpleController {


    private final ReportSenderService reportSenderService;
    private final PostRepository postRepository;

    @GetMapping("/sendReort")
    public String sendReport() {
        reportSenderService.sendReport("Test uchun");
        return "Send report successfully!";
    }


    @GetMapping("/posts")
    public List<Post> getPost() {
        return postRepository.findAll();
    }


    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        System.out.println(post);
        return postRepository.save(post);
    }

}
