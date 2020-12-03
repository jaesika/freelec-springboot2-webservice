package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.service.posts.PostsService;
import springboot.web.dto.PostsResponseDto;
import springboot.web.dto.PostsSaveRequestDto;
import springboot.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /**
     * 게시글 등록 요청
     * @param requstDto { title, content, author }
     * @return id
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requstDto) {
        return postsService.save(requstDto);
    }

    /**
     * 게시글 수정 요청
     * @param id 게시글 id
     * @param requestDto { title, content }
     * @return id
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /**
     * 게시글 조회 요청
     * @param id
     * @return PostsResponseDto { id, title, content, author }
     */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    /**
     * 게시글 삭제 요청
     * @param id
     * @return id
     */
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
