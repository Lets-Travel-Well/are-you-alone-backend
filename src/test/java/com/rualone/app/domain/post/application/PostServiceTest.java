package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dto.PostCreateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
@ActiveProfiles("test")
class PostServiceTest {
    @Autowired
    PostService postService;

    private static long lastPostDataId;

    @BeforeEach
    void beforeEach(){
        init();
    }

    private void init() {
        lastPostDataId = 0;
    }

    @Test
    @DisplayName("게시물 등록하다")
    void savePost() throws Exception {
        //Given
        PostCreateDto postDto1 = PostCreateDto.builder()
                .subject("testSubject")
                .content("testContent")
                .build();

        //When
        Post post1 = postService.save(postDto1);

        //Then
        assertThat(post1.getId()).isEqualTo(lastPostDataId + 1);
        }
}