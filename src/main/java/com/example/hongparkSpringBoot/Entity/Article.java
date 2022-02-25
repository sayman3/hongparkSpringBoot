package com.example.hongparkSpringBoot.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity //DB가 해당 객체를 인식 가능 (해당 클래스로 테이블을 만든다)
@ToString
@Getter
public class Article {

    @Id//대표값을 지정
    //@GeneratedValue//1,2,3  ... 자동생성 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 id를 알아서 생성해주는 어노테이션
    private Long id;

    @Column
    private String title;

    @Column
    private String content;



}
