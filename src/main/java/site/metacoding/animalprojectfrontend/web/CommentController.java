package site.metacoding.animalprojectfrontend.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.comment.Comment;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.CommentService;
import site.metacoding.animalprojectfrontend.web.api.dto.ResponseDto;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;
    private final HttpSession session;

    @PostMapping("/s/post/{postId}/comment")
    public String write(@PathVariable Integer postId, Comment comment) {
        System.out.println(comment);
        User principal = (User) session.getAttribute("principal");
        comment.setUser(principal);
        commentService.댓글쓰기(comment, postId);
        return "redirect:/blog/post/" + postId;
    }

    @DeleteMapping("/s/api/comment/{id}")
    public @ResponseBody ResponseDto<?> deleteById(@PathVariable Integer id) {
        User principal = (User) session.getAttribute("principal");

        commentService.댓글삭제(id, principal);
        return new ResponseDto<>(1, "성공", null);
    }
}
