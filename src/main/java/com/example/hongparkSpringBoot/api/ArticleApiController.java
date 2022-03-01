package com.example.hongparkSpringBoot.api;

import com.example.hongparkSpringBoot.Entity.Article;
import com.example.hongparkSpringBoot.dto.ArticleForm;
import com.example.hongparkSpringBoot.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController //RestApi용 컨트롤러! 데이터를 반환한다 일반적으로 JSON
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;

    //GET(R)
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    //POST(C)
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    //PATCH(U)
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {

        //1.수정용 entity 생성
        Article article = dto.toEntity();
        log.info("id : {}, content : {}", id, article.toString());

        //2.대상 entity를 조회
        Article target = articleRepository.findById(id).orElse(null);

        //3.잘못된 요청 처리(대상이 없거나, id가 다른 경우)
        if (target == null || id != article.getId()) {
            //400에러
            log.info("잘못된 요청! id : {}, content : {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //4.업데이트 및 정상 응답
        target.patch(article);
        Article updated = articleRepository.save(target);
        return ResponseEntity.status(200).body(updated);
    }

    //DELETE(D)
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        //대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //잘못된 요청 처리
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //대상 삭제
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

