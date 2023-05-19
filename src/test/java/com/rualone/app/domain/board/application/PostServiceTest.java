//package com.rualone.app.domain.board.application;
//
//import com.rualone.app.domain.board.entity.Post;
//import com.rualone.app.domain.board.dao.PostRepository;
//import com.rualone.app.domain.board.dto.request.PostCreateRequest;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@Transactional
//@ActiveProfiles("test")
//class PostServiceTest {
//    @Autowired
//    private PostService postService;
//
//    @Autowired
//    private PostRepository postRepository;
//    private Post post;
//    @BeforeEach
//    void beforeEach(){
//        post = postRepository.save(Post.builder()
//                        .subject("postTest1")
//                        .content("postContent1")
//                        .build());
//    }
//
//    @AfterEach
//    void afterEach(){
//
//    }
//
//
//    @Test
//    @DisplayName("1. 게시글 등록")
//    void test1(){
//        // Given
//        PostCreateRequest postDto = PostCreateRequest.builder()
//                .subject("testSubject")
//                .content("testContent")
//                .build();
//
//        // When
//        Post post = postService.save(postDto);
//
//        //Then
//        Optional<Post> findPost = postRepository.findById(post.getId());
//        assertThat(findPost).isPresent();
//    }
//
//    @Test
//    @DisplayName("2. 게시글 단건 조회")
//    void test2(){
//        // Given
//
//        // When
//        Post findPost = postService.findById(post.getId());
//
//        // Then
//        assertThat(findPost.getContent()).isEqualTo("postContent1");
//    }
//
//    @Test
//    @DisplayName("3. 게시글 전체 조회")
//    void test3(){
//        // Given
//
//        // When
//        List<Post> posts = postService.findAll();
//
//        // Then
//        assertThat(posts.size()).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("4. 게시글 수정")
//    void test4(){
//        // Given
//        Post findPost = postService.findById(post.getId());
//
//        // When
//
//        // Then
//    }
//
//    @Test
//    @DisplayName("5. 게시글 삭제")
//    void test5(){
//
//    }
//
//    @Test
//    @DisplayName("6. 게시글 조회수 증가")
//    void test6(){
//
//    }
//}