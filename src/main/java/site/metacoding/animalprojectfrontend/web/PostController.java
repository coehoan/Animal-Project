package site.metacoding.animalprojectfrontend.web;

import javax.persistence.PostRemove;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.service.PostService;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postservice;
}
