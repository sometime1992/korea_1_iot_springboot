package org.example.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootdeveloper.entity.Category;


@NoArgsConstructor
@AllArgsConstructor
@Data
//@Data 어노테이션을 까보면
// @Getter / @Setter, @ToString, @EqualsAndHashCode와
// @RequiredArgsConstructor, @Value 를 합쳐놓은 종합 선물 세트라고 볼 수 있다.
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private Category category;
}
