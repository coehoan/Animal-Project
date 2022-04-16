package site.metacoding.animalprojectfrontend.web.api;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.service.PostService;

@RequiredArgsConstructor
@Controller
public class PostApiController {
    private final PostService postService;
}
