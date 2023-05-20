package com.rualone.app.domain.board.dto.response;

import com.rualone.app.domain.board.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String subject;
    private String content;
    private int hit;
    private String authorName;
//    private int like;

}
