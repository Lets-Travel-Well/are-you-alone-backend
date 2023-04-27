package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dao.PostRepository;
import com.rualone.app.domain.post.dto.request.PostCreateRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
@ActiveProfiles("test")
class PostServiceTest {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    private static long lastPostDataId;

    @BeforeEach
    void beforeEach(){
        init();
    }

    @AfterEach
    void afterEach(){
        
    }

    private void init() {
        createData();
        lastPostDataId = 0;
    }

    private void createData() {

    }

    @Test
    @DisplayName("1. 게시글 등록")
    void test1(){
        // Given
        PostCreateRequest postDto1 = PostCreateRequest.builder()
                .subject("testSubject")
                .content("testContent")
                .build();

        // When
        Post post1 = postService.save(postDto1);

        //Then
        assertThat(post1.getId()).isEqualTo(lastPostDataId + 1);
    }

    @Test
    @DisplayName("2. 게시글 단건 조회")
    void test2(){
        // Given

        // When

        // Then
    }
    
    @Test
    @DisplayName("3. 게시글 전체 조회")
    void test3(){

    }

    @Test
    @DisplayName("4. 게시글 수정")
    void test4(){

    }

    @Test
    @DisplayName("5. 게시글 삭제")
    void test5(){

    }

    @Test
    @DisplayName("6. 게시글 조회수 증가")
    void test6(){

    }
}