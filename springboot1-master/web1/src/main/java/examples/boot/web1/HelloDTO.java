package examples.boot.web1;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDateTime;

// DTO : Data Transfer Object
@JacksonXmlRootElement(localName = "hello")
public class HelloDTO {
    private String name; // 필드(field)
    private int age;
    private LocalDateTime dateTime;

    public HelloDTO(){
        dateTime = LocalDateTime.now();
    }

    // name 프로퍼티
    // getter 메소드
    public String getName() {
        return name;
    }

    // name 프로퍼티(property)
    // setter 메소드
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
