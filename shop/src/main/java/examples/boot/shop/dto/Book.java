package examples.boot.shop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 생성자
@ToString
@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int price;
}
